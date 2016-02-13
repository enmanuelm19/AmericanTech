package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Funcion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String pagina;
	private String iconUri;
	private int id_padre;
	private String clase;
	
	//coleccion de Grupos.. relacion muchos a muchos
	private List<Grupo> grupos= new ArrayList<Grupo>();
	
	public Funcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcion(int id, String nombre, String pagina, String iconUri, int id_padre, String clase) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pagina = pagina;
		this.iconUri = iconUri;
		this.clase = clase;
		this.id_padre = id_padre;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public int getId_padre() {
		return id_padre;
	}

	public void setId_padre(int id_padre) {
		this.id_padre = id_padre;
	}

	public String getIconUri() {
		return iconUri;
	}

	public void setIconUri(String iconUri) {
		this.iconUri = iconUri;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
}
