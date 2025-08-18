package com.wipro.annonymous;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		Predicate<String> isUpperCase = str -> str.equals(str.toUpperCase());
		 Predicate<String> isLowerCase = str -> str.equals(str.toLowerCase());

		String str1 = "abcd";
		System.out.println(isUpperCase.test(str1));  
		System.out.println(isLowerCase.test(str1));  
	}
}
//Supplier<LocalDate> dt=()->{return Localdate} 