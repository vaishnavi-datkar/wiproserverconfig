package com.wipro.uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.uber.entity.Booking;
import com.wipro.uber.service.UberService;

	@RestController
	@RequestMapping("/ride")
	public class UberController {
		
		@Autowired
		UberService uberService;
		
		@PostMapping
		void ride(@RequestBody Booking booking)
		{
			uberService.ride(booking);
		}
		

	}
