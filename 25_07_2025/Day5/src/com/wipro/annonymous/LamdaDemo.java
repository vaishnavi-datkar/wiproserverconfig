package com.wipro.annonymous;

public class LamdaDemo {
	public static void main(String []s) {
		
		Multiply mul=(a,b)->{
			return a*b;
			
		};
	int x=mul.multiply(2,4);
		System.out.println(x);
	}
}
