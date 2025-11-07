package com.wipro.flightdatams.controller;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Flight operations
 * Handles HTTP requests related to flight data
 * 
 * @RestController - Combines @Controller + @ResponseBody
 * @RequestMapping - Base URL: /api/flights
 * @CrossOrigin - Allows requests from Angular frontend
 * @Tag - Swagger documentation
 */
@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Flight Data Management", description = "APIs for managing flight information")
public class FlightController {
    
    private final FlightService flightService;
    
    /**
     * Constructor injection of FlightService
     */
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    
    /**
     * POST /api/flights/add
     * Adds a new flight to the system
     * 
     * @param flight - Flight details from request body (JSON)
     * @return Created flight with 201 status
     */
    @PostMapping("/add")
    @Operation(summary = "Add new flight", description = "Adds a new flight to the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Flight created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid flight data")
    })
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        try {
            Flight createdFlight = flightService.addFlight(flight);
            return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * GET /api/flights/{flightId}
     * Gets flight by its unique ID
     * 
     * @param flightId - Flight identifier from URL path
     * @return Flight details
     */
    @GetMapping("/{flightId}")
    @Operation(summary = "Get flight by ID", description = "Retrieves flight details by flight ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flight found"),
        @ApiResponse(responseCode = "404", description = "Flight not found")
    })
    public ResponseEntity<Flight> getFlightById(@PathVariable String flightId) {
        try {
            Flight flight = flightService.getFlightById(flightId);
            return ResponseEntity.ok(flight);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * GET /api/flights/all
     * Gets all flights in the system
     * 
     * @return List of all flights
     */
    @GetMapping("/all")
    @Operation(summary = "Get all flights", description = "Retrieves all flights from database")
    @ApiResponse(responseCode = "200", description = "List of all flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }
    
    /**
     * GET /api/flights/search?source=Pune&destination=Delhi&date=2025-09-01
     * Searches flights by source, destination and travel date
     * 
     * This is the main endpoint called by BookingMS
     * 
     * @param source - Departure city (query parameter)
     * @param destination - Arrival city (query parameter)
     * @param date - Travel date in yyyy-MM-dd format (query parameter)
     * @return List of available flights
     */
    @GetMapping("/search")
    @Operation(summary = "Search flights", 
               description = "Searches for available flights based on source, destination and date")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flights found"),
        @ApiResponse(responseCode = "404", description = "No flights found"),
        @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<?> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date) {
        try {
            System.out.println("========================================");
            System.out.println("Search request received:");
            System.out.println("Source: " + source);
            System.out.println("Destination: " + destination);
            System.out.println("Date: " + date);
            System.out.println("========================================");
            
            // Call service to search flights
            List<Flight> flights = flightService.searchFlights(source, destination, date);
            
            if (flights.isEmpty()) {
                // No flights found
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No flights available for the specified route and date");
            }
            
            // Return found flights
            return ResponseEntity.ok(flights);
            
        } catch (Exception e) {
            System.err.println("Error in flight search: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error searching flights: " + e.getMessage());
        }
    }
    
    /**
     * PUT /api/flights/update/{flightId}
     * Updates existing flight
     * 
     * @param flightId - Flight to update
     * @param flight - New flight details
     * @return Updated flight
     */
    @PutMapping("/update/{flightId}")
    @Operation(summary = "Update flight", description = "Updates existing flight details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flight updated successfully"),
        @ApiResponse(responseCode = "404", description = "Flight not found")
    })
    public ResponseEntity<Flight> updateFlight(
            @PathVariable String flightId,
            @RequestBody Flight flight) {
        try {
            Flight updatedFlight = flightService.updateFlight(flightId, flight);
            return ResponseEntity.ok(updatedFlight);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * DELETE /api/flights/delete/{flightId}
     * Deletes a flight from the system
     * 
     * @param flightId - Flight to delete
     * @return Success message
     */
    @DeleteMapping("/delete/{flightId}")
    @Operation(summary = "Delete flight", description = "Deletes a flight from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flight deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Flight not found")
    })
    public ResponseEntity<String> deleteFlight(@PathVariable String flightId) {
        try {
            flightService.deleteFlight(flightId);
            return ResponseEntity.ok("Flight deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Flight not found with ID: " + flightId);
        }
    }
}