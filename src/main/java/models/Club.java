package models;

import java.util.HashSet;
import java.util.Set;

public class Club {

	private int id;
	private String rif;
	private String nombre;
	private String direccion;
	private String telefono;
	private String mision;
	private String vision;
	private byte[] logo; //Para almacenar la imagen en base64
	private String telfAlternativo;

	//Coleccion de politicas.. relacion uno a muchos
	private Set<Politica> politicas= new HashSet<Politica>();

	//Coleccion de juntasD.. relacion uno a muchos
	private Set<JuntaDirectiva> juntas= new HashSet<JuntaDirectiva>();
	
	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Club(int id, String rif, String nombre, String direccion,
			String telefono, String mision, String vision, byte[] logo,
			String telfAlternativo) {
		super();
		this.id = id;
		this.rif = rif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mision = mision;
		this.vision = vision;
		this.logo = logo;
		this.telfAlternativo = telfAlternativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMision() {
		return mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getTelfAlternativo() {
		return telfAlternativo;
	}

	public void setTelfAlternativo(String telfAlternativo) {
		this.telfAlternativo = telfAlternativo;
	}

	public Set<Politica> getPoliticas() {
		return politicas;
	}

	public void setPoliticas(Set<Politica> politicas) {
		this.politicas = politicas;
	}

	public Set<JuntaDirectiva> getJuntas() {
		return juntas;
	}

	public void setJuntas(Set<JuntaDirectiva> juntas) {
		this.juntas = juntas;
	}	
}
