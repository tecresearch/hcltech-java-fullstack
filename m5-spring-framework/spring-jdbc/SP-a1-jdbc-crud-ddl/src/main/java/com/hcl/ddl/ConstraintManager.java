package com.hcl.ddl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hcl.setup.config.SpringConfig;

public class ConstraintManager {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        try {
            // 1. Add Primary Key
            jdbcTemplate.execute("ALTER TABLE staff ADD PRIMARY KEY (id)");
            System.out.println("Primary key added.");

            // 2. Add Unique Constraint
            jdbcTemplate.execute("ALTER TABLE staff ADD CONSTRAINT unique_email UNIQUE (email)");
            System.out.println("Unique constraint added.");

            // 3. Add Foreign Key
            jdbcTemplate.execute("ALTER TABLE staff ADD COLUMN department_id INT");
            jdbcTemplate.execute("ALTER TABLE staff ADD CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES departments(id)");
            System.out.println("Foreign key added.");

            // 4. Drop Primary Key
            jdbcTemplate.execute("ALTER TABLE staff DROP CONSTRAINT staff_pkey");
            System.out.println("Primary key dropped.");

            // 5. Drop Unique Constraint
            jdbcTemplate.execute("ALTER TABLE staff DROP CONSTRAINT unique_email");
            System.out.println("Unique constraint dropped.");

            // 6. Drop Foreign Key
            jdbcTemplate.execute("ALTER TABLE staff DROP CONSTRAINT fk_department");
            System.out.println("Foreign key dropped.");

        } catch (Exception e) {
            System.out.println("Error managing constraints: " + e.getMessage());
        }
    }
}
