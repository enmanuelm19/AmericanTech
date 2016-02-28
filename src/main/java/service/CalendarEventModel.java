package service;

import java.util.Date;

import org.zkoss.calendar.impl.SimpleCalendarEvent;
 
public class CalendarEventModel extends SimpleCalendarEvent {
    private static final long serialVersionUID = 1L;
 
    public CalendarEventModel(Date beginDate, Date endDate, String headerColor, String contentColor, String content) {
        setHeaderColor(headerColor);
        setContentColor(contentColor);
        setContent(content);
        setBeginDate(beginDate);
        setEndDate(endDate);
    }
 
    public CalendarEventModel(Date beginDate, Date endDate, String headerColor, String contentColor, String content,
            String title) {
        setHeaderColor(headerColor);
        setContentColor(contentColor);
        setContent(content);
        setTitle(title);
        setBeginDate(beginDate);
        setEndDate(endDate);
    }
 
    public CalendarEventModel(Date beginDate, Date endDate, String headerColor, String contentColor, String content,
            String title, boolean locked) {
        setHeaderColor(headerColor);
        setContentColor(contentColor);
        setContent(content);
        setTitle(title);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setLocked(locked);
    }
     
    public CalendarEventModel() {
        setHeaderColor("#FFFFFF");
        setContentColor("#000000");
    }
}
