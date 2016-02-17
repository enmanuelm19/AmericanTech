package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import models.TipoSugerencia;
import service.TipoSugerenciaService;

public class TipoSugerenciaViewModel{

	
	private TipoSugerencia seleccionado; 								
	private boolean editar = false; 
	private List<TipoSugerencia> tiposAll; 
	private TipoSugerencia tipoS;

	public TipoSugerenciaViewModel() {	
		tipoS = new TipoSugerencia(); 
		tiposAll = new ArrayList<TipoSugerencia>();
		tiposAll = TipoSugerenciaService.getTipoSugerencia();
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	// M�todo para mostrar el formulario de registro
	@Command
	public void showModal() {
		this.tipoS = new TipoSugerencia();
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoSugerencia.zul", null,
				null);
		window.doModal();
	}

	// M�todo que gestiona la visualizaci�n de la grid edici�n
	public boolean getActivarEdicion() {
		return this.editar;
	}

	// M�todo que retorna todos los registros. este metodo se llamara en la
	// grid.
	public List<TipoSugerencia> getAllTipoSugerencia() {
		
		System.out.println("entro");
		
		return new ListModelList<TipoSugerencia>(tiposAll);
	}


	// M�todo de conteo de registros, llamado en el footer de la grid
	public String getCantRegistros() {
		return tiposAll.size() + " items en la lista";
	}

	public TipoSugerencia getTipoS() {
		return tipoS;
	}

	public void setTipoS(TipoSugerencia tipoS) {
		this.tipoS = tipoS;
	}

	/**************************** AGREGAR *************************/
	@Command
	@NotifyChange({ "allTipoSugerencia", "cantRegistros" })
	public void agregarTipoSugerencia(@BindingParam("win") Window win) {
		if (tipoS.getDescripcion() != null && !tipoS.getDescripcion().equalsIgnoreCase("")) {
			TipoSugerenciaService.agregarTipoSugerencia(this.tipoS);
			win.detach();
			tiposAll = TipoSugerenciaService.getTipoSugerencia();
		}
	}

	/**************************** EDICION *************************/
	// Metodo activado cuando selecciono la opcion editar
	@Command
	@NotifyChange({ "seleccionEdicion", "activarEdicion" })
	public void seleccionEdicion(@BindingParam("Tipo") TipoSugerencia tipo) {
		this.seleccionado = tipo; // guardo temporalmente el registro a editar
		this.editar = true;
	}

	// M�todo que retorna el registro a editar
	public TipoSugerencia getSeleccionEdicion() {
		return this.seleccionado;
	}

	// M�todo activado cuando cancelo la edici�n
	@Command
	@NotifyChange({ "activarEdicion" })
	public void cancelarEdicion() {
		this.editar = false;
		this.seleccionado = new TipoSugerencia();
	}

	@Command
	@NotifyChange({ "allTipoSugerencia", "activarEdicion" })
	public void guardarEdicion(@BindingParam("Tipo") TipoSugerencia tipo) {
		this.editar = false;
	}

	/*****************************
	 * ELIMINAR REGISTRO
	 *****************************/

	@Command
	@NotifyChange({ "allTipoSugerencia", "cantRegistros" })
	public void eliminarTipo(@BindingParam("Tipo") TipoSugerencia tipo) {
		tipo.setEstatus("E");
		TipoSugerenciaService.updateTipoSugerencia(tipo);
		tiposAll = TipoSugerenciaService.getTipoSugerencia();
	}

	/********************************** FILTRO **********************************/
	@Command
	@NotifyChange({ "allTipoSugerencia", "cantRegistros" })
	public void filtroTipo() {
		List<TipoSugerencia> tip = new ArrayList<TipoSugerencia>();
		String desc = tipoS.getDescFiltro().toLowerCase();
		
		
		for (Iterator<TipoSugerencia> i = TipoSugerenciaService.getTipoSugerencia().iterator(); i.hasNext();) {
			TipoSugerencia tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}
	
}
