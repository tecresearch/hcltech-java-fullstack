package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;
import com.hcl.validation.EmployeeValidation;
import com.hcl.validation.Validation;

@RestController
@RequestMapping
public class EmployeeController {

	   
	@Autowired
	private EmployeeValidation employeeValidation;
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping("/employee")
	public ResponseEntity<?>addEmployee(@RequestBody Employee emp){
		
		   List<Validation>errors=employeeValidation.validate(emp);
		   
		   if(!errors.isEmpty()) {
			      return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		   }
		   
		  Employee newEmployee=new Employee();
		  newEmployee.setFullName(emp.getFullName());
		  newEmployee.setEmailId(emp.getEmailId());
		  newEmployee.setDateOfBirth(emp.getDateOfBirth());
		  newEmployee.setMobileNumber(emp.getMobileNumber());
		  
		  employeeRepository.save(newEmployee);
		  
		  return new ResponseEntity<>(newEmployee,HttpStatus.OK);
		 
	}
}
