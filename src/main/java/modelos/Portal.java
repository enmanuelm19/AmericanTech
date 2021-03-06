package modelos;

// Generated 06/03/2016 06:03:48 PM by Hibernate Tools 4.3.1

/**
 * Portal generated by hbm2java
 */
public class Portal implements java.io.Serializable {

	private int idPortal;
	private String instalacion;
	private String socio;
	private String evento;
	private boolean activo = true;
	private String fotoSocio;
	private String fotoInstalaciones;
	private String fotoEvento;

	public Portal() {
	}

	public Portal(int idPortal, boolean activo) {
		this.idPortal = idPortal;
		this.activo = activo;
	}

	public Portal(int idPortal, String instalacion, String socio,
			String evento, boolean activo, String fotoSocio,
			String fotoInstalaciones, String fotoEvento) {
		this.idPortal = idPortal;
		this.instalacion = instalacion;
		this.socio = socio;
		this.evento = evento;
		this.activo = activo;
		this.fotoSocio = fotoSocio;
		this.fotoInstalaciones = fotoInstalaciones;
		this.fotoEvento = fotoEvento;
	}

	public int getIdPortal() {
		return this.idPortal;
	}

	public void setIdPortal(int idPortal) {
		this.idPortal = idPortal;
	}

	public String getInstalacion() {
		return this.instalacion;
	}

	public void setInstalacion(String instalacion) {
		this.instalacion = instalacion;
	}

	public String getSocio() {
		return this.socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getFotoSocio() {
		return this.fotoSocio;
	}

	public void setFotoSocio(String fotoSocio) {
		this.fotoSocio = fotoSocio;
	}

	public String getFotoInstalaciones() {
		return this.fotoInstalaciones;
	}

	public void setFotoInstalaciones(String fotoInstalaciones) {
		this.fotoInstalaciones = fotoInstalaciones;
	}

	public String getFotoEvento() {
		return this.fotoEvento;
	}

	public void setFotoEvento(String fotoEvento) {
		this.fotoEvento = fotoEvento;
	}

}
