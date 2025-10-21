-- Criar o banco de dados para a aplicação:

CREATE DATABASE ifitness;
USE ifitness;

-- Criar a tabela user no banco de dados ifitness:

CREATE TABLE user (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL,
	birth_date DATE NOT NULL,
	gender VARCHAR(30) NOT NULL,
  	active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE activity (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	type VARCHAR(20) NOT NULL,
	activity_date DATE NOT NULL,
	distance DOUBLE NOT NULL,
	duration INT NOT NULL,
	user_id BIGINT(20) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from 

select id,name,email from user where email='fernando@gmail.com' and password='25F9E794323B453885F5181F1B624D0B'