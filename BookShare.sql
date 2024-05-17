drop database if exists bookshare;
create database bookshare;
use bookshare;

create table usuario(
nick varchar(40),
nombre varchar(30),
apellido varchar(40),
pwd varchar(25),
rol varchar(20),
img blob,
cp int,
primary key (nick)
)engine=innodb;

create table libro(
id int auto_increment,
titulo varchar(80),
autor varchar(80),
genero varchar(50),
disponible boolean,
valoracion int,
fecha date,
comentario varchar(200),
nick varchar(40),
primary key (id),
foreign key(nick)
references usuario(nick)
)engine innodb;

create table pregunta_recuperacion(
codigo int auto_increment,
pregunta varchar(50),
respuesta varchar(20),
nick varchar(40),
primary key(codigo),
foreign key(nick)
references usuario(nick)
)engine=innodb;

create table notificaciones(
id int auto_increment,
contenido varchar(150),
primary key(id)
)engine=innodb;

create table leer(
nick varchar(40),
id int,
primary key(nick,id),
foreign key(nick)
references usuario(nick),
foreign key(id)
references notificaciones(id)
)engine=innodb;

create table administracion(
clave int,
valor int,
primary key(clave)
)engine=innodb;

create table cod_postal(
codigo_postal int,
comunidad_autonoma varchar(30),
provincia varchar(50),
poblacion int,
primary key(codigo_postal)
)engine=innodb;

create table lugar(
id int auto_increment,
nombre varchar(50),
codigo_postal int,
primary key(id),
foreign key(codigo_postal)
references cod_postal(codigo_postal)
)engine=innodb;

insert into usuario(Nick, nombre, apellido, pwd, Rol, img, cp) values("MenteFria", "Maxi", "angulo", "CañaAqui_33", "Administrador", "Imagen1", "28354");
insert into notificaciones(Contenido) values("Hola");
insert into pregunta_recuperacion(Pregunta, respuesta, nick) values("Bebida favorita", "Coca Cola", "MenteFria"); 
insert into libro(titulo, autor, disponible, genero, valoracion, fecha, comentario,nick)values("Moby Dick", "Herman Melville", TRUE, "Novela de aventuras", 8, '2024-04-11', "Espectacular", "MenteFria");
insert into Cod_Postal(Codigo_Postal, comunidad_autonoma, provincia, poblacion)values(28001, "Comunidad de Madrid", "Madrid", 3220000);
insert into Lugar(Nombre, codigo_postal)values("Madrid", 28001);

