CREATE TABLE clientes(
    cedula VARCHAR(25) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    UNIQUE (email),
    PRIMARY KEY(cedula)
);

CREATE TABLE productos(
    codigo INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    precio_unitario DOUBLE NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE ventas(
    id INT NOT NULL AUTO_INCREMENT,
    id_cliente VARCHAR(25) NOT NULL,
    fecha DATETIME NOT NULL DEFAULT NOW(),
    iva DOUBLE NOT NULL,
    total DOUBLE NOT NULL,
    subtotal DOUBLE NOT NULL,
    domicilio DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(cedula)
);

CREATE TABLE detalles(
    id INT NOT NULL AUTO_INCREMENT,
    id_venta INT NOT NULL DEFAULT 1,
    id_producto INT NOT NULL DEFAULT 1,
    cantidad INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_venta) REFERENCES ventas(id),
    FOREIGN KEY (id_producto) REFERENCES productos(codigo)
);

-- INSERCIONES DE PRUEBA

INSERT INTO clientes (cedula, nombre, apellido, direccion, email)   
VALUES ('11111111','Patricia', 'Franco', 'Medellin', 'patricia@gmail.com');


INSERT INTO productos(codigo,nombre,descripcion,precio_unitario,stock)
VALUES (1, 'producto 1', 'producto 1', 30000, 10);

INSERT INTO productos(codigo,nombre,descripcion,precio_unitario,stock)
VALUES (2, 'producto 2', 'producto 2', 20000, 10);

INSERT INTO productos(codigo,nombre,descripcion,precio_unitario,stock)
VALUES (3, 'producto 3', 'producto 3', 10000, 10);

/*
JSON REALIZAR UNA VENTA
{
    "detalles":[
        {"cantidad": 2,"producto":{"codigo": 2}},
        {"cantidad": 2,"producto":{"codigo": 2}},
        {"cantidad":1, "producto":{"codigo": 3}}
    ],
    "cliente":{
        "cedula": "11111111"
    }
}
*/