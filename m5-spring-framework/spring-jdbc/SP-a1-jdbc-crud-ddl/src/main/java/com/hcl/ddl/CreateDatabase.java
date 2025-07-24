package com.hcl.ddl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres"; // Connect to default DB
        String user = "postgres";
        String password = "Tca@admin";

        String dbName = "tecresearch";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE DATABASE " + dbName;
            stmt.executeUpdate(sql);
            System.out.println("Database '" + dbName + "' created successfully.");

        } catch (Exception e) {
            System.out.println("Error creating database: " + e.getMessage());
        }
    }
}
