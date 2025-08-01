package com.cetpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception 
	{	
		SecurityFilterChain securityFilterChain=http.csrf(cs->cs.disable()).build();
		return securityFilterChain;
	}
	@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
