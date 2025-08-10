package com.tcs.entity.relationdemo.service;

import com.tcs.entity.relationdemo.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);  // ✅ Required!
    List<Department> getAllDepartments();
}
