package com.hcl.jdbc;

import java.sql.*;

public class PostgresJDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/hcltech";
        String user = "postgres";
        String password = "Tca@admin";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employees (" +
                               "id SERIAL PRIMARY KEY, " +
                               "name VARCHAR(100), " +
                               "position VARCHAR(100))");

            // Insert data
            stmt.executeUpdate("INSERT INTO employees (name, position) VALUES " +
                               "('Alice', 'Manager'), " +
                               "('Bob', 'Developer')");

            // Query data
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Position: " + rs.getString("position"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
