package models;

import java.util.ArrayList;
import java.util.List;

public class TipoInstalacion {

	private int id;
	private String descripcion;
	private String estatus;	
	private String descFiltro;
	private String idFiltro;
	private List<Instalacion> instalaciones = new ArrayList<Instalacion>();
	
	
	public TipoInstalacion(){
		super();
	}


	public TipoInstalacion(int id, String descripcion, String estatus) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public String getDescFiltro() {
		return descFiltro;
	}


	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}


	public String getIdFiltro() {
		return idFiltro;
	}


	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro==null?"":idFiltro.trim();
	}

	public List<Instalacion> getInstalaciones() {
		return instalaciones;
	}


	public void setInstalaciones(List<Instalacion> instalaciones) {
		this.instalaciones = instalaciones;
	}
	
	
}
