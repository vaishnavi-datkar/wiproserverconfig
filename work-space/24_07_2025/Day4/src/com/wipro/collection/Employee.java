package com.wipro.collection;

import java.util.*;
public class Employee implements Comparable<Employee> {
    // fields...

		String empId;
	String empName;
	int age;
	double salary;
	public Employee(String empId, String empName, int age, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", age=" + age + ", salary=" + salary + "]";
	}
	 @Override
	    public int compareTo(Employee o) {
		 Double d1=Double.valueOf(this.getSalary());
		 Double d2=Double.valueOf(o.getSalary());
		 
	        return Double.compare(o.salary, this.salary);
	    }
	
	}
	


