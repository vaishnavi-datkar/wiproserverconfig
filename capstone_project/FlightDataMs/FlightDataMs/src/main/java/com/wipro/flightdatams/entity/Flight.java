package com.wipro.flightdatams.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "flights")   // explicitly naming the table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true) // column name in DB
    private String flightId;


    @Column(nullable = false)
    private String flightNumber;
    
    @Column(nullable = false)
    private String airline;
    
    

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String departureTime;  

    @Column(nullable = false)
    private String arrivalTime;
    private String duration;
    @Column(nullable = false)
    private Double price;

    private String stopType;
    private Boolean isNonStop;
    private Boolean isMorning;
    private Boolean isLate;
    private Integer departureHour;
    private LocalDate availableFromDate;
    private LocalDate availableToDate;
    private Integer availableSeats;
}
