package com.ucla.america.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
 
import org.zkoss.calendar.api.CalendarEvent;
 
 
public class DemoCalendarData {
 
    private List<CalendarEvent> calendarEvents = new LinkedList<CalendarEvent>();
    private final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private Calendar cal = Calendar.getInstance();
 
    public DemoCalendarData() {
        init();
    }
 
    private void init() {
        int mod = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String date2 = mod > 9 ? year + "/" + mod + "" : year + "/" + "0" + mod;
        String date1 = --mod > 9 ? year + "/" + mod + "" : year + "/" + "0" + mod;
        ++mod;
        String date3 = ++mod > 9 ? year + "/" + mod + "" : year + "/" + "0" + mod;
        // Red Events
        calendarEvents.add(new DemoCalendarEvent(getDate(date1 + "/28 00:00"), getDate(date1 + "/29 00:00"), "#9c0c0c", "#f74f4f", "Defensa SI"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date1 + "/04 02:00"), getDate(date1 + "/05 03:00"), "#9c0c0c", "#f74f4f", "Reuni�n TEAM O'SULLIVAN"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/21 05:00"), getDate(date2 + "/21 07:00"), "#9c0c0c", "#f74f4f", "Reuni�n junta directiva"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/08 00:00"), getDate(date2 + "/09 00:00"), "#9c0c0c", "#f74f4f", "Evento d�a del Padre"));
        // Blue Events
        calendarEvents.add(new DemoCalendarEvent(getDate(date1 + "/29 03:00"), getDate(date2 + "/02 06:00"), "#3467CE", "#668CD9", "Semana aniversario del club"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/02 10:00"), getDate(date2 + "/02 12:30"), "#3467CE", "#668CD9", "Concierto bailable "));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/17 14:00"), getDate(date2 + "/18 16:00"), "#3467CE", "#668CD9", "Stand'up comedy Bar"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date3 + "/01 14:30"), getDate(date3 + "/01 17:30"), "#3467CE", "#668CD9", "Torneo de Futbol Sala"));
        // Purple Events
        calendarEvents.add(new DemoCalendarEvent(getDate(date1 + "/29 08:00"), getDate(date2 + "/03 12:00"), "#7b8a0e", "#96a80f", "Torneo de Beisbol"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/07 08:00"), getDate(date2 + "/07 12:00"), "#7A367A", "#B373B3", "Reservaci�n caney Chevechita "));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/13 11:00"), getDate(date2 + "/13 14:30"), "#7A367A", "#B373B3", "Reservaci�n Caney de Rafa"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/16 14:00"), getDate(date2 + "/18 16:00"), "#7b8a0e", "#96a80f", "Semana por la familia"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date3 + "/02 12:00"), getDate(date3 + "/02 17:00"), "#7A367A", "#B373B3", "Reservaci�n caney chevechita"));
        // Khaki Events
        calendarEvents.add(new DemoCalendarEvent(getDate(date1 + "/03 00:00"), getDate(date1 + "/04 00:00"), "#88880E", "#BFBF4D", "Sal�n principal"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/13 05:00"), getDate(date2 + "/13 07:00"), "#88880E", "#BFBF4D", "How to Test ZK Application with Selenium"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/24 19:30"), getDate(date2 + "/24 20:00"), "#88880E", "#BFBF4D", "Encuentro americanista"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date3 + "/03 00:00"), getDate(date3 + "/04 00:00"), "#88880E", "#BFBF4D", "ZK selected as SourceForge.net Project of the Month"));
        // Green Events
        calendarEvents.add(new DemoCalendarEvent(getDate(date1 + "/28 10:00"), getDate(date1 + "/28 12:30"), "#0D7813", "#4CB052", "ZK Mobile Released"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/03 00:00"), getDate(date2 + "/03 05:30"), "#0D7813", "#4CB052", "ZK Gmaps released"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/05 20:30"), getDate(date2 + "/06 00:00"), "#0D7813", "#4CB052", "Refresh with Five New ZK Themes!"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date2 + "/23 00:00"), getDate(date2 + "/29 16:30"), "#0D7813", "#4CB052", "Semana por la familia"));
        calendarEvents.add(new DemoCalendarEvent(getDate(date3 + "/01 08:30"), getDate(date3 + "/01 19:30"), "#0D7813", "#4CB052", "Build Database CRUD Application in 6 Steps"));
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