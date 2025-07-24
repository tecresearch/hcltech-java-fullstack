package com.hcl.ddl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hcl.setup.config.SpringConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AdvancedDDLRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        try {
            // 1. Create a sequence
            jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS emp_seq START 1");

            // 2. Create a view
            jdbcTemplate.execute("CREATE OR REPLACE VIEW employee_view AS SELECT name, salary FROM employees");

            // 3. Create an index
            jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_salary ON employees(salary)");

            // 4. Add a unique constraint
            jdbcTemplate.execute("ALTER TABLE employees ADD CONSTRAINT IF NOT EXISTS unique_email UNIQUE (email)");

            // 5. Rename a table
            jdbcTemplate.execute("ALTER TABLE employees RENAME TO staff");

            System.out.println("Advanced DDL operations executed successfully.");

        } catch (Exception e) {
            System.out.println("Error during DDL operations: " + e.getMessage());
        }

        // 6. Rename a database (requires separate connection)
        renameDatabase("hcltech", "hcltech_renamed", "postgres", "Tca@admin");
    }

    public static void renameDatabase(String oldDb, String newDb, String user, String password) {
        String url = "jdbc:postgresql://localhost:5432/postgres"; // connect to default DB

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "ALTER DATABASE " + oldDb + " RENAME TO " + newDb;
            stmt.executeUpdate(sql);
            System.out.println("Database renamed from '" + oldDb + "' to '" + newDb + "'.");

        } catch (Exception e) {
            System.out.println("Error renaming database: " + e.getMessage());
        }
    }
}
