package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Persona {
	
	private int id;
	private String identificacion;
	private byte[] foto;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNac;
	private char sexo;
	private String correo;
	private String telefono;
	private String telefonoFijo;
	private String direccion;
	
	//coleccion de Preferencias.. relacion uno a muchos
	private List<Preferencia> preferencias= new ArrayList<Preferencia>();
	
	//coleccion de Eventualidades.. relacion uno a muchos
	private List<Eventualidad> eventualidades= new ArrayList<Eventualidad>();
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, String identificacion, byte[] foto,
			String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, Date fechaNac, char sexo, String correo,
			String telefono, String telefonoFijo, String direccion) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.foto = foto;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.correo = correo;
		this.telefono = telefono;
		this.telefonoFijo = telefonoFijo;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}

	public List<Eventualidad> getEventualidades() {
		return eventualidades;
	}

	public void setEventualidades(List<Eventualidad> eventualidades) {
		this.eventualidades = eventualidades;
	}
	
}
