package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Visita {
	
	private int id;
	private Date fecha;
	private Afiliado afiliadoId;
	private boolean externo;
	private Invitado invitadoId;
	private Socio socioId;
	
	//coleccion de Eventos.. relacion muchos a muchos;
	private Set<Evento> eventos= new HashSet<Evento>();
	
	public Visita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visita(int id, Date fecha, Afiliado afiliadoId, boolean externo,
			Invitado invitadoId, Socio socioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.afiliadoId = afiliadoId;
		this.externo = externo;
		this.invitadoId = invitadoId;
		this.socioId = socioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Afiliado getAfiliadoId() {
		return afiliadoId;
	}

	public void setAfiliadoId(Afiliado afiliadoId) {
		this.afiliadoId = afiliadoId;
	}

	public boolean isExterno() {
		return externo;
	}

	public void setExterno(boolean externo) {
		this.externo = externo;
	}

	public Invitado getInvitadoId() {
		return invitadoId;
	}

	public void setInvitadoId(Invitado invitadoId) {
		this.invitadoId = invitadoId;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}
	
}
