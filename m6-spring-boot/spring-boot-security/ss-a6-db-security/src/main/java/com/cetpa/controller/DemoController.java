package com.cetpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController 
{
	@GetMapping(value="add")
	public String addUser()
	{
		return "User has been added succesfully";
	}
	@GetMapping(value="delete")
	public String deleteUser()
	{
		return "User has been deleted succesfully";
	}
	@GetMapping(value="update")
	public String updateUser()
	{
		return "User has been updated succesfully";
	}
	@GetMapping(value="get")
	public String getUser()
	{
		return "User has been fetched succesfully";
	}
}
