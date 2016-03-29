package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import models.Funcion;

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

import Dao.GrupoDao;
import modelos.Grupo;

public class GrupoViewModel {
	private Grupo grupo = new Grupo();
	private List<Grupo> grupos;
	private GrupoDao grupoDao;
	private List<Funcion> funcionAll;
	private boolean verFunciones=false;
	private String descFiltro;
	
	@Init
	public void init() throws Exception{
		grupos = new ArrayList<Grupo>();
		grupoDao = new GrupoDao();
		grupos = grupoDao.obtenerTodos();
	}
	
	public String getDescFiltro() {
		if(descFiltro==null)
			return "";
		return descFiltro;
	}

	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}

	//Metodo que se llama para llenar la grid
    public ListModelList<Grupo> getGruposAll() {
		return new ListModelList<Grupo>(grupos);
	}
    public ListModelList<Funcion> getFuncionAll(){
    	return new ListModelList<Funcion>(funcionAll);
    }
    public Grupo getGrupo(){
    	return grupo;
    }
    
	public String getCantRegistros(){
		return grupos.size() + " items en la lista";
	}
	 
	 @Command
		@NotifyChange({ "gruposAll", "cantRegistros" })
		public void filtro() throws Exception {
			List<Grupo> tip = new ArrayList<Grupo>();
			String desc = getDescFiltro().toLowerCase();
			for (Iterator<Grupo> i = grupoDao.obtenerTodos().iterator(); i.hasNext();) {
				Grupo tmp = i.next();
				if (tmp.getDescripcion().toLowerCase().contains(desc)) {
					tip.add(tmp);
				}
			}
			grupos = tip;
		}
	 
		@Command
		public void showModal(@BindingParam("Grupo") Grupo grupo) {
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("Grupo", grupo);
			Window window = (Window) Executions.createComponents("administracion/seguridad/registrarGrupo.zul",
					null, args);
			window.doModal();
		}
		
		@Command
		@NotifyChange({ "gruposAll", "cantRegistros" })
		public void eliminar(@BindingParam("Grupo") final Grupo grupo) {

			Messagebox.show("Estas seguro de eliminar " + grupo.getDescripcion(), "Confirmar",
					Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event evt) throws InterruptedException {
							if (evt.getName().equals("onOK")) {
								try {
									grupoDao.eliminarGrupo(grupo);
									grupos = grupoDao.obtenerTodos();
									Messagebox.show(grupo.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
									BindUtils.postGlobalCommand(null, null, "refreshGrupos", null);
								} catch (Exception e) {
									Messagebox.show(e.getMessage()+ " " + grupo.getDescripcion() +" no se pudo eliminar", "American Tech", Messagebox.OK, Messagebox.ERROR);
								}
							}
						}
					});
		}
		
		@GlobalCommand
		@NotifyChange({ "gruposAll", "cantRegistros" })
		public void refreshGrupos() throws Exception {
			grupos = grupoDao.obtenerTodos();
		}
}
