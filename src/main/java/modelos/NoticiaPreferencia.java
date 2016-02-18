package modelos;

// Generated 14/02/2016 02:21:08 PM by Hibernate Tools 4.3.1

/**
 * NoticiaPreferencia generated by hbm2java
 */
public class NoticiaPreferencia implements java.io.Serializable {

	private int idNoticiaPreferencia;
	private Noticia noticia;
	private Preferencia preferencia;

	public NoticiaPreferencia() {
	}

	public NoticiaPreferencia(int idNoticiaPreferencia, Noticia noticia,
			Preferencia preferencia) {
		this.idNoticiaPreferencia = idNoticiaPreferencia;
		this.noticia = noticia;
		this.preferencia = preferencia;
	}

	public int getIdNoticiaPreferencia() {
		return this.idNoticiaPreferencia;
	}

	public void setIdNoticiaPreferencia(int idNoticiaPreferencia) {
		this.idNoticiaPreferencia = idNoticiaPreferencia;
	}

	public Noticia getNoticia() {
		return this.noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Preferencia getPreferencia() {
		return this.preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

}
