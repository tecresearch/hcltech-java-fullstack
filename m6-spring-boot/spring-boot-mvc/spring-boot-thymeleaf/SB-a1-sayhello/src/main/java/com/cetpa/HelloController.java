package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("sayhello")
public class HelloController 
{
	//url of this handler-->http://localhost:8080/sayhello/hello
	@GetMapping("/hello")
	public String getInputView()
	{
		return "hello-form";
	}
	//url of this handler-->http://localhost:8080/sayhello/hellouser
	@GetMapping("/hellouser")
	public String sayHelloToUser(String str,Model model)
	{
		model.addAttribute("name",str);
		return "sayhello";
	}
}
