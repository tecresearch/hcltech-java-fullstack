package com.hcl.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.test.dto.TestCaseRequest;
import com.hcl.test.service.MathService;

@RestController
@RequestMapping("/api/test/v1")
public class MathController {
	
	@Autowired
	private MathService mathService;
	@GetMapping("/result/{a}/{b}")
	public ResponseEntity<Integer> getResult(@PathVariable("a") int a,@PathVariable("b") int b){
		return ResponseEntity.ok(mathService.addTwoNumber(a, b));
	}
	
	@GetMapping("/list")
	public ResponseEntity<Map<Integer, Object>> getList() {
	    // Create a dummy list to return.
	    Map<Integer, Object> dummyList = new HashMap<>();
	    dummyList.put(1, "First Item");
	    dummyList.put(2, "Second Item");

	    // Return the dummy list wrapped in ResponseEntity.
	    return ResponseEntity.ok(dummyList);
	}
	

}
