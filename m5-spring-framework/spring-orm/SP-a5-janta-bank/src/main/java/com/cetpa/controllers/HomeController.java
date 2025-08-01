package com.cetpa.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController 
{
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
