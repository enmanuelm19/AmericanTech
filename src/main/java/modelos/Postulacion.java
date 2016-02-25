package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Postulacion generated by hbm2java
 */
public class Postulacion implements java.io.Serializable {

	private int idPostulacion;
	private MotivoPostulacion motivoPostulacion;
	private Postulado postulado;
	private Venta venta;
	private Date fecha;
	private short carnetPadrino1;
	private short carnetPadrino2;
	private boolean aprobado;
	private boolean activo;
	private Set<Socio> socios = new HashSet<Socio>(0);
	private Set<Opinion> opinions = new HashSet<Opinion>(0);

	public Postulacion() {
	}

	public Postulacion(int idPostulacion, MotivoPostulacion motivoPostulacion,
			Postulado postulado, Venta venta, Date fecha, short carnetPadrino1,
			short carnetPadrino2, boolean aprobado, boolean activo) {
		this.idPostulacion = idPostulacion;
		this.motivoPostulacion = motivoPostulacion;
		this.postulado = postulado;
		this.venta = venta;
		this.fecha = fecha;
		this.carnetPadrino1 = carnetPadrino1;
		this.carnetPadrino2 = carnetPadrino2;
		this.aprobado = aprobado;
		this.activo = activo;
	}

	public Postulacion(int idPostulacion, MotivoPostulacion motivoPostulacion,
			Postulado postulado, Venta venta, Date fecha, short carnetPadrino1,
			short carnetPadrino2, boolean aprobado, boolean activo,
			Set<Socio> socios, Set<Opinion> opinions) {
		this.idPostulacion = idPostulacion;
		this.motivoPostulacion = motivoPostulacion;
		this.postulado = postulado;
		this.venta = venta;
		this.fecha = fecha;
		this.carnetPadrino1 = carnetPadrino1;
		this.carnetPadrino2 = carnetPadrino2;
		this.aprobado = aprobado;
		this.activo = activo;
		this.socios = socios;
		this.opinions = opinions;
	}

	public int getIdPostulacion() {
		return this.idPostulacion;
	}

	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public MotivoPostulacion getMotivoPostulacion() {
		return this.motivoPostulacion;
	}

	public void setMotivoPostulacion(MotivoPostulacion motivoPostulacion) {
		this.motivoPostulacion = motivoPostulacion;
	}

	public Postulado getPostulado() {
		return this.postulado;
	}

	public void setPostulado(Postulado postulado) {
		this.postulado = postulado;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public short getCarnetPadrino1() {
		return this.carnetPadrino1;
	}

	public void setCarnetPadrino1(short carnetPadrino1) {
		this.carnetPadrino1 = carnetPadrino1;
	}

	public short getCarnetPadrino2() {
		return this.carnetPadrino2;
	}

	public void setCarnetPadrino2(short carnetPadrino2) {
		this.carnetPadrino2 = carnetPadrino2;
	}

	public boolean isAprobado() {
		return this.aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Socio> getSocios() {
		return this.socios;
	}

	public void setSocios(Set<Socio> socios) {
		this.socios = socios;
	}

	public Set<Opinion> getOpinions() {
		return this.opinions;
	}

	public void setOpinions(Set<Opinion> opinions) {
		this.opinions = opinions;
	}

}
