package com.wipro.stream;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str=Optional.ofNullable(null).orElse("Default").toString();
		Integer source=10;
		Optional<Integer>num=Optional.ofNullable(source);
		System.out.println(num);
		 num.ifPresent(val -> System.out.println("Value is: " + val));
		 Integer result = num.orElse(0);
	        System.out.println("Final result: " + result);
	}

}
