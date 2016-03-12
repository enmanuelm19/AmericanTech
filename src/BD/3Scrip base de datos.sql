--Persona
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20525481','Mariangel','Arrieche','05/05/91','F','mariangel@gmail.com','04120584875','02517588520','Barquisimeto',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20525489','Gipsy','Martinez','17/10/91','F','gipsy@gmail.com','04120585789','02517587878','El Cuji',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20322921','Jose','Abreu','16/02/90','M','DeadNox16@gmail.com','04120585285','02534913354','Quibor',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '1589654','Mirian','Vega','05/06/55','F','vegamirian@gmail.com','04120584875','02517588520','Barquisimeto',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20125489','Armando','Perdomo','17/08/54','M','armandoptgs@gmail.com','04120585789','02517587878','Barquisimeto',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '2022921','Malon','Mendoza','22/12/59','M','malomalon@gmail.com','04120585285','02534913354','Caripito',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '25525481','Andy','Elachouche','05/07/78','M','andyelpelon@gmail.com','04120584875','02517588520','Los valles del tuy',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20425489','Mario','Kempes','17/10/91','M','matadorkempes@gmail.com','04120585789','02517587878','Cabudare',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20822921','Wilie','Mays','16/02/90','M','wmmlb@gmail.com','04120585285','02534913354','Barquisimeto',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20925481','Pablo','Giralt','05/05/91','M','directvpgiralt@gmail.com','04120584875','02517588520','Barquisimeto',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20725489','Maria','Machado','17/10/91','F','elcambiollego@gmail.com','04120585789','02517587878','El Tocuyo',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20722921','Francesco','Totti','16/02/90','M','tifosiroma@gmail.com','04120585285','02534913354','Carora',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20825481','Nestor','Garcia','05/05/91','M','chegarcia99@gmail.com','04120584875','02517588520','San Felipe',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20925489','Giovanny','Savarece','17/10/91','M','nycosmos@gmail.com','04120585789','02517587878','Barquisimeto',TRUE);
Insert into persona (identificacion,nombre,apellido,fecha_nac,sexo,correo,telefono,telefono_fijo,direccion,activo) VALUES ( '20122921','Raul','Gonzalez','16/02/90','M','angeldemadrid@gmail.com','04120585285','02534913354','Barquisimeto',TRUE);

--Motivo_postulacion
insert into motivo_postulacion (descripcion,activo) values ('Inversion',true);
insert into motivo_postulacion (descripcion,activo) values ('Participacion Deportiva',true);
insert into motivo_postulacion (descripcion,activo) values ('Beneficios del Club',true);

--Motivo_Venta
Insert into motivo_venta (descripcion,activo) VALUES ('Necesidad Economica',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Cambio de Ciudad',TRUE);
Insert into motivo_venta (descripcion,activo) VALUES ('Descontento con el Club',TRUE);

--Estado_Accion
insert into estado_accion (nombre,activo) values ('Activa',True);
insert into estado_accion (nombre,activo) values ('En Venta',True);

--Accion
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0338',500000,1,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0339',500000,1,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0340',500000,1,true);
insert into accion (nro_accion,valor,estado_accionid_estado_accion,activo) values ('B-0341',500000,2,true);

--solicitud_venta

insert into solicitud_venta (accionid_accion,motivo,fecha,motivo_ventaid_motivo_venta,activo) values (4,'Necesidad Economica','01/03/2016',1,true);


--Red_Social

insert into red_social (descripcion,imagen,activo) values ('Facebook','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('Twitter','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('SnapChat','No Tiene',true);
insert into red_social (descripcion,imagen,activo) values ('Instagram','No Tiene',true);

--Tipo_Sugerencia

insert into tipo_sugerencia (descripcion,activo) values ('Deportiva',true);
insert into tipo_sugerencia (descripcion,activo) values ('Social',true);
insert into tipo_sugerencia (descripcion,activo) values ('Administrativa',true);
insert into tipo_sugerencia (descripcion,activo) values ('Infraestructura',true);

--Cliente _ Externo

insert into cliente_externo (nombre,apellido,correo,activo) values ('Jose','Altuve','elpequeñogigante@gmail.com',true);
insert into cliente_externo (nombre,apellido,correo,activo) values ('Miguel','Cabrera','miggycabrera@gmail.com',true);
insert into cliente_externo (nombre,apellido,correo,activo) values ('Edgar','Ramirez','edgarr@gmail.com',true);
insert into cliente_externo (nombre,apellido,correo,activo) values ('Gustavo','Dudamel','directoryola@gmail.com',true);

--Tipo_Empleado

insert into tipo_empleado (descripcion,activo) values ('Seguridad',true);
insert into tipo_empleado (descripcion,activo) values ('Limpieza',true);
insert into tipo_empleado (descripcion,activo) values ('Administrativo',true);

--Tipo_instalacion

insert into tipo_instalacion (descripcion,activo) values ('Deportivo',true);
insert into tipo_instalacion (descripcion,activo) values ('Fiesta',true);
insert into tipo_instalacion (descripcion,activo) values ('Infantil',true);

--Instalacion

insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,tipo_instalacionid_tipo_instalacion,activo) values ('Campo de Beisbol','espacio para la practica de beisbol',500,2000,1,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,tipo_instalacionid_tipo_instalacion,activo) values ('Salon de Fiesta','Espacio para fiestas y celebraciones',150,20000,2,true);
insert into instalacion (nombre,descripcion,capacidad,precio_alquiler,tipo_instalacionid_tipo_instalacion,activo) values ('Parque Infantil','area recreacional para niños',150,2000,3,true);

--Tipo_Preferencia

insert into tipo_preferencia (descripcion,color,activo) values ('Cultural','#008000',true);
insert into tipo_preferencia (descripcion,color,activo) values ('Deportiva','#0000FF',true);

--Preferencia

insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Beisbol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Futbol',2,true);
insert into preferencia (descripcion,tipo_preferenciaid_tipo_preferencia,activo) values ('Tenis',2,true);

--Recurso

insert into recurso (descripcion,activo) values ('Sillas',True);
insert into recurso (descripcion,activo) values ('Mesas',True);


--recurso_instalacion
insert into recurso_instalacion (instalacionid_instalacion,recursoid_recurso,cantidad,activo) values (2,1,100,true);
insert into recurso_instalacion (instalacionid_instalacion,recursoid_recurso,cantidad,activo) values (2,2,100,true);

--Tipo_sancion
insert into tipo_sancion (descripcion,activo) values ('Prohibida entrada al club',true);
insert into tipo_sancion (descripcion,activo) values ('Prohibido el alquiler de instalaciones',true);
insert into tipo_sancion (descripcion,activo) values ('Prohibido participar en torneos',true);

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

--tipo_afiliado

insert into tipo_afiliado (descripcion,activo) values ('Pareja',true);
insert into tipo_afiliado (descripcion,activo) values ('Hijo',true);

--afiliado
insert into afiliado (tipo_afiliadoid_tipo_afiliado,socioid_socio,nro_carnet,personaid_persona,activo) values (1,1,'B-033801',8,true);
insert into afiliado (tipo_afiliadoid_tipo_afiliado,socioid_socio,nro_carnet,personaid_persona,activo) values (2,3,'B-0340',9,true);

--empleado
insert into empleado (personaid_persona,tipo_empleadoid_tipo_empleado,fecha_contratado,activo) values (10,1,'02/03/2016',true);
insert into empleado (personaid_persona,tipo_empleadoid_tipo_empleado,fecha_contratado,activo) values (11,1,'02/02/2016',true);

--Cargo

insert into cargo (descripcion,activo) values ('presidente',true);
insert into cargo (descripcion,activo) values ('vocero',true);
insert into cargo (descripcion,activo) values ('tesorero',true);

--tipo_eventualidad

insert into tipo_eventualidad (descripcion,activo) values ('Deuda',true);
insert into tipo_eventualidad (descripcion,activo) values ('Perdida de Recursos',true);
insert into tipo_eventualidad (descripcion,activo) values ('Mala Conducta',true);

--eventualidad
insert into eventualidad (instalacionid_instalacion,descripcion,fecha,personaid_persona,tipo_eventualidadid_tipo_eventualidad,activo) values (1,'Perdida de 3 sillas','01/02/2016',3,2,true);

--sancion
insert into sancion (descripcion,socioid_socio,fecha_inic,fecha_fin,monto,eventualidadid_eventualidad,tipo_sancionid_tipo_sancion,activo) values ('Deuda del mes de Enero y Febrero 2016',3,'16/02/2016','08/02/2016',3000,1,1,true);

--preferencia_persona

insert into preferencia_persona (preferenciaid_preferencia,personaid_persona,activo) values (3,1,true);
insert into preferencia_persona (preferenciaid_preferencia,personaid_persona,activo) values (3,2,true);
insert into preferencia_persona (preferenciaid_preferencia,personaid_persona,activo) values (2,2,true);

--Red_persona

insert into red_persona (enlace,red_socialid_red_social,personaid_persona,activo) values ('https://www.facebook.com/mariangel.arrieche.1?fref=ts',1,1,true);
insert into red_persona (enlace,red_socialid_red_social,personaid_persona,activo) values ('https://www.facebook.com/gipsymt?fref=ts',1,2,true);
insert into red_persona (enlace,red_socialid_red_social,personaid_persona,activo) values ('https://www.facebook.com/Josefag16',1,3,true);


--Estado_evento

insert into estado_evento (nombre,activo) values ('Por Planificar',true);
insert into estado_evento (nombre,activo) values ('Listo para Ejecutar',true);
insert into estado_evento (nombre,activo) values ('En Ejecucion',true);
insert into estado_evento (nombre,activo) values ('Finalizado',true);
insert into estado_evento (nombre,activo) values ('Cancelado',true);

--Tipo_actividad

insert into tipo_actividad (descripcion,activo) values ('Mantenimiento',true);
insert into tipo_actividad (descripcion,activo) values ('Iluminacion',true);
insert into tipo_actividad (descripcion,activo) values ('Reparacion',true);
insert into tipo_actividad (descripcion,activo) values ('Protocolo',true);


--Tipo_noticia

insert into tipo_noticia (descripcion,color,activo) values ('Evento','#FF0000',true);
insert into tipo_noticia (descripcion,color,activo) values ('Acciones','#FFFF00',true);
insert into tipo_noticia (descripcion,color,activo) values ('Sucesos','#A52A2A',true);
insert into tipo_noticia (descripcion,color,activo) values ('Otros','#FFA500',true);


--Evento
insert into evento (nombre,descripcion,fecha_inicio,fecha_fin,publico,estado_eventoid_estado_evento,cancelacion_eventoid_cancelacion_evento,activo) values ('Torneo de Beisbol','Torneo Libre Masculino de Beisbol','10/03/2016','10/06/2016',true,2,null,true);
insert into evento (nombre,descripcion,fecha_inicio,fecha_fin,publico,estado_eventoid_estado_evento,cancelacion_eventoid_cancelacion_evento,activo) values ('Torneo de Tenis','Torneo Libre Femenino de tenis','10/03/2016','10/06/2016',true,2,null,true);

--actividad
insert into actividad (descripcion,finalizada,tipo_actividadid_tipo_actividad,eventoid_evento,fecha_tope,fecha_realizacion,valor_esperado,valor_real,activo) values ('mantenimiento al campo de Beisbol',false,1,1,'10/03/2016','08/03/2016',2000,2200,true);

--Instalacion_evento

insert into instalacion_evento (instalacionid_instalacion,eventoid_evento,activo) values (1,1,true);