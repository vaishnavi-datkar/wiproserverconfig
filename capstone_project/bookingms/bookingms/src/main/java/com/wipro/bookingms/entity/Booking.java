package com.wipro.bookingms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @Column(nullable = false, unique = true)
    private String bookingId;
    
    //Flight Details
    private String flightId;
    private String source;
    private String destination;
    private LocalDate travelDate;
    
    // Passenger Details
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    
    private Double basePrice;
    private Double taxes;
    private Double totalAmount;
    
   @Column(nullable = false) 
    private String status; // initiated/success/failed/cancelled
    
    private String paymentMethod;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
    	createdAt = LocalDateTime.now();
    	updatedAt=LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	updatedAt = LocalDateTime.now();
    }


}
