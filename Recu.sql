--tabla cliente 
create table Cliente (
cliente_id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
nombre VARCHAR2(50), 
telefono VARCHAR2(25), 
correo_electronico VARCHAR2(50) UNIQUE NOT NULL, 
edad NUMBER,
contrase�a varchar2(40)
); 

--tabla vehiculo
create table vehiculo(
vehiculo_id  NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
cliente_id NUMBER NOT NULL, 
marca VARCHAR2(50) NOT NULL, 
modelo VARCHAR2(50) NOT NULL, 
a�o number(4) NOT NULL, 
estado VARCHAR2(100) NOT NULL, 
problema VARCHAR2(100)NOT NULL,
FOREIGN KEY (cliente_id) REFERENCES Cliente(cliente_id)ON DELETE CASCADE
); 

