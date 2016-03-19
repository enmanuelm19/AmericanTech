--insertando personas
INSERT INTO persona ( identificacion, nombre, apellido, sexo, correo, telefono, telefono_fijo, direccion, activo)
	VALUES  ('20387728', 'Enmanuel', 'Medina', 'M', 'enmanuelm19@gmail.com', '12345678', '12345678', 'Laboratorio de SI','true'),
		('12345678', 'Dead', 'Pool', 'M', 'deadpool@correo.com', '12345678', '12345678', 'Hell','true'),
		( '11111111', 'Wolverine', 'Xmen', 'M', 'wolverine@correo.com', '12345678', '12345678', 'Mansion Xmen','true'),
		( '55555555', 'Chavo', 'del 8', 'M', 'elchavo@correo.com', '12345667', '12345678', 'Vecindario del 8','true'),
		( '33333333', 'Rocky', 'Balboa', 'M', 'Stallone@correo.com', '12345678', '12345678', 'En el Ring','true'),
		( '99999999', 'Hermione', 'Granger', 'M', 'HermioneGriffindor@correo.com', '12345678', '12345678', 'Mundo muggle','true');

-- insertando usuarios
INSERT INTO usuario ( username, contrasenna, pregunta, respuesta, personaid_persona, fecha, activo)
	VALUES  ( 'enmanuel', '12345678', '¿Quien?', 'Capitan garfio en la cocina', 1, '20160222', 'true'),
		( 'deadpool', '12345678', '¿Quien?', 'Capitan garfio en la cocina', 2, '20160222', 'true' ),
		( 'wolverine', '12345678', '¿Quien?', 'Capitan garfio en la cocina', 3, '20160222', 'true'),
		( 'elchavo', '12345678', '¿Quien?', 'Capitan garfio en la cocina', 4, '20160222', 'true'),
		( 'rocky', '12345678', '¿Quien?', 'Capitan garfio en la cocina', 5, '20160222', 'true'),
		( 'hermione', '12345678', '¿Quien?', 'Capitan garfio en la cocina', 6, '20160222', 'true');

--insertando grupo.
INSERT INTO grupo ( descripcion, activo)
	VALUES 	( 'Socio', true),
		( 'Junta', true),
		( 'Afiliado', true),
		( 'Seguridad', true),
		( 'Comunicador', true),
		( 'Vigilancia', true);


-- insertando usuarios grupos
INSERT INTO usuario_grupo( usuarioid_usuario, grupoid_grupo, activo)
    VALUES ( 4, 1, true),
	   (1 ,6 ,true),
	   ( 2, 4, true),
	   ( 1, 5, true),
	   ( 1, 4, true),
	   ( 1, 2, true),
	   ( 1, 3, true);


--insertando funciones
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) 
VALUES  (1, 'Configuracion', ' ', 'z-icon-cogs', ' ', 0, true),
	(2, 'Socios', ' ', 'z-icon-user', ' ', 0, true),
	(3, 'Instalaciones', ' ', 'z-icon-home', ' ', 0, true),
	(4, 'Eventos', ' ', 'z-icon-calendar', ' ', 0, true),
	(5, 'Consulta', ' ', 'z-icon-th-list', ' ', 0, true),
	(6, 'Adm. del sistema', ' ', 'z-icon-puzzle-piece', ' ', 0, true),
	(7, 'Postulaciones', ' ', 'z-icon-puzzle-piece', ' ', 0, true),
	(8, 'Categorias', ' ', 'z-icon-angle-double-right', ' ', 1, true),
	(9, 'Administrar socio', ' ', 'z-icon-angle-double-right', ' ', 2, true),
	(10, 'Danos tu opinion', ' ', 'z-icon-angle-double-right', ' ', 2, true),
	(11, 'Administrar evento', ' ', 'z-icon-angle-double-right', ' ', 4, true),
	(12, 'Estructurado', ' ', 'z-icon-angle-double-right', ' ', 5, true),
	--(13, 'No estructurado', ' ', 'z-icon-angle-double-right', ' ', 5, true),
	(14, 'Estadisticos', ' ', 'z-icon-angle-double-right', ' ', 5, true),
	(15, 'Seguridad', ' ', 'z-icon-angle-double-right', ' ', 6, true),
	(16, 'Perfil del club', 'configuracion/perfilClub.zul', 'z-icon-angle-double-right', ' ', 1, true),
	(17, 'Junta directiva', 'configuracion/juntaDirectiva.zul', 'z-icon-angle-double-right', ' ', 1, true),
	(18, 'Instalaciones', 'configuracion/gestionarInstalaciones.zul', 'z-icon-angle-double-right', ' ', 1, true),
	(19, 'Reglas club', 'configuracion/reglasClub.zul', 'z-icon-angle-double-right', ' ', 1, true),
	(20, 'Preferencias', 'configuracion/categoria/preferencia.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(21, 'Recursos', 'configuracion/categoria/recursos.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(22, 'Cargo junta directiva', 'configuracion/categoria/cargoJunta.zul', 'z-icon-angle-double-right', ' ', 1, true),
	(23, 'Motivo postulacion', 'configuracion/categoria/motivoPostulacion.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(24, 'Motivo venta', 'configuracion/categoria/motivoVenta.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(25, 'Tipo sugerencia', 'configuracion/categoria/tipoSugerencia.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(26, 'Tipo preferencia', 'configuracion/categoria/tipoPreferencia.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(27, 'Tipo instalacion', 'configuracion/categoria/tipoInstalacion.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(28, 'Tipo sancion', 'configuracion/categoria/tipoSancion.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(29, 'Tipo Afiliado', 'configuracion/categoria/tipoAfiliado.zul', 'z-icon-angle-double-right', ' ', 8, true),
	--(30, 'Tipo actividad', 'configuracion/categoria/tipoActividad.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(31, 'Motivo desvinculacion', 'configuracion/categoria/motivoDesvinculacion.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(32, 'Acciones', 'socio/acciones.zul', 'z-icon-angle-double-right', ' ', 2, true),
	(33, 'Mi perfil', 'socio/miPerfil.zul', 'z-icon-angle-double-right', ' ', 2, true),
	(34, 'Mis sanciones', 'socio/misSanciones.zul', 'z-icon-angle-double-right', ' ', 2, true),
	(35, 'Solicitar venta', 'socio/solicitarVenta.zul', 'z-icon-angle-double-right', ' ', 2, true),
	(36, 'Registrar socio', 'socio/administrarSocio/postulantes.zul', 'z-icon-angle-double-right', ' ', 9, true),
	(37, 'Registrar afiliado', 'socio/administrarSocio/socios.zul', 'z-icon-angle-double-right', ' ', 9, true),
	(38, 'Sanciones', 'socio/administrarSocio/sanciones.zul', 'z-icon-angle-double-right', ' ', 9, true),
	(39, 'Sugerencias', 'socio/buzon/vistaGeneralSugerencias.zul', 'z-icon-angle-double-right', ' ', 10, true),
	(40, 'Opinion postulacion', 'socio/buzon/opinionPostulacion.zul', 'z-icon-angle-double-right', ' ', 10, true),
	(41, 'Reservacion', 'instalacion/misReservaciones.zul', 'z-icon-angle-double-right', ' ', 3, true),
	(42, 'Alquileres', 'instalacion/administrarAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, true),
	(43, 'Mis alquileres', 'instalacion/misAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, true),
	(44, 'Eventualidades', 'instalacion/registrarEventualidadInst.zul','z-icon-angle-double-right', ' ', 2, true),
	(45, 'Registrar eventos', 'evento/administrarEvento/listaEventos.zul', 'z-icon-angle-double-right', ' ', 11, true),
	(46, 'Planificar evento', 'evento/administrarEvento/planificarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true),
	(47, 'Ejecutar evento', 'evento/administrarEvento/ejecutarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true),
	(48, 'Adjuntar empleados', 'administracion/adjuntarEmpleados.zul', 'z-icon-angle-double-right', ' ', 6, true),
	(49, 'Cartelera', 'administracion/cartelera.zul', 'z-icon-angle-double-right', ' ', 6, true),
	(50, 'Backup BD', ' ', 'z-icon-angle-double-right', ' ', 6, true),
	(51, 'Usuarios', 'administracion/seguridad/usuarioGeneral.zul', 'z-icon-angle-double-right', ' ', 15, true),
	(52, 'Grupos', 'administracion/seguridad/mostrarGrupos.zul', 'z-icon-angle-double-right', ' ', 15, true),
	(53, 'Funciones', 'administracion/seguridad/administrarFunciones.zul', 'z-icon-angle-double-right', ' ', 15, true),
	(54, 'Postulados', 'postulado/postulado.zul', 'z-icon-angle-double-right', ' ', 7, true),
	(55, 'Administrar portal', 'configuracion/administracionPortal.zul', 'z-icon-angle-double-right', ' ', 1, true),
	(56, 'Finalizar evento', 'evento/administrarEvento/finalizarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true),
	(57, 'Alquileres', 'consultas/reporteAlquileres.zul', 'z-icon-angle-double-right', ' ', 12, true),
	(58, 'Eventos', 'consultas/reporteEventos.zul', 'z-icon-angle-double-right', ' ', 12, true),
	(59, 'Actividades de Eventos', 'consultas/reporteActividadEventos.zul', 'z-icon-angle-double-right', ' ', 12, true),
	(60, 'Socios', 'consultas/reporteSocios.zul', 'z-icon-angle-double-right', ' ', 12, true),
	(61, 'Sanciones', 'consultas/reporteSanciones.zul', 'z-icon-angle-double-right', ' ', 12, true),
	(62, 'Eventualidades', 'consultas/reporteEventualidad.zul', 'z-icon-angle-double-right', ' ', 12, true),
	(63, 'Sanciones', 'consultas/reporteSancionesEst.zul', 'z-icon-angle-double-right', ' ', 14, true),
	(64, 'Eventualidades', 'consultas/reporteEventualidadesEst.zul', 'z-icon-angle-double-right', ' ', 14, true),
	(65, 'Evento', 'consultas/reporteEventoValorEsperadoRealEst.zul', 'z-icon-angle-double-right', ' ', 14, true),
	(66, 'Socio', 'consultas/reporteSociosEst.zul', 'z-icon-angle-double-right', ' ', 14, true),
   -- (67, 'Instalacion', 'consultas/reporteInstalacionesEst.zul', 'z-icon-angle-double-right', ' ', 14, true),
	(68, 'Instalacion', 'consultas/reporteSociosEst.zul', 'z-icon-angle-double-right', ' ', 14, true),
	(69, 'Red Social', 'configuracion/categoria/redSocial.zul', 'z-icon-angle-double-right', ' ', 8, true),
    (70, 'Tipo eventualidad', 'configuracion/categoria/tipoEventualidad.zul', 'z-icon-angle-double-right', ' ', 8, true),
    (71, 'Indicador', 'configuracion/categoria/indicador.zul', 'z-icon-angle-double-right', ' ', 8, true),
    (72, 'Tipo Opinion', 'configuracion/categoria/tipoOpinion.zul', 'z-icon-angle-double-right', ' ', 8, true),
    (73, 'Tipo Pago', 'configuracion/categoria/tipoPago.zul', 'z-icon-angle-double-right', ' ', 8, true),
    (74, 'Tipo Noticia', 'configuracion/categoria/tipoNoticia.zul', 'z-icon-angle-double-right', ' ', 8, true),
    (75, 'Motivo Cancelacion', 'configuracion/categoria/motivoCancelacion.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(76, 'Sugerencias', 'socio/buzon/sugerenciasAdministrar.zul', 'z-icon-angle-double-right', ' ', 10, true);
--id 13 30 67 disponible
	
-- inserta las funciones pertenecientes al grupo de socio
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 33, 1, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 34, 1, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 35, 1, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 39, 1, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 40, 1, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 41, 1, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 43, 1, true);


-- inserta las funciones pertenecientes al grupo seguridad
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 51, 4, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 52, 4, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 53, 4, true);
--inserta las funciones pertenecientes al grupo del afiliado
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 33, 3, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 34, 3, true);
--inserta las funciones pertenecientes al grupo Comunicador
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 49, 5, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 55, 5, true);
-- inserta las funciones pertenecientes al grupo junta
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 16, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 17, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 18, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 19, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 20, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 21, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 22, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 23, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 24, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 25, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 26, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 27, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 28, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 29, 2, true);
-- INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 30, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 31, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 32, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 36, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 37, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 38, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 42, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 45, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 46, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 47, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 48, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 50, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 54, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 56, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 66, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 57, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 58, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 59, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 60, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 61, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 62, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 63, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 64, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 65, 2, true);

--insertan las funciones pertenecientes a vigilancia
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 44, 6, true);

-- INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 67, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 68, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 70, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 71, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 72, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 73, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 74, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 75, 2, true);
INSERT INTO funcion_grupo ( funcionid_funcion, grupoid_grupo, activo) VALUES ( 76, 2, true);
