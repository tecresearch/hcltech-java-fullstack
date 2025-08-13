
package com.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/test/login")
	public ResponseEntity<Object> testService(){
		return ResponseEntity.ok("Auth service is running");
	}

}
