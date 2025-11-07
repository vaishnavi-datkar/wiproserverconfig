package com.wipro.bookingms.kafka;

import com.wipro.bookingms.dto.PaymentResponse;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.repo.BookingRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    
    private final BookingRepository bookingRepository;
    
    public PaymentConsumer(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    
    @KafkaListener(topics = "payment-response-topic", groupId = "booking-group")
    public void consumePaymentResponse(PaymentResponse paymentResponse) {
        System.out.println("Received payment response from Kafka: " + paymentResponse.getBookingId());
        
        Booking booking = bookingRepository.findByBookingId(paymentResponse.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        booking.setStatus(paymentResponse.getStatus());
        bookingRepository.save(booking);
        
        System.out.println("Updated booking status to: " + paymentResponse.getStatus());
    }
}