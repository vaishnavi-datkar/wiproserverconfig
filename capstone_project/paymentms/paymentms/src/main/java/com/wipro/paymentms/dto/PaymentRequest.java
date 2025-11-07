package com.wipro.paymentms.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for the payment request.
 
 */
@Data // Generates getters, setters, toString, equals, and hashCode methods.
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private String bookingId;
    private Double amount;
    private String paymentMethod;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String upiId;
}
