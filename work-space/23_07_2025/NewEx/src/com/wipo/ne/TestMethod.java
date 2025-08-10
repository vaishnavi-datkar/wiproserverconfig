
package com.wipo.ne;


public class TestMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentMethod payment = new GPay();
        payment.pay(2890.0);
        payment = new PhonePay();
        payment.pay(950.0);
	}

}
