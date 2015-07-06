package models;

public class Afiliado {
	
	private int id;
	private String nroCarnet;
	private Persona personaId;
	private TipoAfiliado tipoAfiliadoId;
	private Socio socioId;
	
	public Afiliado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Afiliado(int id, String nroCarnet, Persona personaId,
			TipoAfiliado tipoAfiliadoId, Socio socioId) {
		super();
		this.id = id;
		this.nroCarnet = nroCarnet;
		this.personaId = personaId;
		this.tipoAfiliadoId = tipoAfiliadoId;
		this.socioId = socioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNroCarnet() {
		return nroCarnet;
	}

	public void setNroCarnet(String nroCarnet) {
		this.nroCarnet = nroCarnet;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public TipoAfiliado getTipoAfiliadoId() {
		return tipoAfiliadoId;
	}

	public void setTipoAfiliadoId(TipoAfiliado tipoAfiliadoId) {
		this.tipoAfiliadoId = tipoAfiliadoId;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}
	
}
