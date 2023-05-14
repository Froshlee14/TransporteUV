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
	CONSTRAINT pkNumEmpleado PRIMARY KEY(numEmpleado)
	FOREIGN KEY (numEmpleado) REFERENCES conductor(numEmpleado) ON DELETE CASCADE
);

CREATE TABLE fabricante(
	idFabricante varchar(3),
	nombreFabricante varchar(20),
	CONSTRAINT pkIdFabricante PRIMARY KEY(idFabricante)
);

CREATE TABLE autobus(
	numUnidad varchar(5) not null,
	numSerie varchar(17),
	idFabricante varchar(3),
	yearFabricacion int,
	capacidad int,
	CONSTRAINT pkNumUnidad PRIMARY KEY(numUnidad)
	FOREIGN KEY (idFabricante) REFERENCES fabricante(idFabricante) ON DELETE CASCADE
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
	diraccion varchar(100),
	horaPartida TIME not null,
	horaLlegada TIME not null,
	CONSTRAINT pkNumViaje PRIMARY KEY(numViaje)
);

