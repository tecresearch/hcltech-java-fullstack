package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cetpa.dto.PersonDto;
import com.cetpa.model.Person;
import com.cetpa.service.PersonService;

@Controller
@ResponseBody
@RequestMapping("person-api") 
public class PersonController 
{
	@Autowired private PersonService personService;
	
	
	@PostMapping("/add/person")
	public ResponseEntity<PersonDto> addPersonResource(@RequestBody PersonDto personDto)
	{
		personService.addPerson(personDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
	}
	@GetMapping("/get/person")
	public ResponseEntity<PersonDto> getPersonResource(@RequestParam int pid)
	{
		PersonDto personDto=personService.getPerson(pid);
		if(personDto==null)
			return ResponseEntity.notFound().build();	
		return ResponseEntity.ok(personDto);
	}
}
