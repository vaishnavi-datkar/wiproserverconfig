package com.wipro.annonymous;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		
		Consumer<Integer> nextEvenNo = (num) -> System.out.println((num % 2 == 0) ? (num + 2) : (num + 1));
		
		nextEvenNo.accept(12);  
		nextEvenNo.accept(100);   
	}
}
