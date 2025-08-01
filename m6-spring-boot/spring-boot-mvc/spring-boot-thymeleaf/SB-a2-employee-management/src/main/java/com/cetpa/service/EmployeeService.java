package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveRecord(Employee employee) 
	{
		employeeRepository.addEmployee(employee);
	}
	public List<Employee> getList()
	{
		return employeeRepository.getEmployeeList();
	}
	public Employee getRecord(int eid) 
	{
		return employeeRepository.getEmployee(eid);
	}
	public void deleteRecord(int eid) 
	{
		Employee emp=employeeRepository.getEmployee(eid);
		employeeRepository.deleteEmployee(emp);
	}
	public void updateRecord(Employee employee) 
	{
		employeeRepository.updateRecord(employee);
	}
}
