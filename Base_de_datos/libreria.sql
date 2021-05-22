DROP DATABASE IF EXISTS libreria;

#Se crea si no existe
CREATE DATABASE IF NOT EXISTS libreria;

USE libreria;


CREATE TABLE usuario_cliente (
  id_usuario INT UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50),
  primerAp VARCHAR(50),
  segundoAp VARCHAR(50),
  correo VARCHAR(50)
);

CREATE TABLE usuario_bibliotecario (
  id_usuario INTEGER UNSIGNED UNIQUE  PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50),
  primerAp VARCHAR(50),
  segundoAp VARCHAR(50),
  contrasena VARCHAR(50)
);

CREATE TABLE libros (
  id_libro INT UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50),
  genero VARCHAR(50),
  autor VARCHAR(50),
  editorial VARCHAR(50)
);

CREATE TABLE movimientos (
  id_movimiento INT UNSIGNED UNIQUE PRIMARY KEY AUTO_INCREMENT NOT NULL,
  id_libro INT UNSIGNED NOT NULL,
  id_usuario INT UNSIGNED NOT NULL,
  fecha DATETIME DEFAULT current_timestamp,
  FOREIGN KEY(id_usuario) REFERENCES usuario_cliente(id_usuario),
  FOREIGN KEY(id_libro) REFERENCES libros(id_libro)
);
