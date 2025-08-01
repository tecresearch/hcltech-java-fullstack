package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cetpa.models.User;
import com.cetpa.services.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String getLoginView()
	{
		return "login/login-form";
	}
	@GetMapping("registration")
	public String getRegistrationView()
	{
		return "login/registration-form";
	}
	@PostMapping("register-user")
	public String registerUser(User user,Model model)
	{
		int accountno=userService.saveUser(user);
		model.addAttribute("accountno",accountno);
		model.addAttribute("username",user.getFirstname()+" "+user.getLastname());
		return "login/registeration-success";
	}
}
