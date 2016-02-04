package com.ucla.america.models;

public class Browser {
    
    public static GROUP FUTBOL = Browser.GROUP.FUTBOL;
    public static GROUP NATACION = Browser.GROUP.NATACION;
    public static GROUP BEISBOL = Browser.GROUP.BEISBOL;
    public static GROUP BOLAS = Browser.GROUP.BOLAS;
    public static GROUP KARAOKE = Browser.GROUP.KARAOKE;
    public static GROUP OTROS = Browser.GROUP.OTROS;
    
    public static enum GROUP {
        FUTBOL("Futbol Sala"),
        NATACION("Nataci�n"),
        BEISBOL("Beisbol"),
        BOLAS("Bolas criollas"),
        KARAOKE("Karaoke"),
        OTROS("Otros");
        
        private String label;
        
        GROUP(String label) {
        	this.label = label;
        }
        
        public String getLabel() {
        	return label;
        }
    }
    
    private GROUP group;
    private String version;
    private Number percentage; 
    
    public Browser(GROUP group, String version, Number percentage) {
        this.group = group;
        this.version = version;
        this.percentage = percentage;
    }

    public GROUP getGroup() {
        return group;
    }

    public String getVersion() {
        return version;
    }

    public Number getPercentage() {
        return percentage;
    }
}