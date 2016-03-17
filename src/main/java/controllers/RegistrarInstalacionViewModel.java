package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


import Dao.RecursoDao;
import Dao.RecursoInstalacionDao;
import Dao.TipoInstalacionDao;
import Dao.InstalacionDao;
import modelos.IndicadorEvento;
import modelos.Instalacion;
import modelos.TipoInstalacion;
import modelos.RecursoInstalacion;
import modelos.RedClub;
import modelos.Recurso;

public class RegistrarInstalacionViewModel {

	private Instalacion instalacion;
	private boolean editable;
	private InstalacionDao instalacionDao;
	private List<TipoInstalacion> allTipoInstalacion;
	private TipoInstalacionDao tipoInstalacionDao;
	private List<Recurso> allRecurso;
	private Recurso recurso;
	private RecursoDao recursoDao;
	private RecursoInstalacion recursoInstalacion;
	private RecursoInstalacionDao recursoInstalacionDao;
	private List<RecursoInstalacion> allRecursoInstalacion;
	private List<RecursoInstalacion> allRecursoparcial;
	private int cantidad;
	private Set<RecursoInstalacion> allRecursoparcial2;
	private Set<RecursoInstalacion> recursosinstalacion;
	private ArrayList<RecursoInstalacion> temporalRecurso;
	private Media uploadedImage;
	private boolean imagenNueva = false;
	
	@Init
	public void init(@ExecutionArgParam("instalacion") Instalacion instalacion)
			throws Exception {
		if (instalacion == null) {
			this.instalacion = new Instalacion();
			recursosinstalacion = new HashSet<RecursoInstalacion>();
			this.editable = false;
		} else {
			this.instalacion = instalacion;
			recursosinstalacion = instalacion.getRecursoInstalacions();
			this.editable = true;
		}
		allRecursoparcial = new ArrayList<RecursoInstalacion>();
		recurso = new Recurso();
		recursoInstalacion = new RecursoInstalacion();
		instalacionDao = new InstalacionDao();
		recursoDao = new RecursoDao();
		recursoInstalacionDao = new RecursoInstalacionDao();
		tipoInstalacionDao = new TipoInstalacionDao();
		allTipoInstalacion = tipoInstalacionDao.obtenerTodos();
		allRecurso = recursoDao.obtenerTodos();
		allRecursoInstalacion = recursoInstalacionDao.obtenerTodos();
		//this.allRecursoparcial2 = instalacion.getRecursoInstalacions();
	}

	public Set<RecursoInstalacion> getAllrecursoi() {

		return new HashSet<RecursoInstalacion>(allRecursoparcial2);
	}
	public ListModelList<TipoInstalacion> getAllTipoInstalacion() {

		return new ListModelList<TipoInstalacion>(allTipoInstalacion);
	}
	public List<RecursoInstalacion> getAllRecursoInstalacion() {

		return new ListModelList<RecursoInstalacion>(allRecursoparcial);
	}
	public ListModelList<Recurso> getAllRecurso() {

		return new ListModelList<Recurso>(allRecurso);
	}
	public ListModelList<RecursoInstalacion> getAllRecursoParcial() {

		return new ListModelList<RecursoInstalacion>(allRecursoparcial);
	}
	public ListModelList<RecursoInstalacion> getRecursosinstalacion() throws Exception{
		ArrayList<RecursoInstalacion> recursosMostrar = new ArrayList<RecursoInstalacion>();
		for(RecursoInstalacion recursoInstalacion: recursosinstalacion){
			if(recursoInstalacion.isActivo())
				recursosMostrar.add(recursoInstalacion);
		}
		return new ListModelList<RecursoInstalacion>(recursosMostrar);
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	public RecursoInstalacion getRecursoInstalacion() {
		return recursoInstalacion;
	}

	public void setRecursoInstalacion(RecursoInstalacion recursoInstalacion) {
		this.recursoInstalacion = recursoInstalacion;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	public Set<RecursoInstalacion> getallrecursopacial2(){
		return allRecursoparcial2;
	}
	public void setAllrecursopacial2(Set<RecursoInstalacion> recursoInstalacion){
		this.allRecursoparcial2 = allRecursoparcial2;
	}
	public ArrayList<RecursoInstalacion> getTemporalrecursos() {

		return temporalRecurso;
	}

	public void setTemporalRecurso(ArrayList<RecursoInstalacion> temporalRecurso) {
		this.temporalRecurso = temporalRecurso;
	}
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	@Command
	@NotifyChange("uploadedImage")
	public void upload(@BindingParam("media") Media myMedia){
		imagenNueva=true;
		uploadedImage = myMedia;
	}

	public Media getUploadedImage() {
		return uploadedImage;
	}


	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}
//	@Command
//	@NotifyChange({"allRecursoparcial2","recurso"})
//	public void guardarRecursoInstalacion() {
//		if(this.recurso.getDescripcion()!=null){
//			for (RecursoInstalacion r: this.allRecursoparcial2) {
//				if( r.getIdRecursoInstalacion()==this.recurso.getIdRecurso())
//					return;
//			}
//			this.recursoInstalacion.setInstalacion(instalacion);
//			this.allRecursoparcial2.add(this.recursoInstalacion);
//			this.recurso = new Recurso();
//
//			System.out.println(instalacion.getRecursoInstalacions());
//		}
//	}
	@Command
	@NotifyChange({ "recursosInstalacion", "recursoInstalacion" })
	public void guardarRecursoInstalacion() {
	
	if (this.recursoInstalacion.getRecurso() != null) {
			for (RecursoInstalacion recursoInstalacion : recursosinstalacion) {
				if (recursoInstalacion.getRecurso().getIdRecurso() == this.recursoInstalacion.getRecurso().getIdRecurso()){
					Messagebox.show(
							"Recurso seleccionado previamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
					return;
				}
					
			}
			this.recursoInstalacion.setInstalacion(instalacion);
			recursosinstalacion.add(this.recursoInstalacion);
			this.recursoInstalacion = new RecursoInstalacion();
			
	}else{
		Messagebox.show(
				"Seleccione al menos un recurso", "",
				Messagebox.OK, Messagebox.INFORMATION);
	}
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (instalacion.getDescripcion() != null
				&& instalacion.getNombre() != null
				&& instalacion.getTipoInstalacion() != null
				&& instalacion.getCapacidad() != 0
				&& instalacion.getPrecioAlquiler() != 0
				&& !instalacion.getDescripcion().equalsIgnoreCase("")
				&& !instalacion.getNombre().equalsIgnoreCase("")) {
			if (instalacionDao.obtenerInstalacion(instalacion.getIdInstalacion()) == null) {
			if (!editable) {
				this.instalacion.setRecursoInstalacions(this.recursosinstalacion);
				instalacionDao.agregarInstalacion(this.instalacion);
//				for(RecursoInstalacion r : recursosinstalacion){
//					r.setInstalacion(instalacion);
//					recursoInstalacionDao.agregarRecursoInstalacion(r);
//					
//				}
//				for (int i = 0; i < allRecursoparcial.size(); i++) {
//					recursoInstalacion.setInstalacion(instalacion);
//					recursoInstalacionDao.agregarRecursoInstalacion(recursoInstalacion);
//					
//				}
				Messagebox.show(
						"La instalacion " + instalacion.getNombre()
								+ " ha sido registrada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
				
			} else {
				instalacionDao.actualizarInstalacion(instalacion);
				Messagebox.show(
						"La instalacion " + instalacion.getNombre()
								+ " ha sido actualizada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			}
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshInstalacion", null);
			}else {
				Messagebox.show("Instalacion con el Nombre "
						+ instalacion.getNombre() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			}

		}

//	@Command
//	@NotifyChange({ "allRecursoparcial" })
//	public void guardarRecursoInstalacion(@BindingParam("win") Window win) throws Exception {
//		
//		//Set<RecursoInstalacion> tmp = new HashSet<RecursoInstalacion>();
//		recursoInstalacion = new RecursoInstalacion();
//		//recursoInstalacion.setIdRecursoInstalacion(0);
//		recursoInstalacion.setRecurso(recurso);
//		recursoInstalacion.setCantidad(cantidad);
//		allRecursoparcial.add(recursoInstalacion);
////		for(RecursoInstalacion ri : getTemporalrecursos()){
////			tmp.add(ri);
////		}
//		//setAllrecursopacial2(tmp);
//		for(RecursoInstalacion ri : allRecursoparcial ){
//			System.out.println(ri.getRecurso().getDescripcion() + ri.getCantidad() + "|");
//		}
////		recursoInstalacion = new RecursoInstalacion();
////		recursoInstalacion.setRecurso(recurso);
////		recursoInstalacion.setCantidad(cantidad);
////		allRecursoparcial.add(recursoInstalacion);
////		for(RecursoInstalacion rp : allRecursoparcial){
////			System.out.println(rp.getRecurso().getDescripcion());
////			System.out.println(rp.getCantidad());
////			
////		}
////		System.out.println(allRecursoparcial);
////		BindUtils.postGlobalCommand(null, null, "refreshParical", null);
////		
//		
//					
//	} 	
//	@GlobalCommand
//	@NotifyChange({ "allRecursoparcial" })
//	public List<RecursoInstalacion> refreshParical() {
//		System.out.println(allRecursoparcial);
//		return allRecursoparcial;
//		
//	}
}
