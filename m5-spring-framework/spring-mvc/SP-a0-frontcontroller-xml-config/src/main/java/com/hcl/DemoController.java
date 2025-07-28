package com.hcl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	//http://localhot:8080/projectname/d1
	@GetMapping("d1")
	public ModelAndView demoMyMethod1() {
		System.out.println("demoMyMethod1 envoked...");
		return null;
	}
	//http://localhot:8080/projectname/d2
	@GetMapping("d2")
	public ModelAndView demoMyMethod2() {
		System.out.println("demoMyMethod2 envoked...");
		return null;
	}
}
