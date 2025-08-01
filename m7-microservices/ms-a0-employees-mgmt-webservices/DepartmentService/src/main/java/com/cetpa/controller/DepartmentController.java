package com.cetpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entity.Department;
import com.cetpa.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController
{
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) 
	{
		this.departmentService = departmentService;
	}
	@PostMapping
	public Department addDepartment(@RequestBody Department department)
	{
		departmentService.saveDepartment(department);
		return department;
	}
	@GetMapping
	public List<Department> getList()
	{
		return departmentService.getDepartments();
	}
	@GetMapping("/{deptId}")
	public Department getDepartment(@PathVariable int deptId)
	{
		return departmentService.getDepartment(deptId);
	}
}
