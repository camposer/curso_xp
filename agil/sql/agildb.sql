CREATE TABLE iteracion (
	id INT  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(200),
	fecha_inicio DATE,
	fecha_fin DATE,
	PRIMARY KEY (id)
);

CREATE TABLE tarea (
	id INT  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(200),
	prioridad INT,
	esfuerzo INT,
	release VARCHAR(50),
	iteracion_id INT,
	fecha DATE,
	valor INT,
	estado VARCHAR(50) NOT NULL DEFAULT 'TODO',
	PRIMARY KEY(id),
	FOREIGN KEY (iteracion_id) REFERENCES iteracion(id)
);
