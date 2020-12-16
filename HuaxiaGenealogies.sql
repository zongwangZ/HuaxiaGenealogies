create database huaxia_genealogies;

use huaxia_genealogies;

create table person(
	id int primary key auto_increment,
    uid varchar(18) unique,
    name varchar(20) not null,
    password varchar(20) not null
);