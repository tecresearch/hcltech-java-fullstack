package com.cetpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.client.DepartmentClient;
import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	private EmployeeRepository employeeRepository;
	@Autowired private DepartmentClient departmentClient;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}

	public void saveEmployee(Employee employee) 
	{
		int deptId=employee.getDeptId();
		if(!departmentClient.isDepartmentExist(deptId))
		{
			throw new RuntimeException("Department with id "+deptId+" does not exist");
		}
		employeeRepository.save(employee);
	}

	public List<Employee> getEmployees() 
	{
		return employeeRepository.findAll();
	}

	public Employee getEmployee(int empId) 
	{
		return employeeRepository.findById(empId).orElse(null);
	}
	public List<Employee> findEmployeeListByDeptId(int deptId) 
	{
		return employeeRepository.findByDeptId(deptId);
	}
	
}
