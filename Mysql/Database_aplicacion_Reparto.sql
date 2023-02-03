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

#------ Arrasate -----------
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Hugo","Rodrigez","00000000A","Azoka Kalea, 1,5D, 20500 Arrasate, Gipuzkoa","000000001","Arrasate","user2","u2",false,1);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Pedro Jose","Oviedo","00000001A","Ferrerías Kalea, 8,Bajo I, 20500 Arrasate, Gipuzkoa","000000002","Arrasate","user3","u3",false,1);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Francesc","de La Cruz","00000002A","Juan Carlos Guerra Plaza, 2,3D, 20500 Arrasate, Gipuzkoa","000000003","Arrasate","user4","u4",false,1);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Thiago","Yuste","00000003A","Ferrerías Kalea, 28,1I, 20500 Arrasate, Gipuzkoa","000000004","Arrasate","user5","u5",false,1);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Amadeo","Diaz","00000004A","Zarugalde Kalea, 5,2D, 20500 Arrasate, Gipuzkoa","000000005","Arrasate","user6","u6",false,1);

#----Aretxabaleta---
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Pascual","Izquierdo","00000005A","Durana Kalea, 26,3A, 20550 Aretxabaleta, Gipuzkoa","000000006","Aretxabaleta","user7","u7",false,2);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Amadeo","Esteve","00000006A","Durana Kalea, 32,Bajo D, 20550 Aretxabaleta, Gipuzkoa","000000007","Aretxabaleta","user8","u8",false,2);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Jesus Antonio"," Novo","00000007A","Calle de, Mitarte Kalea, 10, BAJO, 20550 Aretxabaleta, Gipuzkoa","000000008","Aretxabaleta","user9","u9",false,2);

#--- Onati----
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Mario","Canizares","00000008A","Arantzazuko Ama Kalea, 9,3B, 20560 Oñati, Gipuzkoa","000000009","Oñati","user10","u10",false,3);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Marti","Sevilla","00000009A","Motxon Kalea, 5,D, BAJO, 20560 Oñati, Gipuzkoa","000000010","Oñati","user11","u11",false,3);

#---Bergara-----
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Jose Alberto","Carrasco","00000010A","Altos Hornos, Ibarra Kalea, 12,4A, 20570 Bergara, Gipuzkoa","000000011","Bergara","user12","u12",false,4);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Benat ","Mejia","00000011A","Ozaeta Kalea, 12,2I, 20570 Bergara, Gipuzkoa","000000012","Bergara","user13","u13",false,4);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Yaiza","Olivares","00000012A","Altos Hornos, Ibarra Kalea, 12,1D, 20570 Bergara, Gipuzkoa","000000013","Bergara","user14","u14",false,4);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Claudio","Cervera","00000013A","Telleria Kalea, 12,5I, 20570 Bergara, Gipuzkoa","000000014","Bergara","user15","u15",false,4);

#----Osintxu---------
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Eduardo","Espin","00000014A","Osintxu Gunea, 13,Bajo D, 20580 Osintxu, Gipuzkoa","000000015","Osintxu","user16","u16",false,5);

#-------Soraluze-----------
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Dionisia","Noguera","00000015A","Santa Ana Kalea, 1, 1D,2I, 20590 Soraluze, Gipuzkoa","000000016","Soraluze","user17","u17",false,6);

#-----Eibar------------
INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Pedro Maria ","Sosa","00000016A","Ubitxa Kalea, 16,Bajo D, 20600 Eibar, Gipuzkoa","000000017","Eibar","user18","u18",false,7);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Cipriano","Palma","00000017A","Polonia Etxeberria Kalea, 13,2D, 20600 Eibar, Gipuzkoa","000000018","Eibar","user19","u19",false,7);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Hassan","Hernando","00000018A","J.A.Iturrioz Kalea, 4,2D, 20600 Eibar, Gipuzkoa","000000019","Eibar","user20","u20",false,7);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Julio ","Cesar Lago","00000019A","Calle Polonia Etxeberria, 19, 1D, 20600 Eibar, Gipuzkoa","000000020","Eibar","user21","u21",false,7);

INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)
VALUES ("Teofilo","Romero","00000020A","Santainés Kalea, 5, 3I, 20600 Eibar, Gipuzkoa","000000021","Eibar","user22","u22",false,7);


SELECT * FROM `aplicacion_reparto`.`repartidor`;

SELECT * FROM `aplicacion_reparto`.`repartidor`
WHERE `username`="user1" and `password`="alal";


#UPDATE `repartidor`
#SET `nombre` = 'Alfred Schmidt', `apellido`= 'Frankfurt',`dni`='cosas',`direccion`='alguna',`zona_trabajo`='x'
#WHERE `username` = 'dubai8';

#DELETE FROM `aplicacion_reparto`.`repartidor` WHERE `username`="user2";


#parte para la `cliente`
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

#-------------Arrasate-------------------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.065404,-2.488841, "Biteri Etorbidea", "cliente anonimo 0", "Si",
"dejarlo en el buzon","La puerta suele estar abierta","lu:mar:mie:ju","Arrasate","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.0644,-2.48042,"Etxagibel notari jauna kalea 1","SEIN","SI","HAY","","lu","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.0655,-2.48903,"Zerkaosteta Kalea, 1, 20500 Arrasate, Gipuzkoa","Lasagabaster","No","Pasar por debajo de la puerta","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.06345,-2.53038, "Gesalibar Auzoa Auzoa, 8, 20500 Gesalibar, Gipuzkoa", "Sociedad Recreativa Jentil-Ola", "No",
"dejar en la entrada","","ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.06333,-2.507077, "Goiru Kalea, 1", "Restaurante Garaia", "No",
"dejar dentro","","lu:mar:mie:ju:vi","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.068358,-2.476977, "Gipuzkoa etorbidea 35", "cliente anonimo 1", "Si",
"Buzon","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.069027,-2.477017, "DR. Bolibar kalea 5", "cliente anonimo 2", "Si",
"Buzon","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.068251,-2.479078, "Elkano kalea 10", " Musakolako gaztetxokoa", "No",
"Dejar en el buzon de fuera","","lu:mar:mie:ju:vi","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.067257,-2.479946, "Elkano kalea 2", "cliente anonimo 3", "No",
"Buzon de fuera.","","sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.065919,-2.485042, "Aldai kalea 3", "cliente anomimo 4", "No",
"Buzon de fuera","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.065854,-2.484736, "Aldai kalea 4", "cliente anonimo 5", "No",
"Buzon de fuera","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.065795,-2.483569, "Aldai kalea 9", "cliente anonimo 6", "Si",
"Buzon de dentro","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.064735,-2.488267, "Jokin Zaitegi Plaza 7", "cliente anonimo 7", "Si ",
"Buzon de dentro","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.064488,-2.488851, "Jokin Zaitegi Plaza 10", "cliente anonimo 8", "Si",
"Buzon de dentro.","","lu:mar:mie:ju:vi:sa:do","Arrasate","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (1,43.064049,-2.491837, "ARRASATE PASEALEKUA 10", "SAN VIATOR IKASTOLA", "No",
"Dejarlo fuera ","","lu:mar:mie:ju:vi","Arrasate","Berria","");


# -----------Aretxabaleta--------------------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.0365,-2.50449,"Otalora Kalea, 1, 20550 Aretxabaleta, Gipuzkoa","Ayuntamiento De Aretxabaleta","No","dejar en el baz","","mie","Aretxabaleta","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.0342,-2.50496,"Ilargi Plaza, 4, 20550 Aretxabaleta, Gipuzkoa","Bar Hirusta","No","Entrar y dejar","","lu:mie:ju:sa","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.029,-2.50442,"Araba Ibilbidea, 3, 20550 Aretxabaleta, Gipuzkoa","Copreci","No","Dejarlo","","ju:vi:sa:do","Aretxabaleta","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.029535,-2.505998, "Lugar Barrio Bedarretako San Migel, 9, 20550 Aretxabaleta, Gipuzkoa", "Julio Altuna Akizu", "si",
"Dejar en buzon","","lu:mar:mie:ju:vi","Aretxabaleta","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.038008,-2.504366, "Otalora Kalea, 19, 20550 Aretxabaleta, Gipuzkoa", "Bar Bedarreta", "NO",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.0385,-2.504348, "Otalora Kalea, 25", "Tipi-Tapa Haur-denda", "No",
"entrar y dar en mano","","lu:mar:mie:ju:vi","Aretxabaleta","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.037198,-2.504446, "Otalora Kalea, 11, 20550 Aretxabaleta, Gipuzkoa", "Izozkitegi", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.036584,-2.504156, "Otalora Kalea, 14, 20550 Aretxabaleta, Gipuzkoa", "María Raquel Marrodán Urquiola Lore-denda", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.036422,-2.504096, "Otalora Kalea, 10, 20550 Aretxabaleta, Gipuzkoa", "José Joaquín Jáuregui Bequiristain Okindegia", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Aretxabaleta","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.036168,-2.503767, "Herriko Plaza, 8, 20550 Aretxabaleta, Gipuzkoa", "Paulaner", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.035689,-2.503353, "Herriko Plaza, 3, 20550 Aretxabaleta, Gipuzkoa", "Buket Gastrobar", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.029535,-2.505998, "Calle Belorrieta, 6, 20550 Aretxabaleta, Gipuzkoa", "Ekin Fisioterapia", "No",
"Entrar y dar en mano","","mie","Aretxabaleta","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.032596,-2.50436, "Iralabarri Plaza, 1, 20550 Aretxabaleta, Gipuzkoa", "RAIJIN TATTOO & PIERCING", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Aretxabaleta","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.032072,-2.503935, "Iralabarri Plaza, 11, 20550 Aretxabaleta, Gipuzkoa", "Beroa Taberna", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Aretxabaleta","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (2,43.029535,-2.505998, "Basabe Pol., E-1, 20550 Aretxabaleta, Gipuzkoa", "Kaniber Europa", "No",
"dejar fuera","","ju:vi","Aretxabaleta","Berria","");

#----------- Oñati -----------------------------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.033162,-2.411151, "Santa Marina Plaza, 1, 20560 Oñati, Gipuzkoa", "Biblioteca Pública Municipal", "No",
"Entrar y dar en repcion","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.032241,-2.410841, "Patrue-Kalea, 7, 20560 Oñati, Gipuzkoa", "Antixena Gaztetxia", "No",
"Entrar y dar en mano","","mie","Oñati","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.032132,-2.409804, "Otadui Zuhaiztia Zuhaztia, 25, 20560 Oñati, Gipuzkoa", "CARAVANAS OÑATE CALDERERIA", "No",
"Entrar y dar en recepcion","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.031943,-2.411561, "Kale Barria Kalea, 32", "Itziar optika", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.034807,-2.414179, "Kale Zaharra Kalea, 34", "Bar HARRIPE", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.035982,-2.414991, "Kale Zaharra Kalea, 15", "Ona Taberna", "No",
"Entrar y dar","","lu:mar:mie:ju:vi","Oñati","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.029855,-2.412038, "Bidebarrieta Kalea, 28", "Txantxiku Harategia", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.030797,-2.411886, "Ultzegin Kalea, 11", "LAPIKOGORRI GASTROTEKA", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.030494,-2.412527, "Bidebarrieta Kalea, 19", "BELLOTZA LORADENDA", "No",
"Dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.031091,-2.411183, "Atzeko Kalea, 32", "Iturritxo", "No",
"Dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.031443,-2.411487, "Atzeko Kalea, 22", "Galizia Taberna (antes Bar Galicia)", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Oñati","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (3,43.030565,-2.410513, "Arantzazuko Ama Kalea, 3", "Meraki Exchange Point", "No",
"Entrar y dejarlo a la vista","","mie","Oñati","Argia","");


#---- Bergara ---------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.110964,-2.413306, "San Antonio Kalea, 3", "Zumelaga jatetxea", "No",
"Entrar y dar en mano","","sa:do","Bergara","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.125206,-2.424112, "Martokoa kalea, 24, 20570 Bergara, Gipuzkoa", "Juan kafetegia", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Bergara","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.108708,-2.407561, "Urteaga Kalea, 21", "Biolur Gipuzkoa", "No",
"Dejar en la puerta","","lu:mar:mie:ju:vi","Bergara","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.1118,-2.411722, "Artzamendi Kalea, 13", "Antonio Fernández Cid Taxi-zerbitzua", "No",
"Dejar en las barras de la puerta","","lu:mar:mie:ju:vi","Bergara","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.11165,-2.412277, "Artzamendi Kalea, 12", "Diego Osuna - DOH Margoak Zoruko lanen kontratista", "No",
"Entrar y dar en mano","","mie","Bergara","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.112585,-2.413816, "Mintegi Kalea, 1W, 20570 Bergara, Gipuzkoa", "Iri-Be Industria Hornigayak Informatika-denda", "No",
"Dejar en la puerta","","ju:vi","Bergara","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.112988,-2.414292, "Tokieder Plaza, 3, 20570 Bergara, Gipuzkoa", "Conde Panaderokua", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Bergara","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.125206,-2.424112, "Espoloia Kalea, 1, 20570 Bergara, Gipuzkoa", "Bergarako Musika Eskola", "No",
"Entrar y dejarlo en recepcion","","lu:mar:mie:ju:vi","Bergara","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.118518,-2.412912, "Barrenkalea, 25, 20570 Bergara, Gipuzkoa", "Farmacia Zabala", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Bergara","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.1192,-2.413003, "Kruz Gallastegi Kalea, 1, 20570 Bergara, Gipuzkoa", "Sociedad Artatse", "No",
"Entrar y dar en mano","","sa:do","Bergara","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (4,43.120606,-2.418266, "Matxiategi Kalea, 5, 20570 Bergara, Gipuzkoa", "Estella Farmazia - Ortopedia Sekz.", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Bergara","Berria:Argia","");

#----------Osintxu---------------------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (5,43.1556,-2.40683, "Calle Osintxu, 15, 20580 Osintxu, Gipuzkoa", "Biblioteca Pública Municipal Bergarako Udal Liburutegia", "No",
"Entrar y dejar en recepcion","","lu:mar:mie:ju:vi","Osintxu","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (5,43.15622,-2.40628, "Calle Osintxu, 13, 20580 Osintxu, Gipuzkoa", "Miluk Ile-apaindegia", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Osintxu","Berria:Argia","");


INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (5,43.15655, -2.40558, "Osintxu Gunea, 13, 20580 Osintxu, Gipuzkoa", "Miluk  Ile-apaindegia", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Osintxu","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (5,43.15656, -2.40541, "Osintxu Gunea, 17, 20580 Osintxu, Gipuzkoa", "Euskalduna Sagardotegia", "No",
"Entrar y darlo en mano","","lu:mar:mie:ju:vi","Osintxu","Berria","");

#-----------Soraluze-------------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.17573,-2.413975, "Gabolatz Kalea, 32, 20590 Soraluze, Gipuzkoa", "Ramón Zabala Iñarra Armairu-denda", "No",
"Dejar fuera","","lu:mar:mie:ju:vi","Soraluze","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.175886,-2.414415, "Baltegieta Kalea, 16, 20590 Soraluze, Gipuzkoa", "Nibiru Tattoo estudio artistikoa", "No",
"Dejar fuera","","lu:mar:mie:ju:vi","Soraluze","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.174769,-2.414332, "20590, baltegieta 12, 20590 Soraluze, Gipuzkoa", "Gogortuz Fisioterapia", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Soraluze","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.174932,-2.412665, "Etxaburueta Kalea, 5, 20590 Soraluze, Gipuzkoa", "Carnicería Etxabe", "No",
"Dejar fuera","","mie","Soraluze","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.174644,-2.41284, "Etxaburueta Kalea, 6, BAJO, 20590 Soraluze, Gipuzkoa", "Bar Arrano", "No",
"Entrar y dejar dentro","","lu:mar:mie:ju:vi","Soraluze","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.174547,-2.413075, "Etxaburueta Kalea, 1, 20590 Soraluze, Gipuzkoa", "Bar Bolia", "No",
"Entrar y dejar dentro","","lu:mar:mie:ju:vi","Soraluze","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (6,43.174212,-2.4131, "Santa Ana Kalea, 1, 20590 Soraluze, Gipuzkoa", "Ayuntamiento de Soraluze", "No",
"Dejarlo en recepcion","","lu:mar:mie:ju:vi","Soraluze","Berria:Argia","");

#-------Eibar---------
INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183652,-2.471705, "Otaola Hiribidea, 6, 8, 20600 Eibar, Gipuzkoa", "Hospital de Eibar Osakidetza (Media estancia)", "No",
"Entrar y dejar en recepicion","","lu:mar:mie:ju:vi","Eibar","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183598,-2.48191, "Tiburzio Anitua Kalea, 6, 20600 Eibar, Gipuzkoa", "Panadería Zubizarreta", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.184082,-2.475817, "Ego-Gain Kalea, 6, 20600 Eibar, Gipuzkoa", "Gastro Bar Kontent", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi:sa:do","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.184378,-2.476824, "Kalea Ego - Gain, 12, 20600 Eibar, Gipuzkoa", "Notaría De Eibar", "No",
"Dejar en buzon de fuera","","mie","Eibar","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183602,-2.476251, "Isasi Kalea, 27, 20600 Eibar, Gipuzkoa", "Gertu Osasun Zentrua", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183595,-2.476543, "Isasi Kalea, 31 Bajo, 20600 Eibar, Gipuzkoa", "Farmacia Lekumberri", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183652,-2.471705, "Isasi Kalea, 28, 30, 20600 Eibar, Gipuzkoa", "EIBAR SASOIAN", "No",
"Dejar fuera","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183652,-2.471705, "Ego-Gain Kalea, 13, 20600 Eibar, Gipuzkoa", "Lavandería Speed Queen", "No",
"Entrar y dejar a la vista","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183654,-2.475516, "Isasi Kalea, 19, 20600 Eibar, Gipuzkoa", "Peluqueria Eider", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183676,-2.475234, "Isasi Kalea, 17, 20600 Eibar, Gipuzkoa", "Carniceria De Isasi halal", "No",
"Dejar fuera","","mie","Eibar","Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183705,-2.474902, "Isasi Kalea, 13, 20600 Eibar, Gipuzkoa", "Prince Doner Kebab", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183737,-2.474085, "Isasi Kalea, 7, 20600 Eibar, Gipuzkoa", "Restaurante Chalcha", "No",
"Dejar fuera","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.183755,-2.473873, "Isasi Kalea, 3, 20600 Eibar, Gipuzkoa", "Bar Gure Leku", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.184241,-2.472301, "Fermin Calbeton Kalea, 6, 20600 Eibar, Gipuzkoa", "Bar Koskor", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.184533,-2.47184, "Fermin Calbeton Kalea, 14, 20600 Eibar, Gipuzkoa", "Restaurante Palacio de Oriente", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria:Argia","");

INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,
    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,
    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)
VALUES (7,43.185052,-2.471401, "Fermin Calbeton Kalea, 23, 20600 Eibar, Gipuzkoa", "Okindegia Gozotegia Ogi Berri Calbeton", "No",
"Entrar y dar en mano","","lu:mar:mie:ju:vi","Eibar","Berria","");


select * from `cliente`;

DROP TABLE IF EXISTS `registros_reparto`;
CREATE TABLE `registros_reparto` (
	`id_cliente` int(11),
    `iduser` int(11),
	`idEquipo` int(11),
	`fecha-hora` DATETIME
) ;

select * from `registros_reparto`;
