package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
class MyController{
	List<Person> persons=new ArrayList();
	@PostMapping("/post")
	public ResponseEntity<List<Person>> postMessage(@RequestBody Person person){
		this.persons.add(new Person(0, null, 0));
		this.persons.add(person);
		return ResponseEntity.ok().body(persons);
	}
	@SuppressWarnings("null")
	@GetMapping("/get")
	public ResponseEntity<List<Person>> getMessage(){
		
		return ResponseEntity.ok().allow().body(this.persons);
	}
	// @PutMapping("/update")
	// public ResponseEntity<Map<String,String>> updateMessage(){
	
	// }
	// @DeleteMapping("/delete")
	// public ResponseEntity<Map<String,String>> deleteMessage(){
		
	// }
	// @PatchMapping("/p-update")
	// public ResponseEntity<Map<String,String>> patchMessage(){
		
	// }
	
}








