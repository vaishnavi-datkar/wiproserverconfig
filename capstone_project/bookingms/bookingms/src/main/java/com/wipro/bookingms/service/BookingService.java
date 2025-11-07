package com.wipro.bookingms.service;


import java.util.List;

import com.wipro.bookingms.dto.BookingRequest;
import com.wipro.bookingms.dto.PaymentRequest;
import com.wipro.bookingms.entity.Booking;

public interface BookingService {
	
	Booking createBooking(BookingRequest request);
	
	void initiatePayment(PaymentRequest paymentRequest);
	
	Booking getBookingById(String bookingId);
	List<Booking> getAllBookings();
	Object searchFlights(String source,String destination,String date);
	


}