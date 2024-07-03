show databases;

create database student_management;

use student_management;

show tables;

create table login(
username varchar(20),
password varchar(20)
);

select * from login;

create table student(
name varchar(25),
fname varchar(25),
prn varchar(15),
dob varchar(40),
ay_year varchar(20),
phone varchar(20),
email varchar(40),
course varchar(25),
achievement varchar(40)
);

desc student;

select * from student;

ALTER TABLE student
MODIFY COLUMN achievement VARCHAR(100);

DELETE FROM student WHERE name = 'name';

create table teacher(
name varchar(25),
fname varchar(25),
emp_no varchar(15),
dob varchar(40),
address varchar(100),
phone varchar(20),
email varchar(40),
qualify varchar(20),
dept varchar(20)
);

desc teacher;

select * from teacher;

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/OOPS_CP_Data.csv' 
INTO TABLE student
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
(name,
fname,
prn,
dob,
ay_year,
phone,
email,
course,
achievement);

GRANT ALL PRIVILEGES ON student_management.* TO 'root'@'localhost';
FLUSH PRIVILEGES;

