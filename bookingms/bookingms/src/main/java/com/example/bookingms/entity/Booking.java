package com.example.bookingms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String flightId;
    private LocalDate flightDate;
    private LocalDate bookingDate;
    private String status; // initiated/success/failed/cancelled
    private double amount;
    private String paymentMode;


}
