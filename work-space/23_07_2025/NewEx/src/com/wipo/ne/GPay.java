package com.wipo.ne;

public class GPay implements PaymentMethod {

	    @Override
	    public void pay(double amount) {
	        System.out.println("Paid " + amount + " by using GPay....");
	    }
}
