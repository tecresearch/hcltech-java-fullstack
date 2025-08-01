package com.cetpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
	@Bean
	UserDetailsService getUserDetailsService(PasswordEncoder encoder)
	{
		String pa1=encoder.encode("amit");
		UserDetails user1=User.withUsername("amit123").password(pa1).roles("admin","system").build();
		UserDetails user2=User.withUsername("manoj123").password(encoder.encode("manoj")).roles("system").build();
		UserDetails user3=User.withUsername("kuldeep123").password(encoder.encode("kuldeep")).roles("user","system").build();
		UserDetailsService userDetailsService=new InMemoryUserDetailsManager(user1,user2,user3);
		return userDetailsService;
	}
	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception 
	{	
		//SecurityFilterChain securityFilterChain=http.csrf(cs->cs.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/demo/add","demo/delete").hasRole("admin").anyRequest().fullyAuthenticated()).formLogin(Customizer.withDefaults()).build();
		//SecurityFilterChain securityFilterChain=http.csrf(cs->cs.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/demo/add").hasRole("admin").requestMatchers("/demo/delete").hasRole("user").anyRequest().fullyAuthenticated()).formLogin(Customizer.withDefaults()).build();
		//SecurityFilterChain securityFilterChain=http.csrf(cs->cs.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/demo/get").permitAll().requestMatchers("/demo/add").hasRole("admin").anyRequest().fullyAuthenticated()).formLogin(Customizer.withDefaults()).build();
		SecurityFilterChain securityFilterChain=http.csrf(cs->cs.disable()).
				authorizeHttpRequests(auth->auth.
						requestMatchers("/demo/show").
						permitAll().
						anyRequest().
						fullyAuthenticated()).
				formLogin(Customizer.withDefaults()).
				build();
		return securityFilterChain;
	}
	@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
