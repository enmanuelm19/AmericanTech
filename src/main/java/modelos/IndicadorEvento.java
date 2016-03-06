package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

/**
 * IndicadorEvento generated by hbm2java
 */
public class IndicadorEvento implements java.io.Serializable {

	private int idIndicadorEvento;
	private Evento evento;
	private Indicador indicador;
	private int valorEsperado;
	private Integer valorReal;
	private boolean activo = true;

	public IndicadorEvento() {
	}

	public IndicadorEvento(int idIndicadorEvento, Evento evento,
			Indicador indicador, int valorEsperado, boolean activo) {
		this.idIndicadorEvento = idIndicadorEvento;
		this.evento = evento;
		this.indicador = indicador;
		this.valorEsperado = valorEsperado;
		this.activo = activo;
	}

	public IndicadorEvento(int idIndicadorEvento, Evento evento,
			Indicador indicador, int valorEsperado, Integer valorReal,
			boolean activo) {
		this.idIndicadorEvento = idIndicadorEvento;
		this.evento = evento;
		this.indicador = indicador;
		this.valorEsperado = valorEsperado;
		this.valorReal = valorReal;
		this.activo = activo;
	}

	public int getIdIndicadorEvento() {
		return this.idIndicadorEvento;
	}

	public void setIdIndicadorEvento(int idIndicadorEvento) {
		this.idIndicadorEvento = idIndicadorEvento;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Indicador getIndicador() {
		return this.indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public int getValorEsperado() {
		return this.valorEsperado;
	}

	public void setValorEsperado(int valorEsperado) {
		this.valorEsperado = valorEsperado;
	}

	public Integer getValorReal() {
		return this.valorReal;
	}

	public void setValorReal(Integer valorReal) {
		this.valorReal = valorReal;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
