package com.cetpa.mapper;

import org.springframework.stereotype.Component;

import com.cetpa.dto.PersonDto;
import com.cetpa.model.Person;

@Component
public class EntityMapper 
{
	public Person mapIntoEntity(PersonDto personDto)
	{
		Person person=new Person();
		person.setPersonName(personDto.getPersonName());
		person.setPersonAge(personDto.getPersonAge());
		return person;
	}
	public PersonDto mapIntoDto(Person person)
	{
		PersonDto personDto=new PersonDto();
		personDto.setPersonName(person.getPersonName());
		personDto.setPersonAge(person.getPersonAge());
		return personDto;
	}
}
