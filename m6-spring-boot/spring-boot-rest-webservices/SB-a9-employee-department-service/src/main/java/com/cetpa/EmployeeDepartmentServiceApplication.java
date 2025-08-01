package com.cetpa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cetpa.mapper.EmployeeMapper;

@SpringBootApplication
public class EmployeeDepartmentServiceApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeDepartmentServiceApplication.class, args);
	}
	@Bean
	EmployeeMapper getMapper()
	{
		return new EmployeeMapper();
	}
	@Bean
	ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}
