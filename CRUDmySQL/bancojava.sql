DROP DATABASE IF EXISTS bancojava;
CREATE DATABASE bancojava;
USE bancojava;

CREATE TABLE pessoa(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60),
    sexo CHAR(1),
    idioma VARCHAR(30)
);


SELECT * FROM pessoa;
-- DELETE FROM pessoa WHERE pessoa.id = 2;
