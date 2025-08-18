package com.wipro.annonymous;

import java.util.function.Function;

public class FuncationTest2 {

	public static void main(String[] args) {

		Function<Double, Double> n = (num) -> {
			double fractional = num - Math.floor(num);
			return Math.round(fractional * 1000.0) / 1000.0;
		};

		double input = 99.675;
		

		System.out.println(n.apply(input)); 
	}
}
