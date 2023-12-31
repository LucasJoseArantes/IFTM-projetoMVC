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

create table tb_login( 
   usuario varchar(255) primary key,
   senha varchar(255)
);

create table tb_role (
   id integer auto_increment,
   nome varchar(255) not null,
   primary key(id)
);

insert into tb_role(nome) values ('ADMIN');
insert into tb_role(nome) values ('USER');

create table tb_role_user (
   usuario varchar(255) not null,
   role_id integer not null,
   primary key(usuario,role_id),
   foreign key(usuario) references tb_login(usuario),
   foreign key(role_id) references tb_role(id)
);
