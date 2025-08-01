package com.cetpa.repository;

import java.util.List;

import com.cetpa.model.Employee;

public interface EmployeeRepository 
{
	void saveRecord(Employee employee);
	List<Employee> findAll();
	void deleteRecord(int eid);
	Employee getRecord(int eid);
	void updateRecord(Employee employeeo, Employee employeen);
}
