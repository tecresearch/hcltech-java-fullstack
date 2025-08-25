/*
*The terms Subquery, Function, and CTE (Common Table Expression) refer to different SQL concepts
and serve distinct purposes in database querying. 

Here’s a breakdown of their differences:
--------------
Subquery:
Definition: A subquery is a query nested inside another SQL query.
It can return a single value or a set of values.
Use Case: Used to retrieve data that will be used in the outer query.
Example:
SELECT name FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);
---------------

Function
Definition: A function in SQL is a stored procedure
that performs operations and returns a single value or a table (in some databases).
Use Case: Used for encapsulating reusable logic that can be called within SQL queries. Functions can take parameters.
Example:
CREATE or replace FUNCTION getEmployeeCount() 
RETURNS INT AS $$
BEGIN
    RETURN (SELECT COUNT(*) FROM employees);
END;

-----------------
A stored procedure in SQL is a precompiled collection of one or more SQL statements that can be executed as a single unit. Stored procedures are used to perform operations such as querying, updating, inserting, or deleting data in a database.

Key Characteristics of Stored Procedures:
Modularity: They allow you to group multiple SQL statements for reuse.
Performance: They are precompiled, which can lead to better performance than executing a series of individual SQL statements.
Security: They can help encapsulate business logic and provide controlled access to data.
Creating a Stored Procedure:
Here’s a basic example of how you would create a stored procedure:

CREATE PROCEDURE GetEmployeeByID
    @EmployeeID INT
AS
BEGIN
    SELECT * FROM Employees WHERE EmployeeID = @EmployeeID;
END;
Executing a Stored Procedure:
After creating a stored procedure, you can execute it using the following syntax:

EXEC GetEmployeeByID @EmployeeID = 1;
Benefits of Using Stored Procedures:
Improved maintainability: Changes need only be made in one location.
Reduced network traffic: Multiple operations can be executed in a single call.
Encapsulation of business logic: This allows for easier updates and improvements without affecting application code directly.
-----------------

CTE (Common Table Expression)
Definition: A CTE is a temporary result set 
defined within the execution scope of a single SQL statement,
which can be referenced within SELECT, INSERT, UPDATE, or DELETE statements.
Use Case: Useful for organizing complex queries, making them more readable and manageable.
It can be recursive and is often used in hierarchical queries.
Example:
WITH EmployeeSalaries AS (
    SELECT name, salary FROM employees
)
SELECT name FROM EmployeeSalaries WHERE salary > 50000;
Key Differences
Scope:

Subqueries are executed per row during the execution of the overall query.
Functions can be reused across queries and are defined once in the database.
CTEs define a result set for the duration of a single query execution.
Performance:

Subqueries may impact performance negatively if not used judiciously.
Functions can be optimized based on how they are structured.
CTEs enhance readability but can lead to different execution plans and performance issues if not used correctly.
Readability:

CTEs improve the readability of complex queries compared to subqueries. 
Functions also enhance readability but with the added encapsulation of logic.

--------------------------

Choosing between a Subquery, Function, or CTE (Common Table Expression) depends on the specific use case of your SQL query. 

Here’s when to use each, along with examples:

1. Subquery
When to Use: Use a subquery when you need to filter or retrieve data based on the result of another query,
particularly for comparison or condition checks.

Example:
SELECT employee_id, name 
FROM employees 
WHERE department_id IN (SELECT department_id FROM departments WHERE location_id = 1400);

In this example, the subquery retrieves department IDs for a specific location,
and the outer query fetches employee names in those departments.
--------------------------
2. Function
When to Use: Use a function when you need to encapsulate reusable SQL logic, perform calculations or operations, or manipulate strings or dates.
Functions can take parameters and return a single value or a set.
Example:

CREATE FUNCTION getEmployeeFullName(emp_id INT)
RETURNS VARCHAR AS $$
BEGIN
    RETURN (SELECT CONCAT(first_name, ' ', last_name) FROM employees WHERE id = emp_id);
END;

-- Usage
SELECT getEmployeeFullName(1);

This function retrieves the full name of an employee based on their ID, promoting reusability in your queries.

-------------------------

3. CTE (Common Table Expression)
When to Use: Use a CTE for better readability and organization of complex queries,
especially when dealing with recursive queries 
or needing to reference the result multiple times within the same query.
Example:
WITH DepartmentSalaries AS (
    SELECT department_id, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY department_id
)
SELECT d.department_id, d.avg_salary
FROM DepartmentSalaries d
WHERE d.avg_salary > 60000;

Here, the CTE computes average salaries per department, 
allowing the main query to easily reference this result for filtering.
Using Common Table Expressions (CTEs) can greatly improve the readability and structure of complex SQL queries. Here’s a simplified explanation and an example to clarify their use:

What is a CTE?
A CTE is a temporary result set that you can reference within a SELECT, INSERT, UPDATE, or DELETE statement.
It acts like a named temporary table but only exists for the duration of the query.
Why Use CTEs?
Improves Readability: CTEs can help break down complex queries into simpler parts.
Reusability: You can reference the CTE multiple times within your main query without rewriting the same subquery.

Example Usage of CTE
Here’s a basic example to illustrate:

WITH SalesCTE AS (
    SELECT SaleID, ProductID, Quantity, SaleAmount
    FROM Sales
    WHERE SaleDate >= '2023-01-01'
)

SELECT ProductID, SUM(Quantity) AS TotalQuantity
FROM SalesCTE
GROUP BY ProductID;

SELECT ProductID, SUM(SaleAmount) AS TotalSales
FROM SalesCTE
GROUP BY ProductID;
Explanation of the Example:
CTE Definition: The CTE named SalesCTE filters sales that occurred in 2023.
First Query: It then calculates the total quantity sold per product using the CTE.
Second Query: You can use the same CTE again to calculate total sales amounts per product without rewriting the filtering logic.
This keeps your SQL neat and avoids repetition. Using CTEs like this can make complex queries easier to understand and maintain.
To utilize a window function to achieve the desired output of total report amounts grouped by email, you can use the SUM() function combined with the OVER() clause. This allows you to calculate aggregates without needing to group the result set.

Here’s how you can write your query using a window function:

Example Query Using Window Function:
SELECT DISTINCT email, 
       ROUND(SUM(amount) OVER (PARTITION BY email), 2) AS total_report_amount
FROM accounts a
JOIN reports r ON a.id = r.account_id
WHERE YEAR(r.dt) = 2025
ORDER BY email ASC;
Explanation of the Query:
SUM(amount) OVER (PARTITION BY email): This calculates the sum of amount for each email but keeps all the rows in the result set, effectively grouping by email without collapsing the results into fewer rows.
SELECT DISTINCT: This is used to ensure that each email appears only once in the final output.
Ordering: After grouping the results, the final output is sorted by email in ascending order.
Key Benefits of Using Window Functions:
Performance: They can often be more efficient than traditional aggregation when you need both aggregated and detailed data.
Flexibility: You can perform complex calculations over a specified range of rows related to the current row, which is beneficial for advanced analytics.
Simplified Queries: Achieves grouping and detailed output in a single query without the need for multiple subqueries or additional joins.




Summary

Use Subqueries for simple cases of data filtering or comparisons where a single result is sufficient.
Use Functions when you have repetitive logic or complex calculations that benefit from encapsulation and returns single value or whole table data.
Use CTEs for clarity in complex queries or when you need to reference the result set multiple times in a single query.
**/

select * from customers  ;
select * from orders ;
insert into customers values
(1,'Customer1','Los Angels'),
(2,'Customer2','Chicago'),
(3,'Customer3','Chicago');
insert into orders values
(1,1,'150.75'),
(2,2,230.50),
(3,3,345.25);

SELECT c.id AS customer_id, c.name, c.city, FLOOR(SUM(o.amount)) AS amount_spent
FROM customers AS c
LEFT JOIN orders AS o ON c.id = o.customer_id
GROUP BY c.id, c.name, c.city ;


SELECT customer_id,
       name,
       city,
       total_spending
FROM (
    SELECT c.id AS customer_id,
           c.name,
           c.city,
           FLOOR(SUM(o.amount)) AS total_spending,
           ROW_NUMBER() OVER (
               PARTITION BY c.city
               ORDER BY SUM(o.amount) DESC
           ) AS rn
    FROM customers c
    JOIN orders o
      ON c.id = o.customer_id
    GROUP BY c.id, c.name, c.city
) ranked
WHERE rn = 1
ORDER BY city;

--user defined function

create or replace function myFuctions(a int, b int )
returns int as $$
begin
	return a+b;
end
$$ language plpgsql

select myFuctions(10,23) as result;



CREATE OR REPLACE FUNCTION getCustomerData(eid INT)
RETURNS TABLE(cid INT, full_name VARCHAR(50), c_city VARCHAR(100)) AS $$
BEGIN
    RETURN QUERY select id,name,city from customers where id=eid;
    
END
$$ LANGUAGE plpgsql;

SELECT getCustomerData(2);
SELECT * from getCustomerData(2);

select * from customers where id=1 limit 2;



create index customer_id_index on customers(id);
create index order_id_index on orders(id);

explain analyse
  SELECT c.id AS customer_id, c.name, c.city, FLOOR(SUM(o.amount)) AS amount_spent
FROM customers AS c
LEFT JOIN orders AS o ON c.id = o.customer_id
GROUP BY c.id, c.name, c.city ;



create table campaigns(
id int primary key ,
name varchar(255),
is_active smallint
);

create table engagements(
views int ,
clicks int,
campaign_id int ,
foreign key (campaign_id) references campaigns(id)
);

INSERT INTO campaigns (id, name, is_active) VALUES  
    (4, 'SummerSaving', 1),
	(5,'FallFrenzy',1),
	(6,'WinterWonderland',0);
   
INSERT INTO engagements (views, clicks, campaign_id) VALUES  
    (100, 20, 4),  
	(200, 20, 4), 
	(100, 10, 4), 
	(50, 20, 5),  
	(20, 20, 5), 
	(30, 10, 6);
	
  


select * from campaigns;
select * from engagements;

select c.name, count(a.campaign_id) as total_engagement, coalesce(sum(a.views+a.clicks),) as total_views_and_clicks
from campaigns c
left join engagements a 
on c.id=a.campaign_id
where c.is_active=1
group by c.name order by c.name asc
;




create table accounts(
id int primary key ,
email varchar(255)
);

create table reports(
dt varchar(255),
amount decimal(6,2) ,
account_id int,
foreign key (account_id) references accounts(id)
);

-- Inserting records into the accounts table
INSERT INTO accounts (id, email) VALUES (1, 'example1@example.com');
INSERT INTO accounts (id, email) VALUES (2, 'example2@example.com');

-- Inserting records into the reports table
INSERT INTO reports (dt, amount, account_id) VALUES ('2023-01-01', 100.00, 1);
INSERT INTO reports (dt, amount, account_id) VALUES ('2023-01-02', 150.50, 1);
INSERT INTO reports (dt, amount, account_id) VALUES ('2023-01-01', 200.75, 2);
INSERT INTO reports (dt, amount, account_id) VALUES ('2024-01-01', 200.75, 2);
INSERT INTO reports (dt, amount, account_id) VALUES ('2025-01-01', 200.75, 2);
INSERT INTO reports (dt, amount, account_id) VALUES ('2025-01-01', 203.7565, 2);

select * 
from accounts a
join reports r
on a.id=r.account_id
order by r.dt asc;

--- using windows fuction

SELECT DISTINCT email, 
       ROUND(SUM(amount) OVER (PARTITION BY email), 2) AS total_report_amount
FROM accounts a
JOIN reports r ON a.id = r.account_id
WHERE r.dt like '%2025%'
ORDER BY email ASC;


--using subquery

select  email, round(sum(amount),2) as total_report_amount
from (
select * 
from accounts a
join reports r
on a.id=r.account_id
where r.dt  like '%2025%' --YEAR(r.dt)='2025'
order by r.dt asc
) acc
group by email
order by email asc
;

--using Stored Procedure
CREATE PROCEDURE GetTotalReportAmount
    (Year varchar )
AS $$
BEGIN
    SELECT  email, ROUND(SUM(amount), 2) AS total_report_amount
    FROM (
        SELECT * 
        FROM accounts a
        JOIN reports r ON a.id = r.account_id
        WHERE r.dt like '%' || Year || '%'
    ) AS acc
    GROUP BY email
    ORDER BY email ASC;
END
$$ language plpgsql;

-- CALL GetTotalReportAmount('2023');

--using Common Table Expression (CTE)

with accountsReportsJoined as (
select * 
from accounts a
join reports r
on a.id=r.account_id
where r.dt  like '%2025%' --YEAR(r.dt)='2025'
order by r.dt asc
)

select  email, round(sum(amount),2) as total_report_amount
from accountsReportsJoined acc
group by email
order by email asc
;

--using user defined function
CREATE OR REPLACE FUNCTION GetTotalReportAmount (Year VARCHAR) 
RETURNS TABLE(c_email VARCHAR(255), my_total_amount NUMERIC) AS $$
BEGIN
    RETURN QUERY (
    SELECT email, ROUND(SUM(amount), 2) AS total_report_amount
    FROM accounts a
    JOIN reports r ON a.id = r.account_id
    WHERE r.dt LIKE '%' || Year || '%'
    GROUP BY email
    );
END
$$ LANGUAGE plpgsql;

SELECT * FROM GetTotalReportAmount('2023');


/**
1. Create the customers Table:
Ensure that the table includes the necessary columns such as my_id, customer_name, and location.

**/

CREATE TABLE my_customers (
    my_id INT PRIMARY KEY,
    customer_name VARCHAR(255),
    location VARCHAR(255),
	created_at timestamp default now()
);
/**
2. Create the my_log Table (if not already created):
This step ensures the log table is ready to store the changes.

**/



CREATE TABLE my_log_temp (
    log_id SERIAL PRIMARY KEY,
    my_id INT,
    action VARCHAR(20),
    changed_at TIMESTAMP DEFAULT NOW()
);
/**
3. Create the Logging Function:
This function will log the changes when a trigger event occurs on the customers table.

**/

CREATE OR REPLACE FUNCTION log_changes_info()
RETURNS TRIGGER AS $$
BEGIN  
    INSERT INTO my_log(my_id, action) 
    VALUES(NEW.my_id, TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

/**
4. Create the Trigger:
Now, create the trigger which will execute the logging function whenever an insert, update, or delete operation occurs on the customers table.

**/

CREATE TRIGGER customer_trigger
AFTER  or INSERT OR UPDATE OR DELETE ON my_customers
FOR EACH ROW
EXECUTE FUNCTION log_changes_info();

/**

5. Insert Data into the customers Table:
Now you can insert some data into your new customers table.
**/

INSERT INTO my_customers (my_id, customer_name, location) 
VALUES (78449, 'Customer1-t', 'Los Angeles-t');
delete from my_customers where my_id=789;

/**
6. Check the Log:
After inserting data, you can check the my_log table to see if the log entry has been created correctly.
**/

SELECT * FROM my_log;






