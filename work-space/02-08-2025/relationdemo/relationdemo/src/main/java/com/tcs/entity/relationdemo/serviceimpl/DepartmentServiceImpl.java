package com.tcs.entity.relationdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.relationdemo.entity.Department;
import com.tcs.entity.relationdemo.repo.DepartmentRepo;
import com.tcs.entity.relationdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepo departmentRepo;

	@Override
	public List<Department> findAll() {
		return departmentRepo.findAll();
	}
}
