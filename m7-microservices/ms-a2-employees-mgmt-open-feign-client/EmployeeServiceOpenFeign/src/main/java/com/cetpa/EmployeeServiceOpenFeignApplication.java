package com.cetpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceOpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceOpenFeignApplication.class, args);
	}

}
