package com.cetpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig 
{
	@Bean
	OpenAPI getOpenApi()
	{
		return new OpenAPI().info(new Info().title("Employee Service Document").description("Hello"));
	}
}
