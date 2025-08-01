/*
Explanation of Key Concepts
Database Management:

CREATE DATABASE and DROP DATABASE commands are used for creating and deleting databases.
Switching between databases is done using the USE command.
Table Operations:

CREATE TABLE defines the structure of a table.
RENAME TABLE moves or renames tables.
DROP TABLE deletes a table from the database.
Schema Modification:

ALTER TABLE allows you to modify the structure of an existing table, such as renaming columns or changing data types.
Data Manipulation:

INSERT INTO adds records to a table.
SELECT retrieves data from a table for verification.
Data Inspection:

DESC (or DESCRIBE) provides details about a table's schema.
SHOW TABLES lists all tables in the current database.
SHOW DATABASES lists all databases in the system.
*/

-- Create a database named 'sql_c'
CREATE DATABASE sql_c;

-- Show all databases in the system
SHOW DATABASES;

-- Select the 'sql_c' database for subsequent operations
USE sql_c;

-- Create a table named 'basics' with columns id, username, and passsword
CREATE TABLE basics(
    id INT AUTO_INCREMENT PRIMARY KEY, -- Auto-incrementing primary key for unique identification
    username VARCHAR(50),             -- Column for storing usernames, max length 50
    passsword VARCHAR(50)             -- Column for storing passwords (note the misspelling)
);

-- Create another table named 'basics1' with similar structure as 'basics'
CREATE TABLE basics1(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    passsword VARCHAR(50)
);

-- Create another table named 'basics2' with the same structure
CREATE TABLE basics2(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    passsword VARCHAR(50)
);

-- Display all tables in the current database ('sql_c')
SHOW TABLES;

-- Describe the structure of the 'basics' table
DESC basics;

-- Rename the table 'basics1' to 'basic3'
RENAME TABLE basics1 TO basic3;

-- Create a new database named 'sql_course'
CREATE DATABASE sql_course;

-- Move the 'basics' table from 'sql_c' to 'sql_course'
RENAME TABLE sql_c.basics TO sql_course.basics;

-- Switch to the 'sql_course' database
USE sql_course;

-- Show all tables in the 'sql_course' database
SHOW TABLES;

-- Describe the structure of the 'basics' table in the 'sql_course' database
DESC basics;

-- Rename the 'passsword' column to 'password' and change its type to VARCHAR(255)
ALTER TABLE basics CHANGE passsword password VARCHAR(255);

-- Insert a record into the 'basics' table with username and password values
INSERT INTO basics (`username`, `password`) VALUES ("mr.brijesh.mee", "Admin@tca");

-- Select all data from the 'basics' table to verify the inserted record
SELECT * FROM basics;

-- Switch back to the 'sql_c' database
USE sql_c;

-- Show all tables in the 'sql_c' database
SHOW TABLES;

-- Drop the table 'basic3' from the 'sql_c' database
DROP TABLE basic3;

-- Drop the 'sql_c' database entirely
DROP DATABASE sql_c;

-- Show the remaining databases in the system
SHOW DATABASES;

-- Switch to the 'sql_course' database
USE sql_course;

-- Show all tables in the 'sql_course' database
SHOW TABLES;

-- Describe the structure of the 'basics' table in 'sql_course'
DESC basics;

-- Select all records from the 'basics' table to verify the final state of data
SELECT * FROM basics;

Ques1: mysql> select * from employee where trim(rm)='' ;
