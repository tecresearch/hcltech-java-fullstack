package com.cetpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entity.Employee;
import com.cetpa.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController
{
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) 
	{
		this.employeeService = employeeService;
	}
	@PostMapping
	public Employee addDepartment(@RequestBody Employee employee)
	{
		employeeService.saveEmployee(employee);
		return employee;
	}
	@GetMapping
	public List<Employee> getList()
	{
		return employeeService.getEmployees();
	}
	@GetMapping("/{empId}")
	public Employee getEmplaoyee(@PathVariable int empId)
	{
		return employeeService.getEmployee(empId);
	}
	@GetMapping("/department/{deptId}")
	public List<Employee> getEmplaoyeeListByDeptId(@PathVariable int deptId)
	{
		return employeeService.findEmployeeListByDeptId(deptId);
	}
}
