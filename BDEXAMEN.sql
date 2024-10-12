CREATE DATABASE bdexamen;
USE bdexamen;

CREATE TABLE usuario (
id INT auto_increment NOT NULL PRIMARY KEY,
usuario varchar(100) NULL,
password varchar(300) NULL,
email varchar(200) NULL,
activo BOOL NULL
);


CREATE TABLE rol (
idrol INT auto_increment NOT NULL PRIMARY KEY,
nombrerol varchar(300) NULL
);

CREATE TABLE usuario_rol (
id INT NOT NULL,
idrol INT NOT null,
FOREIGN KEY(id) REFERENCES usuario(id),
FOREIGN KEY(idrol) REFERENCES rol(idrol)
);

CREATE TABLE Pelicula(
idpelicula int auto_increment NOT NULL PRIMARY KEY,
nombre varchar(100) NULL,
descripcion varchar(300) NULL,
duracion int
);

INSERT INTO Pelicula (nombre, descripcion, duracion) 
VALUES 
('Inception', 'Un ladrón que roba secretos corporativos usando tecnología de sueños.', 148),
('The Matrix', 'Un hacker descubre una realidad simulada controlada por máquinas.', 136),
('Interstellar', 'Un equipo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad.', 169),
('The Dark Knight', 'Batman lucha contra el caos sembrado por el Joker en Gotham City.', 152),
('The Godfather', 'La historia de la familia mafiosa Corleone y su imperio criminal.', 175);

-- Gestor password: 1234
-- Coordinador password: 5678
INSERT INTO usuario (usuario,password,email,activo) 
VALUES 
('gestor','$2a$12$KIc0Si4LxzME4K7E87VZw.VtBvXRenuAlpwAHbrHrJ8cH0qyvmFUi','gestor@cibertec.edu.pe',1),
('coordi','$2a$12$eEdZTT/Q.ED7Vl5BCqmn0u9Oplr8lua1IpyBw9DQmLZTrwjxEwfnG','coordinador@cibertec.edu.pe',1);

INSERT INTO rol (nombrerol) 
VALUES ('GESTOR'),('COORDINADOR');

INSERT INTO usuario_rol (id,idrol) 
VALUES (1,1),(1,2);
	