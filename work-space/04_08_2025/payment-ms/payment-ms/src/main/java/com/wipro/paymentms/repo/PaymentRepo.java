package com.wipro.paymentms.repo;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.paymentms.entity.Payment;  

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {}
