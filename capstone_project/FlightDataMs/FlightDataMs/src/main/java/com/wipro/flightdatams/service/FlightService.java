package com.wipro.flightdatams.service;

import com.wipro.flightdatams.entity.Flight;
import java.util.List;
public interface FlightService {
	
	Flight addFlight(Flight flight);
	 Flight getFlightById(String flightId);
	 List<Flight> getAllFlights();
	 
	    List<Flight> searchFlights(String source, String destination, String date);

	    Flight updateFlight(String flightId, Flight flight);
	    void deleteFlight(String flightId);

	 
}
