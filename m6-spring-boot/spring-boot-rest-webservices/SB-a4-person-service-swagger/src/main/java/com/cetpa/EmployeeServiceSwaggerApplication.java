package com.cetpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Person API", version = "1.0", description = "Person Management API"))
public class EmployeeServiceSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceSwaggerApplication.class, args);
	}

}
