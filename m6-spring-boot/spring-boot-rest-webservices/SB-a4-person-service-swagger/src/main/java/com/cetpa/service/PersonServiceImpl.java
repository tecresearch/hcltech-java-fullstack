package com.cetpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cetpa.model.Person;
import com.cetpa.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService 
{
	private PersonRepository personRepository;
	public PersonServiceImpl(PersonRepository personRepository)
	{
		this.personRepository=personRepository;
	}
	public void addPerson(Person person) 
	{
		personRepository.save(person);
	}
	public void updatePerson(Person person) 
	{
		personRepository.save(person);
	}
	public Person getPerson(int pid) 
	{
		return personRepository.findById(pid).orElse(null);
	}
	public List<Person> getList() 
	{
		List<Person> personList=personRepository.findAll();
		return personList;
	}
	public void deletePerson(int personId) 
	{
		personRepository.deleteById(personId);
	}
	public void pupdatePerson(Person persono, Person personn) 
	{
		String name=personn.getPersonName();
		if(name!=null)
			persono.setPersonName(name);
		int age=personn.getPersonAge();
		if(age!=0)
			persono.setPersonAge(age);
		System.out.println("Udate:"+age);
		personRepository.save(persono);
	}
}
