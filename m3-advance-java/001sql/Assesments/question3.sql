 


select * from customers;
select * from orders;


WITH city_max_spending AS (
    SELECT 
        c.city AS city, 
        MAX(o.amount)AS total_spending
    FROM customers c
    LEFT JOIN orders o ON c.id = o.customer_id
    GROUP BY c.city
)


SELECT 
    c.id AS customer_id,
    c.name,
    cm.city ,
    floor(o.amount) as total_spending
FROM customers c
JOIN orders o ON c.id = o.customer_id
JOIN city_max_spending cm ON c.city = cm.city and o.amount=cm.total_spending ;










with group_max_amount as 
(
	select  c.city,max(o.amount) as total_spending
	from customers c
	join orders o 
	on c.id=o.customer_id
	group by c.city 
	
)

select o.customer_id,c.name,c.city, floor(gma.total_spending)
from customers c
join orders o on c.id=o.customer_id
join group_max_amount gma on gma.city=c.city and gma.total_spending=o.amount;




-- recursive cte
with recursive Numbers as(
select 1 as n
union all
select n+1 from Numbers where n<10
)
select * from Numbers;


CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    manager_id INT,
    FOREIGN KEY (manager_id) REFERENCES employees(id)  -- Self-referential foreign key
);

INSERT INTO employees (name, manager_id) VALUES
('Alice', NULL),  -- CEO, no manager
('Bob', 1),       -- Bob is managed by Alice
('Charlie', 1),   -- Charlie is managed by Alice
('David', 2),     -- David is managed by Bob
('Eve', 2);       -- Eve is also managed by Bob

 WITH RECURSIVE employee_hierarchy AS (
    SELECT id, name, manager_id
    FROM employees
    WHERE name = 'Alice'  -- Start from Alice (the root of the hierarchy)
    UNION ALL
    SELECT e.id, e.name, e.manager_id
    FROM employees e
    INNER JOIN employee_hierarchy eh ON e.manager_id = eh.id
)
SELECT * FROM employee_hierarchy;

