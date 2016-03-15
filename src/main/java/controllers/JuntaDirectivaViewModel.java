package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import Dao.JuntaDirectivaDao;
import modelos.JuntaDirectiva;
import modelos.Socio;

public class JuntaDirectivaViewModel {
	private JuntaDirectiva juntaD;
	private JuntaDirectivaDao juntaDao;
	private List<JuntaDirectiva> juntas;
	
	@Init
	public void init() throws Exception{
		this.juntaD= new JuntaDirectiva();
		this.juntaDao= new JuntaDirectivaDao();
		this.juntas=juntaDao.obtenerTodos();
	}
	
	public ListModelList<JuntaDirectiva> getJuntaAll(){
		return new ListModelList<JuntaDirectiva>(this.juntas);
	}
	
	public String getCantidad(){
		return this.juntas.size() +" items en la lista";
	}

	public JuntaDirectiva getJuntaD() {
		return juntaD;
	}
	
	/*
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
	
/*	@Command
	@NotifyChange({ "sociosAll", "cantidadSocios" })
	public void filtro() throws Exception {
		List<JuntaDirectiva> tip = new ArrayList<JuntaDirectiva>();
		String primerNom = getNombreFiltro().toLowerCase();
		String primerApell = getApellidoFiltro().toLowerCase();
		String cedula=getCedulaFiltro();
		
		for (Iterator<JuntaDirectiva> i = juntaDao.obtenerTodos().iterator(); i.hasNext();) {
			JuntaDirectiva tmp = i.next();
			
				if (tmp.getPersona().getIdentificacion().toLowerCase().contains(cedula) &&
					tmp.getPersona().getNombre().toLowerCase().contains(primerNom) &&
					tmp.getPersona().getApellido().toLowerCase().contains(primerApell)){
						tip.add(tmp);
				}
		}
		this.socios = tip;
	}
	*/
	@Command
	public void showModalRegistrarMienbroJunta(){
		Window window = (Window)Executions.createComponents("configuracion/registrarMiembroJunta.zul", null, null);
		window.doModal();
	}
}
