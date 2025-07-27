package com.hcl.aop.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hcl.aop.util.service.DatabaseService;



@SpringBootApplication(scanBasePackages = "com.hcl.aop")
public class SpA2AopRestApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpA2AopRestApplication.class, args);
		 
	DatabaseService service =context.getBean(DatabaseService.class);
	service.testConnection();
	}

}
