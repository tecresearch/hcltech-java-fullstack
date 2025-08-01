package com.cetpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig 
{
	@Bean
	UserDetailsService getUserDetailsService(PasswordEncoder encoder)
	{
		UserDetails user1=User.withUsername("amit123").password(encoder.encode("amit")).roles("admin","system").build();
		UserDetails user2=User.withUsername("manoj123").password(encoder.encode("manoj")).roles("system").build();
		UserDetails user3=User.withUsername("kuldeep123").password(encoder.encode("kuldeep")).roles("user","system").build();
		UserDetailsService userDetailsService=new InMemoryUserDetailsManager(user1,user2,user3);
		return userDetailsService;
	}
	@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
