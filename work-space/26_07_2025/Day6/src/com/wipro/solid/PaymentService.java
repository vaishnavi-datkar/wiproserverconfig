package com.wipro.solid;

public class PaymentService {
	DigitalPayment digitalPayment;

	public PaymentService(DigitalPayment digitalPayment) {
		super();
		this.digitalPayment = digitalPayment;
	}
	public void pay(double amount) {
		digitalPayment.makePayments(amount);
	}
}
