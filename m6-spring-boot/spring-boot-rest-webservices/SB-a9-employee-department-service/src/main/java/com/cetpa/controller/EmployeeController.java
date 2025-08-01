package com.cetpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.dto.EmployeeDto;
import com.cetpa.entity.Employee;
import com.cetpa.service.EmployeeService;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	/*@GetMapping("details/byeid/{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int eid)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(employee);
	}*/
	@GetMapping("details/byeid/{eid}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int eid)
	{
		EmployeeDto employeeDto=employeeService.getRecord(eid);
		if(employeeDto==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(employeeDto);
	}
}
