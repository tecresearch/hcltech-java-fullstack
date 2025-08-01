package com.cetpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person-service")
public class PersonController 
{
	@GetMapping
	public Person getPerson()
	{
		Person person=new Person();
		person.setName("Amit");
		person.setAge(20);
		return person;
	}
}
