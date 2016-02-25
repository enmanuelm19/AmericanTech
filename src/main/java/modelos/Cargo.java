package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Cargo generated by hbm2java
 */
public class Cargo implements java.io.Serializable {

	private int idCargo;
	private String descripcion;
	private boolean activo;
	private Set<MiembroJunta> miembroJuntas = new HashSet<MiembroJunta>(0);

	public Cargo() {
	}

	public Cargo(int idCargo, String descripcion, boolean activo) {
		this.idCargo = idCargo;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Cargo(int idCargo, String descripcion, boolean activo,
			Set<MiembroJunta> miembroJuntas) {
		this.idCargo = idCargo;
		this.descripcion = descripcion;
		this.activo = activo;
		this.miembroJuntas = miembroJuntas;
	}

	public int getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

}
