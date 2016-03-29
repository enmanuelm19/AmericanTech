package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import modelos.Postulacion;
import Dao.PersonaDao;
import Dao.PostulacionDao;
import Dao.PostuladoDao;

public class PostulantesViewModel {
	private PostulacionDao postDAO= new PostulacionDao();
	private String nombreFiltro;
	private String apellidoFiltro;
	private List<Postulacion> postulaciones;
	private PersonaDao pdao;
	private PostuladoDao podao;
	@Init
	public void init() throws Exception {
		postulaciones = postDAO.obtenerTodos();
		pdao= new PersonaDao();
		podao= new PostuladoDao();
	}
	
	public ListModelList<Postulacion> getPostulacionesAll() {
		 return new ListModelList<Postulacion>(postulaciones);
	}
	
	public String getCantidadRegistros(){
		return postulaciones.size() + " items en la lista";
	}
	
	
	public String getNombreFiltro() {
		if(nombreFiltro==null)
			return "";
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro==null?"":nombreFiltro.trim();
	}

	public String getApellidoFiltro() {
		if(apellidoFiltro==null)
			return "";
		return apellidoFiltro;
	}

	public void setApellidoFiltro(String apellidoFiltro) {
		this.apellidoFiltro = apellidoFiltro==null?"":apellidoFiltro.trim();
	}
	
	
	@Command
	@NotifyChange({ "postulacionesAll", "cantidadRegistros" })
	public void filtro() throws Exception {
		List<Postulacion> tip = new ArrayList<Postulacion>();
		String primerNom = getNombreFiltro().toLowerCase();
		String primerApell = getApellidoFiltro().toLowerCase();
		
		for (Iterator<Postulacion> i = postDAO.obtenerTodos().iterator(); i.hasNext();) {
			Postulacion tmp = i.next();
				if (tmp.getPostulado().getPersona().getNombre().toLowerCase().contains(primerNom) &&
					tmp.getPostulado().getPersona().getApellido().toLowerCase().contains(primerApell)){
						tip.add(tmp);
				}
		}
		this.postulaciones = tip;
	}
	
	@Command
	public void showModalOpiniones(@BindingParam("Postulacion") Postulacion postulacion) {
		// create a window programmatically and use it as a modal dialog.
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("Postulacion", postulacion);
    	args.put("verDatos", false);
		Window window = (Window) Executions.createComponents("socio/administrarSocio/opinionesPostulante.zul", null,
				args);
		window.doModal();
	}
	
	@Command
	public void abrirRegistroSocio(@BindingParam("Postulacion") Postulacion postulacions){
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("Postulacion", postulacions);
		Window window = (Window) Executions.createComponents("socio/administrarSocio/registrarSocio.zul", null, args);
		window.doModal();
	}
	
	@GlobalCommand
	@NotifyChange({ "postulacionesAll", "cantidadRegistros" })
	public void refreshPostulantes() throws Exception{
		postulaciones = postDAO.obtenerTodos();
	}
	
	@Command
	public void cancelarPostulacion(@BindingParam("Postulacion") final Postulacion postulacions) throws Exception{
		
		Messagebox.show("Estas seguro de eliminar la postulaci�n", "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {Messagebox.show("La postulaci�n ha sido eliminada", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
							pdao.eliminarPersona(postulacions.getPostulado().getPersona());
							podao.eliminarPostulado(postulacions.getPostulado());
							postulacions.setAprobado(false);
							postDAO.eliminarPostulacion(postulacions);	
							BindUtils.postGlobalCommand(null, null, "refreshPostulantes", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(),"No se pudo eliminar la postulaci�n",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});

	}
}
