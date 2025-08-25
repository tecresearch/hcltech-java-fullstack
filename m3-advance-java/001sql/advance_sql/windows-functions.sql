
/**
The SQL functions you've listed can be categorized as follows:

1. Date and Time Functions
Functions:
NOW(): Returns the current date and time.
CURRENT_DATE: Returns the current date.
CURRENT_TIME: Returns the current time.
2. String Functions
Function:
CONCAT('Brijesh', ' ', 'Nishad'): Concatenates multiple strings into one single string.
3. Mathematical Functions
Functions:
ROUND(123.224, 2): Rounds a number to a specified number of decimal places.
POWER(2, 3): Raises a number to the power of another number.
CEIL(value): Rounds a number up to the nearest integer (Ceiling function).
FLOOR(value): Rounds a number down to the nearest integer (Floor function).
Categories Breakdown:
Date and Time Functions: NOW(), CURRENT_DATE, CURRENT_TIME
String Functions: CONCAT()
Mathematical Functions: ROUND(), POWER(), CEIL(), FLOOR()
**/

select  now();
select current_date;
select current_time;
select concat('Brijesh',' ','Nishad');
select round(123.224,2);
select power(2,3);
select ceil(.9);
select ceil(.5);
select ceil(.4);
select ceil(1.9);--rounding up
select floor(.5);
select floor(1.9);-- rounding down

select extract(year from now());
select extract(month from now());
select extract(day from now());
select now()+interval '7 days';
/**
Windows functions in SQL are specialized for performing calculations across a set of table rows that are somehow related to the current row. There are several types of window functions, generally classified into three main categories:

1. Aggregate Functions
Description: Operate on a set of rows and return a single value.
SUM()
AVG()
COUNT()
MIN()
MAX()
**/
CREATE TABLE my_user (
    user_id  serial PRIMARY KEY ,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now() 
);
INSERT INTO my_user (username, email, password) VALUES 
    ('john_doe', 'john@example.com', 'securepassword1'),
    ('jane_smith', 'jane@example.com', 'securepassword2'),
    ('alice_jones', 'alice@example.com', 'securepassword3'),
    ('bob_brown', 'bob@example.com', 'securepassword4');
select * from my_user;
SELECT COUNT(*) AS total_users FROM my_user;
SELECT username, COUNT(*) AS occurrences 
FROM my_user 
GROUP BY username;
SELECT AVG(LENGTH(username)) AS average_username_length FROM my_user;
SELECT MAX(user_id) AS max_user_id FROM my_user;
SELECT MIN(user_id) AS min_user_id FROM my_user;





/**
2. Ranking Functions
Description: Assign a rank to each row within a partition of a result set.
Common Functions:
ROW_NUMBER(): Assigns a unique number to each row, starting from 1.
RANK(): Assigns the same rank to identical values, leaving gaps in the subsequent ranks.
DENSE_RANK(): Similar to RANK() but does not leave gaps.
**/

/**
3. Analytic Functions
Description: Perform calculations across a range of rows related to the current row, often involving a sliding window.
Common Functions:
LAG(): Accesses data from a previous row in the same result set.
LEAD(): Accesses data from a subsequent row in the result set.
**/


/**
Key Considerations:
Window functions do not reduce the number of rows returned from the query; instead, they add new columns with calculated values.
Use PARTITION BY to divide the result set into partitions to perform calculations on each group separately.
Use ORDER BY to specify the order of rows within each partition for the calculations.
Understanding how and when to use these window functions can significantly enhance your SQL querying capabilities.
**/


