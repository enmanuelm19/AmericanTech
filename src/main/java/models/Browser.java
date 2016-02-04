package models;

public class Browser {
    
    public static GROUP ACETADAS = Browser.GROUP.ACETADAS;
    public static GROUP RECHAZADAS = Browser.GROUP.RECHAZADAS;
    public static GROUP EN_PROCESO = Browser.GROUP.EN_PROCESO;

    
    public static enum GROUP {
    	ACETADAS("Aceptadas"),
    	RECHAZADAS("Rechazadas"),
    	EN_PROCESO("En Proceso");

        
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