package com.wipro.flightdatams.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "flights")   // explicitly naming the table
public class Flight {

    @Id
    @Column(name = "flight_id")   // column name in DB
    private String flightId;

    @Column(name = "airline", nullable = false, length = 50)
    private String airline; 

    @Column(name = "flight_number", nullable = false, unique = true)//unique constrain
    private String flightNumber;

    @Column(name = "source", nullable = false, length = 50)
    private String source;

    @Column(name = "destination", nullable = false, length = 50)
    private String destination;

    @Column(name = "flight_date", nullable = false)
    private LocalDate flightDate;     

    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;  

    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @Column(name = "price", nullable = false)
    private double price;
}
