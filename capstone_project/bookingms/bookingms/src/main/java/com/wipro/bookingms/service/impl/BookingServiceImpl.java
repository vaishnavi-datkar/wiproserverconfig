package com.wipro.bookingms.service.impl;

import com.wipro.bookingms.dto.BookingRequest;
import com.wipro.bookingms.dto.PaymentRequest;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.kafka.PaymentProducer;
import com.wipro.bookingms.repo.BookingRepository;
import com.wipro.bookingms.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Implementation of BookingService
 * Contains actual business logic for booking operations
 * @Service - Marks this as a Spring service component
 */
@Service
public class BookingServiceImpl implements BookingService {

    // Dependencies
    private final RestTemplate restTemplate;           // For calling other microservices
    private final BookingRepository bookingRepository; // For database operations
    private final PaymentProducer paymentProducer;     // For sending messages to Kafka

    /**
     * Constructor injection - Spring automatically injects dependencies
     * @Autowired is optional on constructors (Spring 4.3+)
     */
    @Autowired
    public BookingServiceImpl(RestTemplate restTemplate, 
                             BookingRepository bookingRepository, 
                             PaymentProducer paymentProducer) {
        this.restTemplate = restTemplate;
        this.bookingRepository = bookingRepository;
        this.paymentProducer = paymentProducer;
    }

    /**
     * Creates a new booking with INITIATED status
     * Generates unique booking ID using current timestamp
     */
    @Override
    public Booking createBooking(BookingRequest request) {
        // Create new booking entity
        Booking booking = new Booking();
        
        // Generate unique booking ID: BK + timestamp
        // Example: BK1730889234567
        booking.setBookingId("BK" + System.currentTimeMillis());
        
        // Set flight details
        booking.setFlightId(request.getFlightId());
        booking.setSource(request.getSource());
        booking.setDestination(request.getDestination());
        booking.setTravelDate(request.getTravelDate());
        
        // Set passenger details
        booking.setPassengerName(request.getPassengerName());
        booking.setPassengerEmail(request.getPassengerEmail());
        booking.setPassengerPhone(request.getPassengerPhone());
        
        // Set pricing details
        booking.setBasePrice(request.getBasePrice());
        booking.setTaxes(request.getTaxes());
        booking.setTotalAmount(request.getTotalAmount());
        
        // Set initial status - payment not yet done
        booking.setStatus("INITIATED");
        
        // Save to database and return
        // JPA will automatically set id, createdAt, updatedAt
        return bookingRepository.save(booking);
    }

    /**
     * Initiates payment by sending request to Kafka Topic T1
     * PaymentMS will consume from T1 and process payment
     */
    @Override
    public void initiatePayment(PaymentRequest paymentRequest) {
        // Find booking by booking ID
        Booking booking = bookingRepository.findByBookingId(paymentRequest.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " 
                                                       + paymentRequest.getBookingId()));
        
        // Update booking with payment method (CARD or UPI)
        booking.setPaymentMethod(paymentRequest.getPaymentMethod());  // FIXED: Was setPaymentMode
        bookingRepository.save(booking);
        
        // Send payment request to Kafka Topic T1 (payment-request-topic)
        // PaymentMS is listening to this topic
        paymentProducer.sendPaymentRequest(paymentRequest);
        
        System.out.println("Payment request sent to Kafka for booking: " 
                         + paymentRequest.getBookingId());
    }

    /**
     * Retrieves a specific booking by its booking ID
     * @throws RuntimeException if booking not found
     */
    @Override
    public Booking getBookingById(String bookingId) {  // FIXED: Method name was getBookingId
        return bookingRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
    }

    /**
     * Gets all bookings from database
     * Used for admin panel or booking history
     */
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Searches for flights by calling FlightDataMS via Eureka
     * Uses @LoadBalanced RestTemplate for service discovery
     */
    @Override
    public Object searchFlights(String source, String destination, String date) {
        // Service name from Eureka - LoadBalancer resolves to actual IP:PORT
        // "FLIGHTDATAMS" -> "http://192.168.1.36:9090"
        String flightDataUrl = "http://FLIGHTDATAMS/api/flights/search?source=" 
                             + source + "&destination=" + destination + "&date=" + date;
        
        // Make HTTP GET request to FlightDataMS
        // Returns JSON converted to Object
        return restTemplate.getForObject(flightDataUrl, Object.class);
    }
}