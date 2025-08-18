package com.wipro.empms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.wipro.empms.entity.Department;
import com.wipro.empms.repository.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public Department save(Department d) {
        return repo.save(d);
    }

    public List<Department> findAll() {
        return repo.findAll();
    }

    public Department findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Department findByName(String name) {
        Optional<Department> dept = repo.findByNameIgnoreCase(name);
        return dept.orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
