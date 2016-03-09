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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


import Dao.RecursoDao;
import Dao.RecursoInstalacionDao;
import Dao.TipoInstalacionDao;
import Dao.InstalacionDao;
import modelos.Instalacion;
import modelos.TipoInstalacion;
import modelos.RecursoInstalacion;
import modelos.Recurso;

public class RegistrarInstalacionViewModel {

	private Instalacion instalacion;
	private boolean editable;
	private InstalacionDao instalacionDao;
	private List<TipoInstalacion> allTipoInstalacion;
	private TipoInstalacionDao tipoInstalacionDao;
	private List<Recurso> allRecurso;
	private Recurso recurso;
	private RecursoDao recursoDao;
	private RecursoInstalacion recursoInstalacion;
	private RecursoInstalacionDao recursoInstalacionDao;
	private List<RecursoInstalacion> allRecursoInstalacion;
	private List<RecursoInstalacion> allRecursoparcial;
	private int cantidad;

	@Init
	public void init(@ExecutionArgParam("instalacion") Instalacion instalacion)
			throws Exception {
		if (instalacion == null) {
			this.instalacion = new Instalacion();
			this.editable = false;
		} else {
			this.instalacion = instalacion;
			this.editable = true;
		}
		allRecursoparcial = new ArrayList<RecursoInstalacion>();
		recurso = new Recurso();
		recursoInstalacion = new RecursoInstalacion();
		instalacionDao = new InstalacionDao();
		recursoDao = new RecursoDao();
		recursoInstalacionDao = new RecursoInstalacionDao();
		tipoInstalacionDao = new TipoInstalacionDao();
		allTipoInstalacion = tipoInstalacionDao.obtenerTodos();
		allRecurso = recursoDao.obtenerTodos();
		allRecursoInstalacion = recursoInstalacionDao.obtenerTodos();
	}

	public ListModelList<TipoInstalacion> getAllTipoInstalacion() {

		return new ListModelList<TipoInstalacion>(allTipoInstalacion);
	}
	public List<RecursoInstalacion> getAllRecursoInstalacion() {

		return new ListModelList<RecursoInstalacion>(allRecursoparcial);
	}
	public ListModelList<Recurso> getAllRecurso() {

		return new ListModelList<Recurso>(allRecurso);
	}
	public ListModelList<RecursoInstalacion> getAllRecursoParcial() {

		return new ListModelList<RecursoInstalacion>(allRecursoparcial);
	}

	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	public RecursoInstalacion getRecursoInstalacion() {
		return recursoInstalacion;
	}

	public void setRecursoInstalacion(RecursoInstalacion recursoInstalacion) {
		this.recursoInstalacion = recursoInstalacion;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (instalacion.getDescripcion() != null
				&& instalacion.getNombre() != null
				&& instalacion.getTipoInstalacion() != null
				&& instalacion.getCapacidad() != 0
				&& instalacion.getPrecioAlquiler() != 0
				&& !instalacion.getDescripcion().equalsIgnoreCase("")
				&& !instalacion.getNombre().equalsIgnoreCase("")) {
			if (instalacionDao.obtenerInstalacion(instalacion.getIdInstalacion()) == null) {
			if (!editable) {
				instalacionDao.agregarInstalacion(instalacion);
				for (int i = 0; i < allRecursoparcial.size(); i++) {
					recursoInstalacion.setInstalacion(instalacion);
					recursoInstalacionDao.agregarRecursoInstalacion(recursoInstalacion);
					System.out.println(
							recursoInstalacion.getRecurso().getDescripcion() + "-"
							+recursoInstalacion.getCantidad() + "|");
				}
				Messagebox.show(
						"La instalacion " + instalacion.getNombre()
								+ " ha sido registrada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
				
			} else {
				instalacionDao.actualizarInstalacion(instalacion);
				Messagebox.show(
						"La instalacion " + instalacion.getNombre()
								+ " ha sido actualizada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			}
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshInstalacion", null);
			}else {
				Messagebox.show("Instalacion con el Nombre "
						+ instalacion.getNombre() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			}

		}
	@Command
	public void guardarRecursoInstalacion(@BindingParam("win") Window win) throws Exception {
		
		
		recursoInstalacion = new RecursoInstalacion();
		recursoInstalacion.setRecurso(recurso);
		recursoInstalacion.setCantidad(cantidad);
		allRecursoparcial.add(recursoInstalacion);
		for (int i = 0; i < allRecursoparcial.size(); i++) {
			
			System.out.println(
					recursoInstalacion.getRecurso().getDescripcion() + "-"
					+recursoInstalacion.getCantidad() + "|");
		}
		
		

					
		} 
	@GlobalCommand
	@NotifyChange({ "allRecursoparcial" })
	public void refreshParical() throws Exception {
		allRecursoparcial =   recursoInstalacionDao.obtenerTodos();
	}
}
