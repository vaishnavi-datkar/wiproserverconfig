package com.wipro.flightdatams.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.repo.FlightRepository;
import com.wipro.flightdatams.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> searchFlights(String source, String destination, LocalDate flightDate) {
        return flightRepository.findBySourceAndDestinationAndFlightDate(source, destination, flightDate);
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }
}
