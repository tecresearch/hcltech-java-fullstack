package com.cetpa.service;

import java.util.List;

import com.cetpa.model.Person;

public interface PersonService 
{
	void addPerson(Person person);
	void updatePerson(Person person);
	Person getPerson(int pid);
	List<Person> getList();
	void deletePerson(int personId);
	void pupdatePerson(Person persono, Person personn);
}
