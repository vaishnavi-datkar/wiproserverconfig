package com.wipro.paymentms.service;

import com.wipro.paymentms.dto.PaymentRequest;
import com.wipro.paymentms.dto.PaymentResponse;

public interface PaymentService {
	PaymentResponse processPayment(PaymentRequest request);
}
