create database ecommerce;
use ecommerce;

create table clientes(
	id int auto_increment primary key,
    nome varchar(100),
    email varchar(100) unique,
    senha varchar(100) not null,
	telefone varchar(20),
    criado_em datetime default current_timestamp
);

-- Tabela Endereços
create table enderecos(
	id int auto_increment primary key,
    cliente_id int,
    rua varchar(100),
    complemento varchar(100),
    bairro varchar(50),
    cidade varchar(50),
    estado char(2)
);
 
 -- Tabela Categorias
 create table categorias(
	id int auto_increment primary key,
	nome varchar(100) not null,
    descricao text
 );
 
 -- Tabela Produtos
 create table produtos(
	id int auto_increment primary key,
    nome varchar(100) not null,
    descricao text,
    preco decimal(10,2) not null,
    estoque decimal(10,2) not null,
    categoria_id int
 );
 
 -- Tabela itens pedido
 create table itens_pedido(
	id int auto_increment primary key,
    pedido_id int,
    produto_id int,
    quantidade int not null,
    preco_unitario decimal(10,2) not null
 );
 
 -- Tabela de pedidos
 create table pedidos(
	id int auto_increment primary key,
    cliente_id int,
    data_pedido datetime default current_timestamp,
    status varchar(50) default 'Pendente',
    total decimal(10,2)
 );
 -- cliente_id, data_pedido, status, total
 
 /* 6. Modificando e melhorando o banco*/
 -- 6.1 Renomeando colunas
 alter table clientes 
 change column telefone celular varchar(20);
 
 alter table enderecos
 change column complemento numero varchar(10);
 
 -- 6.2 Renomeando tabela
 rename table clientes to usuarios;
 
  -- adição de coluna na tabela usuarios 
alter table usuarios
add column cpf varchar(14) unique;

alter table enderecos
add column cep varchar(9);

 -- movendo uma coluna dentro de uma tabela
 alter table usuarios
 modify column celular varchar(20) after email;
 
 alter table usuarios
 modify column senha varchar(100) after email;
 
 alter table usuarios
 modify column cpf varchar(14) after celular;
