package com.wipro.sqlop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Vaishnavi", "Rutika", "Tanuja", "Ankita");

        List<String> sortedList = list.stream()
                                   .sorted(String::compareTo)
                                  .collect(Collectors.toList());
        			System.out.println(sortedList);
    }
}
