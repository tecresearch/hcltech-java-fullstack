package com.hcl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Paymentcontroller {

	  @GetMapping("/get")
	  public String getMessage() {
		  return "hi how are you";
	  }
	  
	  @GetMapping("/googlepay")
	   String getPay() {
		  return "google pay services";
	  }
}
