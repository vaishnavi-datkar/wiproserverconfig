package com.wipro.paymentms.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.paymentms.dto.*;
import com.wipro.paymentms.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class to handle payment processing logic.
 * This class consumes messages from Kafka, simulates a payment, and
 * produces a response message back to the BookingMs.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PaymentServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    /**
     * Listens to the 'T1' Kafka topic for incoming payment requests.
     * @param message The JSON message string containing the payment request details.
     */
    @Override
    @KafkaListener(topics = "T1", groupId = "payment-group")
    public void processPayment(String message) {
        System.out.println("Received payment request on topic 'T1': " + message);
        
        try {
            // Deserialize the JSON message into a PaymentRequest object
            PaymentDTO request = objectMapper.readValue(message, PaymentDTO.class);

            // Simulate payment processing logic
            boolean isSuccess = simulatePayment(request.getAmount());
            String status = isSuccess ? "successful" : "failed";

            // Create a response message to be sent back
            String responseMessage = String.format("{\"bookingId\": %d, \"status\": \"%s\"}", request.getBookingId(), status);

            // Send the response to the 'T2' Kafka topic
            kafkaTemplate.send("T2", request.getBookingId().toString(), responseMessage);

            System.out.println("Payment for booking " + request.getBookingId() + " processed. Status sent: " + status);
        } catch (JsonProcessingException e) {
            // Handle JSON parsing errors gracefully
            System.err.println("Error processing Kafka message: " + e.getMessage());
        }
    }

    /**
     * Simulates a payment success or failure based on a simple rule.
     * @param amount The payment amount.
     * @return true if the payment is successful, false otherwise.
     */
    private boolean simulatePayment(double amount) {
        // Simple simulation: payment fails if the amount is exactly $100.
        return amount != 100.00;
    }
}
