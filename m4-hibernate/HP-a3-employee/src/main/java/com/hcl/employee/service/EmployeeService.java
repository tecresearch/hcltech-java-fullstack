package com.hcl.employee.service;

import com.hcl.employee.model.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public void persistEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee getEmployee(int id);
}
