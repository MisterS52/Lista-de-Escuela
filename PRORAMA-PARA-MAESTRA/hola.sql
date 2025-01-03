CREATE TABLE Escuela(

nombre varchar(150),
direccion varchar(150),
clave varchar(30),
PRIMARY KEY (nombre)

);

CREATE TABLE Grupo(

idgrupo serial,
grado varchar(2),
grupo varchar(2),
turno varchar(12),
escuela_nombre varchar(150),
FOREIGN KEY (escuela_nombre) REFERENCES Escuela(nombre),
PRIMARY KEY (idgrupo)
);

CREATE TABLE Alumno(

idAlumno serial,
nombre varchar(150),
apellido_paterno varchar(150),
apellido_materno varchar(150),
id_grupo integer,
FOREIGN KEY (id_grupo) REFERENCES Grupo(idgrupo),
PRIMARY KEY (idAlumno)
);

CREATE TABLE Fechas_asistencia(

idFecha serial,
fecha date, 
id_grupo integer,
FOREIGN KEY (id_grupo) REFERENCES Grupo(idgrupo),
PRIMARY KEY (idFecha)
);

CREATE TABLE Actividad(

idActividad serial,
fecha date,
id_grupo integer,
FOREIGN KEY (id_grupo) REFERENCES Grupo(idgrupo),
PRIMARY KEY (idActividad)
);

CREATE TABLE Asistencia(

idAsistencia serial,
idFecha integer, 
FOREIGN KEY (idFecha) REFERENCES Fechas_asistencia(idFecha),
idAlumno integer,
FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno),
asistencia integer,
PRIMARY KEY (idAsistencia)
);

CREATE TABLE Evaluacion(
idEvaluacion serial,
idAlumno integer,
FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno),
idActividad integer,
FOREIGN KEY (idActividad) REFERENCES Actividad(idActividad),
calificacion integer,
PRIMARY KEY (idEvaluacion)
);
ALTER USER postgres WITH PASSWORD '36379025';
show table
ALTER TABLE Actividad
ADD COLUMN NombreActividad VARCHAR(255);
show table
SELECT * FROM evaluacion;
SELECT * FROM actividad;
SELECT * FROM fechas_asistencia;
SELECT * FROM alumno;
SELECT * FROM grupo;
SELECT * FROM escuela;