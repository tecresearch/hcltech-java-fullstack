package com.cetpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmloyeeServiceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmloyeeServiceEurekaApplication.class, args);
	}

}
