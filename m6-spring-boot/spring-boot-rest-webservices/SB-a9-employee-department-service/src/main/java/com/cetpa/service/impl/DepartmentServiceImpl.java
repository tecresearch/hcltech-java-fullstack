package com.cetpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Department;
import com.cetpa.repository.DepartmentRepository;
import com.cetpa.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentRepository;

	public void saveDepartment(Department department) 
	{
		departmentRepository.save(department);
	}

	public Boolean getDepartmentExistense(int did) 
	{
		return departmentRepository.existsById(did);
	}

	public void updateTotalEmployees(int did,int no) 
	{
		departmentRepository.updateTotalEmployees(did,no);
	}

	public Department getDepartment(int did) 
	{
		return departmentRepository.findById(did).orElse(null);
	}
}
