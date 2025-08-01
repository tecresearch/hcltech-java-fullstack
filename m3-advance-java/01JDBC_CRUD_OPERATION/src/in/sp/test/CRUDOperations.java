package in.sp.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperations {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecresearch?connectTimeout=500", "tca", "Admin@brijesh");
            if (con != null) {
                System.out.println("Database tecresearch connection successfully loaded");
            }
            
            // Get user input for operation
            System.out.println("Select Operation:");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Show All Data");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Insert
                    performInsert(con);
                    break;
                case 2: // Update
                    performUpdate(con);
                    break;
                case 3: // Delete
                    performDelete(con);
                    break;
                case 4: // Show All Data
                    showAllData(con);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            // Close the resources
            con.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void performInsert(Connection con) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get user input for data
            scanner.nextLine(); // Consume newline
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter city: ");
            String city = scanner.nextLine();

            // Prepare and execute the SQL statement (DML command)
            String insertQuery = "INSERT INTO register (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setString(2, email);
            insertStatement.setString(3, password);
            insertStatement.setString(4, gender);
            insertStatement.setString(5, city);

            int insertResult = insertStatement.executeUpdate();
            if (insertResult > 0) {
                System.out.println("Record inserted successfully");
            } else {
                System.out.println("Failed to insert record");
            }

            // Close resources
            insertStatement.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void performUpdate(Connection con) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get user input for data
            scanner.nextLine(); // Consume newline
            System.out.print("Enter email to update: ");
            String emailToUpdate = scanner.nextLine();

            System.out.print("Enter new city: ");
            String newCity = scanner.nextLine();

            // Prepare and execute the SQL statement (DML command)
            String updateQuery = "UPDATE register SET city = ? WHERE email = ?";
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setString(1, newCity);
            updateStatement.setString(2, emailToUpdate);

            int updateResult = updateStatement.executeUpdate();
            if (updateResult > 0) {
                System.out.println("Record updated successfully");
            } else {
                System.out.println("Failed to update record");
            }

            // Close resources
            updateStatement.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void performDelete(Connection con) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get user input for data
            System.out.print("Enter email to delete: ");
            String emailToDelete = scanner.nextLine();

            // Prepare and execute the SQL statement (DML command)
            String deleteQuery = "DELETE FROM register WHERE email = ?";
            PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
            deleteStatement.setString(1, emailToDelete);

            int deleteResult = deleteStatement.executeUpdate();
            if (deleteResult > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("Failed to delete record");
            }

            // Close resources
            deleteStatement.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showAllData(Connection con) {
        try {
            // Prepare and execute the SQL statement to retrieve all data
            String selectQuery = "SELECT * FROM register";
            Statement selectStatement = con.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            // Display all data
            System.out.println("All Data in register table:");
            while (resultSet.next()) {
           
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                String city = resultSet.getString("city");

                System.out.println( " Name: " + name + "\n Email: " + email
                        + "\n Password: " + password + "\n Gender: " + gender + "\n City: " + city);
                System.out.println();
            }
            // Close resources
            resultSet.close();
            selectStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
