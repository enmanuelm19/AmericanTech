package util;

import modelos.Postulacion;
import modelos.TipoOpnion;

public class ContadorOpinion {
	private TipoOpnion tipoOpnion;
	private int cantidad;
	private String color;
	
	public ContadorOpinion( TipoOpnion op, int cant){
		this.tipoOpnion=op;
		this.cantidad=cant;
		if(op.getIdTipoOpninion()==1)
			color="color:#2B7DBC";
		else if(op.getIdTipoOpninion()==2)
			color="color:red";
		else if(op.getIdTipoOpninion()==3)
			color="color:orange";
		else 
			color="color: #5cb85c";
	}

	public TipoOpnion getTipoOpnion() {
		return tipoOpnion;
	}

	public void setTipoOpnion(TipoOpnion tipoOpnion) {
		this.tipoOpnion = tipoOpnion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
