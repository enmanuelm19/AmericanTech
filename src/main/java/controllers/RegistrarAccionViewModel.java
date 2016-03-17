package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import modelos.Accion;
import modelos.EstadoAccion;
import modelos.Noticia;
import modelos.Preferencia;
import Dao.AccionDao;
import Dao.EstadoAccionDao;
import Dao.NoticiaDao;
import Dao.TipoNoticiaDao;

public class RegistrarAccionViewModel {
	private AccionDao accionDAO= new AccionDao();
	private List<EstadoAccion> estados;
	private EstadoAccionDao estdao;
	private Accion accion;
	private boolean editable;
	private Noticia noticia;
	private TipoNoticiaDao tipoNoticiaDao;
	private NoticiaDao noticiaDao;
	@Init
	public void init(@ExecutionArgParam("accion") Accion accion) throws Exception {
		if(accion==null){
			this.accion=new Accion();
			this.editable = false;
		} else {
			this.accion=accion;
			this.editable=true;
		}
		this.estdao= new EstadoAccionDao();
		this.estados= estdao.obtenerTodos();
		this.noticiaDao= new NoticiaDao();
		this.tipoNoticiaDao= new TipoNoticiaDao();
		
	}
	public ListModelList<EstadoAccion> getEstadosAll() {
		 return new ListModelList<EstadoAccion>(estados);
	}
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Accion getAccion() {
		return accion;
	}
	public void setAccion(Accion accion) {
		this.accion = accion;
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		System.out.println("valor "+accion.getValor());
		if ((accion.getNroAccion() != null && !accion.getNroAccion().equalsIgnoreCase("")) || (accion.getValor() > 0.0 && !String.valueOf(accion.getValor()).equalsIgnoreCase(""))) {
			accion.setActivo(true);
			if (!editable){				
				accionDAO.agregarAccion(accion);
				Messagebox.show("La Acci�n " +accion.getNroAccion()+ " ha sido registrada exitosamente", "", Messagebox.OK, Messagebox.INFORMATION);
			}
			else{
				if(accion.getEstadoAccion().getIdEstadoAccion()==2){
					accion.setSocio(null);
				}
				accionDAO.actualizarAccion(accion);
				Messagebox.show("La Acci�n " +accion.getNroAccion()+ " ha sido actualizada exitosamente", "", Messagebox.OK, Messagebox.INFORMATION);		
			}
			if(this.accion.getEstadoAccion().getIdEstadoAccion()==2){
				this.noticia=new Noticia();
				this.noticia.setTitulo("Acci�n en Venta");
				this.noticia.setDescripcion("�Se a aperturado el proceso de postulaci�n para una acci�n en venta!");
				this.noticia.setTipoNoticia(this.tipoNoticiaDao.obtenerTipoNoticia(2));
				this.noticia.setFechaCreacion(new Date());
				this.noticia.setCaducidad(new Date());
				this.noticia.setPublico(true);
				this.noticia.setActivo(true);
				this.noticiaDao.agregarNoticia(noticia);
			}
			
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshAcciones", null);
		}

	}
}
