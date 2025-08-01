package com.cetpa;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DemoController 
{
	@GetMapping("m1")
	public String method1()
	{
		return "GET API invoked";
	}
	@PostMapping("m2")
	public String method2()
	{
		return "POST API invoked";
	}
	@PutMapping("m3")
	public String method3()
	{
		return "PUT API invoked";
	}
	@PatchMapping("m4")
	public String method4()
	{
		return "PATCH API invoked";
	}
	@DeleteMapping("m5")
	public String method5()
	{
		return "DELETE API invoked";
	}
}
