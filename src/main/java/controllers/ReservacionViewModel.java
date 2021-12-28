package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Dao.ReservacionDao;
import Dao.SocioDao;
import enums.CondicionReservacion;
import modelos.Evento;
import modelos.Reservacion;
import modelos.Socio;
import modelos.Usuario;

public class ReservacionViewModel {
	
	private List<Reservacion> reservacionAll;
	private ReservacionDao reservacionDao;
	private String nombreFiltro;
	private Socio socio;
	private boolean disable = false;
	
	@Init
	public void init() throws Exception {
		reservacionDao = new ReservacionDao();
		Session session = Sessions.getCurrent();
		Usuario usuario = (Usuario) session.getAttribute("Usuario");
		if (usuario != null) {
			socio = new SocioDao().obtenerSocioPersona(usuario.getPersona());
		}
		for(Reservacion reser: reservacionDao.obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue())){
			if(socio != null && reser.getSocio().getIdSocio() == socio.getIdSocio()){
				getReservacionAll().add(reser);
			}
		}
		if(socio == null){
			disable = true;
		}
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public ListModelList<Reservacion> getAllReservacion() {
		return new ListModelList<Reservacion>(getReservacionAll());
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
		if(nombreFiltro==null)
			return "";
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
	@NotifyChange({ "allReservacion", "cantRegistros" })
	public void eliminar(@BindingParam("reservacion") final Reservacion reservacion) {
		Messagebox.show("¿Está seguro de eliminar " + reservacion.getInstalacion().getNombre()+"?", "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								reservacionDao.eliminarReservacion(reservacion);
								reservacionAll = reservacionDao.obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue());
								Messagebox.show(reservacion.getInstalacion().getNombre() + " ha sido eliminada", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshReservacion", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), reservacion.getIdReservacion() + " No pudo ser eliminada",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
	@Command
	@NotifyChange({ "allReservacion", "cantRegistros" })
	public void filtro() throws Exception {
		List<Reservacion> reserva = new ArrayList<Reservacion>();
		String nomb = getNombreFiltro().toLowerCase();		
		for (Iterator<Reservacion> i = reservacionDao.obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue()).iterator(); i.hasNext();) {
			Reservacion tmp = i.next();
			if (tmp.getInstalacion().getNombre().toLowerCase().contains(nomb) && getSocio() != null && getSocio().getIdSocio()== tmp.getSocio().getIdSocio()) {
				reserva.add(tmp);
			}
		}
		getReservacionAll().clear();
		getReservacionAll().addAll(reserva);
	}

	@GlobalCommand
	@NotifyChange({"allReservacion", "cantRegistros" })
	public void refreshReservacion() throws Exception {
		getReservacionAll().clear();
		for(Reservacion reser: reservacionDao.obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue())){
			if(socio != null && reser.getSocio().getIdSocio() == socio.getIdSocio()){
				getReservacionAll().add(reser);
			}
		}			
	}
	
	public double precio(Date date1, Date date2,float precio){
		if(date1 != null && date2 != null){
			return precio * diasEntreFecha(date1, date2);
		}
		return 0;
	}
	
	public int diasEntreFecha(Date date1, Date date2) {
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; // Milisegundos al d�a
		long diferencia = 1 + ((date2.getTime() - date1.getTime()) / MILLSECS_PER_DAY);
		return (int) diferencia;
	}
	

}
