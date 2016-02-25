package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Funcion generated by hbm2java
 */
public class Funcion implements java.io.Serializable {

	private int idFuncion;
	private String nombre;
	private String pagina;
	private String iconUri;
	private String clase;
	private boolean activo;
	private Set<FuncionGrupo> funcionGrupos = new HashSet<FuncionGrupo>(0);

	public Funcion() {
	}

	public Funcion(int idFuncion, String nombre, String pagina, String iconUri,
			String clase, boolean activo) {
		this.idFuncion = idFuncion;
		this.nombre = nombre;
		this.pagina = pagina;
		this.iconUri = iconUri;
		this.clase = clase;
		this.activo = activo;
	}

	public Funcion(int idFuncion, String nombre, String pagina, String iconUri,
			String clase, boolean activo, Set<FuncionGrupo> funcionGrupos) {
		this.idFuncion = idFuncion;
		this.nombre = nombre;
		this.pagina = pagina;
		this.iconUri = iconUri;
		this.clase = clase;
		this.activo = activo;
		this.funcionGrupos = funcionGrupos;
	}

	public int getIdFuncion() {
		return this.idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPagina() {
		return this.pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getIconUri() {
		return this.iconUri;
	}

	public void setIconUri(String iconUri) {
		this.iconUri = iconUri;
	}

	public String getClase() {
		return this.clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<FuncionGrupo> getFuncionGrupos() {
		return this.funcionGrupos;
	}

	public void setFuncionGrupos(Set<FuncionGrupo> funcionGrupos) {
		this.funcionGrupos = funcionGrupos;
	}

}
