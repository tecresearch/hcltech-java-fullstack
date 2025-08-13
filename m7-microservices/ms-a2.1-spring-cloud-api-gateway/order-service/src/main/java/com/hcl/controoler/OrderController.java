package com.hcl.controoler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

@RestController
public class OrderController {

	   @GetMapping("/order")
	   public String getOrder() {
		    return "order get successfully";
	   }
}
