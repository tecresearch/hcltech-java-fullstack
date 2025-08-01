package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.dto.PersonDto;
import com.cetpa.mapper.EntityMapper;
import com.cetpa.model.Person;
import com.cetpa.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService 
{
	@Autowired private EntityMapper mapper;
	private PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository)
	{
		this.personRepository=personRepository;
	}
	public void addPerson(PersonDto personDto) 
	{
		personRepository.save(mapper.mapIntoEntity(personDto));
	}
	public PersonDto getPerson(int pid) 
	{
		Person person=personRepository.findById(pid).orElse(null);
		if(person==null)
			return null;
		return mapper.mapIntoDto(person); 
	}
}
