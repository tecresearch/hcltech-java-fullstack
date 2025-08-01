package com.cetpa.service;

import java.util.List;

import com.cetpa.model.Employee;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	List<Employee> getList();
	void deleteEmployee(int eid);
	Employee getEmployee(int eid);
	void updateEmployee(Employee employee);
}
