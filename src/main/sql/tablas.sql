CREATE TABLE conductor(
	numEmpleado SERIAL,
	nombre varchar(30),
	apellidoPaterno varchar(30),
	apellidoMaterno varchar(30),
	birthday date,
	fechaContrato date,
	direccion varchar(120),
	telefono varchar(10),
	yearsExp int,
	status boolean,
	PRIMARY KEY(numEmpleado)
);

CREATE TABLE contactoEmergencia(
	numContacto SERIAL,
	nombre varchar(30),
	apellidoPaterno varchar(30),
	apellidoMaterno varchar(30),
	direccion varchar(120),
	telefono varchar(10),
	numEmpleado int,
	PRIMARY KEY(numEmpleado),
	FOREIGN KEY (numEmpleado) REFERENCES conductor(numEmpleado) ON DELETE CASCADE
);

CREATE TABLE fabricante(
	idFabricante SERIAL,
	nombreFabricante varchar(20),
	PRIMARY KEY(idFabricante)
);

CREATE TABLE autobus(
	numUnidad SERIAL,
	numSerie varchar(17),
	idFabricante int,
	yearFabricacion int,
	capacidad int,
	status boolean,
	PRIMARY KEY(numUnidad),
	FOREIGN KEY (idFabricante) REFERENCES fabricante(idFabricante)
);

CREATE TABLE conductorAutobus(
	numEmpleado int,
	numUnidad int,
	FOREIGN KEY (numEmpleado) REFERENCES conductor(numEmpleado) ON DELETE CASCADE,
	FOREIGN KEY (numUnidad) REFERENCES autobus(numUnidad) ON DELETE CASCADE
);

CREATE TABLE ruta(
	numRuta SERIAL,
	descripcion varchar(100),
	destinoInicial varchar(50),
	destinoFinal varchar(50),
	PRIMARY KEY(numRuta)
);

CREATE TABLE viaje(
	numViaje SERIAL,
	direccion varchar(100),
	horaPartida TIME not null,
	horaLlegada TIME not null,
	PRIMARY KEY(numViaje)
);

CREATE TABLE autobusViaje(
	numUnidad int,
	numViaje int,
	FOREIGN KEY (numUnidad) REFERENCES autobus(numUnidad) ON DELETE CASCADE,
	FOREIGN KEY (numViaje) REFERENCES viaje(numViaje) ON DELETE CASCADE
);

CREATE TABLE autobusRuta(
	numUnidad int,
	numRuta int,
	FOREIGN KEY (numUnidad) REFERENCES autobus(numUnidad) ON DELETE CASCADE,
	FOREIGN KEY (numRuta) REFERENCES ruta(numRuta) ON DELETE CASCADE
);

CREATE TABLE usuarios(
	usuario varchar(8),
	passwrd varchar(6),
	numEmpleado int,
	rol varchar(8),
	status boolean,
	PRIMARY KEY(usuario)
);

--En caso de ser necesario
--se borra de forma descendente
--por las llaves foraneas
/*
DROP TABLE autobusRuta;
DROP TABLE autobusViaje;
DROP TABLE viaje;
DROP TABLE ruta;
DROP TABLE conductorAutobus;
DROP TABLE autobus;
DROP TABLE contactoEmergencia;
DROP TABLE usuarios;
DROP TABLE fabricante;
DROP TABLE conductor;
*/