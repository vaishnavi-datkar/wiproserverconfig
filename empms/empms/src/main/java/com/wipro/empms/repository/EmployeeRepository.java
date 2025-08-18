package com.wipro.empms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.empms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByName(String name);
}
