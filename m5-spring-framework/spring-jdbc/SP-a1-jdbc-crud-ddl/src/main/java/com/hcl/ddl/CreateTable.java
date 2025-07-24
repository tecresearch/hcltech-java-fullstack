package com.hcl.ddl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.setup.config.SpringConfig;

public class CreateTable {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                                "id SERIAL PRIMARY KEY, " +
                                "name VARCHAR(100) NOT NULL, " +
                                "email VARCHAR(100) UNIQUE NOT NULL, " +
                                "salary DECIMAL(10, 2) DEFAULT 0.00" +
                                ")";

        try {
            jdbcTemplate.execute(createTableSQL);
            System.out.println("Table 'employees' created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
