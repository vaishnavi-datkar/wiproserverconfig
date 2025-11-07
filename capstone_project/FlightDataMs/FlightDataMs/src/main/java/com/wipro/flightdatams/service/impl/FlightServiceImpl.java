package com.wipro.flightdatams.service.impl;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.repo.FlightRepository;
import com.wipro.flightdatams.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Implementation of FlightService
 * Contains business logic for flight operations
 * @Service - Marks as Spring service component
 */
@Service
public class FlightServiceImpl implements FlightService {
    
    private final FlightRepository flightRepository;
    
    /**
     * Constructor injection
     */
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    
    /**
     * Adds new flight to database
     */
    @Override
    public Flight addFlight(Flight flight) {
        // Auto-calculate boolean flags if not set
        if (flight.getDepartureHour() != null) {
            // Morning: 6 AM to 12 PM
            flight.setIsMorning(flight.getDepartureHour() >= 6 && flight.getDepartureHour() < 12);
            // Late: After 6 PM
            flight.setIsLate(flight.getDepartureHour() >= 18);
        }
        
        return flightRepository.save(flight);
    }
    
    /**
     * Gets flight by unique flight ID
     * @throws RuntimeException if flight not found
     */
    @Override
    public Flight getFlightById(String flightId) {
        return flightRepository.findByFlightId(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + flightId));
    }
    
    /**
     * Gets all flights from database
     */
    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    
    /**
     * Searches flights by criteria
     * Converts date string to LocalDate and queries database
     */
    @Override
    public List<Flight> searchFlights(String source, String destination, String date) {
        try {
            // Parse date string (format: yyyy-MM-dd)
            LocalDate travelDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            
            System.out.println("Searching flights:");
            System.out.println("Source: " + source);
            System.out.println("Destination: " + destination);
            System.out.println("Travel Date: " + travelDate);
            
            // Query database using custom repository method
            List<Flight> flights = flightRepository.searchFlights(source, destination, travelDate);
            
            System.out.println("Found " + flights.size() + " flights");
            
            return flights;
            
        } catch (Exception e) {
            System.err.println("Error searching flights: " + e.getMessage());
            throw new RuntimeException("Error searching flights: " + e.getMessage());
        }
    }
    
    /**
     * Updates existing flight
     */
    @Override
    public Flight updateFlight(String flightId, Flight updatedFlight) {
        // Find existing flight
        Flight existingFlight = getFlightById(flightId);
        
        // Update fields
        existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
        existingFlight.setAirline(updatedFlight.getAirline());
        existingFlight.setSource(updatedFlight.getSource());
        existingFlight.setDestination(updatedFlight.getDestination());
        existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
        existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
        existingFlight.setDuration(updatedFlight.getDuration());
        existingFlight.setPrice(updatedFlight.getPrice());
        existingFlight.setStopType(updatedFlight.getStopType());
        existingFlight.setIsNonStop(updatedFlight.getIsNonStop());
        existingFlight.setAvailableFromDate(updatedFlight.getAvailableFromDate());
        existingFlight.setAvailableToDate(updatedFlight.getAvailableToDate());
        existingFlight.setAvailableSeats(updatedFlight.getAvailableSeats());
        
        // Save and return
        return flightRepository.save(existingFlight);
    }
    
    /**
     * Deletes flight from database
     */
    @Override
    public void deleteFlight(String flightId) {
        Flight flight = getFlightById(flightId);
        flightRepository.delete(flight);
    }
}