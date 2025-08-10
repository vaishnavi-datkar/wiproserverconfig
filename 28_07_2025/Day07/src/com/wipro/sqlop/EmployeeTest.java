package com.wipro.sqlop;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Demo1> employee = Arrays.asList(
		            new Demo1("John", 25, 40000),
		            new Demo1("Alice", 35, 60000),
		            new Demo1("Bob", 40, 70000),
		            new Demo1("Charlie", 20, 30000),
		            new Demo1("David", 38, 55000)
		        );

		        OptionalDouble averageSalary = employee.stream()
		            .filter(e -> e.getAge() > 30 && e.getSalary() > 50000)
		            .mapToDouble(Demo1::getSalary)
		            .average();
		        System.out.println(averageSalary);
		    }

}
