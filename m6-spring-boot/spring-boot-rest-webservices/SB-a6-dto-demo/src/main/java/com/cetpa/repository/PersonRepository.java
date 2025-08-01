package com.cetpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> 
{
}
