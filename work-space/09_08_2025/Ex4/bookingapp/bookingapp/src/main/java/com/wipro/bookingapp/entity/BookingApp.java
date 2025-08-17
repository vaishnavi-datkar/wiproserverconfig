package com.wipro.bookingapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="booking_app")
@Data
public class BookingApp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="booking_id")
	private String bookingId;
	
	@Column(name="vehical_no")
	private String vehicalNo;
	
	@Column(name="booking_amount")
	private double bookingAmount;

	@Column(name="ride_status")
	private boolean rideStatus;

	@Column(name="booking_time")
	private LocalDate bookingTime;
}