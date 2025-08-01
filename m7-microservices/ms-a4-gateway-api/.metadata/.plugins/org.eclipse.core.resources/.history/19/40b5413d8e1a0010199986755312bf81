package com.cetpa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cetpa.client.EmployeeClient;
import com.cetpa.entity.Department;
import com.cetpa.model.Employee;
import com.cetpa.repository.DepartmentRepository;
import com.cetpa.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	private DepartmentRepository departmentRepository;
	private EmployeeClient employeeClient;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository,EmployeeClient employeeClient) 
	{
		this.departmentRepository = departmentRepository;
		this.employeeClient=employeeClient;
	}

	public void saveDepartment(Department department) 
	{
		departmentRepository.save(department);
	}

	public List<Department> getDepartments() 
	{
		List<Department> deptList=departmentRepository.findAll();
		/*List<Department> departments=new ArrayList<>();
		for(Department dept:deptList)
		{
			dept.setEmployees(employeeClient.getEmployeeListByDeptId(dept.getDeptId()));
			departments.add(dept);
		}*/
		List<Department> departments=deptList.stream()
				.map(dept->{
					dept.setEmployees(employeeClient.getEmployeeListByDeptId(dept.getDeptId()));
					return dept;
				}).collect(Collectors.toList());
		return departments;
	}

	public Department getDepartment(int deptId) 
	{
		Department department=departmentRepository.findById(deptId).orElse(null);
		List<Employee> employees=employeeClient.getEmployeeListByDeptId(deptId);
		department.setEmployees(employees);
		return department;
	}

	public Boolean checkDepartment(int deptId) 
	{
		return departmentRepository.existsById(deptId);
	}
}
