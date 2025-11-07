package com.wipro.paymentms.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.paymentms.dto.PaymentResponse;

@Service
public class PaymentResponseProducer {
	
	private final KafkaTemplate<String, PaymentResponse> kafkaTemplate;
	 private static final String TOPIC="payment-response-topic";
	 
	 public PaymentResponseProducer(KafkaTemplate<String, PaymentResponse> kafkaTemplate) {
		 
		 this.kafkaTemplate=kafkaTemplate;
		 
	 }
	 
	 public void sendPaymentResponse(PaymentResponse paymentResponse) {
		 
		 System.out.println("Sending payment response to Kafka Topic: " + TOPIC);
	        System.out.println("Booking ID: " + paymentResponse.getBookingId());
	        System.out.println("Status: " + paymentResponse.getStatus());
	        
	        // Send message to Kafka topic
	        // This is asynchronous - method returns immediately
	        kafkaTemplate.send(TOPIC, paymentResponse);
	        
	        System.out.println("Payment response sent successfully!");
	 }
	 
	 
}
