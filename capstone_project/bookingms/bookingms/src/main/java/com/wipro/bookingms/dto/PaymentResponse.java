package com.wipro.bookingms.dto;

import lombok.Data;

@Data
public class PaymentResponse {
	
	private String bookingId;
	private String status;
	private String message;
	
}
