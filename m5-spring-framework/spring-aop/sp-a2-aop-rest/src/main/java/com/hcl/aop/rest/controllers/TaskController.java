package com.hcl.aop.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TaskController {
	
	@GetMapping
	public String test() {
		return "Success";
	}
}
