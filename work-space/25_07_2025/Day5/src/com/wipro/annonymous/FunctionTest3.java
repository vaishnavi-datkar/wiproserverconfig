package com.wipro.annonymous;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

		public class FunctionTest3 { 

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				List<String> nameList = Arrays.asList("Jayanta", "Amit", "Vasu");

				Function<List<String>,List<Integer>> fn1 = list -> {
					List<Integer> fn2 = new ArrayList<>();
					for (String str : list) {
						fn2.add(str.length());
					}
					return fn2;
				};

				List<Integer> result = fn1.apply(nameList);
				System.out.println(result);  
			}
		

	}


