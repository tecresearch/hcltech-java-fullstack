
package com.hcl.setup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfig {

    @Bean
    public DriverManagerDataSource myDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/tecresearch");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Tca@admin");

        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate myNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(myDataSource());
    }
}
