package com.wipro.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class TestCase9 {
    public static void main(String[] args) {
        
        List<EmployeeInfo> employees = new CopyOnWriteArrayList<>();


        employees.add(new EmployeeInfo("101", "vaishnavi", 25, 59900));
        employees.add(new EmployeeInfo("1102", "Neha", 30, 850088));
        employees.add(new EmployeeInfo("103", "khushi", 28, 60080));
        employees.add(new EmployeeInfo("114", "Priya", 35, 90777));

        System.out.println("before removing Employee List:");
        for (EmployeeInfo emp : employees) {
            System.out.println(emp);
        }

        for (EmployeeInfo emp : employees) {
            if (emp.getSalary() > 80000) {
                employees.remove(emp); 
            }
        }

        System.out.println("========Employees earning 80000 or less than 80000: =========");
        for (EmployeeInfo emp : employees) {
            System.out.println(emp);
        }
    }
}