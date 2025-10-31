package com.wipro.paymentms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Data Transfer Object (DTO) for the payment request.
 * This object is used to deserialize the JSON message received from Kafka.
 */
@Data // Generates getters, setters, toString, equals, and hashCode methods.
@NoArgsConstructor // Generates a no-argument constructor.
@AllArgsConstructor // Generates a constructor with all fields.
public class PaymentDTO {
    private Long bookingId;
    private double amount;
}
