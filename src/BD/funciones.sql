﻿INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) 
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
	(13, 'No estructurado', ' ', 'z-icon-angle-double-right', ' ', 5, true),
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
	(28, 'Motivo sancion', 'configuracion/categoria/motivoSancion.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(29, 'Tipo Afiliado', 'configuracion/categoria/tipoAfiliado.zul', 'z-icon-angle-double-right', ' ', 8, true),
	(30, 'Tipo actividad', 'configuracion/categoria/tipoActividad.zul', 'z-icon-angle-double-right', ' ', 8, true),
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
	(56, 'Finalizar evento', 'evento/administrarEvento/finalizacionEvento.zul', 'z-icon-angle-double-right', ' ', 11, true),
	(57, 'Socio', ' ', 'z-icon-angle-double-right', ' ', 12, true),
	(58, 'Instalacion', ' ', 'z-icon-angle-double-right', ' ', 12, true),
	(59, 'Evento', ' ', 'z-icon-angle-double-right', ' ', 12, true),
	(60, 'Socio', ' ', 'z-icon-angle-double-right', ' ', 13, true),
	(61, 'Instalacion', ' ', 'z-icon-angle-double-right', ' ', 13, true),
	(62, 'Evento', ' ', 'z-icon-angle-double-right', ' ', 13, true),
	(63, 'Socio', ' ', 'z-icon-angle-double-right', ' ', 14, true),
	(64, 'Instalacion', ' ', 'z-icon-angle-double-right', ' ', 14, true),
	(65, 'Evento', ' ', 'z-icon-angle-double-right', ' ', 14, true),
	(66, 'Unidad medida', 'configuracion/categoria/unidadMedida.zul', 'z-icon-angle-double-right', ' ', 8, true);
        (67, 'Tipo eventualidad', 'configuracion/categoria/tipoEventualidad.zul', 'z-icon-angle-double-right', ' ', 8, true);
        (68, 'Indicador', 'configuracion/categoria/indicador.zul', 'z-icon-angle-double-right', ' ', 8, true);
	
