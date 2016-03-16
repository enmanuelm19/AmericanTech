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
	
	@Command
	public void showModalRegistrarMienbroJunta(){
		Window window = (Window)Executions.createComponents("configuracion/registrarJuntaDirectiva.zul", null, null);
		window.doModal();
	}
	
	@GlobalCommand
	@NotifyChange({"juntaAll","cantidad"})
	public void refreshJuntas() throws Exception{
		this.juntas= juntaDao.obtenerTodos();
	}
	
	@Command
	public void agregarMiembro(@BindingParam("Junta") JuntaDirectiva j){
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("Junta", j);
		 Window window = (Window)Executions.createComponents("configuracion/registrarMiembroJunta.zul", null, args);
		 window.doModal();
	}
}
