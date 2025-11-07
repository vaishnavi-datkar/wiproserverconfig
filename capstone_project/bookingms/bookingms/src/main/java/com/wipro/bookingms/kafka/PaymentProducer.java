package com.wipro.bookingms.kafka;

import com.wipro.bookingms.dto.PaymentRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {
    
    private final KafkaTemplate<String, PaymentRequest> kafkaTemplate;
    private static final String TOPIC = "payment-request-topic";
    
    public PaymentProducer(KafkaTemplate<String, PaymentRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void sendPaymentRequest(PaymentRequest paymentRequest) {
        System.out.println("Sending payment request to Kafka: " + paymentRequest.getBookingId());
        kafkaTemplate.send(TOPIC, paymentRequest);
    }
}