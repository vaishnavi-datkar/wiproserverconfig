package com.wipro.orderms.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import com.wipro.orderms.dto.Payment;


@FeignClient(name="payment-ms")
public interface PaymentConnectService {
	@PostMapping("/payment")
	ResponseEntity<Payment> savePaymentData(@RequestBody Payment payment);
}
