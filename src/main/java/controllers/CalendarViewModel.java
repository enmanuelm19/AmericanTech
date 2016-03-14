package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.calendar.Calendars;
import org.zkoss.calendar.api.CalendarEvent;
import org.zkoss.calendar.event.CalendarsEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.ui.select.annotation.Subscribe;
import org.zkoss.zul.Textbox;

import Dao.EventoDao;
import Dao.TipoPreferenciaDao;
import modelos.Alquiler;
import modelos.Evento;
import modelos.PreferenciaEvento;
import modelos.TipoPreferencia;
import util.QueueMessage;
import util.QueueUtil;
import viewModel.CalendarioEvent;
import viewModel.CalendarioModel;

public class CalendarViewModel extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@Wire
	private Calendars calendars;
	@Wire
	private Textbox filter;

	private CalendarioModel calendarModel;

	private EventoDao eventoDao = new EventoDao();
	
	private List<TipoPreferencia> tipoPreferenciaAll;
	
	// the in editing calendar ui event
	private CalendarsEvent calendarsEvent = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		List<CalendarEvent> calendarEvents = new LinkedList<CalendarEvent>();
		super.doAfterCompose(comp);
		for (Evento evento : eventoDao.obtenerTodos()) {
			if (evento.getPreferenciaEventos() != null) {
				if (evento.getPreferenciaEventos().size() == 1) {
					for (PreferenciaEvento preferencia : evento.getPreferenciaEventos()) {
						calendarEvents.add(new CalendarioEvent(evento.getFechaInicio(), evento.getFechaFin(),
								preferencia.getPreferencia().getTipoPreferencia().getColor(),
								preferencia.getPreferencia().getTipoPreferencia().getColor(), evento.getDescripcion(),evento.getNombre()));
					}
				} else {
					calendarEvents.add(new CalendarioEvent(evento.getFechaInicio(), evento.getFechaFin(), "#11bcb7",
							"#11bcb7", evento.getDescripcion()));
				}
			} else {
				calendarEvents.add(new CalendarioEvent(evento.getFechaInicio(), evento.getFechaFin(), "#11bcb7",
						"#11bcb7", evento.getDescripcion()));
			}
		}
		calendarModel = new CalendarioModel(calendarEvents);
		calendars.setModel(this.calendarModel);
	}

	// control the calendar position
	@Listen("onClick = #today")
	public void gotoToday() {
		TimeZone timeZone = calendars.getDefaultTimeZone();
		calendars.setCurrentDate(Calendar.getInstance(timeZone).getTime());
	}

	@Listen("onClick = #next")
	public void gotoNext() {
		calendars.nextPage();
	}

	@Listen("onClick = #prev")
	public void gotoPrev() {
		calendars.previousPage();
	}

	// control page display
	@Listen("onClick = #pageDay")
	public void changeToDay() {
		calendars.setMold("default");
		calendars.setDays(1);
	}

	@Listen("onClick = #pageWeek")
	public void changeToWeek() {
		calendars.setMold("default");
		calendars.setDays(7);
	}

	@Listen("onClick = #pageMonth")
	public void changeToYear() {
		calendars.setMold("month");
	}

	// control the filter
	@Listen("onClick = #applyFilter")
	public void applyFilter() {
		calendarModel.setFilterText(filter.getValue());
		calendars.setModel(calendarModel);
	}

	@Listen("onClick = #resetFilter")
	public void resetFilter() {
		filter.setText("");
		calendarModel.setFilterText("");
		calendars.setModel(calendarModel);
	}

	// listen to the calendar-create and edit of a event data
	@Listen("onEventCreate = #calendars; onEventEdit = #calendars")
	public void createEvent(CalendarsEvent event) {
		calendarsEvent = event;

		// to display a shadow when editing
		calendarsEvent.stopClearGhost();

		CalendarioEvent data = (CalendarioEvent) event.getCalendarEvent();

		if (data != null) {
			data = (CalendarioEvent) event.getCalendarEvent();		
		}
		// notify the editor
		QueueUtil.lookupQueue().publish(new QueueMessage(QueueMessage.Type.EDIT, data));
	}

//	// listen to the calendar-update of event data, usually send when user drag
//	// the event data
//	@Listen("onEventUpdate = #calendars")
//	public void updateEvent(CalendarsEvent event) {
//		CalendarioEvent data = (CalendarioEvent) event.getCalendarEvent();
//		data.setBeginDate(event.getBeginDate());
//		data.setEndDate(event.getEndDate());
//		calendarModel.update(data);
//	}

	// listen to queue message from other controller
	@Subscribe(value = QueueUtil.QUEUE_NAME)
	public void handleQueueMessage(Event event) {
		if (!(event instanceof QueueMessage)) {
			return;
		}
		QueueMessage message = (QueueMessage) event;
		switch (message.getType()) {
		case DELETE:
			calendarModel.remove((CalendarioEvent) message.getData());
			// clear the shadow of the event after editing
			calendarsEvent.clearGhost();
			calendarsEvent = null;
			break;
		case OK:
			if (calendarModel.indexOf((CalendarioEvent) message.getData()) >= 0) {
				calendarModel.update((CalendarioEvent) message.getData());
			} else {
				calendarModel.add((CalendarioEvent) message.getData());
			}
		case CANCEL:
			// clear the shadow of the event after editing
			calendarsEvent.clearGhost();
			calendarsEvent = null;
			break;
		}
	}

	public List<TipoPreferencia> getTipoPreferenciaAll() {
		if(tipoPreferenciaAll == null){
			tipoPreferenciaAll = new ArrayList<TipoPreferencia>();
		}
		return tipoPreferenciaAll;
	}

	public void setTipoPreferenciaAll(List<TipoPreferencia> tipoPreferenciaAll) {
		this.tipoPreferenciaAll = tipoPreferenciaAll;
	}
	
	@Init
	public void init() {
		try {
			getTipoPreferenciaAll().addAll(new TipoPreferenciaDao().obtenerTodos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
