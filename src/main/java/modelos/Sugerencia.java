package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sugerencia generated by hbm2java
 */
public class Sugerencia implements java.io.Serializable {

	private int idSugerencia;
	private ClienteExterno clienteExterno;
	private TipoSugerencia tipoSugerencia;
	private Usuario usuario;
	private String descripcion;
	private Date fecha;
	private boolean activo = true;

	public Sugerencia() {
	}

	public Sugerencia(int idSugerencia, TipoSugerencia tipoSugerencia,
		String descripcion, Date fecha, boolean activo) {
		this.idSugerencia = idSugerencia;
		this.tipoSugerencia = tipoSugerencia;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.activo = activo;
	}

	public Sugerencia(int idSugerencia, ClienteExterno clienteExterno,
			TipoSugerencia tipoSugerencia, Usuario usuario, String descripcion,
			Date fecha, boolean activo) {
		this.idSugerencia = idSugerencia;
		this.clienteExterno = clienteExterno;
		this.tipoSugerencia = tipoSugerencia;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.activo = activo;
	}

	public int getIdSugerencia() {
		return this.idSugerencia;
	}

	public void setIdSugerencia(int idSugerencia) {
		this.idSugerencia = idSugerencia;
	}

	public ClienteExterno getClienteExterno() {
		return this.clienteExterno;
	}

	public void setClienteExterno(ClienteExterno clienteExterno) {
		this.clienteExterno = clienteExterno;
	}

	public TipoSugerencia getTipoSugerencia() {
		return this.tipoSugerencia;
	}

	public void setTipoSugerencia(TipoSugerencia tipoSugerencia) {
		this.tipoSugerencia = tipoSugerencia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
		
	public String getFechaString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(fecha);
	}
	
}
