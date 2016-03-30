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
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


import Dao.RecursoDao;
import Dao.RecursoInstalacionDao;
import Dao.TipoInstalacionDao;
import Dao.FotoDao;
import Dao.InstalacionDao;
import modelos.Foto;
import modelos.IndicadorEvento;
import modelos.Instalacion;
import modelos.TipoInstalacion;
import util.ManejadorArchivo;
import modelos.RecursoInstalacion;
import modelos.RedClub;
import modelos.Recurso;

public class RegistrarInstalacionViewModel {

	private Instalacion instalacion;
	private boolean editable;
	private boolean fotodefault;
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
	private List<Media> allfotoinstalacion;
	private List<Foto> allfotoEditable;
	private boolean imagenNueva = false;
	private FotoDao fotosInstDao;
	
	@Init
	public void init(@ExecutionArgParam("instalacion") Instalacion instalacion)
			throws Exception {
		fotosInstDao = new FotoDao();
		allfotoinstalacion = new ArrayList<Media>();
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
		
		if (instalacion == null) {
			this.instalacion = new Instalacion();
			recursosinstalacion = new HashSet<RecursoInstalacion>();
			this.editable = false;
			allfotoEditable = new ArrayList<Foto>();
			alquilable = false;
			
		} else {
			this.instalacion = instalacion;
			recursosinstalacion = instalacion.getRecursoInstalacions();
			this.editable = true;
			if (instalacion.isAlquilable()){
				alquilable = true;
			}else{
				alquilable = false;
			}
			
			allfotoEditable = fotosInstDao.obtenerFotoinstalacion(instalacion);
			
		}
		if(allfotoinstalacion.isEmpty()){
			fotodefault = true;
			System.out.println(allfotoinstalacion.isEmpty());
			System.out.println(fotodefault);
		}else{
			fotodefault = false;
		}
		
		
		

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
	public ListModelList<Media> getAllfotoinstalacion() {
		//Obtengo la lista MEDIA para que sea visible al crear
		return new ListModelList<Media>(allfotoinstalacion);
	}
	public ListModelList<Foto> getFotoEditable() {
		
		return new ListModelList<Foto>(allfotoEditable);
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
	public boolean isFotodefault() {
		return fotodefault;
	}

	public void setFotodefault(boolean fotodefault) {
		this.fotodefault = fotodefault;
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
	@GlobalCommand
	@NotifyChange("fotoEditable")
	public void refreshfotos() throws Exception{
		allfotoEditable = fotosInstDao.obtenerFotoinstalacion(instalacion);
	};
	boolean alquilable;
	public boolean isAlquilable() {
		return alquilable;
	}

	@Command
	@NotifyChange("alquilable")
	public void validaralquiler(){
		if(instalacion.isAlquilable()){
			alquilable = true;
		}else{
			alquilable = false;
		}
	}
	@Command
	@NotifyChange({"recursosinstalacion","recursoInstalacion"})
	public void eliminarRecursoInstalacion(@BindingParam("recursoInstalacion") RecursoInstalacion ri){
			recursosinstalacion.remove(ri);
			Messagebox.show("El recurso " + ri.getRecurso().getDescripcion() +" se ha eliminado para esta instalación", "American Tech",
					Messagebox.OK, null );
	}

	
	@Command
	@NotifyChange({"uploadedImage","allfotoinstalacion","fotodefault"})
	public void upload(@BindingParam("media") final Media myMedia) throws Exception{
		if(!editable){
			if(myMedia instanceof org.zkoss.image.Image){
				if(myMedia.getByteData().length > 2000*1024){
					Messagebox.show("Escoja una imagen de menor tamaño", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
				}else{
					imagenNueva=true;
					uploadedImage = myMedia;
					allfotoinstalacion.add(uploadedImage);
					fotodefault = false;
					System.out.println(fotodefault);
				}
			}else{
				Messagebox.show("El archivo que intenta subir no es una imagen", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			}

		}else{
			Messagebox.show("Imagen subida con exito para la instalación " + instalacion.getNombre(), "American Tech",
					Messagebox.OK , Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event evt) throws InterruptedException {
							if (evt.getName().equals("onOK")) {
								try {
									System.out.println(instalacion.getIdInstalacion());
									Foto foto = new Foto();
									foto.setInstalacion(instalacion);
									
									foto.setPublico(true);
									foto.setActivo(true);
									foto.setUrl(ManejadorArchivo.subirImagen(myMedia));
									fotosInstDao.agregarFoto(foto);
								
									BindUtils.postGlobalCommand(null, null, "refreshfotos", null);
								} catch (Exception e) {
									Messagebox.show(e.getMessage(), "Error al cargar la imagen",
											Messagebox.OK, Messagebox.ERROR);
								}
							}
						}
					});
			
		};
		
	}

	public Media getUploadedImage() {
		return uploadedImage;
	}


	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}
	public String getCantRecursoInstalacion() {
		return recursosinstalacion.size()+ " items en la lista";
	}
	@Command
	@NotifyChange({ "recursosinstalacion" })
	public void guardarRecursoInstalacion() {
	
	if (this.recursoInstalacion.getRecurso() != null) {
		if(this.recursoInstalacion.getCantidad() <= 0){
			Messagebox.show("La cantidad de recursos debe ser mayor a 0",
					"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}else{
			for (RecursoInstalacion recursoInstalacion : recursosinstalacion) {
			if (recursoInstalacion.getRecurso().getIdRecurso() == this.recursoInstalacion.getRecurso().getIdRecurso()){
				Messagebox.show(
						"Recurso seleccionado previamente", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
				return;
			}
				
		}
		this.recursoInstalacion.setActivo(true);
		this.recursoInstalacion.setInstalacion(instalacion);
		recursosinstalacion.add(this.recursoInstalacion);
		this.recursoInstalacion = new RecursoInstalacion();
		
		}

	}else{
		Messagebox.show(
				"Seleccione al menos un recurso", "American Tech",
				Messagebox.OK, Messagebox.INFORMATION);
	}
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (instalacion.getDescripcion() != null
				&& instalacion.getNombre() != null
				&& instalacion.getTipoInstalacion() != null
				&& instalacion.getCapacidad() != 0
				&& !instalacion.getDescripcion().equalsIgnoreCase("")
				&& !instalacion.getNombre().equalsIgnoreCase("")) {

			if (!editable) {
				if (instalacionDao.obtenerInstalacion(instalacion.getIdInstalacion()) == null) {
				this.instalacion.setRecursoInstalacions(this.recursosinstalacion);
				instalacionDao.agregarInstalacion(this.instalacion);
				for(Media m: allfotoinstalacion){
					Foto foto = new Foto();
					foto.setInstalacion(instalacion);
					foto.setPublico(true);
					foto.setActivo(true);
					foto.setUrl(ManejadorArchivo.subirImagen(m));
					fotosInstDao.agregarFoto(foto);
					
				};

				Messagebox.show(
						"La instalacion " + instalacion.getNombre()
								+ " ha sido registrada exitosamente", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
			
				}else {
				
				Messagebox.show("Instalación con el Nombre "
						+ instalacion.getNombre() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
				
			} else {
				instalacionDao.actualizarInstalacion(instalacion);
				Messagebox.show(
						"La instalación " + instalacion.getNombre()
								+ " ha sido actualizada exitosamente", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
			}
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshInstalacion", null);

			}

		}


}
