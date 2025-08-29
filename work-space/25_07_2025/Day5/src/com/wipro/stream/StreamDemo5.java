package com.wipro.stream;

import java.util.Arrays;
import java.util.List;

public class StreamDemo5 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int count = numbers.size();

        double average = (double) sum / count;

        System.out.println("Average: " + average);
    }
}
