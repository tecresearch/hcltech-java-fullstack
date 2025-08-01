package com.hcl.services;

import java.util.List;

import com.hcl.entities.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee employee);
	public void updateEmployeeByEmpId(int empId);
	public Employee getEmployeeByEmpId(int i);
	public List<Employee> getEmployees();
	public boolean deleteEmployeeByEmpId(int empId);
}
