package models;

public class Politica {
	
	private int id;
	private String parametro;
	private int valor;
	private Club clubId;
	
	public Politica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Politica(int id, String parametro, int valor, Club clubId) {
		super();
		this.id = id;
		this.parametro = parametro;
		this.valor = valor;
		this.clubId = clubId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}
}
