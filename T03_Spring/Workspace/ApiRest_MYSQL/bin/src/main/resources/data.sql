-- Insertar datos en la tabla 'departamento'
INSERT INTO departamento (nombre) VALUES ('Desarrollo');
INSERT INTO departamento (nombre) VALUES ('Marketing');
INSERT INTO departamento (nombre) VALUES ('Recursos Humanos');

-- Insertar datos en la tabla 'proyecto'
INSERT INTO proyecto (nombre) VALUES ('Proyecto Web');
INSERT INTO proyecto (nombre) VALUES ('App Móvil');
INSERT INTO proyecto (nombre) VALUES ('Estrategia Digital');
INSERT INTO proyecto (nombre) VALUES ('Portal de Empleados');
INSERT INTO proyecto (nombre) VALUES ('Rediseño Corporativo');

-- Insertar datos en la tabla 'empleado'
INSERT INTO empleado (nombre, email, salario, departamento_id, proyecto_id) VALUES ('Juan Pérez', 'juan@example.com', 50000, 1, 1);
INSERT INTO empleado (nombre, email, salario, departamento_id, proyecto_id) VALUES ('Ana López', 'ana@example.com', 55000, 1, 1);
INSERT INTO empleado (nombre, email, salario, departamento_id, proyecto_id) VALUES ('Carlos García', 'carlos@example.com', 40000, 2, 3);
INSERT INTO empleado (nombre, email, salario, departamento_id, proyecto_id) VALUES ('Sofía Martínez', 'sofia@example.com', 45000, 3, 4);
INSERT INTO empleado (nombre, email, salario, departamento_id, proyecto_id) VALUES ('Pedro Ramírez', 'pedro@example.com', 42000, 2, 2);


