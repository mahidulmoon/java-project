create database student_information;

create table security(
username varchar(20) not null,password varchar(20) not null);

insert into security values ('admin','12345');

create table student(
id int primary key,name varchar(20) not null,
age int not null,department varchar(20),
faculty varchar(7),gender varchar(7),religion varchar(10),martial varchar(20),email varchar(40),blood varchar(5),contactnumber varchar(11)
);

insert into student values (1,'mokbul',22,'CSE','FSIT','Male','islam','Married','mokbul@gmail.com','A+','01778207719');

