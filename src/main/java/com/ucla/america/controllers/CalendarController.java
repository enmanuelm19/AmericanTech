package com.ucla.america.controllers;

import java.util.Calendar;


import java.util.TimeZone;

import com.ucla.america.models.DemoCalendarData;
import com.ucla.america.models.DemoCalendarEvent;
import com.ucla.america.models.DemoCalendarModel;

import org.zkoss.calendar.Calendars;
import org.zkoss.calendar.event.CalendarsEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.ui.select.annotation.Subscribe;
import org.zkoss.zul.Textbox;
 
 
public class CalendarController extends SelectorComposer<Component> {
 
    private static final long serialVersionUID = 1L;
 
    @Wire
    private Calendars calendars;
    @Wire
    private Textbox filter;
     
    private DemoCalendarModel calendarModel;
     
    //the in editing calendar ui event
    private CalendarsEvent calendarsEvent = null;
 
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        calendarModel = new DemoCalendarModel(new DemoCalendarData().getCalendarEvents());
        calendars.setModel(this.calendarModel);
    }
     
    //control the calendar position
    @Listen("onClick = #today")
    public void gotoToday(){
        TimeZone timeZone = calendars.getDefaultTimeZone();
        calendars.setCurrentDate(Calendar.getInstance(timeZone).getTime());
    }
    @Listen("onClick = #next")
    public void gotoNext(){
        calendars.nextPage();
    }
    @Listen("onClick = #prev")
    public void gotoPrev(){
        calendars.previousPage();
    }
     
    //control page display
    @Listen("onClick = #pageDay")
    public void changeToDay(){
        calendars.setMold("default");
        calendars.setDays(1);
    }
    @Listen("onClick = #pageWeek")
    public void changeToWeek(){
        calendars.setMold("default");
        calendars.setDays(7);
    }
    @Listen("onClick = #pageMonth")
    public void changeToYear(){
        calendars.setMold("month");
    }
     
    //control the filter
    @Listen("onClick = #applyFilter")
    public void applyFilter(){
        calendarModel.setFilterText(filter.getValue());
        calendars.setModel(calendarModel);
    }
    @Listen("onClick = #resetFilter")
    public void resetFilter(){
        filter.setText("");
        calendarModel.setFilterText("");
        calendars.setModel(calendarModel);
    }
 
    //listen to the calendar-create and edit of a event data
    @Listen("onEventCreate = #calendars; onEventEdit = #calendars")
    public void createEvent(CalendarsEvent event) {
        calendarsEvent = event;
         
        //to display a shadow when editing
        calendarsEvent.stopClearGhost();
         
        DemoCalendarEvent data = (DemoCalendarEvent)event.getCalendarEvent();
         
        if(data == null) {
            data = new DemoCalendarEvent();
            data.setHeaderColor("#3366ff");
            data.setContentColor("#6699ff");
            data.setBeginDate(event.getBeginDate());
            data.setEndDate(event.getEndDate());
        } else {
            data = (DemoCalendarEvent) event.getCalendarEvent();
        }
        //notify the editor
        QueueUtil.lookupQueue().publish(
                new QueueMessage(QueueMessage.Type.EDIT,data));
    }
     
    //listen to the calendar-update of event data, usually send when user drag the event data 
    @Listen("onEventUpdate = #calendars")
    public void updateEvent(CalendarsEvent event) {
        DemoCalendarEvent data = (DemoCalendarEvent) event.getCalendarEvent();
        data.setBeginDate(event.getBeginDate());
        data.setEndDate(event.getEndDate());
        calendarModel.update(data);
    }
     
    //listen to queue message from other controller
   @Subscribe(value = QueueUtil.QUEUE_NAME)
    public void handleQueueMessage(Event event) {
        if(!(event instanceof QueueMessage)) {
            return;
        } 
        QueueMessage message = (QueueMessage)event;
        switch(message.getType()){
        case DELETE:
            calendarModel.remove((DemoCalendarEvent)message.getData());
            //clear the shadow of the event after editing
            calendarsEvent.clearGhost(); 
            calendarsEvent = null;
            break;
        case OK:
            if (calendarModel.indexOf((DemoCalendarEvent)message.getData()) >= 0) {
                calendarModel.update((DemoCalendarEvent)message.getData());
            } else {
                calendarModel.add((DemoCalendarEvent)message.getData());
            }
        case CANCEL:
            //clear the shadow of the event after editing
            calendarsEvent.clearGhost();
            calendarsEvent = null;
            break;
        }
    }   
}