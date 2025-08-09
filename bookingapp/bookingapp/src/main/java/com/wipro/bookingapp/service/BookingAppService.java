package com.wipro.bookingapp.service;
import com.wipro.bookingapp.dto.Booking;
import com.wipro.bookingapp.entity.BookingApp;
public interface BookingAppService {
	void accepteBookingOrder(Booking booking);
	void save(BookingApp bookingApp);
}
