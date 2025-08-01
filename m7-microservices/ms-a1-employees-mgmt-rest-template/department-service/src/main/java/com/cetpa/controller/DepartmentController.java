package com.cetpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entity.Department;
import com.cetpa.service.DepartmentService;

@RestController
@RequestMapping("department-service")
public class DepartmentController 
{
	@Autowired private DepartmentService departmentService;
	
	@PostMapping("add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)
	{
		departmentService.saveDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(department);
	}
	@GetMapping("byid/{did}")
	public ResponseEntity<Boolean> getDepartmentBy(@PathVariable int did)
	{
		Boolean res=departmentService.getDepartmentExistense(did);
		return ResponseEntity.ok(res);
	}
	@PutMapping("update/employee-count/increase/{did}")
	public ResponseEntity<Boolean> increaseEmployeeCount(@PathVariable int did)
	{
		departmentService.updateTotalEmployees(did,1);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@PutMapping("update/employee-count/decrease/{did}")
	public ResponseEntity<Boolean> decreaseEmployeeCount(@PathVariable int did)
	{
		departmentService.updateTotalEmployees(did,-1);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@PutMapping("update/employee-count")
	public ResponseEntity<Boolean> updateEmployeeCount(@RequestParam int oldDid,@RequestParam int newDid)
	{
		departmentService.updateTotalEmployees(oldDid,-1);
		departmentService.updateTotalEmployees(newDid,1);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@GetMapping("details/byid/{did}")
	public ResponseEntity<Department> getDepartmentBy1(@PathVariable int did)
	{
		System.out.println("Called...");
		Department department=departmentService.getDepartment(did);
		return ResponseEntity.ok(department);
	}
}
