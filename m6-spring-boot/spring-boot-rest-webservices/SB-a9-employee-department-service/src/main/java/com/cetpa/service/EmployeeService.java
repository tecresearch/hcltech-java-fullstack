package com.cetpa.service;

import com.cetpa.dto.EmployeeDto;
import com.cetpa.entity.Employee;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	//Employee getRecord(int eid);
	EmployeeDto getRecord(int eid);
}
