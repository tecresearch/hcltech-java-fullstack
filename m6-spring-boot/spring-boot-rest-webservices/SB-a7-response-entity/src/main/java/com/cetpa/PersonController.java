package com.cetpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person-service")
public class PersonController 
{
	private Person person;
	@GetMapping
	public ResponseEntity<Person> getPerson()
	{
		/*person=new Person();
		person.setName("Amit");
		person.setAge(20);*/
		if(person==null)
			return ResponseEntity.notFound().build();
		//ResponseEntity<Person> response=ResponseEntity.ok(person);
		//return response;
		return ResponseEntity.ok(person);
	}
}
