package com.wipro.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=Arrays.asList("vaishnavi","jaya","amit","jayanta","jnanedra","dipika","amit");
		List<String> outputList = list.stream()
                .filter(name -> name.indexOf("ja") >= 0)  
                .collect(Collectors.toList());

        System.out.println(outputList);
	}

}
