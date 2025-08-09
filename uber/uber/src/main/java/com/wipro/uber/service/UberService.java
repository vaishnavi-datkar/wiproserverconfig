package com.wipro.uber.service;

import com.wipro.uber.entity.Booking;

public interface UberService {
	void ride(Booking booking);
	void sendBookingAppStatus(Booking booking);
}
