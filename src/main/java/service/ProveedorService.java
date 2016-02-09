package service;

import java.util.ArrayList;
import java.util.List;

import models.Proveedor;

public class ProveedorService {
	static int id=0;
	static List<Proveedor> pro= new ArrayList<Proveedor>();
	static{
		pro.add(new Proveedor(id++,  "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++,  "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++,  "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
		pro.add(new Proveedor(id++, "Fidel Alejos", "Barquisimeto", "0424-555-9999", "Correo@Correo.com"));
	}
	
	public static List<Proveedor> getPro() {
		return pro;
	}
	
}
