package com.wipro.flightdatams.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.flightdatams.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

	List<Flight> findBySourceAndDestinationAndFlightDate(
	        String source,
	        String destination,
	        LocalDate flightDate
	);

}
