--for varchar to timestamp
create table support_tickets(
id int primary key,
customer_id int,
created_at varchar(19),
resolved_at varchar(19)
);
insert into support_tickets values
(1,1,'2023-12-21 05:42:00','2024-01-01 05:42:00'),
(2,2,'2023-07-08 14:22:00',NULL),
(3,3,'2023-05-22 08:54:00','2023-06-17 08:54:00');
truncate support_tickets;
select round(avg(extract(epoch from ((resolved_at::timestamp)-(created_at::timestamp)))/3600),2) as response_time  from support_tickets;

SELECT ROUND(AVG(EXTRACT(EPOCH FROM (TO_TIMESTAMP(resolved_at, 'YYYY-MM-DD HH24:MI:SS') - TO_TIMESTAMP(created_at, 'YYYY-MM-DD HH24:MI:SS'))) / 3600), 2) AS avg_response_time_hours
FROM support_tickets
WHERE resolved_at IS NOT NULL AND resolved_at != 'NULL';


--for date

create table s_tickets(
id int primary key,
customer_id int,
created_at date,
resolved_at date
);
 INSERT INTO s_tickets VALUES
(1, 1, '2023-12-21', '2024-01-01'),
(2, 2, '2023-07-08', NULL),
(3, 3, '2023-05-22', '2023-06-17');

truncate s_tickets;
select * from s_tickets;

select round(avg(extract(epoch from ((resolved_at::timestamp)-(created_at::timestamp)))/3600),2) from s_tickets;

--for timestamp

create table st_tickets(
id int primary key,
customer_id int,
created_at timestamp,
resolved_at timestamp
);

insert into st_tickets values
(1,1,'2023-12-21 05:42:00','2024-01-01 05:42:00'),
(2,2,'2023-07-08 14:22:00',NULL),
(3,3,'2023-05-22 08:54:00','2023-06-17 08:54:00');

truncate st_tickets;
select * from st_tickets;


select resolved_at, created_at from st_tickets;
select resolved_at - created_at from st_tickets;
select avg(resolved_at - created_at) from st_tickets;


select round(avg(extract(epoch from (resolved_at-created_at))/3600),2) as response_time  from st_tickets;




