package com.wipro.bookingms.controller;

import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Endpoint to search for flights.
     * It delegates the search to the BookingService, which then uses RestTemplate
     * to call the FlightDataMs.
     *
     * @param source      The departure city.
     * @param destination The arrival city.
     * @param flightDate  The date of the flight.
     * @return A list of flights that match the search criteria.
     */
    @GetMapping("/search")
    public List<Object> searchFlights(@RequestParam String source, @RequestParam String destination, @RequestParam String flightDate) {
        LocalDate date = LocalDate.parse(flightDate);
        return bookingService.searchFlights(source, destination, date);
    }

    /**
     * Endpoint to initiate a new booking.
     *
     * @param flightId The ID of the flight to book.
     * @param amount The amount to pay.
     * @param paymentMode The payment mode (e.g., "card").
     * @return The created Booking entity.
     */
    @PostMapping("/book")
    public Booking bookFlight(@RequestParam String flightId, @RequestParam double amount, @RequestParam String paymentMode) {
        return bookingService.initiateBookingAndPayment(flightId, amount, paymentMode);
    }
}