-- database: ../database/db_PoliSalud.sqlite
/*
Copyright EPN 2025
Autor: Anthony ALangasí
Paralelo: GR2CC
DML : db_PoliSalud >> Creación de los registros
*/

INSERT INTO CatalogoTipo(Nombre,FechaModificacion) 
VALUES
 ('Sexo','')
,('TipoIdentificacion','')
,('Especialidad','')
,('Rol','2025-01-18')
,('Afiliacion','2025-01-18');

INSERT INTO Catalogo(IdTipoCatalogo,Nombre,FechaModificacion) 
VALUES
 (1,'Masculino','')
,(1,'Femenino','')
,(2,'Pasaporte','')
,(2,'Cédula','')
,(3,'Medicina General','2025-01-18')
,(3,'Cardiología','2025-01-18')
,(4,'Paciente','')
,(4,'Médico','2025-01-18')
,(5,'Sí','')
,(5,'No','');

INSERT INTO Persona(IdCatalogoRol, IdCatalogoSexo, IdCatalogoTipoIdentificacion, NumeroIdentificacion, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, FechaNacimiento, Direccion, FechaModificacion) 
VALUES
(8, 1, 3, 'A0012', 'Diego', 'Leo', 'Aquino', 'Bélez', '2002-10-13', 'Guamaní',''),
(8, 2, 4, 'A0013', 'María', 'Elena', 'Sánchez', 'Martínez', '1998-05-21', 'La Floresta',''),
(8, 1, 3, 'A0014', 'Juan', 'Carlos', 'Mora', 'Velasco', '1995-07-15', 'Cotocollao',''),
(8, 2, 4, 'A0015', 'Ana', 'Lucía', 'García', 'Pérez', '2000-12-09', 'El Condado',''),
(8, 1, 3, 'A0016', 'Luis', 'Fernando', 'Castro', 'Jiménez', '1997-03-19', 'Carapungo',''),
(8, 2, 4, 'A0017', 'Sofía', 'Isabel', 'Ruiz', 'Vargas', '2001-09-27', 'Chimbacalle',''),
(8, 1, 3, 'A0018', 'Carlos', 'Andrés', 'Zambrano', 'Ortiz', '1996-11-05', 'Tumbaco',''),
(8, 2, 4, 'A0019', 'Paola', 'Andrea', 'Cruz', 'Salinas', '1999-08-30', 'Calderón',''),
(8, 1, 3, 'A0020', 'Javier', 'Eduardo', 'Ramos', 'Guerrero', '1994-06-10', 'San Rafael',''),
(8, 2, 4, 'A0021', 'Marisol', 'Beatriz', 'Gómez', 'Chávez', '1993-04-14', 'Cumbayá',''),
(9, 1, 3, 'A0022', 'Pedro', 'Luis', 'Torres', 'Romero', '1992-01-18', 'Los Chillos',''),
(9, 2, 4, 'A0023', 'Gabriela', 'Cristina', 'López', 'Paredes', '2001-07-07', 'La Carolina',''),
(9, 1, 3, 'A0024', 'Esteban', 'David', 'Mejía', 'Suárez', '1989-02-23', 'Chillogallo',''),
(9, 2, 4, 'A0025', 'Andrea', 'Natalia', 'Fernández', 'Mendoza', '1990-09-12', 'San Bartolo',''),
(9, 1, 3, 'A0026', 'Felipe', 'Santiago', 'Ortiz', 'Ruiz', '1991-05-05', 'La Mariscal',''),
(9, 2, 4, 'A0027', 'Lorena', 'María', 'Quintana', 'Vega', '1988-12-20', 'Conocoto',''),
(9, 1, 3, 'A0028', 'Miguel', 'Ángel', 'Benítez', 'Mora', '1987-03-03', 'La Gasca',''),
(9, 2, 4, 'A0029', 'Diana', 'Sofía', 'Paredes', 'Velázquez', '1993-11-29', 'El Inca',''),
(9, 1, 3, 'A0030', 'José', 'Alejandro', 'Espinoza', 'Guayasamín', '1990-08-15', 'San Antonio',''),
(9, 2, 4, 'A0031', 'Verónica', 'Teresa', 'Acosta', 'López', '1985-10-18', 'Pomasqui','');

INSERT INTO Paciente(IdPersonaPaciente, IdCatalogoAfiliacion ,FechaModificacion) 
VALUES
(11, 9,'2025-01-18'),
(12, 10,''),
(13, 9,''),
(14, 10,''),
(15, 9,''),
(16, 10,'2025-01-18'),
(17, 9,''),
(18, 10,''),
(19, 9,'2025-01-18'),
(20, 10,'');

INSERT INTO CentroMedico(Nombre,Direccion,FechaModificacion) 
VALUES
 ('Hospital Padre Carollo', 'Av. Rumichaca','2025-01-18')
,('Clínica Pichincha', 'Calle Amazonas y Naciones Unidas','')
,('Hospital Metropolitano', 'Av. Mariana de Jesús y Occidental','')
,('Clínica Santa María', 'Av. 6 de Diciembre y Eloy Alfaro','')
,('Hospital de los Valles', 'Cumbayá, Vía Interoceánica','')
,('Clínica Internacional', 'Calle República y Av. América','2025-01-18')
,('Centro Médico La Primavera', 'Calle Eloy Alfaro y Los Nogales','')
,('Clínica San Francisco', 'Av. 10 de Agosto y La Pradera','')
,('Hospital Vozandes', 'Av. Vozandes y América','')
,('Centro Médico Especializado', 'Calle Alemania y República','2025-01-18')
,('Clínica San Gabriel', 'Av. Brasil y Wilson','')
,('Hospital Eugenio Espejo', 'Calle Gran Colombia y Sodiro','')
,('Centro Médico Quito', 'Av. Galo Plaza y De los Nogales','2025-01-18')
,('Clínica Pasteur', 'Av. 12 de Octubre y Roca','')
,('Hospital del Día Quito Sur', 'Av. Mariscal Sucre y Morán Valverde','2025-01-18')
,('Clínica El Batán', 'Calle Batán y González Suárez','')
,('Centro Médico Vida Sana', 'Av. De la Prensa y Occidental','')
,('Clínica Santa Inés', 'Av. Simón Bolívar y De los Granados','')
,('Hospital San Juan', 'Calle La Gasca y Occidental','')
,('Centro Médico Salud Plus', 'Av. Real Audiencia y Bellavista','2025-01-18');

INSERT INTO Medico(IdPersonaMedico,IdCentroMedico,IdCatalogoEspecialidad,NumeroLicencia,FechaModificacion) 
VALUES
(1, 1, 5, '000120','2025-01-18'),
(2, 2, 6, '000121',''),
(3, 3, 5, '000122',''),
(4, 1, 6, '000123','2025-01-18'),
(5, 2, 5, '000124',''),
(6, 3, 6, '000125',''),
(7, 1, 5, '000126','2025-01-18'),
(8, 2, 6, '000127',''),
(9, 3, 5, '000128','2025-01-18'),
(10, 1, 6, '000129','');

INSERT INTO Cita(IdMedico,IdPaciente,FechaCita,HoraCita,FechaModificacion) 
VALUES
(1, 1, '2025-01-18', '17:20:00','2025-01-18'),
(2, 2, '2025-01-19', '09:00:00',''),
(3, 3, '2025-01-20', '10:30:00',''),
(4, 4, '2025-01-21', '15:00:00',''),
(5, 5, '2025-01-22', '12:00:00','2025-01-18'),
(6, 6, '2025-01-23', '14:00:00',''),
(7, 7, '2025-01-24', '08:00:00',''),
(8, 8, '2025-01-25', '11:15:00',''),
(9, 9, '2025-01-26', '13:30:00',''),
(10,10,'2025-01-27', '16:45:00','2025-01-18'),
(1, 1, '2025-01-28', '10:00:00',''),
(2, 2, '2025-01-29', '09:45:00',''),
(3, 3, '2025-01-30', '11:30:00',''),
(4, 4, '2025-01-31', '15:15:00',''),
(5, 5, '2025-02-01', '12:30:00',''),
(6, 6, '2025-02-02', '14:15:00','2025-01-18'),
(7, 7, '2025-02-03', '08:30:00',''),
(8, 8, '2025-02-04', '11:45:00',''),
(9, 9, '2025-02-05', '13:00:00',''),
(10,10, '2025-02-06', '16:00:00','2025-01-18');

INSERT INTO HistorialClinico(IdPaciente,IdCita,Diagnostico,Tratamiento,FechaModificacion) 
VALUES
(1, 1, 'Gripe', 'Paracetamol cada 8 horas','2025-01-18'),
(2, 2, 'Faringitis', 'Ibuprofeno cada 6 horas',''),
(3, 3, 'Dolor de cabeza', 'Paracetamol según sea necesario',''),
(4, 4, 'Alergia estacional', 'Loratadina diaria',''),
(5, 5, 'Infección urinaria', 'Antibióticos por 7 días',''),
(6, 6, 'Resfriado común', 'Descanso e hidratación',''),
(7, 7, 'Gastritis', 'Omeprazol en ayunas',''),
(8, 8, 'Hipertensión', 'Control con medicamentos antihipertensivos','2025-01-18'),
(9, 9, 'Diabetes Tipo 2', 'Metformina diaria',''),
(10, 10, 'Migraña', 'Sumatriptán según indicación','');

INSERT INTO Correo(IdPersona,Correo,FechaModificacion) 
VALUES
(1, 'diegoA@gmail.com','2025-01-18'),
(2, 'mariaB@gmail.com',''),
(3, 'juanC@gmail.com',''),
(4, 'sofiaD@gmail.com',''),
(5, 'carlosE@gmail.com',''),
(6, 'lauraF@gmail.com',''),
(7, 'pedroG@gmail.com','2025-01-18'),
(8, 'anaH@gmail.com',''),
(9, 'luisI@gmail.com',''),
(10, 'paulaJ@gmail.com',''),
(11, 'fernandoK@gmail.com','2025-01-18'),
(12, 'dianaL@gmail.com',''),
(13, 'andresM@gmail.com',''),
(14, 'valeriaN@gmail.com',''),
(15, 'sergioO@gmail.com',''),
(16, 'camilaP@gmail.com',''),
(17, 'alejandroQ@gmail.com','2025-01-18'),
(18, 'martinaR@gmail.com',''),
(19, 'julianS@gmail.com',''),
(20, 'luciaT@gmail.com','');
INSERT INTO Telefono(IdPersona, NumeroTelefono,FechaModificacion) 
VALUES
(1, '0964257634',''),
(2, '0981234567',''),
(3, '0959876543','2025-01-18'),
(4, '0991122334',''),
(5, '0945566778',''),
(6, '0976655443',''),
(7, '0939876123','2025-01-18'),
(8, '0923344556',''),
(9, '0987765432',''),
(10, '0961234987',''),
(11, '0993344552',''),
(12, '0972233445','2025-01-18'),
(13, '0948877665',''),
(14, '0921122344',''),
(15, '0985544332',''),
(16, '0936677889',''),
(17, '0969988776',''),
(18, '0942233441',''),
(19, '0925566774','2025-01-18'),
(20, '0983322110','');