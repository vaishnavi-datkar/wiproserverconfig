package com.wipro.bookingms.controller;

import com.wipro.bookingms.dto.BookingRequest;
import com.wipro.bookingms.dto.PaymentRequest;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller - Handles HTTP requests from Angular frontend
 * @RestController - Combines @Controller + @ResponseBody
 *                   Automatically converts return values to JSON
 * @RequestMapping - Base URL for all endpoints: /api/bookings
 * @CrossOrigin - Allows requests from Angular (port 4200)
 *               Solves CORS (Cross-Origin Resource Sharing) issue
 * @Tag - Swagger documentation annotation
 */
@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Booking Management", description = "APIs for managing flight bookings")
public class BookingController {
    
    // Inject service interface (not implementation)
    // Spring will automatically inject BookingServiceImpl
    // This is Dependency Inversion Principle
    private final BookingService bookingService;
    
    /**
     * Constructor injection - Recommended over @Autowired
     * Makes code more testable
     */
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    /**
     * POST /api/bookings/create
     * Creates a new booking
     * 
     * @PostMapping - Handles HTTP POST requests
     * @RequestBody - Converts JSON from request body to BookingRequest object
     * @Operation - Swagger documentation
     * 
     * Returns ResponseEntity:
     * - 201 CREATED if successful
     * - 400 BAD REQUEST if error
     */
    @PostMapping("/create")
    @Operation(summary = "Create a new booking", description = "Creates a new flight booking with passenger details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Booking created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {
        try {
            // Call service layer to create booking
            Booking booking = bookingService.createBooking(request);
            
            // Return 201 CREATED with booking data
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        } catch (Exception e) {
            // Return 400 BAD REQUEST if error
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * POST /api/bookings/payment
     * Initiates payment for a booking
     * 
     * Flow:
     * 1. Receives payment details from Angular
     * 2. Service sends request to Kafka topic T1
     * 3. PaymentMS processes from T1
     * 4. PaymentMS sends response to T2
     * 5. BookingMS consumes from T2
     * 6. Status updated in database
     */
    @PostMapping("/payment")
    @Operation(summary = "Initiate payment", description = "Initiates payment process for a booking")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment initiated successfully"),
        @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<String> initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            bookingService.initiatePayment(paymentRequest);
            return ResponseEntity.ok("Payment initiated for booking: " + paymentRequest.getBookingId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
    
    /**
     * GET /api/bookings/{bookingId}
     * Retrieves booking by ID
     * 
     * @PathVariable - Extracts bookingId from URL path
     * Example: GET /api/bookings/BK1234567890
     */
    @GetMapping("/{bookingId}")
    @Operation(summary = "Get booking by ID", description = "Retrieves booking details by booking ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Booking found"),
        @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Booking> getBooking(@PathVariable String bookingId) {
        try {
            Booking booking = bookingService.getBookingById(bookingId);
            return ResponseEntity.ok(booking);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * GET /api/bookings/all
     * Gets all bookings
     * Used for admin panel or history
     */
    @GetMapping("/all")
    @Operation(summary = "Get all bookings", description = "Retrieves all bookings from database")
    @ApiResponse(responseCode = "200", description = "List of all bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
    
    /**
     * GET /api/bookings/search?source=Pune&destination=Delhi&date=2025-09-01
     * Searches flights by calling FlightDataMS
     * 
     * @RequestParam - Extracts query parameters from URL
     */
    @GetMapping("/search")
    @Operation(summary = "Search flights", description = "Searches for available flights")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Flights found"),
        @ApiResponse(responseCode = "404", description = "No flights found")
    })
    public ResponseEntity<Object> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date) {
        try {
            Object flights = bookingService.searchFlights(source, destination, date);
            return ResponseEntity.ok(flights);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error searching flights: " + e.getMessage());
        }
    }
}