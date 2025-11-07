package com.wipro.flightdatams.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.flightdatams.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

	Optional<Flight> findByFlightId(String flightId);
	@Query("SELECT f FROM Flight f WHERE " +
	           "LOWER(f.source) = LOWER(:source) AND " +
	           "LOWER(f.destination) = LOWER(:destination) AND " +
	           ":travelDate BETWEEN f.availableFromDate AND f.availableToDate")
	    List<Flight> searchFlights(@Param("source") String source,
	                               @Param("destination") String destination,
	                               @Param("travelDate") LocalDate travelDate);
	
	List<Flight> findBySourceAndDestination(String source, String destination);

}
