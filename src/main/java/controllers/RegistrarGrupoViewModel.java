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
	private Set<FuncionGrupo> funciones;
	private FuncionGrupoDao funcionGrupoDao;
	private List<Funcion> funcionesAll;
	private FuncionDao funcionDao;
	private Funcion funcionSeleccionada;
	
	@Init
	public void init(@ExecutionArgParam("Grupo") Grupo group) {
		this.funciones = new HashSet<FuncionGrupo>();
		if (group == null) {
			this.grupo = new Grupo();
			this.editable = false;
			this.funciones = grupo.getFuncionGrupos();
		} else {
			this.grupo = group;
			this.editable = true;
			setFunciones(grupo.getFuncionGrupos());
			funciones = getFunciones();
					
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
				grupo.setFuncionGrupos(funciones);
				grupoDao.agregarGrupo(grupo);
			}
			else {
				grupo.setFuncionGrupos(funciones);
				grupoDao.actualizarGrupo(grupo);
			}
				
			win.detach();
			Messagebox.show("Usuario " + grupo.getDescripcion() + " agregado satisfactoriamente!", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			BindUtils.postGlobalCommand(null,null,"refreshGrupos",null);
		}
		
		
	}
	
	@Command
	@NotifyChange({"funciones", "cantRegistros"})
	public void eliminarFuncion(@BindingParam("Funcion") final FuncionGrupo funcion){
		System.out.println(funcion.getIdFuncionGrupo());
		Messagebox.show("Estas seguro de eliminar " + funcion.getFuncion().getNombre() + " del grupo", "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								if(funcion.getIdFuncionGrupo() == 0){
									funciones.remove(funcion);
									BindUtils.postGlobalCommand(null, null, "refreshFuncionesGrupo", null);
								}else{
								funcion.setActivo(false);
								funcionGrupoDao.eliminarFuncionGrupo(funcion);
								}
								Messagebox.show(funcion.getFuncion().getNombre() + " ha sido eliminado", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshFuncionesGrupo", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage()+ " " + funcion.getFuncion().getNombre() + " no se pudo eliminar", "American Tech", Messagebox.OK, Messagebox.ERROR);
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

	public Set<FuncionGrupo> getFunciones() {
		Set<FuncionGrupo> tmp =  new HashSet<FuncionGrupo>();
		for(FuncionGrupo f: funciones){
			if(f.isActivo()){
				tmp.add(f);
			}
		}
		funciones = tmp;
		return funciones;
	}

	public void setFunciones(Set<FuncionGrupo> funciones) {
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
		funciones = this.getFunciones();
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
	public void agregarFuncion() throws Exception{
		FuncionGrupo funcGrupo = new FuncionGrupo();
		boolean existe = false;
		funcGrupo.setGrupo(grupo);
		for(FuncionGrupo f : funciones){
			if(funcionSeleccionada.getIdFuncion() == f.getFuncion().getIdFuncion()){
				Messagebox.show("Esta funcion ya pertenece al grupo seleccionado", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
				existe = true;
				break;
			}
		}
		if(existe == false){
			if (funcionSeleccionada == null) {
				Messagebox.show("Por favor seleccione una funcion", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			}else{
				funcGrupo.setFuncion(funcionSeleccionada);
				funcGrupo.setActivo(true);
				funciones.add(funcGrupo);
				Messagebox.show("Funcion " + funcionSeleccionada.getNombre() + " agregada satisfactoriamente!", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			}
		}
		
		BindUtils.postGlobalCommand(null, null, "refreshFuncionesGrupo", null);
		
	}
}
