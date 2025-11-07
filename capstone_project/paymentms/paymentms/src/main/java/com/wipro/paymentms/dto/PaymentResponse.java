package com.wipro.paymentms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor   // Default constructor needed for JSON deserialization
@AllArgsConstructor
public class PaymentResponse {

	private String bookingId;
	private String status;
	private String message;
	
}
