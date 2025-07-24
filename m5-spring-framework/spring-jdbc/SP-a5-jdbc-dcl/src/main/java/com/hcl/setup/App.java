package com.hcl.setup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.setup.config.SpringConfig;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // Example usage of DCL operations
//        createRole(jdbcTemplate, "user_role", "your_password"); // Create role
        grantPermission(jdbcTemplate, "user_role", "SELECT"); // Grant permission
        revokePermission(jdbcTemplate, "user_role", "SELECT"); // Revoke permission
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
