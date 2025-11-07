package com.wipro.flightdatams.config;
import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.repo.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class DataInitializer implements CommandLineRunner {
private final FlightRepository flightRepository;
    
    public DataInitializer(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (flightRepository.count() > 0) {
            System.out.println("Flight data already exists. Skipping initialization.");
            return;
        }
        
        System.out.println("========================================");
        System.out.println("Initializing flight data...");
        System.out.println("========================================");
        
        LocalDate fromDate = LocalDate.now();
        LocalDate toDate = fromDate.plusMonths(3);
        
        // Add Pune to Delhi flights
        addFlight("6E-2124", "6E-2124", "IndiGo", "Pune", "Delhi", 
                 "06:00 AM", "08:30 AM", "2h 30m", 4500.0, "Non-stop", 
                 true, true, false, 6, fromDate, toDate, 180);
        
        addFlight("AI-631", "AI-631", "Air India", "Pune", "Delhi", 
                 "09:15 AM", "11:45 AM", "2h 30m", 5200.0, "Non-stop", 
                 true, true, false, 9, fromDate, toDate, 150);
        
        addFlight("SG-8709", "SG-8709", "SpiceJet", "Pune", "Delhi", 
                 "02:30 PM", "06:45 PM", "4h 15m", 3800.0, "1 Stop", 
                 false, false, false, 14, fromDate, toDate, 120);
        
        addFlight("UK-955", "UK-955", "Vistara", "Pune", "Delhi", 
                 "08:45 PM", "11:15 PM", "2h 30m", 6200.0, "Non-stop", 
                 true, false, true, 20, fromDate, toDate, 200);
        // Add Pune to Mumbai flights
        addFlight("6E-5124", "6E-5124", "IndiGo", "Pune", "Mumbai", 
                 "07:30 AM", "08:45 AM", "1h 15m", 2800.0, "Non-stop", 
                 true, true, false, 7, fromDate, toDate, 180);
        
        addFlight("AI-642", "AI-642", "Air India", "Pune", "Mumbai", 
                 "05:00 PM", "06:15 PM", "1h 15m", 3200.0, "Non-stop", 
                 true, false, false, 17, fromDate, toDate, 150);
        
        // Add Delhi to Mumbai flights
        addFlight("6E-3001", "6E-3001", "IndiGo", "Delhi", "Mumbai", 
                 "06:30 AM", "08:45 AM", "2h 15m", 5500.0, "Non-stop", 
                 true, true, false, 6, fromDate, toDate, 180);
        
        addFlight("AI-501", "AI-501", "Air India", "Delhi", "Mumbai", 
                 "01:00 PM", "03:15 PM", "2h 15m", 6000.0, "Non-stop", 
                 true, false, false, 13, fromDate, toDate, 150);
        
        // Add Mumbai to Delhi flights
        addFlight("6E-3002", "6E-3002", "IndiGo", "Mumbai", "Delhi", 
                 "09:00 AM", "11:15 AM", "2h 15m", 5500.0, "Non-stop",
true, true, false, 9, fromDate, toDate, 180);
        
        addFlight("AI-502", "AI-502", "Air India", "Mumbai", "Delhi", 
                 "07:00 PM", "09:15 PM", "2h 15m", 6000.0, "Non-stop", 
                 true, false, true, 19, fromDate, toDate, 150);
        
        // Add Delhi to Pune flights
        addFlight("6E-2125", "6E-2125", "IndiGo", "Delhi", "Pune", 
                 "12:30 PM", "03:00 PM", "2h 30m", 4500.0, "Non-stop", 
                 true, false, false, 12, fromDate, toDate, 180);
        
        addFlight("AI-632", "AI-632", "Air India", "Delhi", "Pune", 
                 "04:00 PM", "06:30 PM", "2h 30m", 5200.0, "Non-stop", 
                 true, false, false, 16, fromDate, toDate, 150);
        
        // Add Mumbai to Pune flights
        addFlight("6E-5125", "6E-5125", "IndiGo", "Mumbai", "Pune", 
                 "10:00 AM", "11:15 AM", "1h 15m", 2800.0, "Non-stop", 
                 true, true, false, 10, fromDate, toDate, 180);
        
        addFlight("AI-643", "AI-643", "Air India", "Mumbai", "Pune",
        		 "07:30 PM", "08:45 PM", "1h 15m", 3200.0, "Non-stop", 
                 true, false, true, 19, fromDate, toDate, 150);
        
        System.out.println("========================================");
        System.out.println("Flight data initialization completed!");
        System.out.println("Total flights added: " + flightRepository.count());
        System.out.println("========================================");
    }
    	
    private void addFlight(String flightId, String flightNumber, String airline, 
            String source, String destination, String departureTime, 
            String arrivalTime, String duration, Double price, 
            String stopType, Boolean isNonStop, Boolean isMorning, 
            Boolean isLate, Integer departureHour, 
            LocalDate fromDate, LocalDate toDate, Integer seats) {

    	Flight flight = new Flight();
    	flight.setFlightId(flightId);
    	flight.setFlightNumber(flightNumber);
    	flight.setAirline(airline);
    	flight.setSource(source);
    	flight.setDestination(destination);
    	flight.setDepartureTime(departureTime);
    	flight.setArrivalTime(arrivalTime);
    	flight.setDuration(duration);
    	flight.setPrice(price);
    	flight.setStopType(stopType);
    	flight.setIsNonStop(isNonStop);
    	flight.setIsMorning(isMorning);
    	flight.setIsLate(isLate);
    	flight.setDepartureHour(departureHour);
    	flight.setAvailableFromDate(fromDate);
    	flight.setAvailableToDate(toDate);
    	flight.setAvailableSeats(seats);

    	flightRepository.save(flight);
    		
    		System.out.println("Added flight: " + flightNumber + " (" + source + " to " + destination + ")");
    }

}
