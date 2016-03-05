package controllers;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.FuncionDao;
import Dao.FuncionGrupoDao;
import Dao.GrupoDao;
import modelos.Funcion;
import modelos.FuncionGrupo;
import modelos.Grupo;

public class RegistrarGrupoViewModel {
	
	private Grupo grupo;
	private boolean editable;
	private GrupoDao grupoDao;
	private List<FuncionGrupo> funciones;
	private FuncionGrupoDao funcionGrupoDao;
	private List<Funcion> funcionesAll;
	private FuncionDao funcionDao;
	private Funcion funcionSeleccionada;
	
	@Init
	public void init(@ExecutionArgParam("Grupo") Grupo group) {
		if (group == null) {
			this.grupo = new Grupo();
			this.editable = false;
		} else {
			this.grupo = group;
			this.editable = true;
			this.funciones = new ArrayList<FuncionGrupo>(grupo.getFuncionGrupos());
		}
		grupoDao = new GrupoDao();
		funcionGrupoDao = new FuncionGrupoDao();
		funcionDao = new FuncionDao();
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (grupo.getDescripcion() != null && !grupo.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable){
				grupo.setActivo(true);
				grupoDao.agregarGrupo(grupo);
			}
			else {
				grupoDao.actualizarGrupo(grupo);
			}
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshGrupos",null);
		}
		
		
	}
	
	@Command
	@NotifyChange({"funciones", "cantRegistros"})
	public void eliminarFuncion(@BindingParam("Funcion") final FuncionGrupo funcion){
		Messagebox.show("Estas seguro de eliminar " + funcion.getFuncion().getNombre() + "del grupo", "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								funcionGrupoDao.eliminarFuncionGrupo(funcion);;
								funciones = funcionGrupoDao.obtenerTodos();
								Messagebox.show(funcion.getFuncion().getNombre() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshFuncionesGrupo", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), funcion.getFuncion().getNombre() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public List<FuncionGrupo> getFunciones() {
		List<FuncionGrupo> tmp =  new ArrayList<FuncionGrupo>();
		for(FuncionGrupo f: funciones){
			if(f.isActivo()){
				tmp.add(f);
			}
		}
		funciones = tmp;
		return funciones;
	}

	public void setFunciones(List<FuncionGrupo> funciones) {
		this.funciones = funciones;
	}

	public String getCantRegistros() {
		if(funciones!=null){
		return funciones.size() + " items en la lista";
		}else{
			return "No hay items en la lista";
		}
	}
	
	@GlobalCommand
	@NotifyChange({ "funciones", "cantRegistros" })
	public void refreshFuncionesGrupo() throws Exception {
		funciones = new ArrayList<FuncionGrupo>(grupo.getFuncionGrupos());
	}

	public List<Funcion> getFuncionesAll() throws Exception {
		List<Funcion> tmp = new ArrayList<Funcion>();
		funcionesAll = funcionDao.obtenerTodos();
		for(Funcion f : funcionesAll){
			if(f.getPagina().equalsIgnoreCase(" ")){
				
			}else{
				tmp.add(f);
			}
		}
		return tmp;
	}

	public void setFuncionesAll(List<Funcion> funcionesAll) {
		this.funcionesAll = funcionesAll;
	}

	public Funcion getFuncionSeleccionada() {
		return funcionSeleccionada;
	}

	public void setFuncionSeleccionada(Funcion funcionSeleccionada) {
		this.funcionSeleccionada = funcionSeleccionada;
	}
	
	@Command
	@NotifyChange({"funciones", "cantRegistros"})
	public void agregarFuncion() throws Exception{
		FuncionGrupo funcGrupo = new FuncionGrupo();
		funcGrupo.setGrupo(grupo);
		funcGrupo.setFuncion(funcionSeleccionada);
		funcGrupo.setActivo(true);
		funcionGrupoDao.agregarFuncionGrupo(funcGrupo);
		BindUtils.postGlobalCommand(null, null, "refreshFuncionesGrupo", null);
		
	}
}
