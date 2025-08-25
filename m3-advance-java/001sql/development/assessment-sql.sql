create table student (
	id int  primary key,
	name varchar(100),
	age int ,
	grade int
);
alter table student
add column marks int;

INSERT INTO student (id, name, age, marks,grade) VALUES
(1045, 'Brijesh', 23, 60,13),
(124, 'Dev', 23, 65,90),
(13063, 'Aditi', 21, 75,99),
(12073, 'Rahul', 24, 80,4),
(10483, 'Sita', 22, 70,4),
(10393, 'Akash', 25, 85,12),
(12103, 'Nina', 23, 90,56),
(12113, 'Ravi', 20, 50,56),
(13142, 'Lata', 22, 65,67),
(19143, 'Anil', 24, 95,56),
(10144, 'Sneha', 21, 88,46),
(11945, 'Suresh', 23, 92,34),
(19126, 'Pooja', 22, 78,34),
(11937, 'Raj', 25, 67,35),
(11938, 'Deepa', 24, 77,34),
(19139, 'Vijay', 23, 66,66),
(10230, 'Kiran', 21, 80,44),
(10221, 'Amit', 20, 65,34);


select * from student;
select count(*) from student where grade>50;
select sum(age) from student;

update student
set grade = 70
where name='brijesh';

delete from student where name='brijesh' ;

select * from student order by id asc;

select * from student where grade is null ;

SELECT name, AVG(marks) AS average_marks
FROM student
GROUP BY name
HAVING AVG(marks) > 70;

create table department(
id int primary key ,
name varchar(100)
);


INSERT INTO department (id, name) VALUES
(1, 'Sales'),
(2, 'Marketing'),
(3, 'Research and Development'),
(4, 'Finance'),
(5, 'Human Resources'),
(6, 'Customer Service'),
(7, 'IT Support'),
(8, 'Logistics'),
(9, 'Engineering'),
(10, 'Product Management'),
(11, 'Legal'),
(12, 'Quality Assurance'),
(13, 'Health and Safety'),
(14, 'Training and Development'),
(15, 'Public Relations'),
(16, 'Compliance'),
(17, 'Administration'),
(18, 'Procurement'),
(19, 'Business Development'),
(20, 'Corporate Strategy'),
(21, 'Data Analytics'),
(22, 'Technical Support'),
(23, 'Supply Chain Management'),
(24, 'Vendor Management'),
(25, 'Digital Marketing'),
(26, 'Content Creation'),
(27, 'Social Media'),
(28, 'Sales Enablement'),
(29, 'Market Research'),
(30, 'Customer Experience');

create table employee(
id int primary key,
emp_name varchar(100),
salary float4,
dept_id int ,
foreign key (dept_id) references department(id) 
);

INSERT INTO employee (id, emp_name, salary, dept_id) VALUES
(1, 'John Smith', 55000, 1),
(2, 'Sara Jones', 62000, 2),
(3, 'Michael Brown', 70000, 3),
(4, 'Emily Davis', 52000, 4),
(5, 'David Wilson', 48000, 5),
(6, 'Sophia Taylor', 92000, 1),
(7, 'James Anderson', 68000, 2),
(8, 'Olivia Thomas', 75000, 3),
(9, 'Daniel White', 53000, 4),
(10, 'Ava Harris', 59000, 5),
(11, 'Michael Lee', 81000, 6),
(12, 'Emma Walker', 58000, 7),
(13, 'William Hall', 62000, 8),
(14, 'Isabella Allen', 57000, 9),
(15, 'Ethan Young', 72000, 10),
(16, 'Charlotte King', 65000, 11),
(17, 'Amelia Wright', 60000, 12),
(18, 'Lucas Scott', 64500, 13),
(19, 'Grace Green', 58000, 14),
(20, 'Benjamin Adams', 72000, 15),
(21, 'Mia Baker', 68000, 16),
(22, 'Ella Gonzalez', 99000, 1),
(23, 'Henry Perez', 42000, 17),
(24, 'Jackson Roberts', 67000, 18),
(25, 'Zoe Turner', 74000, 19),
(26, 'Liam Murphy', 50000, 20),
(27, 'Chloe Sanchez', 83000, 21),
(28, 'David Clark', 49000, 22),
(29, 'Ella Lewis', 89000, 23),
(30, 'Noah Lee', 71000, 24),
(31, 'Madison Hill', 91000, 1),
(32, 'Jacob Robinson', 54000, 3),
(33, 'Backley Smith', 86000, 4),
(34, 'Carter Walker', 60000, 5),
(35, 'Nina Phillips', 72000, 6),
(36, 'James Phillips', 46000, 14),
(37, 'Fiona Moore', 87000, 15),
(38, 'Alice Reyes', 52000, 16),
(39, 'Logan Martinez', 81000, 17),
(40, 'Lily Edwards', 69000, 18),
(41, 'Ella Murphy', 53000, 19),
(42, 'Owen Bell', 65000, 20),
(43, 'Sebastian Wood', 72000, 21),
(44, 'Avery Jackson', 49000, 22),
(45, 'Henry Johnson', 80000, 23),
(46, 'Addison Martinez', 40000, 24),
(47, 'Muhammad Harris', 44000, 1),
(48, 'Luna Allen', 47000, 2),
(49, 'Sophie King', 83000, 3),
(50, 'Brooklyn Scott', 56000, 4),
(51, 'David Thompson', 65000, 5),
(52, 'Leah Price', 73000, 6),
(53, 'Travis Wright', 57000, 7),
(54, 'Samantha Hill', 55000, 8),
(55, 'Danny Long', 44000, 9),
(56, 'Mason Young', 62000, 10),
(57, 'Ariana Johnson', 69000, 11),
(58, 'Callum Jones', 75000, 12),
(59, 'Athena Sanchez', 99999, 13),
(60, 'Elijah Clark', 67000, 14),
(61, 'Elena Lewis', 48000, 15),
(62, 'Jaxon Baker', 69000, 16),
(63, 'Harrison Nelson', 61000, 17),
(64, 'Julia Carter', 54000, 18),
(65, 'Brielle Green', 77000, 19),
(66, 'Alana Marsh', 58000, 20),
(67, 'Hayden Sullivan', 71000, 21),
(68, 'Sophie Pierce', 59000, 22),
(69, 'Owen Powell', 64000, 23),
(70, 'Brooke Lee', 68000, 24),
(71, 'Levi Nguyen', 79000, 1),
(72, 'Jacob Hernandez', 62000, 2),
(73, 'Ricardo Ramirez', 78000, 3),
(74, 'Kylie Sanchez', 47000, 4),
(75, 'Paige Hall', 72000, 5),
(76, 'Ashton Torres', 65000, 6),
(77, 'Aidan Parker', 63000, 7),
(78, 'Hannah Edwards', 80000, 8),
(79, 'Benjamin Morales', 72000, 9),
(80, 'Gabriella Ortiz', 82000, 10),
(81, 'Daniel Harris', 61000, 11),
(82, 'Lillian Cox', 57000, 12),
(83, 'Oliver Watson', 74000, 13),
(84, 'Emma Baker', 52000, 14),
(85, 'Ruby Foster', 69000, 15),
(86, 'Kelly Reyes', 63800, 16),
(87, 'Megan Morgan', 65000, 17),
(88, 'Jacob Powell', 70000, 18),
(89, 'Abigail Sanders', 83000, 19),
(90, 'Tyler Cooper', 90000, 20),
(91, 'Zoe Rivera', 42000, 21),
(92, 'Xander Gray', 59000, 22),
(93, 'Grayson Turner', 67000, 23),
(94, 'Isabel Ramirez', 73000, 24),
(95, 'Olivia Bennett', 67000, 1),
(96, 'Max Wilson', 49000, 2),
(97, 'Scarlett Morris', 60000, 3),
(98, 'Bryce Carpenter', 44000, 4),
(99, 'Violet Barnes', 53000, 5),
(100, 'Sophia Jenkins', 71000, 1);

--inner join : only common data retrival
select e.emp_name , d.name
from employee e
inner join department d on e.id=d.id;

--inner join : only common data retrival





