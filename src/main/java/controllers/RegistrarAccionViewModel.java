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
	private boolean val;
	@Init
	public void init(@ExecutionArgParam("accion") Accion accion) throws Exception {
		if(accion==null){
			this.accion=new Accion();
			EstadoAccion e=new EstadoAccion();
			e.setNombre("");
			this.accion.setEstadoAccion(e);
			this.accion.setValor(0);
			this.editable = false;
			val=false;
		} else {
			this.accion=accion;
			this.editable=true;
			val=true;
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
	public void val(){
		val=true;
	}
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if ((accion.getNroAccion() != null && !accion.getNroAccion().equalsIgnoreCase("")) || (accion.getValor() > 0.0 && !String.valueOf(accion.getValor()).equalsIgnoreCase(""))) {
			accion.setActivo(true);
			if (!editable){
				if(validarDesc())
					Messagebox.show("Ya existe una acción con ese numero","American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				else{
					if(!val){
						Messagebox.show("Debe seleccionar un estado acción","American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
					}else{
						if(accion.getValor()== 0.0){
							Messagebox.show("Debe ingresar un valor de acción","American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
							
						}else{
					accionDAO.agregarAccion(accion);
					Messagebox.show("La Acción " +accion.getNroAccion()+ " ha sido registrada exitosamente", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
					if(this.accion.getEstadoAccion().getIdEstadoAccion()==2){
						publicarNoticia();
					}
					win.detach();
					BindUtils.postGlobalCommand(null, null, "refreshAcciones", null);
				}}}
			}
			else{
				if(accion.getEstadoAccion().getIdEstadoAccion()==2){
					accion.setSocio(null);
				}
				accionDAO.actualizarAccion(accion);
				Messagebox.show("La acción " +accion.getNroAccion()+ " ha sido actualizada exitosamente", "American Tech", Messagebox.OK, Messagebox.INFORMATION);		
				if(this.accion.getEstadoAccion().getIdEstadoAccion()==2){
					publicarNoticia();
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshAcciones", null);
			}
			
		}

	}
	
	public boolean validarDesc() throws Exception{
		boolean val=false;
		List<Accion> acc= accionDAO.obtenerTodos();
		for(int i=0; i<acc.size(); i++){
			if(acc.get(i).getNroAccion().equalsIgnoreCase(accion.getNroAccion()))
				val=true;
		}
		return val;
	}
	public void publicarNoticia() throws Exception{
		this.noticia=new Noticia();
		this.noticia.setTitulo("Acción en Venta");
		this.noticia.setDescripcion("Se a aperturado el proceso de postulación para una acción en venta");
		this.noticia.setTipoNoticia(this.tipoNoticiaDao.obtenerTipoNoticia(2));
		this.noticia.setFechaCreacion(new Date());
		this.noticia.setFoto("http://i.imgur.com/E9BHBju.png");
		Date dia= new Date();
		dia.setDate(new Date().getDate()+15);
		this.noticia.setCaducidad(dia);
		this.noticia.setPublico(true);
		this.noticia.setActivo(true);
		this.noticiaDao.agregarNoticia(noticia);
	}
}
