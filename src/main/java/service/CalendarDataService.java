package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.calendar.api.CalendarEvent;

import modelos.EstadoEvento;
import modelos.Evento;
import modelos.Socio;

public class CalendarDataService {

	private List<CalendarEvent> calendarEvents = new LinkedList<CalendarEvent>();
	private final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private Calendar cal = Calendar.getInstance();

	public CalendarDataService() {
		init();
	}

	private void init() {
		int mod = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		String date2 = mod > 9 ? year + "/" + mod + "" : year + "/" + "0" + mod;
		String date1 = --mod > 9 ? year + "/" + mod + "" : year + "/" + "0" + mod;
		++mod;
		String date3 = ++mod > 9 ? year + "/" + mod + "" : year + "/" + "0" + mod;
		initDataEvent();
		// Red Events

		// calendarEvents.add(new CalendarEventModel(getDate(date1 + "/04
		// 02:00"), getDate(date1 + "/05 03:00"), "#9c0c0c", "#f74f4f",
		// "Reuniï¿½n TEAM O'SULLIVAN"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/21
		// 05:00"), getDate(date2 + "/21 07:00"), "#9c0c0c", "#f74f4f",
		// "Reuniï¿½n junta directiva"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/08
		// 00:00"), getDate(date2 + "/09 00:00"), "#9c0c0c", "#f74f4f", "Evento
		// dï¿½a del Padre"));
		// // Blue Events
		// calendarEvents.add(new CalendarEventModel(getDate(date1 + "/29
		// 03:00"), getDate(date2 + "/02 06:00"), "#3467CE", "#668CD9", "Semana
		// aniversario del club"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/02
		// 10:00"), getDate(date2 + "/02 12:30"), "#3467CE", "#668CD9",
		// "Concierto bailable "));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/17
		// 14:00"), getDate(date2 + "/18 16:00"), "#3467CE", "#668CD9",
		// "Stand'up comedy Bar"));
		// calendarEvents.add(new CalendarEventModel(getDate(date3 + "/01
		// 14:30"), getDate(date3 + "/01 17:30"), "#3467CE", "#668CD9", "Torneo
		// de Futbol Sala"));
		// // Purple Events
		// calendarEvents.add(new CalendarEventModel(getDate(date1 + "/29
		// 08:00"), getDate(date2 + "/03 12:00"), "#7b8a0e", "#96a80f", "Torneo
		// de Beisbol"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/07
		// 08:00"), getDate(date2 + "/07 12:00"), "#7A367A", "#B373B3",
		// "Reservaciï¿½n caney Chevechita "));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/13
		// 11:00"), getDate(date2 + "/13 14:30"), "#7A367A", "#B373B3",
		// "Reservaciï¿½n Caney de Rafa"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/16
		// 14:00"), getDate(date2 + "/18 16:00"), "#7b8a0e", "#96a80f", "Semana
		// por la familia"));
		// calendarEvents.add(new CalendarEventModel(getDate(date3 + "/02
		// 12:00"), getDate(date3 + "/02 17:00"), "#7A367A", "#B373B3",
		// "Reservaciï¿½n caney chevechita"));
		// // Khaki Events
		// calendarEvents.add(new CalendarEventModel(getDate(date1 + "/03
		// 00:00"), getDate(date1 + "/04 00:00"), "#88880E", "#BFBF4D", "Salï¿½n
		// principal"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/13
		// 05:00"), getDate(date2 + "/13 07:00"), "#88880E", "#BFBF4D", "How to
		// Test ZK Application with Selenium"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/24
		// 19:30"), getDate(date2 + "/24 20:00"), "#88880E", "#BFBF4D",
		// "Encuentro americanista"));
		// calendarEvents.add(new CalendarEventModel(getDate(date3 + "/03
		// 00:00"), getDate(date3 + "/04 00:00"), "#88880E", "#BFBF4D", "ZK
		// selected as SourceForge.net Project of the Month"));
		// // Green Events
		// calendarEvents.add(new CalendarEventModel(getDate(date1 + "/28
		// 10:00"), getDate(date1 + "/28 12:30"), "#0D7813", "#4CB052", "ZK
		// Mobile Released"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/03
		// 00:00"), getDate(date2 + "/03 05:30"), "#0D7813", "#4CB052", "ZK
		// Gmaps released"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/05
		// 20:30"), getDate(date2 + "/06 00:00"), "#0D7813", "#4CB052", "Refresh
		// with Five New ZK Themes!"));
		// calendarEvents.add(new CalendarEventModel(getDate(date2 + "/23
		// 00:00"), getDate(date2 + "/29 16:30"), "#0D7813", "#4CB052", "Semana
		// por la familia"));
		// calendarEvents.add(new CalendarEventModel(getDate(date3 + "/01
		// 08:30"), getDate(date3 + "/01 19:30"), "#0D7813", "#4CB052", "Build
		// Database CRUD Application in 6 Steps"));
	}


	public void initDataEvent() {
		List<Socio> listaSocio = new ArrayList<Socio>();
		Socio socio = new Socio(1, null, "ab12",true);
		short cont = 0;		
		List<Evento> eventos = new ArrayList<Evento>();
		Evento evento1 = new Evento(1, new EstadoEvento(1, "Activo",true), "Torneo de Futbol", "Torneo de Futbol",
				new Date(116, 2, 1, 2, 00), new Date(116, 2, 6, 5, 00), true, true);
		Evento evento2 = new Evento(2, new EstadoEvento(1, "Activo",true), "Aqua Terapia", "Aqua Terapia", new Date(116, 3, 12, 2, 00),
				new Date(116, 3, 12, 5, 00), true, true);
		Evento evento3 = new Evento(3, new EstadoEvento(1, "Activo",true), "Dia de las Madres", "Dia de las Madres",
				new Date(116, 5, 15, 2, 00), new Date(116, 5, 15, 5, 00), true, true);
		Evento evento4 = new Evento(4, new EstadoEvento(1, "Activo",true), "Dia de los Padres", "Dia de los Padres",
				new Date(116, 6, 19, 2, 00), new Date(116, 6, 19, 5, 00), true, true);
		Evento evento5 = new Evento(5, new EstadoEvento(1, "Activo",true), "Dia del Niño",  "Dia del Niño", new Date(116, 7, 24, 2, 00),
				new Date(116, 7, 24, 5, 00), true, true);
		Evento evento6 = new Evento(6, new EstadoEvento(1, "Activo",true), "Plan Vacacional", "Plan Vacacional",
				new Date(116, 8, 1, 2, 00), new Date(116, 8, 30, 5, 00), true, true);
		eventos.add(evento1);
		eventos.add(evento2);
		eventos.add(evento3);
		eventos.add(evento4);
		eventos.add(evento5);
		eventos.add(evento6);
		for (Evento evento : eventos) {			
			calendarEvents.add(new CalendarEventModel(evento.getFechaInicio(), evento.getFechaFin(), "#9c0c0c",
					"#f74f4f",evento.getIdEvento()+ "__" + evento.getDescripcion()));
		}
	}

	private Date getDate(String dateText) {
		try {
			return DATA_FORMAT.parse(dateText);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CalendarEvent> getCalendarEvents() {
		return calendarEvents;
	}
}