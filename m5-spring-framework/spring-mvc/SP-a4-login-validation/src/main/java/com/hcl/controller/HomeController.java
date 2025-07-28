package com.hcl.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHome() {

		return "home";
	}

	@GetMapping("/login")
	public String getLogin() {
		
		return "login";
	}
	@GetMapping("/auth")
	public String authUser(@RequestParam Map<String, String> allParams, Model model) {
		String username = (String)allParams.get("username");
		String password = (String)allParams.get("password");

		// Check for null before calling equals
		if (username != null && password != null && username.equals("admin") && password.equals("Tca@admin")) {
			model.addAttribute("username", username);
			model.addAttribute("password", password);
			return "dashboard";
		}

		model.addAttribute("sms", "Invalid Credentials");
		model.addAttribute("username", username);
		return "login";
	}
}
