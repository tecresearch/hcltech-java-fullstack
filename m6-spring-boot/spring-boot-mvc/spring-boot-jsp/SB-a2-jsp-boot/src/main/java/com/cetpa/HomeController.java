package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController 
{
	@GetMapping("cetpa")
	public String getHome()
	{
		return "home";
	}
}
