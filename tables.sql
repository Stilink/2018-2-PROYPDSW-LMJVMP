-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-02 21:11:08.115

-- tables
-- Table: area
CREATE TABLE area (
    id int  NOT NULL,
    nombre varchar(25)  NOT NULL,
    CONSTRAINT area_pk PRIMARY KEY (id)
);

-- Table: comentarios
CREATE TABLE comentarios (
    iniciativa int  NOT NULL,
    perfil varchar(75)  NOT NULL,
    descripcion varchar(100)  NOT NULL,
    id int  NOT NULL,
    fecha date  NOT NULL,
    CONSTRAINT comentarios_pk PRIMARY KEY (id)
);

-- Table: iniciativa
CREATE TABLE iniciativa (
    id int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    estado varchar(25)  CHECK(estado in('En revision','En espera de revision','Proyecto','Solucionado')),
    creador varchar(75)  NOT NULL,
    no_votos int  NOT NULL,
    descripcion varchar(255)  NOT NULL,
    fechaDeCreacion date  NOT NULL,
    CONSTRAINT iniciativa_pk PRIMARY KEY (id)
);

-- Table: interes
CREATE TABLE interes (
    perfil varchar(75)  NOT NULL,
    iniciativa int  NOT NULL,
    CONSTRAINT interes_pk PRIMARY KEY (perfil,iniciativa)
);

-- Table: palabra_clave
CREATE TABLE palabra_clave (
    palabra varchar(25)  NOT NULL,
    iniciativa int  NOT NULL,
    CONSTRAINT palabra_clave_pk PRIMARY KEY (palabra,iniciativa)
);

-- Table: perfil
CREATE TABLE perfil (
    rol varchar(25)  NOT NULL,
    nombre varchar(75)  NOT NULL,
    email varchar(75)  NOT NULL,
    area int NOT NULL,
    CONSTRAINT perfil_pk PRIMARY KEY (email)
);

-- Table: rol
CREATE TABLE rol (
    nombre varchar(25)  NOT NULL,
    prioridad int  NOT NULL UNIQUE,
    CONSTRAINT rol_pk PRIMARY KEY (nombre)
);

-- Table: voluntad
CREATE TABLE voluntad (
    perfil varchar(75) NOT NULL,
    iniciativa int  NOT NULL,
    CONSTRAINT voluntad_pk PRIMARY KEY (perfil,iniciativa)
);
-- Table: usuario
CREATE TABLE usuario(
    email varchar(75)  NOT NULL,
    password varchar(50)  NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (email)
);

-- foreign keys
-- Reference: usuario_perfil (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_perfil
    FOREIGN KEY (email)
    REFERENCES perfil (email)  
;

-- Reference: comentarios_iniciativa (table: comentarios)
ALTER TABLE comentarios ADD CONSTRAINT comentarios_iniciativa
    FOREIGN KEY (iniciativa)
    REFERENCES iniciativa (id)  
;

-- Reference: perfil_area (table: perfil)
ALTER TABLE perfil ADD CONSTRAINT perfil_area
    FOREIGN KEY (area)
    REFERENCES area (id)  
;

-- Reference: iniciativa_palabra_clave (table: palabra_clave)
ALTER TABLE palabra_clave ADD CONSTRAINT iniciativa_palabra_clave
    FOREIGN KEY (iniciativa)
    REFERENCES iniciativa (id)  
;

-- Reference: intencion_iniciativa (table: voluntad)
ALTER TABLE voluntad ADD CONSTRAINT intencion_iniciativa
    FOREIGN KEY (iniciativa)
    REFERENCES iniciativa (id)  
;

-- Reference: intencion_perfil (table: voluntad)
ALTER TABLE voluntad ADD CONSTRAINT intencion_perfil
    FOREIGN KEY (perfil)
    REFERENCES perfil (email)  
;

-- Reference: interes_iniciativa (table: interes)
ALTER TABLE interes ADD CONSTRAINT interes_iniciativa
    FOREIGN KEY (iniciativa)
    REFERENCES iniciativa (id)  
;

-- Reference: interes_perfil (table: interes)
ALTER TABLE interes ADD CONSTRAINT interes_perfil
    FOREIGN KEY (perfil)
    REFERENCES perfil (email)  
;

-- Reference: perfil_comentarios (table: comentarios)
ALTER TABLE comentarios ADD CONSTRAINT perfil_comentarios
    FOREIGN KEY (perfil)
    REFERENCES perfil (email)  
;

-- Reference: perfil_iniciativa (table: iniciativa)
ALTER TABLE iniciativa ADD CONSTRAINT perfil_iniciativa
    FOREIGN KEY (creador)
    REFERENCES perfil (email)  
;

-- Reference: rol_perfil (table: perfil)
ALTER TABLE perfil ADD CONSTRAINT rol_perfil
    FOREIGN KEY (rol)
    REFERENCES rol (nombre)  
;

-- End of file.

