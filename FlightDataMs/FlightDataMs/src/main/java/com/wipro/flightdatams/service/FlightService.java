package com.wipro.flightdatams.service;

import java.time.LocalDate;
import com.wipro.flightdatams.entity.Flight;
import java.util.List;
public interface FlightService {
	
	 List<Flight> searchFlights(String source, String destination, LocalDate flightDate);

	 Flight save(Flight flight);

	 List<Flight> findAll();

	 
}
