DROP DATABASE if exists `aplicacion_reparto`;
CREATE DATABASE `aplicacion_reparto`;
USE `aplicacion_reparto`;

DROP TABLE IF EXISTS `repartidor`;
CREATE TABLE `repartidor` (
	`iduser` int(255) unique NOT NULL AUTO_INCREMENT,
    `nombre` varchar(130) not null ,
    `apellido` varchar(130) not null,
     `dni` varchar(30) not null,
     `direccion` varchar(130) not null,
     `tlf` varchar(30) not null,
     `zona_trabajo` varchar(130) not null ,
     `username` varchar(125) unique not null,
     `password` varchar(125) not null,
     `admin` boolean,
     `idEquipo` int(255),
  PRIMARY KEY (`iduser`)
) ;

INSERT INTO `repartidor` (`iduser`,`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES (1,"admin","admin","00000000A","alguna","000000001","Arrasate","user1","alal",true,0);

SELECT * FROM `aplicacion_reparto`.`repartidor`;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
	`id_cliente` int(255) unique NOT NULL AUTO_INCREMENT,
	`idEquipo` int(255),
	
    `latitud` FLOAT(20),
    `longitud` FLOAT(20),

    `direccion` varchar(125) unique not null,
    `nombre_cliente` varchar(125) ,
    `llaves` varchar(255),
    `como_dejarlo` varchar(255),
    `notas` varchar(255),
	`dias` varchar (125),
    `poblacion` varchar (125),
    `lista_productos` varchar(125),
    `dias_completados` varchar(255),

  PRIMARY KEY (`id_cliente`)
) ;

select * from `cliente`;

DROP TABLE IF EXISTS `registros_reparto`;
CREATE TABLE `registros_reparto` (
	`id_cliente` int(11),
    `iduser` int(11),
	`idEquipo` int(11),
	`fecha-hora` DATETIME
) ;

select * from `registros_reparto`;