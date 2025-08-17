package com.wipro.empms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.empms.entity.Employee;
import com.wipro.empms.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee save(Employee e) {
    	return repo.save(e); 
    	}

    public List<Employee> findAll() { 
    	return repo.findAll();
    	}

    public Employee findById(Long id) { 
    	return repo.findById(id).orElse(null); 
    	}

    public List<Employee> findByName(String name) {
        return repo.findByName(name); 
    }
    public void delete(Long id) { 
    	repo.deleteById(id); 
    	}
}