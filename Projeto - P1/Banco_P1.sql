DROP DATABASE IF EXISTS projeto_p1;
CREATE DATABASE projeto_p1;
USE projeto_p1;

CREATE TABLE produto(
	pro_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pro_nome VARCHAR(60),
    pro_desc VARCHAR(200),
    pro_precovenda DECIMAL(8,2),
    pro_qtdestoque INT
);

CREATE TABLE clientes(
	cli_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cli_nome VARCHAR(60),
    cli_endereco VARCHAR(100),
    cli_email VARCHAR(60),
    cli_telefone INT
);

CREATE TABLE fornecedores(
	for_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    for_nome VARCHAR(80),
    for_nomefantasia VARCHAR(80),
    for_cnpj INT,
    for_endereco VARCHAR(100),
    for_email VARCHAR(60),
    for_telefone INT
);

CREATE TABLE tipoNota(
	tip_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tip_nome VARCHAR(30)
    
);

CREATE TABLE notas(
	not_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    not_data DATE,
    cli_codigo INT,
    for_codigo INT,
    tip_codigo INT,
    
    FOREIGN KEY (cli_codigo) REFERENCES clientes (cli_codigo),
    FOREIGN KEY (for_codigo) REFERENCES fornecedores (for_codigo),
    FOREIGN KEY (tip_codigo) REFERENCES tipoNota (tip_codigo)
);

CREATE TABLE itemNota(
	itm_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    itm_quantidade INT,
    pro_codigo INT,
    
    FOREIGN KEY (pro_codigo) REFERENCES produto (pro_codigo)
);

