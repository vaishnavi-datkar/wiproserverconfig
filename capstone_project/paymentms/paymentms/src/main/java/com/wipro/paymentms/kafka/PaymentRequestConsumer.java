package com.wipro.paymentms.kafka;

import com.wipro.paymentms.dto.PaymentRequest;
import com.wipro.paymentms.dto.PaymentResponse;
import com.wipro.paymentms.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer for Payment Requests
 * Listens to payment-request-topic (T1)
 * Receives payment requests from BookingMS
 * @Service - Makes this a Spring component
 */
@Service
public class PaymentRequestConsumer {
    
    private final PaymentService paymentService;
    private final PaymentResponseProducer paymentResponseProducer;
    
    /**
     * Constructor injection of dependencies
     */
    public PaymentRequestConsumer(PaymentService paymentService, 
                                  PaymentResponseProducer paymentResponseProducer) {
        this.paymentService = paymentService;
        this.paymentResponseProducer = paymentResponseProducer;
    }
    
    /**
     * Kafka Listener Method
     * @KafkaListener - Automatically called when message arrives on topic
     * 
     * Flow:
     * 1. BookingMS sends payment request to T1 (payment-request-topic)
     * 2. This method automatically receives the message
     * 3. Processes payment using PaymentService
     * 4. Sends response to T2 (payment-response-topic)
     * 5. BookingMS consumes from T2 and updates booking status
     * 
     * @param paymentRequest - Deserialized from JSON automatically
     */
    @KafkaListener(topics = "payment-request-topic", groupId = "payment-group")
    public void consumePaymentRequest(PaymentRequest paymentRequest) {
        System.out.println("========================================");
        System.out.println("Received payment request from Kafka:");
        System.out.println("Booking ID: " + paymentRequest.getBookingId());
        System.out.println("Amount: ₹" + paymentRequest.getAmount());
        System.out.println("Payment Method: " + paymentRequest.getPaymentMethod());
        System.out.println("========================================");
        
        // Process the payment using service layer
        PaymentResponse response = paymentService.processPayment(paymentRequest);
        
        System.out.println("Payment processing completed.");
        System.out.println("Result: " + response.getStatus());
        System.out.println("========================================");
        
        // Send response back to BookingMS via Kafka Topic T2
        paymentResponseProducer.sendPaymentResponse(response);
    }
}