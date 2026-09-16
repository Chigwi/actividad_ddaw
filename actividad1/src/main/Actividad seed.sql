
CREATE TABLE empleado(
    id_empleado int PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    correo varchar(100),
    rol int
);

CREATE TABLE detalle_producto(
    id_detalle_producto int PRIMARY KEY,
    notas varchar(1000),
    detalle_pedido int,
    producto_id int
);

CREATE TABLE producto(
    id_producto int PRIMARY KEY,
    nombre varchar(1000),
    descripcion varchar(1000),
    disponible boolean,
    precio float,
    categoria varchar(100)
);