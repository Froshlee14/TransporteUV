CREATE TABLE conductor(
	numEmpleado varchar(5) not null,
	nombre varchar(30),
	apellidoPaterno varchar(30),
	apellidoMaterno varchar(30),
	birthday date,
	fechaContrato date,
	direccion varchar(120),
	telefono varchar(10),
	yearsExp int,
	CONSTRAINT pkNumEmpleado PRIMARY KEY(numEmpleado)
);

CREATE TABLE contactoEmergencia(
	numContacto varchar(5) not null,
	nombre varchar(30),
	apellidoPaterno varchar(30),
	apellidoMaterno varchar(30),
	direccion varchar(120),
	telefono varchar(10),
	numEmpleado varchar(5),
	CONSTRAINT pkNumContacto PRIMARY KEY(numEmpleado),
	FOREIGN KEY (numEmpleado) REFERENCES conductor(numEmpleado) ON DELETE CASCADE
);

CREATE TABLE autobus(
	numUnidad varchar(5) not null,
	numSerie varchar(17),
	idFabricante varchar(3) UNIQUE,
	yearFabricacion int,
	capacidad int,
	CONSTRAINT pkNumUnidad PRIMARY KEY(numUnidad)
);

CREATE TABLE conductorAutobus(
	numEmpleado varchar(5),
	numUnidad varchar(5),
	fecha date,
	FOREIGN KEY (numEmpleado) REFERENCES conductor(numEmpleado) ON DELETE CASCADE,
	FOREIGN KEY (numUnidad) REFERENCES autobus(numUnidad) ON DELETE CASCADE
);

CREATE TABLE fabricante(
	idFabricante varchar(3),
	nombreFabricante varchar(20),
	CONSTRAINT pkIdFabricante PRIMARY KEY(idFabricante),
	FOREIGN KEY (idFabricante) REFERENCES autobus(idFabricante) ON DELETE CASCADE
);

CREATE TABLE ruta(
	numRuta varchar(5) not null,
	descripcion varchar(100),
	destinoInicial varchar(50),
	destinoFinal varchar(50),
	CONSTRAINT pkNumRuta PRIMARY KEY(numRuta)
);

CREATE TABLE viaje(
	numViaje varchar(5) not null,
	direccion varchar(100),
	horaPartida TIME not null,
	horaLlegada TIME not null,
	CONSTRAINT pkNumViaje PRIMARY KEY(numViaje)
);

CREATE TABLE autobusViaje(
	numUnidad varchar(5),
	numViaje varchar(5),
	FOREIGN KEY (numUnidad) REFERENCES autobus(numUnidad) ON DELETE CASCADE,
	FOREIGN KEY (numViaje) REFERENCES viaje(numViaje) ON DELETE CASCADE
);

CREATE TABLE autobusRuta(
	numRuta varchar(5),
	numUnidad varchar(5),
	FOREIGN KEY (numRuta) REFERENCES ruta(numRuta) ON DELETE CASCADE,
	FOREIGN KEY (numUnidad) REFERENCES autobus(numUnidad) ON DELETE CASCADE
);

--DROP TABLE conductor;
--DROP TABLE contactoEmergencia;
--DROP TABLE autobus;
--DROP TABLE conductorAutobus;
--DROP TABLE fabricante;
--DROP TABLE ruta;
--DROP TABLE viaje;
--DROP TABLE autobusViaje;
--DROP TABLE autobusRuta;