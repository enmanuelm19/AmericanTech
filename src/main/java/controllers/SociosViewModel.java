package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import Dao.SocioDao;
import modelos.Accion;
import modelos.Postulacion;
import modelos.Socio;

public class SociosViewModel {
	private List<Socio> socios;
	private SocioDao socioDao;
	private String cedulaFiltro;
	private String nombreFiltro;
	private String apellidoFiltro;
	
	@Init
	public void init() throws Exception{
		this.socioDao= new SocioDao();
		this.socios= socioDao.obtenerTodos();
	}
	
	public ListModelList<Socio> getSociosAll(){
		return new ListModelList<Socio>(socios);
	}
	
	public String getCantidadSocios(){
		return socios.size() + " items en la lista";
	}
	
	public String getCedulaFiltro() {
		if(cedulaFiltro==null)
			return "";
		return cedulaFiltro;
	}

	public void setCedulaFiltro(String cedulaFiltro) {
		this.cedulaFiltro = cedulaFiltro==null?"":cedulaFiltro.trim();
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
	@NotifyChange({ "sociosAll", "cantidadSocios" })
	public void filtro() throws Exception {
		List<Socio> tip = new ArrayList<Socio>();
		String primerNom = getNombreFiltro().toLowerCase();
		String primerApell = getApellidoFiltro().toLowerCase();
		String cedula=getCedulaFiltro();
		
		for (Iterator<Socio> i = socioDao.obtenerTodos().iterator(); i.hasNext();) {
			Socio tmp = i.next();
				if (tmp.getPersona().getIdentificacion().toLowerCase().contains(cedula) &&
					tmp.getPersona().getNombre().toLowerCase().contains(primerNom) &&
					tmp.getPersona().getApellido().toLowerCase().contains(primerApell)){
						tip.add(tmp);
				}
		}
		this.socios = tip;
	}
	
	@Command
	public void showModalAfiliados(@BindingParam("socio") Socio socio){
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("socioss", socio);
		 Window window = (Window)Executions.createComponents("socio/administrarSocio/registrarAfiliadoSocio.zul", null, args);
		 window.doModal();
	 }
	
	
	@Command
	public void showModalAccionesSocios(@BindingParam("Socio") Socio socio){
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("Socio", socio);
		Window window = (Window)Executions.createComponents("socio/administrarSocio/accionesSocio.zul", null, args);
		window.doModal();

	 }

}
