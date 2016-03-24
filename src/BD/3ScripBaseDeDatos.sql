--Configuracion del Script

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--Tipo_Sugerencia

insert into tipo_sugerencia (descripcion,activo) values ('Opinión',true);
insert into tipo_sugerencia (descripcion,activo) values ('Queja',true);
insert into tipo_sugerencia (descripcion,activo) values ('Sugerencia',true);
insert into tipo_sugerencia (descripcion,activo) values ('Pregunta',true);

--Tipo_instalacion

insert into tipo_instalacion (descripcion,activo) values ('Deportivo',true);
insert into tipo_instalacion (descripcion,activo) values ('Fiesta',true);
insert into tipo_instalacion (descripcion,activo) values ('Infantil',true);

--Tipo_Preferencia

insert into tipo_preferencia (descripcion,color,activo) values ('Cultural','#008000',true);
insert into tipo_preferencia (descripcion,color,activo) values ('Deportiva','#0000FF',true);
insert into tipo_preferencia (descripcion,color,activo) values ('Social','#20B2AA',true);

--tipo_afiliado

insert into tipo_afiliado (descripcion,subfijo,activo) values ('Esposo','-1',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Esposa','-1',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Hijo','-2',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Hija','-2',true);

--Tipo_sancion
insert into tipo_sancion (descripcion,activo) values ('Suspensión',true);
insert into tipo_sancion (descripcion,activo) values ('Multa',true);

--Tipo_archivo
insert into tipo_archivo (descripcion,activo) values ('Lista Invitados',true);
insert into tipo_archivo (descripcion,activo) values ('Lista Proveedores',true);

--tipo_eventualidad

insert into tipo_eventualidad (descripcion,activo) 
                       values ('Deuda',true),
 							  ('Estravío de Recursos',true),
							  ('Mala Conducta',true),
							  ('Actos Inmorales', true),
           					  ('Daños a Instalación', true);
           					  
--Tipo_noticia

insert into tipo_noticia (descripcion,color,activo) values ('Evento','#3300cc',false);
insert into tipo_noticia (descripcion,color,activo) values ('Postulación','#f88514',false);
insert into tipo_noticia (descripcion,color,activo) values ('Acciones','#FFFF00',true);
insert into tipo_noticia (descripcion,color,activo) values ('Sucesos','#cc00ff',true);
insert into tipo_noticia (descripcion,color,activo) values ('Otros','#FFA500',true);

--Tipo_opinion
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('Lo Recomiendo', true);
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('No lo recomiendo', true);
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('No lo conozco', true);

--tipo_pago
INSERT INTO tipo_pago(descripcion, activo)
    VALUES ('Efectivo', TRUE),
	   	   ('Transferencia', TRUE),
	       ('Depósito', TRUE);

--Estado_evento

insert into estado_evento (nombre,activo) values ('Por Planificar',true);
insert into estado_evento (nombre,activo) values ('Listo para Ejecutar',true);
insert into estado_evento (nombre,activo) values ('En Ejecución',true);
insert into estado_evento (nombre,activo) values ('Finalizado',true);
insert into estado_evento (nombre,activo) values ('Cancelado',true);

--Motivo_sancion
insert into motivo_sancion (descripcion,activo) values ('Eventualidad',true);
insert into motivo_sancion (descripcion,activo) values ('Morosidad',true);

--Motivo_postulacion
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (1, 'Beneficios del Club', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (2, 'Inversión', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (3, 'Deporte', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (4, 'Osio', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (5, 'Recreación', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (6, 'Diversión', true);

--Motivo_Venta
Insert into motivo_venta (descripcion,activo) VALUES ('Necesidad Económica',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Cambio de Ciudad',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Descontento con el Club',TRUE);

--Motivo_cancelacion

INSERT INTO motivo_cancelacion (descripcion, activo) VALUES ( 'Falta de Recursos', true);
INSERT INTO motivo_cancelacion (descripcion, activo) VALUES ( 'Por Presupuestos', true);
INSERT INTO motivo_cancelacion (descripcion, activo) VALUES ( 'Actividades Imcompletas', true);

--motivo_desvinculacion

insert into motivo_desvinculacion (descripcion,activo) values ('Venta de Acción',true);
insert into motivo_desvinculacion (descripcion,activo) values ('Socio Sancionado',true)

--Estado_Accion
INSERT INTO estado_accion (nombre, activo) VALUES ('Asociada', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('En Venta', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('En Solicitud', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('Inactiva', true);

--Red_Social

insert into red_social (descripcion,imagen,activo) values ('Facebook','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('Twitter','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('Instagram','No Tiene',true);

--Cargo

insert into cargo (descripcion,activo) values ('Presidente',true);
insert into cargo (descripcion,activo) values ('Vicepresidente',true);
insert into cargo (descripcion,activo) values ('Vocero',true);
insert into cargo (descripcion,activo) values ('Tesorero',true);

--indicador
INSERT INTO indicador(descripcion, activo)
    VALUES ('Asistencia de Personas', TRUE),
           ('Ingresos Recolectados', TRUE),
           ('Utilidad', TRUE),
           ('Ingresos por Inscripción a Torneos', TRUE),
           ('Ingresos por Bebidas alcohólicas', TRUE);

--Persona
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('20387728', 'Enmanuel', 'Medina', NULL, '1980-03-01', 'M', 'enmanuelm19@gmail.com', '04146549874', '02516548765', 'Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('12345678', 'Prisco', 'Canelón', NULL, '1981-04-01', 'M', 'carlos@gmail.com', '04249876668', '02513348765', 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('12546318', 'Carlos', 'Colmenarez', NULL, '1982-05-01', 'M', 'juan@gmail.com', '04127896654', '02516548705', 'Valle Hondo, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('14327254', 'Manuel', 'Guerrero', 'http://i.imgur.com/xXp0wXP.png', '1983-06-01', 'M', 'manuel@gmail.com', '04147658877', '02516548265', 'Carrera 25 con calle 12', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('13658792', 'Hector', 'Gil', NULL, '1983-07-01', 'M', 'sergio@hotmail.com', '04167779788', '02516540965', 'Av Libertador con calle 12', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('16267894', 'Pedro', 'Camacaro', NULL, '1984-08-01', 'M', 'pedrocamacaro@gmail.com', '04263423433', '0255657432', 'Santa Isabel, Avenida 4', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('22186230', 'Fidel', 'Aliaga', 'http://i.imgur.com/mSJl1BZ.jpg', '1985-03-17', 'M', 'fidel.alejos@gmail.com', '04263237394', '02512553545', 'Barquisimeto', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19648893', 'Ruben', 'Vivas', 'http://i.imgur.com/ycCM1PJ.jpg', '1991-09-13', 'M', 'rvivas89@gmail.com', '04165438877', '02513456566', 'UrbanizaciÃ³n Las Trinitarias2', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('21140247', 'Mariangel', 'Arrieche', 'http://i.imgur.com/8t2CuRs.png', '1980-03-18', 'F', 'mariangel@gmail.com', '0416555555', '02412222222', 'barquisimeto', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('23393273', 'Roman', 'Arrieche', 'http://i.imgur.com/krJ9S4R.png', '1992-03-18', 'M', 'roman@gmail.com', '041255555', NULL, 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('11593903', 'Romulo', 'Dominguez', 'http://i.imgur.com/duCXybQ.jpg', '1972-03-03', 'M', 'rdominguez@gmail.com', '04168765555', '02512557654', 'Pardos del Glof III Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('13353553', 'María', 'Rosario', NULL, '1996-09-24', 'F', 'maria@gmail.com', '04243131311', NULL, 'Prados del Golf III, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19818668', 'Edward', 'Rodríguez', NULL, '1996-04-25', 'M', 'edward@gmail.com', '04169522432', NULL, 'La Piedad', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('22097230', 'Karla', 'Moron', NULL, '1994-06-17', 'F', 'karla@gmail.com', '04263567394', '02512903265', 'Trujillo', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19648034', 'Elisabeth', 'Oviedo', NULL, '1995-06-15', 'F', 'elisaovi@gmail.com', '04145438877', '02513456034', 'Urbanización La Sábila', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('20860247', 'Tony', 'Suárez', NULL, '1995-10-21', 'M', 'suareztony@gmail.com', '04162574955', '02413492212', 'barquisimeto', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('23328473', 'Rosmary', 'Fuentes', NULL, '1997-05-11', 'F', 'rosmary@gmail.com', '04122697514', NULL, 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('11843703', 'Beatriz', 'Encinoza', NULL, '1995-03-03', 'M', 'rdominguez@gmail.com', '04168765555', '02512557654', 'Pardos del Glof III Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('13357913', 'Anthony', 'Cordero', NULL, '1996-09-24', 'M', 'maria@gmail.com', '04243131311', NULL, 'Prados del Golf III, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19810068', 'Yajaira', 'Marchan', NULL, '1997-01-24', 'F', 'yajaira@gmail.com', '78389327', NULL, 'La Piedad', true);

--solicitud_venta

insert into solicitud_venta (accionid_accion,motivo,fecha,motivo_ventaid_motivo_venta,activo) values (4,'Necesidad Economica','01/03/2016',1,true);

--Noticia

INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Nueva Postulación', 'El Sr(a). Fidel Aliaga, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 'http://i.imgur.com/mSJl1BZ.jpg', 5, '2016-03-17', '2016-03-17', false, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Prepárate para el 89 aniversario del Centro Atlético América', 'En su semana aniversario, la junta directiva, encabezada por el Dr. Víctor Montilla, se complace en invitar a todos los consocios y comunidad larense a disfrutar y compartir del programa de actividades designado.', NULL, 'http://i.imgur.com/JNy9o9V.png', 4, '2016-03-18', '2016-03-20', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Jornadas Infociencias XXXII', 'La 32 edición de las Jornadas de Infociencias de la Universidad Centroccidental Lisandro Alvarado, se realizará el día 6 de Abril del presente año en las instalaciones del Decanato de Ciencias y Tecnología, núcleo Obelisco, donde se darán a conocer cuatro proyectos informáticos creados por los estudiantes de Ingeniería en Informática', NULL, 'http://i.imgur.com/JNy9o9V.png', 3, '2016-03-18', '2016-03-20', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Nueva Postulación', 'El Sr(a). Ruben Vivas, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 'http://i.imgur.com/ycCM1PJ.jpg', 5, '2016-03-18', '2016-03-18', false, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Torneo de Beisbol', 'Disfruta del Torneo de Beisbol', NULL, 'localhost:8080/america/assets/img/default-placeholder.png', 1, '2016-03-18', '2016-03-19', false, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Evento Hilder', 'Este un evento con la noticia corregida', 3, 'localhost:8080/america/assets/img/default-placeholder.png', 1, '2016-03-25', '2016-04-01', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-18', '2016-03-18', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-18', '2016-03-18', true, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Nueva Postulación', 'El Sr(a). Mariangel Arrieche, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secciÃ³n de opiniones postulantes!', NULL, 'http://i.imgur.com/8t2CuRs.png', 5, '2016-03-18', '2016-03-18', false, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Nueva Postulación', 'El Sr(a). Romulo Dominguez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secciÃ³n de opiniones postulantes!', NULL, 'http://i.imgur.com/duCXybQ.jpg', 5, '2016-03-18', '2016-03-18', false, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Parrilla Osullivan', 'Evento para quitar la presión de los desarrolladores del Club América', 4, 'localhost:8080/america/assets/img/default-placeholder.png', 1, '2016-03-20', '2016-03-21', false, NULL, true);
INSERT INTO noticia (titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES ('Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-18', '2016-03-18', true, NULL, true);

--Cliente _ Externo

insert into cliente_externo (nombre,apellido,correo,activo) values ('Jose','Mendoza','elpequeñogigante@gmail.com',true);
insert into cliente_externo (nombre,apellido,correo,activo) values ('Miguel','Alonso','miggy_19@gmail.com',true);
insert into cliente_externo (nombre,apellido,correo,activo) values ('Edgar','Sanchez','edgarr@gmail.com',true);
insert into cliente_externo (nombre,apellido,correo,activo) values ('Gustavo','Araujo','directoryola@gmail.com',true);

--Sugerencias

INSERT INTO sugerencia(descripcion, fecha, cliente_externoid_cliente, tipo_sugerenciaid_tipo_sugerencia, activo)
    VALUES ('Quiero manifestar mi molestia, tuve un incidente con uno de los vigilantes que me insulto y me trato mal, me sorprende que permitan esto, yo conozco miembros de la directiva y son gente muy seria.', '20-02-2016', 1, 2, true),
	   ('Buenos Días, quisiera sugerir que aumenten la iluminacion en la nueva cancha de futbol, me parece muy bonita pero en la noche ahi puntos que les falta iluminación', '25-02-2016', 2, 3, true),
	   ('Necesito hacer una fiesta para mi hijo, que cumple 11 años. ¿Como puedo alquilar una de sus instalaciones?, la distribucion de los espacios es lo que tengo en mente para la fiesta', '27-02-2016', 3, 4, true),
	   ('Estuve el fin de semana allá, y pienso que la seguridad es muy escasa en el campo de beisbol, tuve una anecdota no muy grata por este motivo, pienso que es bueno que analicen esto.', '13-03-2016', 4, 1, true);

--Instalacion

insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Campo de Beisbol','Espacio para la Práctica de Beisbol',500,20000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Salon de Fiesta','Espacio para Fiestas y Celebraciones',150,25000,true,2,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Parque Infantil','area recreacional para niÃƒÆ’Ã‚Â±os',150,NULL,false,3,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Cancha de Tenis','Espacio para la Práctica de Tenis, para el disfrute de todos nuestros socios',500,20000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Cancha de Bolas Criollas','Cancha popular entre nuestros socios, en especial los fines de semana',150,25000,true,2,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Caney de Rafa','area recreacional para niÃƒÆ’Ã‚Â±os',150,2000,true,3,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Caney de Chevechita','Caney que debe su Nombre a un Socio emblemático, desaparecido físicamente desde hace años.',150,NULL,false,3,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Piscina','Área amplia con Comodidades dignas de la Comunidad Americanista',150,35000,true,3,true);

--Preferencia

insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Beisbol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Futbol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Tenis',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Bolas Criollas',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Natacion',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Kickingball',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Voleibol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Baile',3,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Bebedor Ocasional',3,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Musica',3,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Televisión',3,true);

--Recurso

insert into recurso (descripcion,activo) values ('Sillas de PlÃ¡stico',True);
insert into recurso (descripcion,activo) values ('Sillas de Madera',True);
insert into recurso (descripcion,activo) values ('Mesas Redondas',True);
insert into recurso (descripcion,activo) values ('Mesas Cuadradas',True);
insert into recurso (descripcion,activo) values ('Manteles',True);
insert into recurso (descripcion,activo) values ('Hieleras',True);
insert into recurso (descripcion,activo) values ('Cornetas',True);

--recurso_instalacion

insert into recurso_instalacion (instalacionid_instalacion,recursoid_recurso,cantidad,activo) values (2,1,100,true);
insert into recurso_instalacion (instalacionid_instalacion,recursoid_recurso,cantidad,activo) values (2,2,100,true);

--Postulado

INSERT INTO postulado (personaid_persona, activo) VALUES ( 7, true);
INSERT INTO postulado (personaid_persona, activo) VALUES ( 8, true);
INSERT INTO postulado (personaid_persona, activo) VALUES ( 9, true);
INSERT INTO postulado (personaid_persona, activo) VALUES ( 11, true);

--Postulacion

INSERT INTO postulacion (postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES ( 1, '2016-03-17', 'B-0339', 'B-0342', 1, true, false);
INSERT INTO postulacion (postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES ( 2, '2016-03-18', 'B-0341', 'B-0342', 2, true, false);
INSERT INTO postulacion (postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES ( 3, '2016-03-18', 'B-0342', 'B-0340', 2, true, false);
INSERT INTO postulacion (postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES ( 4, '2016-03-18', 'B-0341', 'B-0340', 1, true, false);

--Socio

INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0338', 1, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0339', 2, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0340', 3, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0341', 4, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0342', 5, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0343', 6, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( 1, 'B-0344', 7, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( 2, 'B-0349', 8, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( 3, 'B-0330', 9, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( 4, 'B-0350', 11, true);

--Accion
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000001', 10000, 1, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000002', 10000, 2, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000003', 10000, 3, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000004', 10000, 4, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000005', 10000, 5, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000006', 10000, 6, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000007', 10000, 7, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000008', 10000, 8, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000009', 10000, 9, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000010', 10000, 10, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000011', 10000, NULL, 2, true);

--Venta

insert into venta (accionid_accion,postulacionid_postulacion,fecha,monto,activo) values (4,1,'01/03/2016',500000,true);

--afiliado
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (3, 9, 'B-0330--2', 10, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (4, 9, 'B-0330--2', 15, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (2, 9, 'B-0330--1', 20, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (2, 10, 'B-0350--1', 14, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (3, 10, 'B-0350--2', 12, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (2, 4, 'B-0341--1', 17, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (3, 4, 'B-0341--2', 13, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (2, 5, 'B-0342--1', 18, TRUE);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (3, 5, 'B-0342--2', 19, true);
INSERT INTO afiliado (tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (3, 5, 'B-0342--2', 16, TRUE);

--eventualidad
insert into eventualidad (instalacionid_instalacion,descripcion,fecha,personaid_persona,tipo_eventualidadid_tipo_eventualidad,activo) 
				  values (1,'Perdida de 3 sillas','01/02/2016',3,2,true),
				  		 (2, 'PartiÃƒÂ³ 3 sillas', '01-03-2016 09:00:00',5,5,TRUE),
	   			  		 (1, 'RiÃƒÂ±a con otro jugador', '04-03-2016 11:00:00',12,3,TRUE),
	   			  		 (3, 'Uso inadecuado de instalaciÃƒÂ³n', '05-03-2016 16:00:00',7,5,TRUE),
	   			 		 (3, 'CaminÃƒÂ³ desnudo dentro de la instalacion', '08-03-2016 18:00:00',6,4,TRUE),
	   			  		 (1, 'Hurto de pelota de Baseball', '11-03-2016 19:00:00',14,2,TRUE),
	   			 		 (2, 'RiÃƒÂ±a con otro socio', '16-03-2016 21:00:00',13,3,TRUE),
	   			 		 (1, 'Hizo un hueco en el campo', '17-03-2016 22:00:00',15,5,TRUE);

--preferencia_persona

insert into preferencia_persona (preferenciaid_preferencia,personaid_persona,activo) values (3,1,true);
insert into preferencia_persona (preferenciaid_preferencia,personaid_persona,activo) values (3,2,true);
insert into preferencia_persona (preferenciaid_preferencia,personaid_persona,activo) values (2,2,true);

--Red_persona

insert into red_persona (enlace,red_socialid_red_social,personaid_persona,activo) values ('https://www.facebook.com/mariangel.arrieche.1?fref=ts',1,1,true);
insert into red_persona (enlace,red_socialid_red_social,personaid_persona,activo) values ('https://www.facebook.com/gipsymt?fref=ts',1,2,true);
insert into red_persona (enlace,red_socialid_red_social,personaid_persona,activo) values ('https://www.facebook.com/Josefag16',1,3,true);

--Evento
INSERT INTO evento (nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) VALUES ('Torneo de Tenis', 'Torneo Libre Femenino de tenis', '2016-03-25 00:00:00', '2016-04-01 00:00:00', true, 1, NULL, true);
INSERT INTO evento (nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) VALUES ('Torneo de Beisbol', 'Torneo Libre Masculino de Beisbol', '2016-03-18 00:00:00', '2016-03-19 00:00:00', false, 4, NULL, true);
INSERT INTO evento (nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) VALUES ('Parrilla Osullivan', 'Evento para quitar la presión de los desarrolladores del Club Atletico Ámerica', '2016-03-20 00:00:00', '2016-03-21 00:00:00', true, 4, NULL, true);


--actividad
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Preparar Campo de Beisbol', 2, '2016-03-18 00:00:00', '2016-03-18 00:00:00', 25000, 30000, true, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Contratar Árbitros', 2, '2016-03-18 00:00:00', NULL, 10, NULL, false, false);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Buscar Bates', 2, '2016-03-18 00:00:00', '2016-03-18 00:00:00', 100, 100, true, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Buscar Pelotas', 2, '2016-03-18 00:00:00', NULL, 50, NULL, false, false);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Reparar Parrillera', 3, '2016-03-20 00:00:00', '2016-03-18 00:00:00', 20, 10, true, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Comprar Carbones', 3, '2016-03-20 00:00:00', NULL, 10, NULL, false, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES ('Comprar Carne de Lomito', 3, '2016-03-20 00:00:00', NULL, 3, NULL, false, true);

--Instalacion_evento

insert into instalacion_evento (instalacionid_instalacion,eventoid_evento,activo) values (1,1,true);

--Sanciones
INSERT INTO sancion(descripcion,socioid_socio,fecha_inic,fecha_fin,tipo_sancionid_tipo_sancion,motivo_sancionid_motivo_sancion,activo)
    VALUES ('Se agarro a golpes con otro socio en medio del partido', 2, '01-01-2016', '10-01-2016', 1,1, TRUE),
	   	   ('Destrozo la propiedad', 2, '02-01-2016', '12-01-2016', 2,2, TRUE),
	       ('Se orino en la piscina', 2, '04-01-2016', '10-01-2016', 2,2, TRUE),
	       ('Insulto a un directivo del Club', 1, '06-01-2016', '30-01-2016', 1,1, TRUE),
	       ('Borracho molesto a unas muchachas', 1, '01-01-2016', '10-01-2016', 1,1, TRUE);

---reservaciones
INSERT INTO reservacion (instalacionid_instalacion, socioid_socio, fecha_inicio, fecha_fin, condicion, activo) VALUES (1, 4, '2016-03-22 15:00:00', '2016-03-24 19:00:00', 'A', true);
INSERT INTO reservacion (instalacionid_instalacion, socioid_socio, fecha_inicio, fecha_fin, condicion, activo) VALUES (2, 4, '2016-03-18 00:00:00', '2016-03-20 00:00:00', 'A', true);
INSERT INTO reservacion(instalacionid_instalacion, socioid_socio, fecha_inicio, fecha_fin, activo)
    VALUES (1, 2, '01-01-2016', '01-01-2016', TRUE),
	   (2, 3, '01-01-2016', '01-01-2016', TRUE),
	   (3, 1, '01-01-2016', '01-01-2016', TRUE),
	   (1, 4, '10-01-2016', '10-01-2016', TRUE),
	   (2, 2, '10-01-2016', '10-01-2016', TRUE),
	   (3, 1, '10-01-2016', '10-01-2016', TRUE),
	   (1, 3, '12-01-2016', '12-01-2016', TRUE),
	   (2, 3, '12-01-2016', '12-01-2016', TRUE),
	   (3, 4, '12-01-2016', '12-01-2016', TRUE);

--alquileres

INSERT INTO alquiler (id_alquiler, reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo) VALUES (1, 1, 1, '2016-03-18', 0, true);
INSERT INTO alquiler (id_alquiler, reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo) VALUES (2, 2, 1, '2016-03-18', 0, true);
INSERT INTO alquiler(reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo)
    VALUES (3, 1, '05-01-2016', 2000, TRUE),
	   (4, 2, '05-01-2016', 20000, TRUE),
	   (4, 3, '07-01-2016', 2000, TRUE),
	   (5, 1, '15-01-2016', 2000, TRUE),
	   (6, 2, '16-01-2016', 20000, TRUE),
	   (7, 3, '17-01-2016', 2000, TRUE),
	   (7, 1, '18-01-2016', 2000, TRUE),
	   (8, 2, '19-01-2016', 20000, TRUE),
	   (9, 3, '20-01-2016', 2000, TRUE);
	   
--calendario_fecha
INSERT INTO calendario_fecha (descripcion, fecha, eventoid_evento, reservacionid_reservacion, activo) VALUES ('espacio para la practica de beisbol', '2016-03-18', NULL, 1, true);
INSERT INTO calendario_fecha (descripcion, fecha, eventoid_evento, reservacionid_reservacion, activo) VALUES ('Espacio para fiestas y celebraciones', '2016-03-18', NULL, 2, true);

-- preferencia_evento
INSERT INTO preferencia_evento(eventoid_evento, preferenciaid_preferencia, 
            activo)
    VALUES ( 1, 1, TRUE),
           ( 2, 3, TRUE);

--indicador_evento

INSERT INTO indicador_evento(valor_esperado, valor_real, indicadorid_indicador, 
            eventoid_evento, activo)
    VALUES (30000000, 25000000, 2, 1, TRUE),
           (300000, 200000, 4, 1, TRUE),
           (2500, 1850, 1, 2, TRUE),
           (300000, 350000, 3, 2, TRUE),
           (200000, 300000, 4, 2, TRUE);
           
         

