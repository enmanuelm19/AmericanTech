package controllers;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;
import org.zkoss.zul.Window;

import Dao.AlquilerDao;
import Dao.ReservacionDao;
import Dao.TipoPagoDao;
import modelos.Alquiler;
import modelos.Reservacion;
import modelos.TipoPago;
import enums.CondicionReservacion;

public class RegistrarAlquilerViewModel {
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
			getReservacionAll()
					.addAll(new ReservacionDao().obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue()));
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
	public void denegarReservacion(@BindingParam("reservacion") final Reservacion reservacion) {
		if (reservacion != null) {
			EventListener<ClickEvent> clickListener = new EventListener<Messagebox.ClickEvent>() {
				public void onEvent(ClickEvent event) throws Exception {
					if (Messagebox.Button.YES.equals(event.getButton())) {
						if (reservacion.getCondicion() == CondicionReservacion.PENDIENTE.getValue()) {
							reservacion.setCondicion(CondicionReservacion.CANCELADA.getValue());
						}
						try {
							new ReservacionDao().actualizarReservacion(reservacion);
							getReservacionAll().clear();
							getReservacionAll().addAll(new ReservacionDao()
									.obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue()));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Messagebox.show("Se ha cancelado la reservacion:"+reservacion.getInstalacion().getNombre(), "American Tech", Messagebox.OK, Messagebox.INFORMATION);
					}
				}
			};
			Messagebox.show("Desea cancelar la reservacion?", "American Tech",
					new Messagebox.Button[] { Messagebox.Button.YES, Messagebox.Button.NO }, Messagebox.QUESTION,
					clickListener);

		}
	}

	@Command
	public void showModal(@BindingParam("reservacion") Reservacion reservacion) {
		if (reservacion != null) {
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("reservacion", reservacion);
			setReservacionSelected(reservacion);
			Window window = (Window) Executions.createComponents("instalacion/dialogo/registrarAlquiler.zul", null,
					args);
			window.doModal();
		}
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (tipoPagoSelected != null) {
			getReservacionSelected().setCondicion(CondicionReservacion.ALQUILADA.getValue());
			Alquiler alquilerCreate = new Alquiler();
			alquilerCreate.setReservacion(getReservacionSelected());
			alquilerCreate.setFecha(new Date());
			alquilerCreate.setTipoPago(getTipoPagoSelected());
			try {
				new ReservacionDao().actualizarReservacion(getReservacionSelected());
				new AlquilerDao().agregarAlquiler(alquilerCreate);
				getAlquilerAll().clear();
				getReservacionAll().clear();
				getReservacionAll().addAll(
						new ReservacionDao().obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue()));
				getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
				setTipoPagoAll(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshAlquilerReservacion", null);
		} else {
			Messagebox.show("Por favor seleccione Tipo de Pago", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
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
		getReservacionAll()
				.addAll(new ReservacionDao().obtenerTodosPorCondicion(CondicionReservacion.PENDIENTE.getValue()));
		getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
	}

	public int diasEntreFecha(Date date1, Date date2) {
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; // Milisegundos al día
		long diferencia = 1 + ((date2.getTime() - date1.getTime()) / MILLSECS_PER_DAY);
		return (int) diferencia;
	}
	
	public double precio(Date date1, Date date2,float precio){
		if(date1 != null && date2 != null){
			return precio * diasEntreFecha(date1, date2);
		}
		return 0;
	}
}
