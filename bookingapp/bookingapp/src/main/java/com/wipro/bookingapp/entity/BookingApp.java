package com.wipro.bookingapp.entity;
//import java.time.LocalDate;

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
int id;
	
	@Column(name="booking_id")
	String bookingId;
	
	@Column(name="ride_status")
	boolean rideStatus;
}
