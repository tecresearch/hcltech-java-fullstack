CREATE DATABASE tecresearch;
SHOW DATABASES;
USE tecresearch;
CREATE TABLE users(
id int ,
name varchar(100),
role varchar(10)
);
show tables;
desc users;
select * from users;

truncate table users;
create table users(
id int auto_increment primary key,
name varchar(100),
role varchar(10)
);

