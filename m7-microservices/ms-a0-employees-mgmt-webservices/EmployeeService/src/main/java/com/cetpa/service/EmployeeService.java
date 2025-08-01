package com.cetpa.service;

import java.util.List;

import com.cetpa.entity.Employee;

public interface EmployeeService
{
	void saveEmployee(Employee employee);
	List<Employee> getEmployees();
	Employee getEmployee(int empId);
	List<Employee> findEmployeeListByDeptId(int deptId);
}
