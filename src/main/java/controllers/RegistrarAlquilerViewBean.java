package controllers;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AlquilerDao;
import Dao.ReservacionDao;
import Dao.TipoPagoDao;
import modelos.Alquiler;
import modelos.Reservacion;
import modelos.TipoPago;

public class RegistrarAlquilerViewBean {
	private List<Reservacion> reservacionAll;
	private List<Alquiler> alquilerAll;
	private List<TipoPago> tipoPagoAll;
	private TipoPago tipoPagoSelected;
	private Reservacion reservacionSelected;

	@Init
	public void init(@ExecutionArgParam("reservacion") Reservacion reservacion) {
		try {
			if (reservacion != null) {
				setReservacionSelected(reservacion);
			}
			getReservacionAll().addAll(new ReservacionDao().obtenerTodos());
			getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
			getTipoPagoAll().addAll(new TipoPagoDao().obtenerTodos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Reservacion> getReservacionAll() {
		if (reservacionAll == null) {
			reservacionAll = new ArrayList<Reservacion>();
		}
		return reservacionAll;
	}

	public void setReservacionAll(List<Reservacion> reservacionAll) {
		this.reservacionAll = reservacionAll;
	}

	public List<Alquiler> getAlquilerAll() {
		if (alquilerAll == null) {
			alquilerAll = new ArrayList<Alquiler>();
		}
		return alquilerAll;
	}

	public void setAlquilerAll(List<Alquiler> alquilerAll) {
		this.alquilerAll = alquilerAll;
	}

	public List<TipoPago> getTipoPagoAll() {
		if (tipoPagoAll == null) {
			tipoPagoAll = new ArrayList<TipoPago>();
		}
		return tipoPagoAll;
	}

	public void setTipoPagoAll(List<TipoPago> tipoPagoAll) {
		this.tipoPagoAll = tipoPagoAll;
	}

	public TipoPago getTipoPagoSelected() {
		return tipoPagoSelected;
	}

	public void setTipoPagoSelected(TipoPago tipoPagoSelected) {
		this.tipoPagoSelected = tipoPagoSelected;
	}

	public Reservacion getReservacionSelected() {
		return reservacionSelected;
	}

	public void setReservacionSelected(Reservacion reservacionSelected) {
		this.reservacionSelected = reservacionSelected;
	}

	@Command
	public void showModal(@BindingParam("reservacion") Reservacion reservacion) {
		if (reservacion != null) {
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("reservacion", reservacion);
			setReservacionSelected(reservacion);
			Window window = (Window) Executions.createComponents("instalacion/dialogo/registrarAlquiler.zul",
					null, args);
			window.doModal();
		}
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (tipoPagoSelected != null) {
			getReservacionSelected().setActivo(false);
			Alquiler alquilerCreate = new Alquiler();
			alquilerCreate.setReservacion(getReservacionSelected());
			alquilerCreate.setFecha(new Date());
			alquilerCreate.setTipoPago(getTipoPagoSelected());
			try {
				new ReservacionDao().actualizarReservacion(getReservacionSelected());
				new AlquilerDao().agregarAlquiler(alquilerCreate);
				getAlquilerAll().clear();
				getReservacionAll().clear();
				getReservacionAll().addAll(new ReservacionDao().obtenerTodos());
				getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
				setTipoPagoAll(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshAlquilerReservacion", null);
		} else {
			Messagebox.show("Por favor seleccione Tipo de Pago", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}
	}
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
	@GlobalCommand
	@NotifyChange({ "alquilerAll", "reservacionAll" })
	public void refreshAlquilerReservacion() throws Exception {
		getReservacionAll().clear();
		getAlquilerAll().clear();
		getReservacionAll().addAll(new ReservacionDao().obtenerTodos());
		getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
	}
}