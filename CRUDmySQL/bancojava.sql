DROP DATABASE IF EXISTS bancojava;
CREATE DATABASE bancojava;
USE bancojava;

CREATE TABLE pessoa(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   nome VARCHAR(60),
   sexo CHAR(1),
   idioma VARCHAR(30)
);

CREATE TABLE professor(
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   disciplina VARCHAR(60),
   salario DECIMAL(8, 2),
   sexo CHAR(1),
   idioma VARCHAR(30)
);

CREATE TABLE aluno(
	ra INT NOT NULL PRIMARY KEY,
	media DECIMAL(8,2),
	faltas INT,
	sexo CHAR(1),
   idioma VARCHAR(30)
);


SELECT * FROM pessoa;
-- DELETE FROM pessoa WHERE pessoa.id = 2;
