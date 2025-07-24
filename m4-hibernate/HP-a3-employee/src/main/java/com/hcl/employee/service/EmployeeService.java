package com.hcl.employee.service;

import java.util.List;

import com.hcl.employee.model.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public void persistEmployee(Employee employee);
	public void updateEmployee(Employee employee,int id);
	public void deleteEmployee(int id);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
}
