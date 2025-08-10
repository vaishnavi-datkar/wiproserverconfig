package com.wipro.paymentms.service;

import java.util.List;

import com.wipro.paymentms.entity.Payment;

 

public interface PaymentService {

	void save(Payment order);
	List<Payment> findAll();
}