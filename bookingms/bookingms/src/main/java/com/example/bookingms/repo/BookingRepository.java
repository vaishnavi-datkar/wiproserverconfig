package com.example.bookingms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookingms.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
