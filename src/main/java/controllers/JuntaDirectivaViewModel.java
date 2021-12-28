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

import Dao.JuntaDirectivaDao;
import Dao.MiembroJuntaDao;
import modelos.JuntaDirectiva;
import modelos.MiembroJunta;
import modelos.Socio;

public class JuntaDirectivaViewModel {
	private JuntaDirectiva juntaD;
	private JuntaDirectivaDao juntaDao;
	private List<JuntaDirectiva> juntas;
	private MiembroJuntaDao miembroDao;
	
	@Init
	public void init() throws Exception{
		this.juntaD= new JuntaDirectiva();
		this.juntaDao= new JuntaDirectivaDao();
		this.juntas=juntaDao.obtenerTodos();
		this.miembroDao= new MiembroJuntaDao();
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
	
	@Command
	public void editarMiembro(@BindingParam("m") MiembroJunta m, @BindingParam("j") JuntaDirectiva j){
		Map<String, Object> args = new HashMap<String, Object>();
    	args.put("m", m);
    	args.put("Junta", j);
    	Window window = (Window)Executions.createComponents("configuracion/registrarMiembroJunta.zul", null, args);
		 window.doModal();
	}
	
	@Command
	public void eliminarMiembro(@BindingParam("m") final MiembroJunta m, @BindingParam("j") final JuntaDirectiva j){
		Messagebox.show("¿Estas seguro de eliminar el Miembro " + m.getPersona().getNombre()+" "+m.getPersona().getApellido()+"?", "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								j.getMiembroJuntas().remove(m);
								m.setActivo(false);
								m.setJuntaDirectiva(null);
								miembroDao.actualizarMiembroJunta(m);
								juntaDao.actualizarJuntaDirectiva(j);
								Messagebox.show("El miembro " + m.getPersona().getNombre()+" "+m.getPersona().getApellido()+" ha sido eliminado", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshJuntas", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), "El miembro " + m.getPersona().getNombre()+" "+m.getPersona().getApellido()+ " no se pudo eliminar", Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
			
	}
}
