package com.hcl.ddl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hcl.setup.config.SpringConfig;

public class AlterRenameTable {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        String sql = "ALTER TABLE employees RENAME TO employees_details";//postgress 
        jdbcTemplate.execute(sql);
        System.out.println("Table truncated successfully.");
    }
}
