package com.wipro.uber.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="booking")
@Data
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="booking_id")
	String bookingId;
	
	@Column(name="vehical_no")
	String vehicalNo;
	
	@Column(name="booking_status")
	boolean bookingStatus;
	
	@Column(name="booking_amount")
	double bookingAmount;
	
	
	@Column(name="booking_time")
	LocalDate bookingTime;
	

}