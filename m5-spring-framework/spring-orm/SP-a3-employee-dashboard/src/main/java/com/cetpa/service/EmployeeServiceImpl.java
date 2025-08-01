package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.model.Employee;
import com.cetpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) 
	{
		employeeRepository.saveRecord(employee);
	}

	public List<Employee> getList() 
	{
		return employeeRepository.findAll();
	}

	public void deleteEmployee(int eid) 
	{
		employeeRepository.deleteRecord(eid);
	}

	public Employee getEmployee(int eid) 
	{
		return employeeRepository.getRecord(eid);
	}

	public void updateEmployee(Employee employeen) 
	{
		Employee employeeo=employeeRepository.getRecord(employeen.getEid());
		employeeRepository.updateRecord(employeeo,employeen);
	}
}
