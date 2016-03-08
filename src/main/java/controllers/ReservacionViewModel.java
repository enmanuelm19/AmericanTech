package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Dao.ReservacionDao;
import modelos.Reservacion;

public class ReservacionViewModel {
	
	private List<Reservacion> reservacionAll;
	private ReservacionDao reservacionDao;
	private String nombreFiltro;
	
	@Init
	public void init() throws Exception {
		reservacionDao = new ReservacionDao();
		getReservacionAll().addAll(reservacionDao.obtenerTodos());				
	}

	public List<Reservacion> getReservacionAll() {
		if(reservacionAll == null){
			reservacionAll = new ArrayList<Reservacion>();
		}
		return reservacionAll;
	}

	public void setReservacionAll(List<Reservacion> reservacionAll) {
		this.reservacionAll = reservacionAll;
	}

	public String getNombreFiltro() {
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro;
	}
	
	public String getCantRegistros() {
		return getReservacionAll().size() + " items en la lista";
	}
	
	@Command
	public void showModal(@BindingParam("reservacion") Reservacion reservacion) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("reservacion", reservacion);
		Window window = (Window) Executions.createComponents("instalacion/solicitudAlquiler.zul",
				null, args);
		window.doModal();
	}
	
	@Command
	@NotifyChange({ "reservacionAll", "cantRegistros" })
	public void eliminar(@BindingParam("reservacion") final Reservacion reservacion) {
		Messagebox.show("Estas seguro de eliminar " + reservacion.getIdReservacion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								reservacionDao.eliminarReservacion(reservacion);
								reservacionAll = reservacionDao.obtenerTodos();
								Messagebox.show(reservacion.getIdReservacion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshEventos", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), reservacion.getIdReservacion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
	@Command
	@NotifyChange({ "reservacionAll", "cantRegistros" })
	public void filtro() throws Exception {
		List<Reservacion> reservacion = new ArrayList<Reservacion>();
		String nomb = getNombreFiltro().toLowerCase();
		
		for (Iterator<Reservacion> i = reservacionDao.obtenerTodos().iterator(); i.hasNext();) {
			Reservacion tmp = i.next();
			if (tmp.getInstalacion().getNombre().toLowerCase().contains(nomb)) {
				reservacion.add(tmp);
			}
		}
		if(reservacion.isEmpty()){
			getReservacionAll().addAll(reservacionDao.obtenerTodos());
		}
		getReservacionAll().addAll(reservacion);
	}

	@GlobalCommand
	@NotifyChange({"reservacionAll", "cantRegistros" })
	public void refreshReservacion() throws Exception {
		getReservacionAll().clear();
		getReservacionAll().addAll(reservacionDao.obtenerTodos());
	}
	
	

}
