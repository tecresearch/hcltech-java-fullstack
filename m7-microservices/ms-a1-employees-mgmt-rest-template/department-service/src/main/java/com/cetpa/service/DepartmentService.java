package com.cetpa.service;

import com.cetpa.entity.Department;

public interface DepartmentService 
{
	void saveDepartment(Department department);
	Boolean getDepartmentExistense(int did);
	void updateTotalEmployees(int did,int no);
	Department getDepartment(int did);
}
