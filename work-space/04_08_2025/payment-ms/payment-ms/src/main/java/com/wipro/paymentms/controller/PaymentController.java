package com.wipro.paymentms.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.wipro.paymentms.entity.Payment;
import com.wipro.paymentms.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    
   
    @PostMapping
	void save(@RequestBody Payment payment)
	{
		
		paymentService.save(payment);
		
		
	}

	@GetMapping
	List<Payment> findAll()
	{
		return paymentService.findAll();
	}
}