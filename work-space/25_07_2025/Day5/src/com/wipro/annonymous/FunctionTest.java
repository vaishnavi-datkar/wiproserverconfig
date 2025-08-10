package com.wipro.annonymous;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<String,Integer> fn=s -> {return s.length();};
		System.out.println(fn.apply("jaya"));
	List<Integer> numList=Arrays.asList(1,2,4,5);
	Function<List<Integer>,Integer>doSum= list->{
		int sum=0;
		for(int n:list)
		{
			sum=sum+n;
		}
		return sum;
	};
	
	int sumVal=doSum.apply(numList);
	System.out.println(sumVal);
	}

}
