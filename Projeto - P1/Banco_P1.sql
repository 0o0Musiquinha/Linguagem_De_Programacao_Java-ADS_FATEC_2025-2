DROP DATABASE IF EXISTS banco_p1;
CREATE DATABASE banco_p1;
USE banco_p1;

CREATE TABLE produto(
	pro_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pro_nome VARCHAR(60),
    pro_desc VARCHAR(200),
    pro_precovenda DECIMAL(8,2),
    pro_qtdestoque INT
);

CREATE TABLE fornecedores(
	for_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    for_nome VARCHAR(80),
    for_nomefantasia VARCHAR(80),
    for_cnpj VARCHAR(18),
    for_email VARCHAR(60),
    for_telefone VARCHAR(15),
    for_logradouro VARCHAR(60),
    for_bairro VARCHAR(60),
    for_municipio VARCHAR(60),
    for_uf VARCHAR(2)
);

CREATE TABLE tipoNota(
	tip_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tip_nome VARCHAR(30)
    
);

CREATE TABLE tipoCliente(
	tcl_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	tcl_nome VARCHAR(60)

);

CREATE TABLE clientes(
	cli_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cli_nome VARCHAR(60),
    cli_documento VARCHAR(18),
    cli_email VARCHAR(60),
    cli_telefone VARCHAR(15),
    cli_logradouro VARCHAR(60),
    cli_bairro VARCHAR(60),
    cli_municipio VARCHAR(60),
    cli_uf VARCHAR(2),
    tcl_codigo INT,
    
    FOREIGN KEY (tcl_codigo) REFERENCES tipoCliente (tcl_codigo)
);

CREATE TABLE notas(
	nta_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nta_data DATE,
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
    nta_codigo INT,
    
    FOREIGN KEY (pro_codigo) REFERENCES produto (pro_codigo),
    FOREIGN KEY (nta_codigo) REFERENCES notas (nta_codigo)
    
);


INSERT INTO tipocliente VALUES (NULL, "Pessoa Física"), (NULL, "Pessoa Juridica");
INSERT INTO tipoNota VALUES (NULL, "Entrada"), (NULL, "Saída");
