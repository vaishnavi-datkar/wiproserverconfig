package com.wipro.bookingms.service.impl;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.repo.BookingRepository;
import com.wipro.bookingms.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.time.LocalDate;
import java.util.List;

/**
 * Service class for handling all booking-related business logic.
 * This version uses RestTemplate for inter-service communication.
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final RestTemplate restTemplate;
    private final BookingRepository bookingRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    // The name of the FlightDataMs service as registered in Eureka.
    private static final String FLIGHT_DATA_MS_NAME = "FLIGHTDATAMS";

    @Autowired
    public BookingServiceImpl(RestTemplate restTemplate, BookingRepository bookingRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.restTemplate = restTemplate;
        this.bookingRepository = bookingRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Searches for flights using RestTemplate to call the FlightDataMs.
     * @param source The source city.
     * @param destination The destination city.
     * @param flightDate The flight date.
     * @return A list of flight results.
     */
    @Override // This annotation ensures the method signature matches the interface.
    public List<Object> searchFlights(String source, String destination, LocalDate flightDate) {
        // Construct the URL to call the FlightDataMs service.
        // The URL uses the service name from Eureka.
        String url = UriComponentsBuilder.fromHttpUrl("http://" + FLIGHT_DATA_MS_NAME)
                .path("/flights/search")
                .queryParam("source", source)
                .queryParam("destination", destination)
                .queryParam("flightDate", flightDate.toString())
                .toUriString();

        // Make the GET request and get the response as a List.
        List<Object> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    /**
     * Initiates a new booking, saves it to the database, and sends a payment request to Kafka.
     * @param flightId The ID of the flight to book.
     * @param amount The amount to pay.
     * @param paymentMode The payment method.
     * @return The saved Booking entity.
     */
    @Override // This annotation ensures the method signature matches the interface.
    public Booking initiateBookingAndPayment(String flightId, double amount, String paymentMode) {
        // Create a new booking entry with "initiated" status
        Booking newBooking = new Booking();
        newBooking.setFlightId(flightId);
        newBooking.setFlightDate(LocalDate.now());
        newBooking.setBookingDate(LocalDate.now());
        newBooking.setAmount(amount);
        newBooking.setPaymentMode(paymentMode);
        newBooking.setStatus("initiated");

        // Save the booking to the database
        Booking savedBooking = bookingRepository.save(newBooking);

        // Send a payment request to the Kafka topic T1
        String message = String.format("{\"bookingId\": %d, \"amount\": %.2f}", savedBooking.getBookingId(), amount);
        kafkaTemplate.send("T1", savedBooking.getBookingId().toString(), message);

        System.out.println("Initiated booking ID: " + savedBooking.getBookingId() + " and sent payment request.");

        return savedBooking;
    }

    /**
     * Kafka listener that consumes payment status updates from the 'T2' topic.
     * @param message The JSON message string containing the payment status.
     */
    @KafkaListener(topics = "T2", groupId = "payment-status-group")
    public void listenForPaymentStatus(String message) {
        System.out.println("Received payment status on topic 'T2': " + message);
    }
}
