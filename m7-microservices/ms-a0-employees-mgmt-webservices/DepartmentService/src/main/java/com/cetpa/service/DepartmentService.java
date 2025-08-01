package com.cetpa.service;

import java.util.List;

import com.cetpa.entity.Department;

public interface DepartmentService
{
	void saveDepartment(Department department);
	List<Department> getDepartments();
	Department getDepartment(int deptId);
	Boolean checkDepartment(int deptId);
}
