package com.cetpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Suggesting Doctor API", version = "1.0", description = "Doctor and Patient management"))
public class SuggestingdoctorsApiApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SuggestingdoctorsApiApplication.class, args);
	}

}
