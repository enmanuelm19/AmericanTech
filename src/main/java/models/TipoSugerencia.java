package models;

import java.util.ArrayList;
import java.util.List;

public class TipoSugerencia {
	
	private int id;
	private String descripcion;
	private String estatus;
	
	private String descFiltro;
	private String idFiltro;

	//Coleccion de sugerencias.. relacion uno a muchos
	private List<Sugerencia> sugerencias= new ArrayList<Sugerencia>();
	
	public TipoSugerencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoSugerencia(int id, String descripcion, String estatus) {
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

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}
	
	public String getDescFiltro() {
		return descFiltro;
	}

	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro;
	}

	public String getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
