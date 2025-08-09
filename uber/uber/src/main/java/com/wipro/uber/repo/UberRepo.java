package com.wipro.uber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.uber.entity.Booking;
@Repository
public interface UberRepo extends JpaRepository<Booking, Integer> {

}
