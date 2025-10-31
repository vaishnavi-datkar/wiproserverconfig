package com.wipro.bookingms.service;

import java.time.LocalDate;
import java.util.List;

import com.wipro.bookingms.entity.Booking;

public interface BookingService {
	List<Object> searchFlights(String source, String destination, LocalDate flightDate);

    Booking initiateBookingAndPayment(String flightId, double amount, String paymentMode);


}