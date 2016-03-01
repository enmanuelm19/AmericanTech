package modelos;

// Generated 01/03/2016 02:05:25 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Archivo generated by hbm2java
 */
public class Archivo implements java.io.Serializable {

	private int idArchivo;
	private String url;
	private String nombre;
	private String extension;
	private boolean activo = true;
	private Set<Noticia> noticias = new HashSet<Noticia>(0);
	private Set<ArchivoPortal> archivoPortals = new HashSet<ArchivoPortal>(0);
	private Set<Club> clubs = new HashSet<Club>(0);
	private Set<ArchivoAlquiler> archivoAlquilers = new HashSet<ArchivoAlquiler>(
			0);
	private Set<Persona> personas = new HashSet<Persona>(0);

	public Archivo() {
	}

	public Archivo(int idArchivo, String url, String nombre, String extension,
			boolean activo) {
		this.idArchivo = idArchivo;
		this.url = url;
		this.nombre = nombre;
		this.extension = extension;
		this.activo = activo;
	}

	public Archivo(int idArchivo, String url, String nombre, String extension,
			boolean activo, Set<Noticia> noticias,
			Set<ArchivoPortal> archivoPortals, Set<Club> clubs,
			Set<ArchivoAlquiler> archivoAlquilers, Set<Persona> personas) {
		this.idArchivo = idArchivo;
		this.url = url;
		this.nombre = nombre;
		this.extension = extension;
		this.activo = activo;
		this.noticias = noticias;
		this.archivoPortals = archivoPortals;
		this.clubs = clubs;
		this.archivoAlquilers = archivoAlquilers;
		this.personas = personas;
	}

	public int getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Set<ArchivoPortal> getArchivoPortals() {
		return this.archivoPortals;
	}

	public void setArchivoPortals(Set<ArchivoPortal> archivoPortals) {
		this.archivoPortals = archivoPortals;
	}

	public Set<Club> getClubs() {
		return this.clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}

	public Set<ArchivoAlquiler> getArchivoAlquilers() {
		return this.archivoAlquilers;
	}

	public void setArchivoAlquilers(Set<ArchivoAlquiler> archivoAlquilers) {
		this.archivoAlquilers = archivoAlquilers;
	}

	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

}
