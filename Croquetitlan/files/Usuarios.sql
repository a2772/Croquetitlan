DROP DATABASE IF EXISTS usuarios_db;
CREATE DATABASE usuarios_db;
USE usuarios_db;

-- Drop Tables
        
DROP TABLE IF EXISTS users; 
   


CREATE TABLE users (
                            
	email VARCHAR(100) NOT NULL PRIMARY KEY,
                                            
	password VARCHAR(100) NOT NULL,

	firstname VARCHAR(100) NOT NULL,

	lastname VARCHAR(100) NOT NULL


--	role VARCHAR(50) NOT NULL,

--	estatus VARCHAR(50) NOT NULL,

--	clave_activacion VARCHAR(50),

--	password_es_temporal BOOLEAN NOT NULL,

--	vigencia_password INTEGER NOT NULL,

--	ultima_actualizacion_password DATE NOT NULL

            
);

DROP TABLE IF EXISTS products;

CREATE TABLE products (
	
	id INTEGER NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	image VARCHAR(50) NOT NULL
);

INSERT INTO users VALUES ("admin@novalidserver.net", "passw0rd", "Admin", "");
INSERT INTO users VALUES ("alvarolez@outlook.com", "passw0rd", "Alvaro", "Lezama");
INSERT INTO users VALUES ("paris.140815@gmail.com", "passw0rd", "Paris", "Saldaña");

INSERT INTO products VALUES( 1, "Arnes y correa","images/p2.jpg");






  