package com.cetpa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cetpa.entity.Department;
import com.cetpa.repository.DepartmentRepository;
import com.cetpa.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) 
	{
		this.departmentRepository = departmentRepository;
	}

	public void saveDepartment(Department department) 
	{
		departmentRepository.save(department);
	}

	public List<Department> getDepartments() 
	{
		return departmentRepository.findAll();
	}

	public Department getDepartment(int deptId) 
	{
		Department department=departmentRepository.findById(deptId).orElse(null);
		return department;
	}

	public Boolean checkDepartment(int deptId) 
	{
		return departmentRepository.existsById(deptId);
	}
}
