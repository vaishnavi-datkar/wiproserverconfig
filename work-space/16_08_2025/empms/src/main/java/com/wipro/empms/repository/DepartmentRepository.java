package com.wipro.empms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.empms.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
	    Optional<Department> findByNameIgnoreCase(String name);
}
