package com.wipro.carregistrationdetailsms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRegistrationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    String registrationNumber;

    LocalDate dateOfRegistration;
}
