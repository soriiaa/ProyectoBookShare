/*
@author: Pablo
*/
drop database if exists bookshare;
create database bookshare;
use bookshare;


create table pregunta_recuperacion(
codigo int auto_increment,
pregunta varchar(50),
primary key(codigo)
)engine=innodb;

insert into pregunta_recuperacion(Pregunta) values("¿Como se llama tu perro?");
insert into pregunta_recuperacion(Pregunta) values("¿Cual es tu comida favorita?");
insert into pregunta_recuperacion(Pregunta) values("¿Cual es tu superheroe favorito?");

create table users(
usr varchar(40) not null,
nombre varchar(30) not null,
apellido varchar(40) not null,
pwd varchar(25) not null,
rol varchar(20) not null,
img blob,
cp int not null,
codigoPreguntaRecuperacion int not null,
respuestaPreguntaRecuperacion varchar(100) not null,
primary key (usr),
foreign key (codigoPreguntaRecuperacion) references pregunta_recuperacion(codigo)
)engine=innodb;

insert into users(usr, nombre, apellido, pwd, Rol, img, cp, codigoPreguntaRecuperacion, respuestaPreguntaRecuperacion) values("MenteFria", "Maxi", "angulo", "CañaAqui_33", "Administrador", "Imagen1", "28360", 1, "Coca Cola");
insert into users(usr, nombre, apellido, pwd, Rol, img, cp, codigoPreguntaRecuperacion, respuestaPreguntaRecuperacion) values("a", "Tinky", "Winky", "a", "usuario", "ImagenTeletubbie", "15001", 2, "Rogelio");

create table notificaciones(
id int auto_increment,
texto varchar(150),
primary key(id)
)engine=innodb;

insert into notificaciones(texto) values("Hola");

create table usuario_Notificaciones(
usr varchar(40),
id int,
primary key(usr,id),
foreign key(usr) references users(usr),
foreign key(id) references notificaciones(id)
)engine=innodb;

insert into usuario_Notificaciones(usr, id) values("MenteFria", 1);

create table libro(
id int auto_increment,
titulo varchar(80) not null,
autor varchar(80) not null,
genero varchar(50)not null,
disponible boolean ,
activo boolean ,
primary key (id)
)engine innodb;

insert into libro(titulo, autor, genero,  disponible, activo)values("Moby Dick", "Herman Melville", "Novela de aventuras", TRUE, TRUE);
insert into libro(titulo, autor, genero,  disponible, activo)values("Jurassic Park", "Michael Crichton", "Ciencia Ficcion", TRUE, TRUE);

create table coger(
usr varchar(40),
id int,
Fecha date not null,
primary key(usr, id),
foreign key (usr) references users(usr),
foreign key (id) references libro(id)
)engine innodb;

insert into coger(usr, id, Fecha) values("a", 2, '2024-05-07');

create table dejar(
usr varchar(40),
id int,
Fecha date not null,
Comentario varchar(40),
Valoracion varchar(30) not null,
primary key(usr, id),
foreign key (usr) references users(usr),
foreign key (id) references libro(id)
)engine innodb;

insert into dejar(usr, id, fecha, comentario, valoracion) values("MenteFria", 1, '2024-04-11', "Espectacular", "8/10");

create table administracion(
clave int,
valor int not null,
primary key(clave)
)engine=innodb;

create table cod_postal(
codigo_postal int not null,
comunidad_autonoma varchar(30) not null,
provincia varchar(50) not null,
poblacion int not null,
primary key(codigo_postal)
)engine=innodb;

insert into Cod_Postal(Codigo_Postal, comunidad_autonoma, provincia, poblacion)values(28360, "Comunidad de Madrid", "Villaconejos", 3360);
insert into Cod_Postal(Codigo_Postal, comunidad_autonoma, provincia, poblacion)values(15001, "Galicia", "A coruña", 244850);

create table lugar(
id int auto_increment,
nombre varchar(50) not null,
codigo_postal int not null,
primary key(id),
foreign key(codigo_postal) references cod_postal(codigo_postal)
)engine=innodb;

insert into Lugar(Nombre, codigo_postal)values("Villaconejos", 28360);
insert into Lugar(Nombre, codigo_postal)values("A coruña", 15001);

create table libro_Lugar(
id_Libro int, 
id_Lugar int,
Fecha date not null, 
primary key(id_Libro, id_Lugar), 
foreign key(id_Libro) references libro(id),
foreign key(id_lugar) references lugar(id)
)engine=innodb;

insert into libro_Lugar(id_libro, id_Lugar, Fecha) values(1, 1, '2024-05-16');
insert into libro_Lugar(id_libro, id_Lugar, Fecha) values(2, 2, '2024-05-17');

use bookshare;
-- Select usr from users where usr = ? and pwd = ?;
select * from users;

<<<<<<< HEAD
SELECT libro.id AS idLibro, libro.titulo AS tituloLibro, lugar.nombre AS nombreLugar, libro.genero AS generoLibro FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON libro_lugar.id_Lugar = lugar.id; 
=======
SELECT cod_postal.codigo_postal, libro.titulo AS tituloLibro FROM libro INNER JOIN libro_lugar ON libro_lugar.id_libro = libro.id INNER JOIN lugar ON lugar.id = libro_lugar.id_Lugar inner join cod_postal on lugar.codigo_postal = cod_postal.codigo_postal;
>>>>>>> 2bf8bf3e9aae8e2618704fec3b4c83839e894bbf
