package com.cetpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cetpa.entity.Employee;
import com.cetpa.exception.DepartmentNotFoundException;
import com.cetpa.service.EmployeeService;

@RestController
@RequestMapping("employee-service")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private RestTemplate restTemplate;
	
	@PostMapping("add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		int did=employee.getDeptId();
		boolean departmentExist=restTemplate.getForObject("http://localhost:8080/department-service/byid/"+did,Boolean.class);
		if(!departmentExist)
		{
			throw new DepartmentNotFoundException("Department with id "+did+" does not exist");
		}
		employeeService.saveEmployee(employee);
		return null;
	}
}
