package reportes.estructurados;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.util.test.Test;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Window;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ReporteAlquileres extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	private String sql, reporte;
	private Connection con;
	
	@Wire
	private Combobox cmbCargos;
	@Wire
	private Combobox cmbPrioridades;
	
	
	@Listen("onClick = #btnImprimir")
	public void imprimirReporte(Event e) throws SQLException, JRException, IOException {
		
		try {
			Class.forName ("org.postgresql.Driver");
		
			con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
			
			
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}	
					
		String archivo = System.getProperty("user.home") + "/workspace/web/src/main/webapp/archivos/example1.jrxml";
		
		sql =  "select * "
				+ "	FROM instalacion i "
				+ "INNER JOIN reservacion r "
				+ "ON r.instalacionid_instalacion = i.id_instalacion";
		
		String titulo = "Instalacion";
		JasperDesign jd = null;  
		jd = JRXmlLoader.load(archivo); 
	
		JRDesignQuery newQuery = new JRDesignQuery();  
	
		newQuery.setText(sql);  
		jd.setQuery(newQuery); 

		JasperReport jasperRepor = JasperCompileManager.compileReport(jd);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("REPORTE_TITULO", titulo);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRepor, parameters, con);
		JasperViewer.viewReport(jasperPrint, false);
		
		
		con.close();

	}
}
