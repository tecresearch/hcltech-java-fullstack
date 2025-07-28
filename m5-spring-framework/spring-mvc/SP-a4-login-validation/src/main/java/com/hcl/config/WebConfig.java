package com.hcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hcl")
public class WebConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
