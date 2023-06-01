INSERT INTO conductor (nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp) VALUES
	('Juan','García','Pérez','1990-05-10','2018-01-01','Calle Hidalgo #34, Colonia Centro, Veracruz','2285551234',5),
	('Ana','Torres','Reyes','1992-08-15','2019-07-01','Avenida Juárez #76, Colonia Obrera, Xalapa','2295555678',7),
	('Carlos','Martínez','Gómez','1995-04-20','2020-01-01','Calle Miguel Hidalgo #120, Colonia Libertad, Coatzacoalcos','2295559876',1),
	('Sofía','Torres','García','1997-08-05','2021-04-01','Calle Pino Suárez #22, Colonia Emiliano Zapata, Poza Rica','2295554321',3),
	('Luis','Hernández','Ortiz','1989-11-22','2019-01-01','Avenida Lerdo de Tejada #45, Colonia Centro, Boca del Río','2285556789',5)
;
select * from conductor;

INSERT INTO contactoEmergencia (nombre,apellidoPaterno,apellidoMaterno,direccion,telefono,numEmpleado) VALUES
	('Ana','Torres','Flores','Calle Cipres #10, Colonia El Mirador, Xalapa, Veracruz','2285552468',2),
	('Jose','García','Pérez','Avenida Reforma #98, Colonia Centro, Veracruz','2295551357',1),
	('Gabriela','Pérez','López','Calle San Francisco #35, Colonia El Vergel, Boca del Río, Veracruz','2295553698',3),
	('Ricardo','Gonzáles','Ramirez','Avenida Juárez #255, Colonia El Pueblito, Córdoba, Veracruz','2295555796',4),
	('Carmen','Díaz','Castro','Calle Morelos #80, Colonia La Luz, Poza Rica, Veracruz','2285557814',5)
;
select * from contactoEmergencia;

INSERT INTO fabricante (nombreFabricante) VALUES
	('Mercedes-Benz'),
	('Volvo'),
	('Scania'),
	('MAN'),
	('Daimler AG')
;
select * from fabricante;

INSERT INTO autobus (numSerie,idFabricante,yearFabricacion,capacidad) VALUES
	('X1K9L2H8M7N3O4P5',1,2001,40),
	('B5N2M7J4K1L6H8G9',3,2012,35),
	('Q4Z7X6C1V9B8N3M2',3,2006,40),
	('L3K5J6H8G9F4D2S1',2,2000,40),
	('A2B3C4D5E6F7G8H9',4,2011,35)
;
select * from autobus;

INSERT INTO conductorAutobus (numEmpleado,numUnidad) VALUES
	(1,1),
	(1,2),
	(2,3),
	(3,4),
	(4,5)
;
select * from conductorAutobus;

INSERT INTO ruta (descripcion,destinoInicial,destinoFinal) VALUES
	('Ruta montañosa con hermosas vistas al mar.','Veracruz','Xalapa'),
	('Ruta de costa y montaña, rodeada de paisajes verdes.','Veracruz','San Andrés Tuxtla'),
	('Ruta costera hacia la exótica laguna de Catemaco.','Veracruz','Catemaco'),
	('Ruta hacia la capital poblana, con un bello paisaje montañoso.','Veracruz','Puebla')
;
select * from ruta;

INSERT INTO viaje (direccion,horaPartida,horaLlegada) VALUES
	('Veracruz-Xalapa','10:30:00','13:20:00'),
	('Veracruz-Catemaco','09:00:00','13:00:00'),
	('Veracruz-Puebla','12:00:00','18:30:00'),
	('San Andrés Tuxtla-Veracruz','06:00:00','09:45:00'),
	('Puebla-Veracruz','05:25:00','12:00:00')
;
select * from viaje;

INSERT INTO autobusViaje (numUnidad,numViaje) VALUES
	(1,5),
	(2,4),
	(3,3),
	(4,2),
	(5,1)
;
select * from autobusViaje;

INSERT INTO autobusRuta (numUnidad,numRuta) VALUES
	(1,4),
	(2,2),
	(3,4),
	(4,3),
	(5,1)
;
select * from autobusRuta;

INSERT INTO usuarios (usuario,passwrd,numEmpleado, rol) VALUES
	('JuanitoG','juan01',1,'empleado'),
	('AnaTorre','anit45',2,'empleado'),
	('CarlosMa','carl05',3,'empleado'),
	('SofiaTor','sofi45',4,'empleado'),
	('LuisHern','luis22',5,'empleado'),
	('Admin','lennon',0,'admin')
;