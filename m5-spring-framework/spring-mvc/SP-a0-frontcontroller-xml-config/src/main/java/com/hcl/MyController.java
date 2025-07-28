package com.hcl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	//http://localhot:8080/projectname/m1
	@GetMapping("m1")
	public ModelAndView handleMyMethod1() {
		System.out.println("handleMyMethod1 envoked...");
		return null;
	}
	//http://localhot:8080/projectname/m2
	@GetMapping("m2")
	public ModelAndView handleMyMethod2() {
		System.out.println("handleMyMethod2 envoked...");
		return null;
	}
}
