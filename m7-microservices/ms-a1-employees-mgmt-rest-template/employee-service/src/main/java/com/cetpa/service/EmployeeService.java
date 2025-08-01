package com.cetpa.service;

import com.cetpa.entity.Employee;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	Employee getRecord(int eid);
	void deleteById(int eid,int did);
	void updateDepartmentById(int newDid,Employee employee);
}
