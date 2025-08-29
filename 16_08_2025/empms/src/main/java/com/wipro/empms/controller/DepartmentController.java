package com.wipro.empms.controller;

import com.wipro.empms.entity.Department;
import com.wipro.empms.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public Department add(@RequestBody Department d) {
        return service.save(d);
    }

    @GetMapping
    public List<Department> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/search/{name}")
    public Department getByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
