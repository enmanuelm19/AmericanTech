package models;

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

        
        brands = new LinkedHashMap<Browser.GROUP, Double>();
        brands.put(Browser.ACETADAS, 49.9);
        brands.put(Browser.RECHAZADAS, 24.7);
        brands.put(Browser.EN_PROCESO, 25.4);
 
        
        browsers = new LinkedList<Browser>();
        
        browsers.add(new Browser(Browser.ACETADAS, "2015", 26.61));
        browsers.add(new Browser(Browser.ACETADAS, "2014", 16.96));
        browsers.add(new Browser(Browser.ACETADAS, "2013", 8.8));
        browsers.add(new Browser(Browser.ACETADAS, "2012", 3.55));
        browsers.add(new Browser(Browser.ACETADAS, "2011", 0.09));
        
        browsers.add(new Browser(Browser.RECHAZADAS, "2015", 12.01 ));
        browsers.add(new Browser(Browser.RECHAZADAS, "2014", 7.73 ));
        browsers.add(new Browser(Browser.RECHAZADAS, "2013", 5.13 ));
        browsers.add(new Browser(Browser.RECHAZADAS, "2012", 0.45 ));
        browsers.add(new Browser(Browser.RECHAZADAS, "2011", 0.26 ));
        browsers.add(new Browser(Browser.RECHAZADAS, "2010", 0.25 ));
        browsers.add(new Browser(Browser.RECHAZADAS, "2009", 0.24 ));
              
        browsers.add(new Browser(Browser.EN_PROCESO, "2015", 6.72));
        browsers.add(new Browser(Browser.EN_PROCESO, "2014", 4.72));
        browsers.add(new Browser(Browser.EN_PROCESO, "2013", 3.16));
        browsers.add(new Browser(Browser.EN_PROCESO, "2012", 2.17));
        browsers.add(new Browser(Browser.EN_PROCESO, "2011", 1.05));
        browsers.add(new Browser(Browser.EN_PROCESO, "2010", 0.93));
        browsers.add(new Browser(Browser.EN_PROCESO, "2009", 0.75));
        browsers.add(new Browser(Browser.EN_PROCESO, "2008", 0.38));
        

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