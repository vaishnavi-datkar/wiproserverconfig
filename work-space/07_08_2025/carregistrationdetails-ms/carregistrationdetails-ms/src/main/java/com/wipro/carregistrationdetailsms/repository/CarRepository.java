package com.wipro.carregistrationdetailsms.repository;

import com.wipro.carregistrationdetailsms.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
