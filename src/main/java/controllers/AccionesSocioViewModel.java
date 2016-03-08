package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import modelos.Accion;
import modelos.Socio;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import Dao.AccionDao;

public class AccionesSocioViewModel {
	private Set<Accion> acciones;
	private Socio socio;
	private String nroAccionFiltro;
	private AccionDao accionDAO;
	@Init
	public void init(@ExecutionArgParam("Socio") Socio socio){
		acciones=socio.getAccions();
		accionDAO= new AccionDao();
	}
	
	public ListModelList<Accion> getAccionSocio(){
		return new ListModelList<Accion>(this.acciones);
	}
	
	public String getCantidadAcciones(){
		return this.acciones.size() + " items en la lista";
	}
	

	public String getNroAccionFiltro() {
		if(nroAccionFiltro==null)
			return "";
		return nroAccionFiltro;
	}

	public void setNroAccionFiltro(String nroAccionFiltro) {
		this.nroAccionFiltro = nroAccionFiltro==null?"": nroAccionFiltro.trim();
	}
	@Command
	@NotifyChange({ "accionSocio", "cantidadAcciones" })
	public void filtro() throws Exception {
		Set<Accion> tip = new HashSet<Accion>();
		String nro= getNroAccionFiltro().toLowerCase();
		for (Iterator<Accion> i = accionDAO.obtenerTodos().iterator(); i.hasNext();) {
			Accion tmp = i.next();
				if (tmp.getNroAccion().toLowerCase().contains(nro)) {
						tip.add(tmp);
				}
		}
		this.acciones = tip;
	}

}
