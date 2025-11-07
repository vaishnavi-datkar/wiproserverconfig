package com.wipro.bookingms.dto;

import lombok.Data;

@Data
public class PaymentRequest {
	private String bookingId;
    private Double amount;
    private String paymentMethod;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String upiId;
}
