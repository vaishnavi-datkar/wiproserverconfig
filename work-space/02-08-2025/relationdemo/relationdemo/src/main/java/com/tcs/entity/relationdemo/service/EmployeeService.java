package com.tcs.entity.relationdemo.service;

import com.tcs.entity.relationdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
