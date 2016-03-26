--Configuracion del Script

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--Club
INSERT INTO club (id_club, rif, nombre, direccion, telefono, mision, vision, logo, telf_alternativo, correo, clave_correo, eslogan, activo) VALUES (1, 'J-08521135-7', 'Centro Atlético América', 'Av. Fuerzas Armadas con Calle 57, Concepción, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la unión familiar y consolidando el legado de sus fundadores.', 'Constituirnos como la institución social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus socios y sus familiares e impulsar la transformación consolidando un ambiente cada día más idóneo para el desarrollo biopsicosocial de nuestras generaciones.', 'http://i.imgur.com/UKvuTwu.png', '0251-4411594', 'centroatleticoclubamerica@gmail.com', NULL, 'Incentivando y Promoviendo la Participación Cultural y Deportiva', true);

--Portal

INSERT INTO portal (id_portal, instalacion, socio, evento, activo, foto_socio, foto_instalaciones, foto_evento) VALUES (1, 'El Centro Atlético América cuenta con canchas de Tenis, Baloncesto, Béisbol, Bolas criollas. Además cuenta con un Salón de Fiestas y dos Caneyes para el disfrute de sus socios e invitados', 'Nuestros Socios Se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de Club. ¿Quieres ser un socio del Centro Atlético América?', 'Nos Interesa Motivar la interacción social a través de actividades culturales de intercambio, en busca del crecimiento humano mediante la Realización de Eventos. ¿Quieres participar en nuestros Eventos?', true, 'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');

--Tipo_Sugerencia

insert into tipo_sugerencia (descripcion,activo) values ('Pregunta',true);
insert into tipo_sugerencia (descripcion,activo) values ('Sugerencia',true);
insert into tipo_sugerencia (descripcion,activo) values ('Comentario',true);
insert into tipo_sugerencia (descripcion,activo) values ('Queja',true);
insert into tipo_sugerencia (descripcion, activo) VALUES ('Reclamo', true);

--Tipo_instalacion

insert into tipo_instalacion (descripcion,activo) values ('Deportivo',true);
insert into tipo_instalacion (descripcion,activo) values ('Fiesta',true);
insert into tipo_instalacion (descripcion,activo) values ('Infantil',true);
insert into tipo_instalacion (descripcion,activo) values ('Caney',true);

--Tipo_Preferencia

insert into tipo_preferencia (descripcion,color,activo) values ('Cultural','#008000',true);
insert into tipo_preferencia (descripcion,color,activo) values ('Deportiva','#0000FF',true);
insert into tipo_preferencia (descripcion,color,activo) values ('Social','#20B2AA',true);
insert into tipo_preferencia (descripcion,color,activo) values ('Jobby','#20B2AA',true);

--tipo_afiliado

insert into tipo_afiliado (descripcion,subfijo,activo) values ('Esposo','-1',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Esposa','-1',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Hijo','-2',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Hija','-2',true);

--Tipo_sancion
insert into tipo_sancion (descripcion,activo) values ('Suspensión',true);
insert into tipo_sancion (descripcion,activo) values ('Multa',true);

--tipo_eventualidad

insert into tipo_eventualidad (descripcion,activo) 
                       values ('Estravío de Recursos',true),
							  ('Mala Conducta',true),
							  ('Actos Inmorales', true),
           					  ('Daños a Instalación', true),
           					  ('Pelea', true);
           					  
--Tipo_noticia

insert into tipo_noticia (descripcion,color,activo) values ('Evento Auto','#3300cc',false);
insert into tipo_noticia (descripcion,color,activo) values ('Postulación Auto','#f88514',false);
insert into tipo_noticia (descripcion,color,activo) values ('Evento','#3300cc',true);
insert into tipo_noticia (descripcion,color,activo) values ('Postulación','#f88514',true);
insert into tipo_noticia (descripcion,color,activo) values ('Acciones','#FFFF00',true);
insert into tipo_noticia (descripcion,color,activo) values ('Sucesos','#cc00ff',true);
insert into tipo_noticia (descripcion,color,activo) values ('Otros','#FFA500',true);

--Tipo_opinion
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('Lo Recomiendo', true);
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('No lo Recomiendo', true);
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('No lo Conozco', true);

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
INSERT INTO motivo_postulacion (descripcion, activo) VALUES ('Beneficios del Club', true);
INSERT INTO motivo_postulacion (descripcion, activo) VALUES ('Inversión', true);
INSERT INTO motivo_postulacion (descripcion, activo) VALUES ('Deporte', true);
INSERT INTO motivo_postulacion (descripcion, activo) VALUES ('Osio', true);
INSERT INTO motivo_postulacion (descripcion, activo) VALUES ('Recreación', true);
INSERT INTO motivo_postulacion (descripcion, activo) VALUES ('Diversión', true);

--Motivo_Venta
Insert into motivo_venta (descripcion,activo) VALUES ('Necesidad Económica',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Cambio de Ciudad',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Descontento con el Club',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Otro',TRUE);

--Motivo_cancelacion

INSERT INTO motivo_cancelacion (descripcion, activo) VALUES ( 'Falta de Recursos', true);
INSERT INTO motivo_cancelacion (descripcion, activo) VALUES ( 'Por Presupuestos', true);
INSERT INTO motivo_cancelacion (descripcion, activo) VALUES ( 'Actividades Imcompletas', true);

--motivo_desvinculacion

insert into motivo_desvinculacion (descripcion,activo) values ('Venta de Acción',true);
insert into motivo_desvinculacion (descripcion,activo) values ('Socio Sancionado',true);

--Estado_Accion
INSERT INTO estado_accion (nombre, activo) VALUES ('Asociada', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('En Venta', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('En Solicitud', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('Inactiva', true);

--Red_Social

insert into red_social (descripcion,imagen,activo) values ('Facebook','http://i.imgur.com/J8nfPwn.png',true);
insert into red_social (descripcion,imagen,activo) values ('Instagram','http://i.imgur.com/E6xQKvN.png',true);
insert into red_social (descripcion,imagen,activo) values ('Twitter','http://i.imgur.com/rox1qxk.png',true);

--red_club

INSERT INTO red_club (clubid_club, red_socialid_red_social, enlace, activo) VALUES (1, 3, 'https://twitter.com/CAAAMERICA',true);
INSERT INTO red_club (clubid_club, red_socialid_red_social, enlace, activo) VALUES (1, 1, 'https://www.facebook.com/accaa',true);

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
           
--Instalacion

insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Cancha de Softball','Espacio para la Práctica de Softball ó Béisbol',500,20000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Salon de Fiesta Principal','Espacio de excelente prestancia para Fiestas y Celebraciones',150,25000,true,2,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Parque Infantil','Área recreacional para niños y niñas',150,0,false,3,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Cancha de Tenis','Espacio para la Práctica de Tenis, para el disfrute de todos nuestros socios',500,5000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Cancha de Baloncesto','Es un espacio deportivo ideal para quienes Práctican el Baloncesto ',150,5000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Cancha de Bolas Criollas','Cancha popular entre nuestros socios, en especial los fines de semana',150,5000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Caney de Rafa','Amplio Caney, muy popular entre la Comunidad Americanista',150,2000,true,4,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Caney de Chevechita','Caney que debe su Nombre a un Socio emblemático, desaparecido físicamente desde hace años.',150,0,false,4,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Piscina','Área amplia con Comodidades dignas de la Comunidad Americanista',150,35000,true,3,true);

--foto

INSERT INTO foto ( url, instalacionid_instalacion, publico, clubid_club, activo) VALUES ('http://i.imgur.com/wHrzoYB.jpg', 1, true, 1, true);
INSERT INTO foto ( url, instalacionid_instalacion, publico, clubid_club, activo) VALUES ('http://i.imgur.com/cHPOldS.jpg', 2, true, 1, true);
INSERT INTO foto ( url, instalacionid_instalacion, publico, clubid_club, activo) VALUES ('http://i.imgur.com/2pTsUU6.jpg', 4, true, 1, true);

--Recurso

insert into recurso (descripcion,activo) values ('Sillas de Plástico',True);
insert into recurso (descripcion,activo) values ('Sillas de Madera',True);
insert into recurso (descripcion,activo) values ('Mesas Redondas',True);
insert into recurso (descripcion,activo) values ('Mesas Cuadradas',True);
insert into recurso (descripcion,activo) values ('Manteles',True);
insert into recurso (descripcion,activo) values ('Hieleras',True);
insert into recurso (descripcion,activo) values ('Cornetas',True);
INSERT INTO recurso (descripcion, activo) VALUES ('Parrilleras', true);
INSERT INTO recurso (descripcion, activo) VALUES ('Vasos', true);
INSERT INTO recurso (descripcion, activo) VALUES ('Cubiertos', true);
INSERT INTO recurso (descripcion, activo) VALUES ('Lamparas', true);
INSERT INTO recurso (descripcion, activo) VALUES ('Neveras', true);

--recurso_instalacion

insert into recurso_instalacion (instalacionid_instalacion,recursoid_recurso,cantidad,activo) values (2,1,100,true);
insert into recurso_instalacion (instalacionid_instalacion,recursoid_recurso,cantidad,activo) values (2,2,100,true);

--Preferencia

insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Beisbol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Futbol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Tenis',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Bolas Criollas',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Natacion',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Kickingball',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Voleibol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Baile',3,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Musica',3,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Bebedor Ocasional',3,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Televisión',4,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Cine',4,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Cantar',4,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Ciclismo',2,true);

--politica

INSERT INTO politica (descripcion, valor, clubid_club, activo) VALUES ('Personas que puede traer un socio por visita diaria', 3, 1, true);
INSERT INTO politica (descripcion, valor, clubid_club, activo) VALUES ('Veces que puede traer a un mismo invitado al mes', 3, 1, true);

--Persona
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('20387728', 'Enmanuel', 'Medina', NULL, '1980-03-01', 'M', 'enmanuelm19@gmail.com', '04146549874', '02516548765', 'Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('12345678', 'Prisco', 'Canelón', NULL, '1981-04-01', 'M', 'carlos@gmail.com', '04249876668', '02513348765', 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('12546318', 'Carlos', 'Colmenarez', NULL, '1982-05-01', 'M', 'juan@gmail.com', '04127896654', '02516548705', 'Valle Hondo, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('14327254', 'Manuel', 'Guerrero', 'http://i.imgur.com/xXp0wXP.png', '1983-06-01', 'M', 'manuel@gmail.com', '04147658877', '02516548265', 'Carrera 25 con calle 12', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('13658792', 'Hector', 'Gil', NULL, '1983-07-01', 'M', 'sergio@hotmail.com', '04167779788', '02516540965', 'Av Libertador con calle 12', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('16267894', 'Pedro', 'Camacaro', NULL, '1984-08-01', 'M', 'pedrocamacaro@gmail.com', '04263423433', '0255657432', 'Santa Isabel, Avenida 4', true);

--socio

INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0339', 2, true);
INSERT INTO socio (postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES ( NULL, 'B-0340', 3, true);

--Accion
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000001', 10000, 1, 1, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000002', 10000, 2, 1, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000003', 10000, NULL, 2, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000004', 10000, NULL, 2, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000005', 10000, NULL, 2, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000006', 10000, NULL, 2, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000007', 10000, NULL, 2, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000008', 10000, NULL, 4, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000009', 10000, NULL, 4, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000010', 10000, NULL, 4, true);
INSERT INTO accion (nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES ( 'A00000011', 10000, NULL, 4, true);

--usuario 

INSERT INTO usuario (contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES ('12345678', 'enmanuel', '¿Quién?', 'administrador', 1, '2016-02-22', true);
INSERT INTO usuario (contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES ('12345678', 'carlos', '¿Nombre de mi Madre?', 'raquel', 2, '2016-02-22', true);
INSERT INTO usuario (contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES ('12345678', 'juan', '¿Nombre de mi Abuela?', 'esperanza', 3, '2016-02-22', true);
INSERT INTO usuario (contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES ('12345678', 'manuel', '¿Nombre de mi primera mascota?', 'rossy', 4, '2016-02-22', true);
INSERT INTO usuario (contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES ('12345678', 'sergio', '¿Color Favorito?', 'azul', 5, '2016-02-22', true);
INSERT INTO usuario (contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES ('12345678', 'pedro', '¿Lugar Favorito?', 'mi casa', 6, '2016-02-22', true);


--funcion

INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (1, 'Configuración', ' ', 'z-icon-cogs', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (2, 'Socios', ' ', 'z-icon-user', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (3, 'Instalaciones', ' ', 'z-icon-home', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (4, 'Eventos', ' ', 'z-icon-calendar', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (5, 'Consulta', ' ', 'z-icon-th-list', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (6, 'Adm. del Sistema', ' ', 'z-icon-puzzle-piece', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (7, 'Postulaciones', ' ', 'z-icon-puzzle-piece', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (8, 'Categorias', ' ', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (9, 'Administrar Socio', ' ', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (10, 'Danos tu Opinión', ' ', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (11, 'Administrar Evento', ' ', 'z-icon-angle-double-right', ' ', 4, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (12, 'Estructurado', ' ', 'z-icon-angle-double-right', ' ', 5, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (13, 'Motivo Sanción', 'configuracion/categoria/motivoSancion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (14, 'Estadísticos', ' ', 'z-icon-angle-double-right', ' ', 5, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (15, 'Seguridad', ' ', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (16, 'Perfil del Club', 'configuracion/perfilClub.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (17, 'Junta Directiva', 'configuracion/juntaDirectiva.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (18, 'Instalaciones', 'configuracion/gestionarInstalaciones.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (19, 'Reglas Club', 'configuracion/reglasClub.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (20, 'Preferencias', 'configuracion/categoria/preferencia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (21, 'Recursos', 'configuracion/categoria/recursos.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (22, 'Cargo Junta Directiva', 'configuracion/categoria/cargoJunta.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (23, 'Motivo Postulación', 'configuracion/categoria/motivoPostulacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (24, 'Motivo Venta', 'configuracion/categoria/motivoVenta.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (25, 'Tipo Sugerencia', 'configuracion/categoria/tipoSugerencia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (26, 'Tipo Preferencia', 'configuracion/categoria/tipoPreferencia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (27, 'Tipo Instalación', 'configuracion/categoria/tipoInstalacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (28, 'Tipo Sanción', 'configuracion/categoria/tipoSancion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (29, 'Tipo Afiliado', 'configuracion/categoria/tipoAfiliado.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (31, 'Motivo Desvinculación', 'configuracion/categoria/motivoDesvinculacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (32, 'Acciones', 'socio/acciones.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (33, 'Mi Perfil', 'socio/miPerfil.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (34, 'Mis Sanciones', 'socio/misSanciones.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (35, 'Solicitar Venta', 'socio/solicitarVenta.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (36, 'Registrar Socio', 'socio/administrarSocio/postulantes.zul', 'z-icon-angle-double-right', ' ', 9, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (37, 'Registrar Afiliado', 'socio/administrarSocio/socios.zul', 'z-icon-angle-double-right', ' ', 9, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (38, 'Sanciones', 'socio/administrarSocio/sanciones.zul', 'z-icon-angle-double-right', ' ', 9, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (39, 'Sugerencias', 'socio/buzon/vistaGeneralSugerencias.zul', 'z-icon-angle-double-right', ' ', 10, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (40, 'Opinión Postulación', 'socio/buzon/opinionPostulacion.zul', 'z-icon-angle-double-right', ' ', 10, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (41, 'Reservación', 'instalacion/misReservaciones.zul', 'z-icon-angle-double-right', ' ', 3, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (42, 'Alquileres', 'instalacion/administrarAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (43, 'Mis Alquileres', 'instalacion/misAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (44, 'Eventualidades', 'instalacion/registrarEventualidadInst.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (45, 'Registrar Eventos', 'evento/administrarEvento/listaEventos.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (46, 'Planificar Evento', 'evento/administrarEvento/planificarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (47, 'Ejecutar Evento', 'evento/administrarEvento/ejecutarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true);
--INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (48, 'Adjuntar Empleados', 'administracion/adjuntarEmpleados.zul', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (49, 'Cartelera', 'administracion/cartelera.zul', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (50, 'Backup BD', ' ', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (51, 'Usuarios', 'administracion/seguridad/usuarioGeneral.zul', 'z-icon-angle-double-right', ' ', 15, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (52, 'Grupos', 'administracion/seguridad/mostrarGrupos.zul', 'z-icon-angle-double-right', ' ', 15, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (53, 'Funciones', 'administracion/seguridad/administrarFunciones.zul', 'z-icon-angle-double-right', ' ', 15, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (54, 'Postulados', 'postulado/postulado.zul', 'z-icon-angle-double-right', ' ', 7, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (55, 'Administrar portal', 'configuracion/administracionPortal.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (56, 'Finalizar evento', 'evento/administrarEvento/finalizarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (57, 'Alquileres', 'consultas/reporteAlquileres.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (58, 'Eventos', 'consultas/reporteEventos.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (59, 'Actividades de Eventos', 'consultas/reporteActividadEventos.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (60, 'Socios', 'consultas/reporteSocios.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (61, 'Sanciones', 'consultas/reporteSanciones.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (62, 'Eventualidades', 'consultas/reporteEventualidad.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (63, 'Sanciones', 'consultas/reporteSancionesEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (64, 'Eventualidades', 'consultas/reporteEventualidadesEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (65, 'Evento', 'consultas/reporteEventoValorEsperadoRealEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (66, 'Socio', 'consultas/reporteSociosEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (68, 'Instalaciones', 'consultas/reporteInstalacionesEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (69, 'Red Social', 'configuracion/categoria/redSocial.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (70, 'Tipo Eventualidad', 'configuracion/categoria/tipoEventualidad.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (71, 'Indicador', 'configuracion/categoria/indicador.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (72, 'Tipo Opinión', 'configuracion/categoria/tipoOpinion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (73, 'Tipo Pago', 'configuracion/categoria/tipoPago.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (74, 'Tipo Noticia', 'configuracion/categoria/tipoNoticia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (75, 'Motivo Cancelación', 'configuracion/categoria/motivoCancelacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (76, 'Sugerencias', 'socio/buzon/sugerenciaAdministrativo.zul', 'z-icon-angle-double-right', ' ', 10, true);

--grupo
INSERT INTO grupo (descripcion, activo) VALUES ('Socio', true);
INSERT INTO grupo (descripcion, activo) VALUES ('Junta', true);
INSERT INTO grupo (descripcion, activo) VALUES ('Afiliado', true);
INSERT INTO grupo (descripcion, activo) VALUES ('Seguridad', true);
INSERT INTO grupo (descripcion, activo) VALUES ('Comunicador', true);
INSERT INTO grupo (descripcion, activo) VALUES ('Vigilancia', true);

--funcion_grupo

INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (1, 33, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (2, 34, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (3, 35, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (4, 39, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (5, 40, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (6, 41, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (7, 43, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (8, 51, 4, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (9, 52, 4, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (10, 53, 4, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (11, 33, 3, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (12, 34, 3, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (13, 49, 5, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (14, 55, 5, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (53, 44, 6, true);
--INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (29, 30, 2, false);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (16, 17, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (33, 37, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (18, 19, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (45, 58, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (61, 76, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (30, 31, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (47, 60, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (35, 42, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (37, 46, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (52, 65, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (44, 57, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (51, 64, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (48, 61, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (55, 70, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (17, 18, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (50, 63, 2, true);
--INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (39, 48, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (58, 73, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (38, 47, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (25, 26, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (36, 45, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (49, 62, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (23, 24, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (24, 25, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (54, 68, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (60, 75, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (27, 28, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (59, 74, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (34, 38, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (28, 29, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (43, 66, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (40, 50, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (26, 27, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (57, 72, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (19, 20, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (20, 21, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (46, 59, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (31, 32, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (15, 16, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (56, 71, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (21, 22, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (22, 23, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (32, 36, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (42, 56, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (41, 54, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (62, 69, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (63, 13, 2, true);

--usuario_grupo

INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (1, 4, 1, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (2, 1, 6, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (3, 2, 1, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (4, 1, 5, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (5, 1, 4, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (6, 1, 2, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (7, 1, 3, true);

