create database biblioteca;
use biblioteca;

-- Tabela de livros
CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano_publicacao YEAR NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) UNIQUE,
    quantidade INT DEFAULT 0,
    img TEXT
);

-- Tabela de usuários (leitores)
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(32) COMMENT 'Criptografado com MD5' NOT NULL,
    telefone VARCHAR(25),
    tipo_usuario tinyint COMMENT '1 - Leitor 2 - Admin' DEFAULT 1
);

-- Tabela de empréstimos
-- relacionamento N para N de usuarios e livros
CREATE TABLE emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_livro INT,
    id_usuario INT,
    data_criacao DATE,
    data_emprestimo DATE,
    data_devolucao_prevista DATE,
    data_devolucao_real DATE,
    multa DECIMAL(10,2) DEFAULT 0.00,
    status tinyint COMMENT '1 - Em andamento 2 - Devolvido',
    FOREIGN KEY (id_livro) REFERENCES livros(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabela de reservas de livros
CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_livro INT,
    id_usuario INT,
    data_reserva DATE,
    data_retirada DATE DEFAULT NULL,
    status tinyint COMMENT '1 - Ativa 2 - Concluída 3 - Cancelada',
    FOREIGN KEY (id_livro) REFERENCES livros(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabela de multas
CREATE TABLE multas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_emprestimo INT,
    valor DECIMAL(10,2) NOT NULL,
    status_pagamento tinyint COMMENT '1 - Pago 2 - Não Pago' DEFAULT 0,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_emprestimo) REFERENCES emprestimos(id)
);
