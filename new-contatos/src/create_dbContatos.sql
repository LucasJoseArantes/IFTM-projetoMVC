create database dbContatos;

use dbContatos;

create table tb_contato(
	email varchar(255) primary key,
	nome varchar(255) ,
	cpf_cnpj VARCHAR(18)
);

insert into tb_contato values ('user01@gmail.com', 'Usuario 01', '123.456.789.10');
insert into tb_contato values ('user02@outlook.com', 'Usuario 02', '987.231.654.50');
insert into tb_contato values ('grande@empresa.com', 'Empresa Grande', '78.854.811-0001-40');