package com.wipro.collection;
import java.util.*;

public class TestCase8{
    public static void main(String[] args) {
        List<EmployeeInfo> list = new ArrayList<>();
        list.add(new EmployeeInfo("E101", "Ravi", 25, 50000));
        list.add(new EmployeeInfo("E102", "Neha", 30, 75000));
        list.add(new EmployeeInfo("E103", "Amit", 28, 60000));
        		
        System.out.println("Sorted by Salary Desc:");
        Collections.sort(list, new SortedBySalary());
        list.forEach(System.out::println);

        System.out.println("\nSorted by Name:");
        Collections.sort(list, new SortedByName());
        list.forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        Collections.sort(list, new SortByAge());
        list.forEach(System.out::println);
    }
}

