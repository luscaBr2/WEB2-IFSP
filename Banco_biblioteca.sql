create database biblioteca;
use biblioteca;

-- Tabela de livros
CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano_publicacao YEAR NOT NULL,
    genero VARCHAR(100),
    isbn VARCHAR(20) UNIQUE,
    quantidade INT DEFAULT 0,
    img TEXT
);

-- Tabela de usuários (leitores)
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    tipo_usuario tinyint COMMENT '1 - Estudante 2 - Professor' DEFAULT 1
);

-- Tabela de empréstimos
-- relacionamento N para N de usuarios e livros
CREATE TABLE emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_livro INT,
    id_usuario INT,
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

-- Tabela de avaliações de livros
CREATE TABLE avaliacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_livro INT,
    id_usuario INT,
    nota INT CHECK (nota >= 1 AND nota <= 5),
    comentario TEXT,
    data_avaliacao DATE,
    FOREIGN KEY (id_livro) REFERENCES livros(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabela de categorias de livros
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_categoria VARCHAR(100) NOT NULL
);

-- Tabela de livros e categorias (relacionamento muitos para muitos)
CREATE TABLE livros_categorias (
    id_livro INT,
    id_categoria INT,
    PRIMARY KEY (id_livro, id_categoria),
    FOREIGN KEY (id_livro) REFERENCES livros(id),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id)
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
