package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Window;

import Dao.AlquilerDao;
import Dao.ReservacionDao;
import Dao.TipoPagoDao;
import modelos.Alquiler;
import modelos.Reservacion;
import modelos.Usuario;

public class MisAlquileresViewModel {
	private List<Alquiler> alquilerAll;
	private Alquiler alquilerSelected;
	private Usuario usuario;

	@Init
	public void init(@ExecutionArgParam("alquiler") Alquiler alquiler) {
		try {
			if (alquiler != null) {
				setAlquilerSelected(alquiler);
			}			
			Session session = Sessions.getCurrent();
			usuario = (Usuario) session.getAttribute("Usuario");
			getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Alquiler> getAlquilerAll() {
		if(alquilerAll == null){
			alquilerAll = new ArrayList<Alquiler>();
		}
		return alquilerAll;
	}

	public void setAlquilerAll(List<Alquiler> alquilerAll) {
		this.alquilerAll = alquilerAll;
	}

	public Alquiler getAlquilerSelected() {
		return alquilerSelected;
	}

	public void setAlquilerSelected(Alquiler alquilerSelected) {
		this.alquilerSelected = alquilerSelected;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Command
	public void showModal(@BindingParam("alquiler") Alquiler alquiler) {
		if (alquiler != null) {
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("alquiler", alquiler);
//			Window window = (Window) Executions.createComponents("instalacion/dialogo/registrarAlquiler.zul",
//					null, args);
//			window.doModal();
		}
	}

}
