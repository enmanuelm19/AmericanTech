package service;

import java.util.ArrayList;
import java.util.List;

import models.Funcion;


public class FuncionService {
	static List<Funcion> funcion= new ArrayList<Funcion>();
	
	static {
		funcion.add(new Funcion(1, "Configuracion", "", "z-icon-cogs", 0, ""));
		funcion.add(new Funcion(2, "Socios", "", "z-icon-user", 0, ""));
		funcion.add(new Funcion(3, "Instalaciones", "", "z-icon-home", 0, ""));
		funcion.add(new Funcion(4, "Eventos", "", "z-icon-calendar", 0, ""));
		funcion.add(new Funcion(5, "Consulta", "", "z-icon-th-list", 0, ""));
		funcion.add(new Funcion(6, "Adm. del sistema", "", "z-icon-puzzle-piece", 0, ""));
		funcion.add(new Funcion(7, "Postulaciones", "", "z-icon-group", 0, ""));
		funcion.add(new Funcion(8, "Categorias", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(10, "Administrar Socio", "", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(11, "Danos tu opinion", "", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(12, "Administrar Evento", "", "z-icon-angle-double-right", 4, ""));
		funcion.add(new Funcion(13, "Socio", "", "z-icon-angle-double-right", 5, ""));
		funcion.add(new Funcion(14, "Instalacion", "", "z-icon-angle-double-right", 5, ""));
		funcion.add(new Funcion(15, "Evento", "", "z-icon-angle-double-right", 5, ""));
		funcion.add(new Funcion(16, "Seguridad", "", "z-icon-angle-double-right", 6, ""));
		funcion.add(new Funcion(17, "Perfil del Club", "configuracion/perfilClub.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(18, "Junta Directiva", "configuracion/juntaDirectiva.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(20, "Instalaciones", "configuracion/gestionarInstalaciones.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(21, "Proveedores", "configuracion/proveedores.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(22, "Patrocinantes", "configuracion/patrocinantes.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(23, "Reglas Club", "configuracion/reglasClub.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(27, "Tipo preferencia", "configuracion/categoria/tipoPreferencia.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(24, "Tipo sugerencia", "configuracion/categoria/tipoSugerencia.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(28, "Tipo instalacion", "configuracion/categoria/tipoInstalacion.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(66, "Tipo afiliado", "configuracion/categoria/parentesco.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(32, "Tipo actividad", "configuracion/categoria/tipoActividad.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(31, "Motivo postulacion", "configuracion/categoria/motivoPostulacion.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(29, "Motivo sancion", "configuracion/categoria/tiposSanciones.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(34, "Motivo desvinculacion", "configuracion/categoria/tipoDesvinculacion.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(33, "Motivo venta", "configuracion/categoria/motivoVenta.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(19, "Preferencias", "configuracion/categoria/preferencia.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(30, "Recursos", "configuracion/categoria/recursos.zul", "z-icon-angle-double-right", 8, ""));
		//funcion.add(new Funcion(25, "Tipo de noticia", "configuracion/categoria/tipoNoticia.zul", "z-icon-angle-double-right", 8, ""));
		//funcion.add(new Funcion(26, "Tipo de Evento", "configuracion/categoria/tipoEvento.zul", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(35, "Cargo junta directiva", "configuracion/categoria/cargoJunta.zul", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(36, "Acciones", "socio/acciones.zul", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(37, "Mi perfil", "socio/miPerfil.zul", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(38, "Mis sanciones", "socio/misSanciones.zul", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(39, "Solicitar venta", "socio/solicitarVenta.zul", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(40, "Registrar socio", "socio/administrarSocio/postulantes.zul", "z-icon-angle-double-right", 10, ""));
		//Hay una funcion de registrar (mirar controllerNavgation no entiendo eso
		funcion.add(new Funcion(41, "Registrar afiliado", "socio/administrarSocio/socios.zul", "z-icon-angle-double-right", 10, ""));
		funcion.add(new Funcion(42, "Sanciones", "socio/administrarSocio/sanciones.zul", "z-icon-angle-double-right", 10, ""));
		funcion.add(new Funcion(43, "Sugerencias", "socio/buzon/vistaGeneralSugerencias.zul", "z-icon-angle-double-right", 11, ""));
		funcion.add(new Funcion(44, "Opinion postulacion", "socio/buzon/opinionPostulacion.zul", "z-icon-angle-double-right", 11, ""));
		funcion.add(new Funcion(45, "Visitas", "instalacion/registrarVisita.zul", "z-icon-angle-double-right", 3, ""));
		funcion.add(new Funcion(46, "Reservacion", "instalacion/misReservaciones.zul", "z-icon-angle-double-right", 3, ""));
		funcion.add(new Funcion(47, "Alquileres", "instalacion/administrarAlquileres.zul", "z-icon-angle-double-right", 3, ""));
		funcion.add(new Funcion(48, "Mis alquileres", "instalacion/misAlquileres.zul", "z-icon-angle-double-right", 3, ""));
		funcion.add(new Funcion(49, "Eventualidades", "instalacion/registrarEventualidadInst.zul", "z-icon-angle-double-right", 2, ""));  
		//funcion.add(new Funcion(50, "Solicitudes evento", "evento/solicitudesEvento.zul", "z-icon-angle-double-right", 4, ""));
		//funcion.add(new Funcion(51, "Lista de solicitudes", "evento/administrarEvento/listaSolicitudes.zul", "z-icon-angle-double-right", 12, ""));
		funcion.add(new Funcion(52, "Registrar evento", "evento/administrarEvento/listaEventos.zul", "z-icon-angle-double-right", 12, ""));
		funcion.add(new Funcion(53, "Planificar evento", "evento/administrarEvento/planificarEvento.zul", "z-icon-angle-double-right", 12, ""));
		funcion.add(new Funcion(54, "Ejecutar evento", "evento/administrarEvento/ejecutarEvento.zul", "z-icon-angle-double-right", 12, ""));
		funcion.add(new Funcion(55, "Opiniones postulacion", "administracion/seguridad/usuarioGeneral.zul", "z-icon-angle-double-right", 13, ""));
		funcion.add(new Funcion(56, "Sugerencias", "consultas/sugerencia.zul", "z-icon-angle-double-right", 13, ""));
		funcion.add(new Funcion(57, "Usuario", "administracion/seguridad/usuarioGeneral.zul", "z-icon-angle-double-right", 14, ""));
		funcion.add(new Funcion(58, "Usuario", "administracion/seguridad/usuarioGeneral.zul", "z-icon-angle-double-right", 15, ""));
		funcion.add(new Funcion(59, "Adjuntar empleados", "administracion/adjuntarEmpleados.zul", "z-icon-angle-double-right", 6, ""));
		funcion.add(new Funcion(60, "Cartelera", "administracion/cartelera.zul", "z-icon-angle-double-right", 6, ""));
		funcion.add(new Funcion(61, "Backup BD", "", "z-icon-angle-double-right", 6, ""));
		funcion.add(new Funcion(62, "Usuarios", "administracion/seguridad/usuarioGeneral.zul", "z-icon-angle-double-right", 16, ""));
		funcion.add(new Funcion(63, "Grupos", "administracion/seguridad/mostrarGrupos.zul", "z-icon-angle-double-right", 16, ""));
		funcion.add(new Funcion(64, "Funciones", "administracion/seguridad/administrarFunciones.zul", "z-icon-angle-double-right", 16, ""));
		funcion.add(new Funcion(65, "Postulados", "postulado/postulado.zul", "z-icon-angle-double-right", 7, ""));
		
		funcion.add(new Funcion(67, "Finalizar evento", "evento/administrarEvento/finalizacionEvento.zul", "z-icon-angle-double-right", 12, ""));
		funcion.add(new Funcion(68, "Registrar Portal", "configuracion/categoria/administracionPortal.zul", "z-icon-angle-double-right", 8, ""));
	}
	
	public static List<Funcion> getFunciones(){
		return funcion;
	}
}
