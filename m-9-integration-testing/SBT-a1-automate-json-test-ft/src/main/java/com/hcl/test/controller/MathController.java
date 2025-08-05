package com.hcl.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.test.dto.TestCaseRequest;
import com.hcl.test.service.MathService;

@RestController
@RequestMapping("/api/test/v1")
public class MathController {
	
	@Autowired
	private MathService mathService;
	@GetMapping("/result")
	public ResponseEntity<List<TestCaseRequest>> getResult(){
		return ResponseEntity.ok(mathService.getResult());
	}

}
