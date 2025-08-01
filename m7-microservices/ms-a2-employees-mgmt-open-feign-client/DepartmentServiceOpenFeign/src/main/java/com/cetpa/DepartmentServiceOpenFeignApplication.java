package com.cetpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cetpa.client.EmployeeClient;

@SpringBootApplication
@EnableFeignClients
public class DepartmentServiceOpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceOpenFeignApplication.class, args);
	}
}
