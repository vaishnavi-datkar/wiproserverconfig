package com.wipro.annonymous;

import java.util.*;

public class EmployeeTest {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("vaishnavi", 25, 50000));
		empList.add(new Employee("ravi", 30, 60000));
		empList.add(new Employee("Vasu", 22, 55000));

		empList.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("Sorted by Salary:" + empList);
		
		
		
	}
}
