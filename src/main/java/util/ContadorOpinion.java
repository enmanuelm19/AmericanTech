package util;

import modelos.Postulacion;
import modelos.TipoOpnion;

public class ContadorOpinion {
	private TipoOpnion tipoOpnion;
	private int cantidad;
	
	public ContadorOpinion( TipoOpnion op, int cant){
		this.tipoOpnion=op;
		this.cantidad=cant;
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
	
}
