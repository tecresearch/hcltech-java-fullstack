package com.cetpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entity.UserRole;
import com.cetpa.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController 
{
	@Autowired private RoleService roleService;
	
	@PostMapping("create")
	public ResponseEntity<UserRole> addUserRole(@RequestBody UserRole userRole)
	{
		roleService.saveRole(userRole);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRole);
	}
}
