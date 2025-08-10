package com.wipro.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=Arrays.asList("jaya","amit","vasu","dipika","amit");
		//Predicate<String> pred=(s)->s.length()<5;
		Predicate<String> pred=s->s.length()<5;
		Function<String,String> fn=s->s.toLowerCase();
		List<String> outputList=list
	.stream()
	.filter(s->s.length()<5)
	.map(s->s.toUpperCase())
		.distinct()
		.collect(Collectors.toList());
		System.out.println(outputList);
		
	}

}
