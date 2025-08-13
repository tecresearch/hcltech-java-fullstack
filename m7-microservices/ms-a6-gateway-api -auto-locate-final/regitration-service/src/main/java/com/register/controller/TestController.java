
package com.register.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/test/register")
	public ResponseEntity<Object> testService(){
		return ResponseEntity.ok("Register service is running");
	}

}
