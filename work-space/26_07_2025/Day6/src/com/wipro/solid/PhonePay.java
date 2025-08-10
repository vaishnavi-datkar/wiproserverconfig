package com.wipro.solid;

public class PhonePay implements DigitalPayment{

	@Override
	public void makePayments(double amount) {
		// TODO Auto-generated method stub
	System.out.println("Payment" + "done by Phonepay");
	}

}
