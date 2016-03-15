package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import modelos.Postulacion;
import Dao.PostulacionDao;

public class OpinionesPostulantesViewModel {
	private List<Postulacion> postulaciones;
	private PostulacionDao postulacionDao;
	private String nombreFiltro;
	
	@Init
	public void init() throws Exception{
		this.postulacionDao= new PostulacionDao();
		this.postulaciones=postulacionDao.obtenerTodos();
	}
	
	public ListModelList<Postulacion> getPostulacionesAll(){
		return new ListModelList<Postulacion>(this.postulaciones);
	}
	
	public String getCantidadPostulaciones(){
		return this.postulaciones.size()+" items en la lista";
	}
	
	@Command
	public void agregarOpinion(@BindingParam("Postulacion") Postulacion postulacion){
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("Postulacion", postulacion);
    	Window window = (Window)Executions.createComponents("socio/buzon/registrarOpinion.zul", null, args);
        window.doModal();
	}
	
	public String getNombreFiltro() {
		if(nombreFiltro==null)
			return "";
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro==null?"":nombreFiltro.trim();
	}
	
	@Command
	@NotifyChange({ "postulacionesAll", "cantidadRegistros" })
	public void filtro() throws Exception {
		List<Postulacion> tip = new ArrayList<Postulacion>();
		String primerNom = getNombreFiltro().toLowerCase();
		
		for (Iterator<Postulacion> i = postulacionDao.obtenerTodos().iterator(); i.hasNext();) {
			Postulacion tmp = i.next();
				if (tmp.getPostulado().getPersona().getNombre().toLowerCase().contains(primerNom) ||
					tmp.getPostulado().getPersona().getApellido().toLowerCase().contains(primerNom)){
						tip.add(tmp);
				}
		}
		this.postulaciones = tip;
	}
	
	@GlobalCommand
	@NotifyChange({ "postulacionesAll", "cantidadPostulaciones" })
	public void refreshPostulaciones() throws Exception{
		postulaciones = postulacionDao.obtenerTodos();
	}
	
	@Command
	public void showDatosPostulante(@BindingParam("Postulacion") Postulacion postulacion) {
		// create a window programmatically and use it as a modal dialog.
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("Postulacion", postulacion);
    	args.put("verDatos", true);
		Window window = (Window) Executions.createComponents("socio/administrarSocio/opinionesPostulante.zul", null,
				args);
		window.doModal();
	}
	
}
