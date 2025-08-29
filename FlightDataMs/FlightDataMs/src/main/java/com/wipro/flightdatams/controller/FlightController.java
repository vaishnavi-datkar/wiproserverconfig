package com.wipro.flightdatams.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String source,
                                      @RequestParam String destination,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate) {
        return service.searchFlights(source, destination, flightDate);
    }
    @PostMapping("/add")
    public Flight add(@RequestBody Flight flight) {
        return service.save(flight);
    }

    @GetMapping
    public List<Flight> all() {
        return service.findAll();
    }
}