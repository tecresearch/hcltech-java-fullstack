package com.cetpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entity.User;
import com.cetpa.service.UserService;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired private UserService userService;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@PostMapping("create")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		String pass=user.getUserPassword();
		String epass=passwordEncoder.encode(pass);
		user.setUserPassword(epass);
		userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
