package models;

import java.util.Date;

public class Hora {
	
	private int id;
	private Date valorHorario;
	
	public Hora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hora(int id, Date valorHorario) {
		super();
		this.id = id;
		this.valorHorario = valorHorario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getValorHorario() {
		return valorHorario;
	}

	public void setValorHorario(Date valorHorario) {
		this.valorHorario = valorHorario;
	}
	
}
