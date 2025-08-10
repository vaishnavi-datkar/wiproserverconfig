package com.wipro.bookingapp.dto;
import java.time.LocalDate;

import lombok.Data;



@Data
public class Booking {
	int id;
	String bookingId;
	String vehicalNo;
	boolean rideStatus;
	double bookingAmount;
	LocalDate bookingTime;

}
