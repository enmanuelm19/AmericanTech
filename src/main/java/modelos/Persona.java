package modelos;

// Generated 06/03/2016 06:03:48 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona implements java.io.Serializable {

	private int idPersona;
	private String identificacion;
	private String nombre;
	private String apellido;
	private String foto;
	private Date fechaNac;
	private String sexo;
	private String correo;
	private String telefono;
	private String telefonoFijo;
	private String direccion;
	private boolean activo;
	private Set<MiembroJunta> miembroJuntas = new HashSet<MiembroJunta>(0);
	private Set<Afiliado> afiliados = new HashSet<Afiliado>(0);
	private Set<RedPersona> redPersonas = new HashSet<RedPersona>(0);
	private Set<Socio> socios = new HashSet<Socio>(0);
	private Set<Eventualidad> eventualidads = new HashSet<Eventualidad>(0);
	private Set<Postulado> postulados = new HashSet<Postulado>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<PreferenciaPersona> preferenciaPersonas = new HashSet<PreferenciaPersona>(
			0);

	public Persona() {
	}

	public Persona(int idPersona, String nombre, String apellido, String sexo,
			boolean activo) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.activo = activo;
	}

	public Persona(int idPersona, String identificacion, String nombre,
			String apellido, String foto, Date fechaNac, String sexo,
			String correo, String telefono, String telefonoFijo,
			String direccion, boolean activo, Set<MiembroJunta> miembroJuntas,
			Set<Afiliado> afiliados, Set<RedPersona> redPersonas,
			Set<Socio> socios, Set<Eventualidad> eventualidads,
			Set<Postulado> postulados, Set<Usuario> usuarios,
			Set<PreferenciaPersona> preferenciaPersonas) {
		this.idPersona = idPersona;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.foto = foto;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.correo = correo;
		this.telefono = telefono;
		this.telefonoFijo = telefonoFijo;
		this.direccion = direccion;
		this.activo = activo;
		this.miembroJuntas = miembroJuntas;
		this.afiliados = afiliados;
		this.redPersonas = redPersonas;
		this.socios = socios;
		this.eventualidads = eventualidads;
		this.postulados = postulados;
		this.usuarios = usuarios;
		this.preferenciaPersonas = preferenciaPersonas;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<MiembroJunta> getMiembroJuntas() {
		return this.miembroJuntas;
	}

	public void setMiembroJuntas(Set<MiembroJunta> miembroJuntas) {
		this.miembroJuntas = miembroJuntas;
	}

	public Set<Afiliado> getAfiliados() {
		return this.afiliados;
	}

	public void setAfiliados(Set<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}

	public Set<RedPersona> getRedPersonas() {
		return this.redPersonas;
	}

	public void setRedPersonas(Set<RedPersona> redPersonas) {
		this.redPersonas = redPersonas;
	}

	public Set<Socio> getSocios() {
		return this.socios;
	}

	public void setSocios(Set<Socio> socios) {
		this.socios = socios;
	}

	public Set<Eventualidad> getEventualidads() {
		return this.eventualidads;
	}

	public void setEventualidads(Set<Eventualidad> eventualidads) {
		this.eventualidads = eventualidads;
	}

	public Set<Postulado> getPostulados() {
		return this.postulados;
	}

	public void setPostulados(Set<Postulado> postulados) {
		this.postulados = postulados;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<PreferenciaPersona> getPreferenciaPersonas() {
		return this.preferenciaPersonas;
	}

	public void setPreferenciaPersonas(
			Set<PreferenciaPersona> preferenciaPersonas) {
		this.preferenciaPersonas = preferenciaPersonas;
	}

}
