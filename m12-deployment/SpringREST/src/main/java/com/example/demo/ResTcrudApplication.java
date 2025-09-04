package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.example.controller"),
	@ComponentScan("com.example.service")})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class ResTcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTcrudApplication.class, args);
	}

}
