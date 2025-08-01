package com.cetpa.service;

import com.cetpa.dto.PersonDto;

public interface PersonService 
{
	void addPerson(PersonDto personDto);
	PersonDto getPerson(int pid);
}
