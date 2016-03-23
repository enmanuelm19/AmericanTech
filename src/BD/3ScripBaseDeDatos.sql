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

insert into tipo_afiliado (descripcion,subfijo,activo) values ('Esposo','01',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Esposa','01',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Hijo','02',true);
insert into tipo_afiliado (descripcion,subfijo,activo) values ('Hija','02',true);

--Tipo_sancion
insert into tipo_sancion (descripcion,activo) values ('Suspension',true);
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

insert into tipo_noticia (descripcion,color,activo) values ('Evento','#FF0000',true);
insert into tipo_noticia (descripcion,color,activo) values ('Acciones','#FFFF00',true);
insert into tipo_noticia (descripcion,color,activo) values ('Sucesos','#A52A2A',true);
insert into tipo_noticia (descripcion,color,activo) values ('Otros','#FFA500',true);

--Tipo_opinion
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('Lo Recomiendo', true);
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('No lo recomiendo', true);
INSERT INTO tipo_opnion (descripcion, activo) VALUES ('No lo conozco', true);

--tipo_pago
INSERT INTO tipo_pago(descripcion, activo)
    VALUES ('Efectivo', TRUE),
	   	   ('Transferencia', TRUE),
	       ('Deposito', TRUE);

--Estado_evento

insert into estado_evento (nombre,activo) values ('Por Planificar',true);
insert into estado_evento (nombre,activo) values ('Listo para Ejecutar',true);
insert into estado_evento (nombre,activo) values ('En Ejecucion',true);
insert into estado_evento (nombre,activo) values ('Finalizado',true);
insert into estado_evento (nombre,activo) values ('Cancelado',true);

--Motivo_sancion
insert into motivo_sancion (descripcion,activo) values ('Eventualidad',true);
insert into motivo_sancion (descripcion,activo) values ('Morosidad',true);

--Motivo_postulacion
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (1, 'Beneficios del Club', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (2, 'InversiÃ³n', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (3, 'Deporte', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (4, 'Osio', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (5, 'RecreaciÃ³n', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (6, 'DiversiÃ³n', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (7, 'Por amor', true);

--Motivo_Venta
Insert into motivo_venta (descripcion,activo) VALUES ('Necesidad Económica',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Cambio de Ciudad',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Descontento con el Club',TRUE);

--Motivo_cancelacion

insert into motivo_cancelacion (descripcion,activo) values ('Falta de Presupuesto',true);

--motivo_desvinculacion

insert into motivo_desvinculacion (descripcion,activo) values ('Venta de Accion',true);
insert into motivo_desvinculacion (descripcion,activo) values ('Socio Sancionado',true)

--Estado_Accion
INSERT INTO estado_accion (nombre, activo) VALUES ('Asociada', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('En Venta', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('En Solicitud', true);
INSERT INTO estado_accion (nombre, activo) VALUES ('Inactiva', true);

--Red_Social

insert into red_social (descripcion,imagen,activo) values ('Facebook','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('Twitter','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('SnapChat','No Tiene',true);
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
           ('Ingresos por Inscripcion a Torneos', TRUE),
           ('Ingresos por Bebidas alcoholicas', TRUE);

--Persona
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('20387728', 'Enmanuel', 'Medina', NULL, '1980-03-01', 'M', 'enmanuelm19@gmail.com', '04146549874', '02516548765', 'Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('12345678', 'Carlos', 'Amaro', NULL, '1981-04-01', 'M', 'carlos@gmail.com', '04249876668', '02513348765', 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('11111111', 'Juan', 'Petaquero', NULL, '1982-05-01', 'M', 'juan@gmail.com', '04127896654', '02516548705', 'Valle Hondo, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('55555555', 'Manuel', 'Guerrero', 'http://i.imgur.com/xXp0wXP.png', '1983-06-01', 'M', 'manuel@gmail.com', '04147658877', '02516548265', 'Carrera 25 con calle 12', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('33333333', 'Sergio', 'Hernandez', NULL, '1983-07-01', 'M', 'sergio@hotmail.com', '04167779788', '02516540965', 'Av Libertador con calle 12', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('99999999', 'Pedro', 'Camacaro', NULL, '1984-08-01', 'M', 'pedrocamacaro@gmail.com', '04263423433', '0255657432', 'Santa Isabel, Avenida 4', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('22186230', 'Fidel', 'Aliaga', 'http://i.imgur.com/mSJl1BZ.jpg', '1985-03-17', 'M', 'fidel.alejos@gmail.com', '04263237394', '02512553545', 'Barquisimeto', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19648893', 'Ruben', 'Vivas', 'http://i.imgur.com/ycCM1PJ.jpg', '1991-09-13', 'M', 'rvivas89@gmail.com', '04165438877', '02513456566', 'UrbanizaciÃ³n Las Trinitarias2', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('21140247', 'Mariangel', 'Arrieche', 'http://i.imgur.com/8t2CuRs.png', '1980-03-18', 'F', 'mariangel@gmail.com', '0416555555', '02412222222', 'barquisimeto', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('23393273', 'Roman', 'Arrieche', 'http://i.imgur.com/krJ9S4R.png', '1992-03-18', 'M', 'roman@gmail.com', '041255555', NULL, 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('11593903', 'Romulo', 'Dominguez', 'http://i.imgur.com/duCXybQ.jpg', '1972-03-03', 'M', 'rdominguez@gmail.com', '04168765555', '02512557654', 'Pardos del Glof III Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('13353553', 'Maria', 'Rosario', NULL, '1976-09-24', 'F', 'maria@gmail.com', '04243131311', NULL, 'Prados del Golf III, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19818668', 'Edward', 'Rodriguez', NULL, '1989-08-18', 'M', 'j@gmail.com', '78389327', NULL, 'La Piedad', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('22097230', 'Karla', 'Moron', NULL, '1994-06-17', 'F', 'karla@gmail.com', '04263567394', '02512903265', 'Trujillo', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19648034', 'Elisa', 'Vivas', NULL, '1991-09-13', 'M', 'rvivas89@gmail.com', '04165438877', '02513456566', 'UrbanizaciÃ³n Las Trinitarias2', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('20860247', 'Mariangel', 'Arrieche', 'http://i.imgur.com/8t2CuRs.png', '1980-03-18', 'F', 'mariangel@gmail.com', '0416555555', '02412222222', 'barquisimeto', false);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('23393273', 'Roman', 'Arrieche', 'http://i.imgur.com/krJ9S4R.png', '1992-03-18', 'M', 'roman@gmail.com', '041255555', NULL, 'Barquisimeto', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('11593903', 'Romulo', 'Dominguez', 'http://i.imgur.com/duCXybQ.jpg', '1972-03-03', 'M', 'rdominguez@gmail.com', '04168765555', '02512557654', 'Pardos del Glof III Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('13353553', 'Maria', 'Rosario', NULL, '1976-09-24', 'F', 'maria@gmail.com', '04243131311', NULL, 'Prados del Golf III, Cabudare', true);
INSERT INTO persona (identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES ('19818668', 'Edward', 'Rodriguez', NULL, '1989-08-18', 'M', 'j@gmail.com', '78389327', NULL, 'La Piedad', true);

--Accion
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0338',500000,1,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0339',500000,1,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0340',500000,1,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0341',500000,2,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0342',500000,2,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0343',500000,2,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0344',500000,2,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0345',500000,2,true);

--solicitud_venta

insert into solicitud_venta (accionid_accion,motivo,fecha,motivo_ventaid_motivo_venta,activo) values (4,'Necesidad Economica','01/03/2016',1,true);

--Noticia

INSERT INTO noticia(titulo, descripcion, tipo_noticiaid_tipo_noticia,fecha_creacion, caducidad, publico, activo)
    VALUES ('Prepárate para el 89 aniversario del Centro Atlético América', 'En su semana aniversario, la junta directiva, encabezada por el Dr. Víctor Montilla, se complace en invitar a todos los consocios y comunidad larense a disfrutar y compartir del programa de actividades designado.',4, '25-04-2016', '10-05-2016', true, true),
	       ('Jornadas Infociencias XXXII', ' La 32 edición de las Jornadas de Infociencias de la Universidad Centroccidental Lisandro Alvarado, se realizará el día 6 de Abril del presente año en las instalaciones del Decanato de Ciencias y Tecnología, núcleo Obelisco, donde se darán a conocer cuatro proyectos informáticos creados por los estudiantes de Ingeniería en Informática.',3, '06-04-2016', '21-04-2016', true, true);

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

insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Campo de Beisbol','espacio para la practica de beisbol',500,2000,true,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Salon de Fiesta','Espacio para fiestas y celebraciones',150,20000,true,2,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,alquilable,tipo_instalacionid_tipo_instalacion,activo) values ('Parque Infantil','area recreacional para niÃƒÆ’Ã‚Â±os',150,2000,false,3,true);

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

--Socio

insert into socio (nro_carnet,personaid_persona,activo) values ('B-0338',1,true);
insert into socio (nro_carnet,personaid_persona,activo) values ('B-0339',2,true);
insert into socio (nro_carnet,personaid_persona,activo) values ('B-0340',3,true);
insert into socio (nro_carnet,personaid_persona,activo) values ('B-0341',4,true);

--Postulado

Insert into postulado (personaid_persona,activo) VALUES  ( 5,False);
Insert into postulado (personaid_persona,activo) VALUES  ( 6,False);
Insert into postulado (personaid_persona,activo) VALUES  ( 7,False);

--Postulacion

insert into postulacion (postuladoid_postulado,fecha,carnet_padrino1,carnet_padrino2,motivo_postulacionid_motivo_postulacion,aprobado,activo) values (1,'01/03/2016',1,2,1,true,true);

--Venta

insert into venta (accionid_accion,postulacionid_postulacion,fecha,monto,activo) values (4,1,'01/03/2016',500000,true);

--afiliado
insert into afiliado (tipo_afiliadoid_tipo_afiliado,socioid_socio,nro_carnet,personaid_persona,activo) values (1,1,'B-033801',8,true);
insert into afiliado (tipo_afiliadoid_tipo_afiliado,socioid_socio,nro_carnet,personaid_persona,activo) values (2,4,'B-0340',9,true);

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
insert into evento (nombre,descripcion,fecha_inicio,fecha_fin,publico,estado_eventoid_estado_evento,cancelacion_eventoid_cancelacion_evento,activo) 
			values ('Torneo de Beisbol','Torneo Libre Masculino de Beisbol','10/03/2016','16/03/2016',true,4,null,true);
		    	   ('Torneo de Tenis','Torneo Libre Femenino de tenis','10/03/2016','10/06/2016',true,4,null,true);

--actividad
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,fecha_realizacion,valor_esperado,valor_real,activo) values ('Mantenimiento al Campo de Beisbol',true,1,'01/03/2016','02/03/2016',2000,2200,true);
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,valor_esperado,activo) values ('Contratar Arbitros para el Torneo',false,1,'10/03/2016',10,true);
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,fecha_realizacion,valor_esperado,activo) values ('Buscar Patrocinantes',true,1,'27/02/2016','01/03/2016',8,true);
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,valor_esperado,activo) values ('Comprar equipamiento para los equipos',false,1,'08/03/2016',90000,true);			   		  
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,fecha_realizacion,valor_esperado,valor_real,activo) values ('Reparar Cancha de Tenis Principal',true,2,'01/03/2016','02/03/2016',250000,230000,true);
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,valor_esperado,activo) values ('Contratar Arbitros para el Torneo',false,2,'10/03/2016',10,true);
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,fecha_realizacion,valor_esperado,activo) values ('Buscar Patrocinantes',true,2,'27/02/2016','01/03/2016',8,true);
insert into actividad (descripcion,finalizada,eventoid_evento,fecha_tope,valor_esperado,activo) values ('Comprar equipamiento para los equipos',false,2,'08/03/2016',90000,true);			   		  

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

INSERT INTO alquiler(reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo)
    VALUES (1, 1, '05-01-2016', 2000, TRUE),
	   (2, 2, '05-01-2016', 20000, TRUE),
	   (3, 3, '07-01-2016', 2000, TRUE),
	   (4, 1, '15-01-2016', 2000, TRUE),
	   (5, 2, '16-01-2016', 20000, TRUE),
	   (6, 3, '17-01-2016', 2000, TRUE),
	   (7, 1, '18-01-2016', 2000, TRUE),
	   (8, 2, '19-01-2016', 20000, TRUE),
	   (9, 3, '20-01-2016', 2000, TRUE);

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
           
--Afiliados          
INSERT INTO afiliado(tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, 
            personaid_persona, activo)
    VALUES (1, 2, 'B-0339-01', 5, TRUE),
           (2, 2, 'B-0339-02', 7, TRUE),
           (1, 3, 'B-0340-01', 11, TRUE),
           (2, 3, 'B-0340-02', 13, TRUE);
