package com.hcl.setup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hcl.setup.config.SpringConfig;

@EnableTransactionManagement
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        TransactionTemplate transactionTemplate = context.getBean(TransactionTemplate.class);

        // Example usage of TCL operations
//        createRole(jdbcTemplate, "user_role", "your_password"); // Create role
        grantPermission(jdbcTemplate, "user_role", "SELECT"); // Grant permission

        // Perform TCL operations
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    // Your transactional code here
                    // For example, inserting data or other operations
                    System.out.println("Performing transactional operations...");
                    // Simulate an operation
                    // jdbcTemplate.update(...);
                    return null;
                } catch (Exception e) {
                    status.setRollbackOnly(); // Rollback on error
                    System.out.println("Transaction rolled back due to: " + e.getMessage());
                    return null;
                }
            }
        });
    }

    public static void createRole(JdbcTemplate jdbcTemplate, String roleName, String password) {
        String sql = "CREATE ROLE " + roleName + " WITH LOGIN PASSWORD '" + password + "'";
        jdbcTemplate.execute(sql);
        System.out.println("Created role: " + roleName);
    }

    public static void grantPermission(JdbcTemplate jdbcTemplate, String roleName, String permission) {
        String sql = "GRANT " + permission + " ON ALL TABLES IN SCHEMA public TO " + roleName;
        jdbcTemplate.execute(sql);
        System.out.println("Granted " + permission + " to " + roleName);
    }

    public static void revokePermission(JdbcTemplate jdbcTemplate, String roleName, String permission) {
        String sql = "REVOKE " + permission + " ON ALL TABLES IN SCHEMA public FROM " + roleName;
        jdbcTemplate.execute(sql);
        System.out.println("Revoked " + permission + " from " + roleName);
    }
}