use master;
DROP DATABASE croquetitlan_db;
CREATE DATABASE croquetitlan_db;
USE croquetitlan_db;
-- Create tables
create table catestados(idestado int primary key identity, estado varchar(255) not null);
create table catmunicipios(idmunicipio int primary key identity, municipio varchar(255) not null, idestado int, constraint fk_idestado foreign key(idestado) references catestados(idestado));
create table catproducto(idproducto int primary key identity, nombre varchar(255) not null, descripcion varchar(500)  not null);
create table catgramaje(idgramaje int primary key identity, idproducto int, preciokg DECIMAL(13,2) not null, gramajemin DECIMAL(15,3) not null, constraint fk_idproducto foreign key(idproducto) references catproducto(idproducto));
create table catestatus(idestatus int primary key identity, estatus varchar(50) not null, porcentaje DECIMAL(6,2) not null);
create table catjerarquia(idjerarquia int primary key identity, jerarquia varchar(50) not null);
create table catgastos(idgastos int primary key identity, gasto varchar(50) not null);
create table producto(idprod int primary key identity, idproducto2 int, fechacaducidad date, cantidad int not null, preciouni DECIMAL(13,2) not null, pesocostal DECIMAL(15,3), constraint fk_idproducto2 foreign key(idproducto2) references catproducto(idproducto));
create table gramaje(idgram int primary key identity, idgramaje int, fechacaducidad date not null, cantidad DECIMAL(15,3) not null, constraint fk_idgramaje foreign key(idgramaje) references catgramaje(idgramaje));
create table datos(iddatos int primary key identity, telefono varchar(25), email varchar(150) not null, nombre varchar(255) not null, appat varchar(255), apmat varchar(255), fechanac date not null, cp varchar(10) not null, idmunicipio int, calle varchar(150), numero varchar(15), numintterior varchar(15), constraint fk_idmunicipio foreign key(idmunicipio) references catmunicipios(idmunicipio));
create table descuentos(iddescuento int primary key identity, idproducto3 int, fechainicio date not null, fechafin date not null, solocliente bit not null, porcentaje DECIMAL(6,2), preciodesc DECIMAL(15,2), cantidadunit int, cantidadgram DECIMAL(15,3), constraint fk_idproducto3 foreign key(idproducto3) references catproducto(idproducto));
create table trabajadores(idtrabajador int primary key identity, iddatos2 int, rfc varchar(18), curp varchar(18), horas int, sueldohora DECIMAL(15,2), idjerarquia2 int, constraint fk_iddatos2 foreign key(iddatos2) references datos(iddatos),constraint fk_idjerarquia2 foreign key(idjerarquia2) references catjerarquia(idjerarquia));
create table gastos(idgastmens int primary key identity, idgastos int, total DECIMAL(15,2), fechapago date, pagado bit, idtrabajador2 int, constraint fk_idgastos foreign key(idgastos) references catgastos(idgastos), constraint fk_idtrabajador2 foreign key(idtrabajador2) references trabajadores(idtrabajador));
create table clientefrecuente(idcliente int primary key identity, iddatos int, idestatus int, constraint fk_iddatos foreign key(iddatos) references datos(iddatos), constraint fk_idestatus foreign key(idestatus) references catestatus(idestatus));
create table transacciones(idtransaccion int primary key identity, totalcompra DECIMAL(15,2), fechahora timestamp, idcliente int, constraint fk_idcliente foreign key(idcliente) references clientefrecuente(idcliente));
create table vproductoent(idvproductoent int primary key identity, cantidad int, idprod int, idtransaccion int, constraint fk_idprod foreign key(idprod) references producto(idprod), constraint fk_idtransaccion foreign key(idtransaccion) references transacciones(idtransaccion));
create table vproductgra(idvproductgra int primary key identity, gramoscom int, idprod2 int, idtransaccion2 int, constraint fk_idprod2 foreign key(idprod2) references producto(idprod), constraint fk_idtransaccion2 foreign key(idtransaccion2) references transacciones(idtransaccion));
create table pass(idpass int primary key identity, pass varchar(255), idtrabajador int, constraint fk_idtrabajador foreign key(idtrabajador) references trabajadores(idtrabajador));
-- Insercciones a la DB para catálogos