package in.tecresearch.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tecresearch.model.User;

@RestController
@RequestMapping("/secure")
public class Response {

	@GetMapping("/user")
	public ResponseEntity<Map<String,Object>> getUser(){
		User user=new User(101,"tecresearch","Tca@admin");
		Map<String, Object> response=new HashMap<>();
		response.put("user", user);
		response.put("timestamp", LocalDateTime.now());
		response.put("status", "User fetched successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
