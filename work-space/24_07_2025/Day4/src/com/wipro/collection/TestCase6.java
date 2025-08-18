package com.wipro.collection;

import java.util.*;
public class TestCase6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        List<Employee> list = new ArrayList<>();
		        list.add(new Employee("111", "vaishnavi", 25, 50000));
		        list.add(new Employee("102", "Neha", 30, 75000));
		        list.add(new Employee("103", "Ravi", 28, 60000));

		        Collections.sort(list); // Uses Comparable

		        for (Employee emp : list) {
		           System.out.println(emp);
		        }
		    }
		


	

}
