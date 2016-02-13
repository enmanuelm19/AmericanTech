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
		funcion.add(new Funcion(17, "Perfil del Club", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(18, "Junta Directiva", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(19, "Preferencias", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(20, "Instalaciones", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(21, "Proveedores", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(22, "Patrocinantes", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(23, "Reglas Club", "", "z-icon-angle-double-right", 1, ""));
		funcion.add(new Funcion(24, "Tipo de sugerencia", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(25, "Tipo de noticia", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(26, "Tipo de Evento", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(27, "Tipo de preferencia", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(28, "Tipo de instalacion", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(29, "Tipo de sancion", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(30, "Recursos", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(31, "Motivo postulacion", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(32, "Tipo de actividad", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(33, "Motivo venta", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(34, "Tipo desvinculacion", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(35, "Cargo junta directiva", "", "z-icon-angle-double-right", 8, ""));
		funcion.add(new Funcion(36, "Acciones", "", "z-icon-angle-double-right", 2, ""));
		funcion.add(new Funcion(37, "Mi perfil", "", "z-icon-user", 2, ""));
		funcion.add(new Funcion(38, "Mis sanciones", "", "z-icon-user", 2, ""));
		funcion.add(new Funcion(39, "Solicitar venta", "", "z-icon-user", 2, ""));
		funcion.add(new Funcion(40, "Registrar socio", "", "z-icon-user", 10, ""));
		funcion.add(new Funcion(41, "Registrar afiliado", "", "z-icon-user", 10, ""));
		funcion.add(new Funcion(42, "Sanciones", "", "z-icon-user", 10, ""));
		funcion.add(new Funcion(43, "Sugerencias", "", "z-icon-user", 11, ""));
		funcion.add(new Funcion(44, "Opinion postulacion", "", "z-icon-user", 11, ""));
		funcion.add(new Funcion(45, "Visitas", "", "z-icon-user", 3, ""));
		funcion.add(new Funcion(46, "Reservacion", "", "z-icon-user", 3, ""));
		funcion.add(new Funcion(47, "Alquileres", "", "z-icon-user", 3, ""));
		funcion.add(new Funcion(48, "Mis alquileres", "", "z-icon-user", 3, ""));
		funcion.add(new Funcion(49, "Eventualidades", "", "z-icon-user", 3, ""));
		funcion.add(new Funcion(50, "Solicitudes evento", "", "z-icon-user", 4, ""));
		funcion.add(new Funcion(51, "Eventualidades", "", "z-icon-user", 4, ""));
		funcion.add(new Funcion(52, "Lista eventos", "", "z-icon-user", 12, ""));
		funcion.add(new Funcion(53, "Planificar evento", "", "z-icon-user", 12, ""));
		funcion.add(new Funcion(54, "Ejecutar evento", "", "z-icon-user", 12, ""));
		funcion.add(new Funcion(55, "Opiniones postulacion", "", "z-icon-user", 13, ""));
		funcion.add(new Funcion(56, "Sugerencias", "", "z-icon-user", 13, ""));
		funcion.add(new Funcion(57, "Usuario", "", "z-icon-user", 14, ""));
		funcion.add(new Funcion(58, "Usuario", "", "z-icon-user", 15, ""));
		funcion.add(new Funcion(59, "Adjuntar empleados", "", "z-icon-user", 6, ""));
		funcion.add(new Funcion(60, "Cartelera", "", "z-icon-user", 6, ""));
		funcion.add(new Funcion(61, "Backup BD", "", "z-icon-user", 6, ""));
		funcion.add(new Funcion(62, "Usuarios", "", "z-icon-user", 16, ""));
		funcion.add(new Funcion(63, "Grupos", "", "z-icon-user", 16, ""));
		funcion.add(new Funcion(64, "Funciones", "", "z-icon-user", 16, ""));
		funcion.add(new Funcion(65, "Postulados", "", "z-icon-user", 7, ""));
	}
	
	public static List<Funcion> getFunciones(){
		return funcion;
	}
}
