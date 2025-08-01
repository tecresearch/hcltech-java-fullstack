package com.cetpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController 
{
	@GetMapping("/add")
	public String addUser()
	{
		return "Add user api called...";
	}
	@GetMapping("/delete")
	public String deleteUser()
	{
		return "Delete user api called...";
	}
	@GetMapping("/update")
	public String updateUser()
	{
		return "Update user api called...";
	}
	@GetMapping("/show")
	public String showUser()
	{
		return "Show user api called...";
	}
}
