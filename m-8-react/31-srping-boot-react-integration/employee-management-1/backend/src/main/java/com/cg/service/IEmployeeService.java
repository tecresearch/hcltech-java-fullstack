package com.cg.service;

import java.util.List;

import com.cg.bean.Employee;
import com.cg.dto.EmployeeDto;
import com.cg.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	public EmployeeDto createEmployee(EmployeeDto e);
	public List<Employee> getAllEmployee();
	public EmployeeDto getEmployeeByID(int empid) throws EmployeeNotFoundException;
	public String removeEmployee(int empid) throws EmployeeNotFoundException;
	public void updateEmployee(EmployeeDto emp);
	public List<Employee> getEmployeeByNameLike(String name);
}
