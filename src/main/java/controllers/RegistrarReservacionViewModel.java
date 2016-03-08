package controllers;

import java.util.ArrayList;
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
import Dao.PreferenciaDao;
import Dao.ReservacionDao;
import Dao.SocioDao;
import Dao.CalendarioFechaDao;
import modelos.CalendarioFecha;
import modelos.Evento;
import modelos.Instalacion;
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
	private Instalacion	instalacionSeleccionada;
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

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (!isCamposVacio()) {
			Socio socio = new Socio(1, new Persona(1,usuario.getUsername(),usuario.getUsername(),"INDEFINIDO",true), null, "1", true, null, null, null, null, null);
			new SocioDao().agregarSocio(socio);
			//reservacion.setSocio(new SocioDao().obtenerSocioPersona(usuario.getPersona()));
			reservacion.setSocio(socio);
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
						.equals(Format.getDateString(reservacion.getFechaInicio())) && Format.getDateString(calendarioFecha.getReservacion().getFechaFin())
						.equals(Format.getDateString(reservacion.getFechaFin()))) {
					Messagebox.show("Debe seleccionar otra fecha");
				}
			}
		}
	}

}
