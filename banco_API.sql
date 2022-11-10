create database agendaapi;
use agendaapi;

create table Agenda(
id int primary key auto_increment not null,
nome varchar(50) not null,
evento varchar(250),
descEvento varchar(250));
desc Agenda;
select * from Agenda;

insert into Agenda(nome,evento,descEvento) values('Mara','Villa mix', 'Show sertanejo');