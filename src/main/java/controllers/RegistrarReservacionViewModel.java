package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jboss.logging.Logger;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.InstalacionDao;
import Dao.InstalacionEventoDao;
import Dao.ReservacionDao;
import Dao.SocioDao;
import enums.CondicionReservacion;
import Dao.CalendarioFechaDao;
import modelos.CalendarioFecha;
import modelos.Instalacion;
import modelos.InstalacionEvento;
import modelos.Reservacion;
import modelos.Usuario;
import util.Format;

public class RegistrarReservacionViewModel {

	private Reservacion reservacion;
	private boolean editable;
	private ReservacionDao reservacionDao;
	private ArrayList<Instalacion> temporalInstalaciones;
	private Usuario usuario;
	private Instalacion instalacionSeleccionada;
	private boolean disabled;

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
		this.setDisabled(true);
		reservacionDao = new ReservacionDao();
		try {
			getTemporalInstalaciones().addAll(new InstalacionDao().obtenerAlquilables());
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

	public boolean isDisabled() {
		return disabled;
	}

	public boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (!isCamposVacio()) {
			if (getReservacion().getFechaInicio().after(getReservacion().getFechaFin())) {
				setDisabled(true);
				Messagebox.show("La fecha de final no puede ser menor a la fecha inicio", "Warning", Messagebox.OK,
						Messagebox.EXCLAMATION);
			}	
			if (isDisponible(getInstalacionSeleccionada())) {
				CalendarioFecha calendarioFecha = new CalendarioFecha();
				reservacion.setSocio(new SocioDao().obtenerSocioPersona(usuario.getPersona()));
				reservacion.setInstalacion(getInstalacionSeleccionada());
				reservacion.setCondicion(CondicionReservacion.PENDIENTE.getValue());
				reservacion.setActivo(true);
				if (!editable) {
					calendarioFecha.setFecha(new Date());
					calendarioFecha.setReservacion(reservacion);
					calendarioFecha.setDescripcion(reservacion.getInstalacion().getDescripcion());
					reservacionDao.agregarReservacion(reservacion);
					new CalendarioFechaDao().agregarCalendarioFecha(calendarioFecha);
				} else {
					calendarioFecha = new CalendarioFechaDao()
							.obtenerPorEvento(reservacionDao.obtenerReservacion(reservacion.getIdReservacion()));
					calendarioFecha.setReservacion(reservacion);
					reservacionDao.actualizarReservacion(reservacion);
					new CalendarioFechaDao().actualizarCalendarioFecha(calendarioFecha);
				}
				Messagebox.show("Reservacion Agregada: " + getInstalacionSeleccionada().getNombre(), "", Messagebox.OK,
						Messagebox.INFORMATION);
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshReservacion", null);
			} else {
				Messagebox.show("Debe seleccionar otra fecha la intalación se encuentra reservada");
			}
		} else {
			Messagebox.show("Llenar todos los campos");
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
		System.out.print("look");
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
		if (a != null && b != null && d != null) {
			return a.compareTo(d) * d.compareTo(b) >= 0;
		}
		return false;
	}

	public boolean isDisponible(Instalacion instalacion) throws Exception {
		// verificamos que no este reservada esa intalacion
		for (Reservacion reservacion : reservacionDao.obtenerReservacionesInstalacion(instalacion)) {
			if (getReservacion().getIdReservacion() == reservacion.getIdReservacion()) {
				continue;
			}
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

	@Command
	@NotifyChange({ "reservacion", "disabled" })
	public void validarReservacion() {
		if (getReservacion() != null && getInstalacionSeleccionada() != null) {
			try {
				if (getReservacion().getFechaInicio() != null && getReservacion().getFechaFin() != null
						&& getReservacion().getFechaInicio().after(getReservacion().getFechaFin())) {
					setDisabled(true);
					Messagebox.show("La fecha de final no puede ser menor a la fecha inicio", "Warning", Messagebox.OK,
							Messagebox.EXCLAMATION);
				}
				if (isDisponible(getInstalacionSeleccionada())) {
					setDisabled(false);
					BindUtils.postNotifyChange(null, null, RegistrarReservacionViewModel.this, "reservacion");
					BindUtils.postNotifyChange(null, null, RegistrarReservacionViewModel.this, "precio");
				} else {
					setDisabled(true);
					Messagebox.show(
							getInstalacionSeleccionada().getNombre()
									+ " no se encuentra disponible en el rango de fecha selecionado",
							"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			Messagebox.show("Por favor indique rango de fechas del evento de forma correcta", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
	}

	@NotifyChange({ "reservacion", "disabled" })
	public double precio() {
		if (getReservacion().getFechaInicio() != null && getReservacion().getFechaFin() != null) {
			return getInstalacionSeleccionada().getPrecioAlquiler() * diasEntreFecha(getReservacion().getFechaInicio(), getReservacion().getFechaFin());
		}
		return 0;
	}

	public int diasEntreFecha(Date date1, Date date2) {
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; // Milisegundos al día
		long diferencia = 1 + ((date2.getTime() - date1.getTime()) / MILLSECS_PER_DAY);
		return (int) diferencia;
	}

}
