package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private int id;
	private String contrasenna;
	private String usuario;
	private String pregunta;
	private String respuesta;
	private Persona personaId;
	
	//coleccion de Sugerencias.. relacion uno a muchos
	private List<Sugerencia> sugerencias= new ArrayList<Sugerencia>();
	
	//coleccion de Grupo.. relacion muchos a muchos
	private List<Grupo> grupos= new ArrayList<Grupo>();
	
	//coleccion de Opiniones.. relacion uno a muchos
	private List<Opinion> opiniones=new ArrayList<Opinion>();
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String contrasenna, String usuario, String pregunta,
			String respuesta, Persona personaId) {
		super();
		this.id = id;
		this.contrasenna = contrasenna;
		this.usuario = usuario;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.personaId = personaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}
}
