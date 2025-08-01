package com.cetpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
	@Autowired private UserDetailsService userDetailsService;
	
	/*@Bean
	DaoAuthenticationConfigurer<AuthenticationManagerBuilder, UserDetailsService> getConfigure(AuthenticationManagerBuilder auth)throws Exception
	{
		return auth.userDetailsService(userDetailsService);
	}*/
	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception 
	{	
		SecurityFilterChain securityFilterChain=http.csrf(cs->cs.disable())
				.authorizeHttpRequests(auth->auth
						.requestMatchers("/demo/add")
						.hasAnyRole("admin")
						.anyRequest()
						.fullyAuthenticated())
				.httpBasic(Customizer.withDefaults()).build();
		return securityFilterChain;
	}
	@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
