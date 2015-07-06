package models;

import java.util.Date;

public class Sugerencia {
	
	private int id;
	private String descripcion;
	private Date fecha;
	private ClienteExterno clienteExternoId;
	private TipoSugerencia tipoSugerenciaId;
	private Usuario usuarioId;
	
	public Sugerencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sugerencia(int id, String descripcion, Date fecha,
			ClienteExterno clienteExternoId, TipoSugerencia tipoSugerenciaId,
			Usuario usuarioId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.clienteExternoId = clienteExternoId;
		this.tipoSugerenciaId = tipoSugerenciaId;
		this.usuarioId = usuarioId;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ClienteExterno getClienteExternoId() {
		return clienteExternoId;
	}

	public void setClienteExternoId(ClienteExterno clienteExternoId) {
		this.clienteExternoId = clienteExternoId;
	}

	public TipoSugerencia getTipoSugerenciaId() {
		return tipoSugerenciaId;
	}

	public void setTipoSugerenciaId(TipoSugerencia tipoSugerenciaId) {
		this.tipoSugerenciaId = tipoSugerenciaId;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
}
