-- database: ../database/db_PoliSalud.sqlite
/*
Copyright EPN 2025
Autor: Anthony ALangasí
Paralelo: GR2CC
DLL : db_PoliSalud >> Creación de las tablas
*/

DROP TABLE IF EXISTS Telefono;
DROP TABLE IF EXISTS Correo;
DROP TABLE IF EXISTS HistorialClinico;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS Medico;
DROP TABLE IF EXISTS CentroMedico;
DROP TABLE IF EXISTS Paciente;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;


CREATE TABLE Catalogo(
  IdCatalogo            INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdTipoCatalogo        INTEGER NOT NULL REFERENCES CatalogoTipo (IdCatalogoTipo)
 ,Nombre                TEXT NOT NULL
  
 ,EstadoRegistro        VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion         timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion     DATETIME
);


CREATE TABLE CatalogoTipo(
  IdCatalogoTipo        INTEGER PRIMARY KEY AUTOINCREMENT
 ,Nombre                TEXT NOT NULL
  
 ,EstadoRegistro        VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion         timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion     DATETIME
);


CREATE TABLE CentroMedico(
  IdCentroMedico        INTEGER PRIMARY KEY AUTOINCREMENT
 ,Nombre                VARCHAR(100) NOT NULL
 ,Direccion             TEXT NOT NULL
  
 ,EstadoRegistro        VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion         timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion     DATETIME
);


CREATE TABLE Cita(
  IdCita                INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdMedico              INTEGER NOT NULL REFERENCES Medico (IdMedico)
 ,IdPaciente            INTEGER NOT NULL REFERENCES Paciente (IdPaciente)
 ,FechaCita             DATETIME NOT NULL
 ,HoraCita              INTEGER NOT NULL
  
  ,EstadoRegistro       VARCHAR(1) DEFAULT 'A'
  ,FechaCreacion        timestamp DATE DEFAULT (datetime('now','localtime'))
  ,FechaModificacion    DATETIME
);


CREATE TABLE Correo(
  IdCorreo              INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdPersona             INTEGER NOT NULL REFERENCES Persona (IdPersona)
 ,Correo                TEXT NOT NULL UNIQUE
  
 ,EstadoRegistro        VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion         timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion     DATETIME
);


CREATE TABLE HistorialClinico(
  IdHistorialClinico    INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdPaciente            INTEGER NOT NULL REFERENCES Paciente (IdPaciente)
 ,IdCita                INTEGER NOT NULL REFERENCES Cita (IdCita)
 ,Diagnostico           TEXT NOT NULL
 ,Tratamiento           TEXT NOT NULL
  
 ,EstadoRegistro       VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion        timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion    DATETIME
);

CREATE TABLE Medico(
  IdMedico               INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdPersonaMedico        INTEGER NOT NULL REFERENCES Persona (IdPersona)
 ,IdCentroMedico         INTEGER NOT NULL REFERENCES CentroMedico (IdCentroMedico)
 ,IdCatalogoEspecialidad INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo)
 ,NumeroLicencia         VARCHAR(10) NOT NULL UNIQUE
  
 ,EstadoRegistro       VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion        timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion    DATETIME
);


CREATE TABLE Paciente(
  IdPaciente            INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdPersonaPaciente     INTEGER NOT NULL REFERENCES Persona (IdPersona)
 ,IdCatalogoAfiliacion  INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo)
  
 ,EstadoRegistro       VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion        timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion    DATETIME
);


CREATE TABLE Persona(
  IdPersona                     INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdCatalogoRol                 INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo)
 ,IdCatalogoSexo                INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo)
 ,IdCatalogoTipoIdentificacion  INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo)
 ,NumeroIdentificacion          VARCHAR(10) NOT NULL UNIQUE
 ,PrimerNombre                  VARCHAR(100) NOT NULL
 ,SegundoNombre                 VARCHAR(100) NOT NULL
 ,PrimerApellido                VARCHAR(100) NOT NULL
 ,SegundoApellido               VARCHAR(100) NOT NULL
 ,FechaNacimiento               DATETIME NOT NULL
 ,Direccion                     TEXT NOT NULL
  
 ,EstadoRegistro       VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion        timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion    DATETIME
);


CREATE TABLE Telefono(
  IdTelefono           INTEGER PRIMARY KEY AUTOINCREMENT
 ,IdPersona            INTEGER NOT NULL REFERENCES Persona (IdPersona)
 ,NumeroTelefono       VARCHAR(10) NOT NULL UNIQUE
 
 ,EstadoRegistro       VARCHAR(1) DEFAULT 'A'
 ,FechaCreacion        timestamp DATE DEFAULT (datetime('now','localtime'))
 ,FechaModificacion    DATETIME
);


