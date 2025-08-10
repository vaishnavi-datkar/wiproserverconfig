package com.wipro.bookingapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bookingapp.entity.BookingApp;
@Repository
public interface BookingAppRepo extends JpaRepository<BookingApp, Integer> {
	BookingApp findByBookingId(String bookingId);
}
