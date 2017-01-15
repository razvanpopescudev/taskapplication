create database manager_taskuri;

use manager_taskuri;

create table users(id int primary key auto_increment, password varchar(80) not null, email varchar(240) not null unique, buget_total double);


create table task_types(id int primary key auto_increment, typename varchar(50) not null);

    


create table priority(id int primary key auto_increment, priority_name varchar(40));
insert into priority(priority_name) values('urgent'), ('medium'), ('not important');

create table tasks(id int primary key auto_increment, titlu varchar(50) not null, descriere text, 
	data_adaugare datetime default now(), 
    data_terminare datetime, durata int, cost double, tip int, completata tinyint(1), prioritate int);
alter table tasks add constraint fk_types foreign key(tip) references task_types(id);
alter table tasks add constraint fk_priority foreign key(prioritate) references priority(id);

insert into task_types(typename) values('cumparaturi'), ('cheltuiala'), ('training');
insert into tasks(titlu, durata, tip) values('cumpara pizza', 10, 1);


select now();


