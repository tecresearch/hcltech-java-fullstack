package com.hcl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getHomeView(Model model) {
		System.out.println("in home controller");
		model.addAttribute("message","From home controller");
		return "welcome";
	}
}
