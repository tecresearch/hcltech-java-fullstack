package com.cetpa.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	public HomeController() {
		System.out.println("Home controller created...");
	}
	
	@GetMapping("")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("username")==null)
		{
			return "user/login/login-form";	
		}
		return "home/home";
	}
}
