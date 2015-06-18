package com.ucla.america.models;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;


public class BrowserMarketShare {
    private static final PieModel model;
    private static Map<Browser.GROUP, Double> brands;
    private static List<Browser> browsers;
    static {
        
        model = new DefaultPieModel();
        model.setValue("Beisbol", 45.0);//FIREFOX
        model.setValue("Futbol Sala", 26.8);//IE
        model.setValue("Nataci�n", 12.8);//CHROME
        model.setValue("Bolas criollas", 8.5);//SAFARI
        model.setValue("Karaoke", 6.2);//OPERA
        model.setValue("Otros", 0.7);//OTROS
        
        brands = new LinkedHashMap<Browser.GROUP, Double>();
        brands.put(Browser.FUTBOL, 54.1);
        brands.put(Browser.NATACION, 18.7);
        brands.put(Browser.BEISBOL, 19.9);
        brands.put(Browser.BOLAS, 4.6);
        brands.put(Browser.KARAOKE, 2.5);
        brands.put(Browser.OTROS, 0.29);
        
        browsers = new LinkedList<Browser>();
        
        browsers.add(new Browser(Browser.FUTBOL, "2015", 26.61));
        browsers.add(new Browser(Browser.FUTBOL, "2014", 16.96));
        browsers.add(new Browser(Browser.FUTBOL, "2013", 8.8));
        browsers.add(new Browser(Browser.FUTBOL, "2012", 3.55));
        browsers.add(new Browser(Browser.FUTBOL, "2011", 0.09));
        
        browsers.add(new Browser(Browser.NATACION, "2015", 10.01 ));
        browsers.add(new Browser(Browser.NATACION, "2014", 7.73 ));
        browsers.add(new Browser(Browser.NATACION, "2013", 1.13 ));
        browsers.add(new Browser(Browser.NATACION, "2012", 0.45 ));
        browsers.add(new Browser(Browser.NATACION, "2011", 0.26 ));
        browsers.add(new Browser(Browser.NATACION, "2010", 0.25 ));
        browsers.add(new Browser(Browser.NATACION, "2009", 0.24 ));
              
        browsers.add(new Browser(Browser.BEISBOL, "2015", 6.72));
        browsers.add(new Browser(Browser.BEISBOL, "2014", 4.72));
        browsers.add(new Browser(Browser.BEISBOL, "2013", 3.16));
        browsers.add(new Browser(Browser.BEISBOL, "2012", 2.17));
        browsers.add(new Browser(Browser.BEISBOL, "2011", 1.05));
        browsers.add(new Browser(Browser.BEISBOL, "2010", 0.93));
        browsers.add(new Browser(Browser.BEISBOL, "2009", 0.75));
        browsers.add(new Browser(Browser.BEISBOL, "2008", 0.38));
        
        
        browsers.add(new Browser(Browser.BOLAS, "2015", 3.53));
        browsers.add(new Browser(Browser.BOLAS, "2014", 0.85));
        browsers.add(new Browser(Browser.BOLAS, "2013", 0.14));
        browsers.add(new Browser(Browser.BOLAS, "2012", 0.12));
        
        browsers.add(new Browser(Browser.KARAOKE, "2015", 2.30));
        browsers.add(new Browser(Browser.KARAOKE, "2014", 0.15));
        browsers.add(new Browser(Browser.KARAOKE, "2013", 0.09));
    }

    public static PieModel getPieModel() {
        return model;
    }
    
    static public  Map<Browser.GROUP, Double> getBrands() {
        return brands;
    }
    
    static public List<Browser> getVersions(Browser.GROUP group) {
        List<Browser> result = new LinkedList<Browser>();
        for (Browser browser: browsers) {
            if(browser.getGroup() == group) {
                result.add(browser);
            }
        }
        return result;
    }
}