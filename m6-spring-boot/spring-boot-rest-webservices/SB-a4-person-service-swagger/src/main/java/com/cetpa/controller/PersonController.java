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

import com.cetpa.model.Person;
import com.cetpa.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@ResponseBody
@RequestMapping("person-api") 
public class PersonController 
{
	@Autowired private PersonService personService;
	
	//URL will be-->http://localhost:8080/person-api/add/person
	
	@Operation(summary = "Create a new person", description = "Adds a person to the system")
	@PostMapping("/add/person")
	public ResponseEntity<Person> addPersonResource(@RequestBody Person person)
	{
		personService.addPerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(person);
	}
	//URL will be-->http://localhost:8080/person-api/update/person/3
	@PutMapping("/update/person/{pid}")
	public ResponseEntity<Person> updatePersonResource(@PathVariable int pid,@RequestBody Person person)
	{
		person.setPersonId(pid);
		personService.updatePerson(person);
		//return ResponseEntity.status(HttpStatus.OK).body(person);
		return ResponseEntity.ok(person);
	}
	//URL will be-->http://localhost:8080/person-api/get/person?pid=1
	@GetMapping("/get/person")
	public ResponseEntity<Person> getPersonResource(@RequestParam int pid)
	{
		Person person=personService.getPerson(pid);
		if(person==null)
			return ResponseEntity.notFound().build();	
		return ResponseEntity.ok(person);
	}
	@GetMapping("/get/person-list")
	public ResponseEntity<List<Person>> getPersonResourceList()
	{
		List<Person> personList=personService.getList();
		if(personList.isEmpty())
			return ResponseEntity.noContent().build();	
		return ResponseEntity.ok(personList);
	}
	@DeleteMapping("/delete/person/{pid}")
	public ResponseEntity<Person> deletePersonResource(@PathVariable("pid") int personId)
	{
		Person person=personService.getPerson(personId);
		if(person==null)
			return ResponseEntity.notFound().build();
		personService.deletePerson(personId);
		return ResponseEntity.ok(person);
	}
	@PatchMapping("/pupdate/person")
	public ResponseEntity<Person> pupdatePersonResource(@RequestParam int pid,@RequestBody Person personn)
	{
		Person persono=personService.getPerson(pid);
		if(persono==null)
			return ResponseEntity.notFound().build();
		personService.pupdatePerson(persono,personn);
		return ResponseEntity.ok(persono);
	}
}
