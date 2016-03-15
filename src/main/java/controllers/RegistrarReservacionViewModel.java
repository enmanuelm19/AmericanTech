package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.jboss.logging.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.InstalacionDao;
import Dao.InstalacionEventoDao;
import Dao.PreferenciaDao;
import Dao.ReservacionDao;
import Dao.SocioDao;
import Dao.CalendarioFechaDao;
import modelos.CalendarioFecha;
import modelos.Evento;
import modelos.Instalacion;
import modelos.InstalacionEvento;
import modelos.Persona;
import modelos.Reservacion;
import modelos.Socio;
import modelos.Usuario;
import util.Format;

public class RegistrarReservacionViewModel {

	private Reservacion reservacion;
	private boolean editable;
	private ReservacionDao reservacionDao;
	private ArrayList<Instalacion> temporalInstalaciones;
	private Usuario usuario;
	private Instalacion instalacionSeleccionada;
	private boolean disable;
	
	@Init
	public void init(@ExecutionArgParam("reservacion") Reservacion reservacion) {
		if (reservacion == null) {
			this.reservacion = new Reservacion();
			this.editable = false;
		} else {
			this.reservacion = reservacion;
			this.instalacionSeleccionada = reservacion.getInstalacion();
			this.editable = true;
		}
		reservacionDao = new ReservacionDao();
		try {
			getTemporalInstalaciones().addAll(new InstalacionDao().obtenerTodos());
		} catch (Exception ex) {
			Logger.getLogger(RegistrarReservacionViewModel.class.getName());
		}
		Session session = Sessions.getCurrent();
		usuario = (Usuario) session.getAttribute("Usuario");
	}

	public Instalacion getInstalacionSeleccionada() {
		return instalacionSeleccionada;
	}

	public void setInstalacionSeleccionada(Instalacion instalacionSeleccionada) {
		this.instalacionSeleccionada = instalacionSeleccionada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public ReservacionDao getReservacionDao() {
		return reservacionDao;
	}

	public void setReservacionDao(ReservacionDao reservacionDao) {
		this.reservacionDao = reservacionDao;
	}

	public ArrayList<Instalacion> getTemporalInstalaciones() {
		if (temporalInstalaciones == null) {
			temporalInstalaciones = new ArrayList<Instalacion>();
		}
		return temporalInstalaciones;
	}

	public void setTemporalInstalaciones(ArrayList<Instalacion> temporalInstalaciones) {
		this.temporalInstalaciones = temporalInstalaciones;
	}	

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (!isCamposVacio()) {
			reservacion.setSocio(new SocioDao().obtenerSocioPersona(usuario.getPersona()));
			reservacion.setInstalacion(getInstalacionSeleccionada());
			if (!editable)				
				reservacionDao.agregarReservacion(reservacion);
			else
				reservacionDao.actualizarReservacion(reservacion);
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshReservacion", null);
		}
	}

	public boolean isCamposVacio() {
		if (reservacion.getFechaInicio() != null && reservacion.getFechaFin() != null
				&& getInstalacionSeleccionada() != null && usuario != null)
			return false;
		return true;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void validarFecha() {
		List<CalendarioFecha> calendarioFechaAll = new ArrayList<CalendarioFecha>();
		try {
			calendarioFechaAll = new CalendarioFechaDao().obtenerTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CalendarioFecha calendarioFecha : calendarioFechaAll) {
			if (calendarioFecha.getReservacion() != null && calendarioFecha.getReservacion().equals(getReservacion())) {
				if (Format.getDateString(calendarioFecha.getReservacion().getFechaInicio())
						.equals(Format.getDateString(reservacion.getFechaInicio()))
						&& Format.getDateString(calendarioFecha.getReservacion().getFechaFin())
								.equals(Format.getDateString(reservacion.getFechaFin()))) {
					Messagebox.show("Debe seleccionar otra fecha");
				}
			}
		}
	}

	public boolean isRango(Date a, Date b, Date d) {
		return a.compareTo(d) * d.compareTo(b) >= 0;
	}

	public boolean isDisponible(Instalacion instalacion) throws Exception {

		// verificamos que no este reservada esa intalacion
		for (Reservacion reservacion : reservacionDao.obtenerReservacionesInstalacion(instalacion)) {

			if (isRango(reservacion.getFechaInicio(), reservacion.getFechaFin(), getReservacion().getFechaInicio()))
				return false;
			if (isRango(reservacion.getFechaInicio(), reservacion.getFechaFin(), getReservacion().getFechaFin()))
				return false;
			if (isRango(getReservacion().getFechaInicio(), getReservacion().getFechaFin(),
					reservacion.getFechaInicio()))
				return false;

		}

		// verificamos que no se vaya usar esa instalacion en un evento
		for (InstalacionEvento instalacionEvento : new InstalacionEventoDao().obtenerPorInstalacion(instalacion)) {
			if (isRango(instalacionEvento.getEvento().getFechaInicio(), instalacionEvento.getEvento().getFechaFin(),
					getReservacion().getFechaInicio()))
				return false;
			if (isRango(instalacionEvento.getEvento().getFechaInicio(), instalacionEvento.getEvento().getFechaFin(),
					getReservacion().getFechaFin()))
				return false;
			if (isRango(getReservacion().getFechaInicio(), getReservacion().getFechaFin(),
					instalacionEvento.getEvento().getFechaInicio()))
				return false;
		}

		return true;

	}

	public void validateReservacion() {
		if (getReservacion() != null && getReservacion().getInstalacion() != null) {
			try {
				if (isDisponible(getReservacion().getInstalacion())) {
					setDisable(false);
				} else {
					Messagebox.show(
							getReservacion().getInstalacion().getNombre()
									+ " no se encuentra disponible en el rango de fecha selecionado",
							"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
					setDisable(true);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
