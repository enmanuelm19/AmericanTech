package reportes.estructurados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.InstalacionDao;
import modelos.Instalacion;
import modelos.Preferencia;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;



public class ReporteAlquilerViewModel {
	

	private String estadoinstalacion;
	private Date fechadesde;
	private Date fechahasta;
	private InstalacionDao instalacionDao;
	private Instalacion instalacionSelected;
	//private static ArrayList<String> arrestadoInstalacion;
	
	//reporte
	private String sql = "";
	
	private String consulta = "";
	private String titulo = "Instalacion";
	private String reporte;
	private Connection con;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
	private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");
	private boolean isPdf;
	private String rutaNoEstructurado;
	
	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
	}
	
	public ListModelList<Instalacion> getInstalaciones() throws Exception {
		ArrayList<Instalacion> instalaciones = (ArrayList<Instalacion>) instalacionDao.obtenerTodos();
		Instalacion todas = new Instalacion();
		todas.setIdInstalacion(0);
		todas.setNombre("Todas");
		instalaciones.add(todas);
		return new ListModelList<Instalacion>(instalaciones);

	}	
	
	@NotifyChange("instalacionSelected")
	public Instalacion getInstalacionSelected() {
		return instalacionSelected;
	}

	@NotifyChange("instalacionSelected")
	public void setInstalacionSelected(Instalacion instalacionSelected) {
		this.instalacionSelected = instalacionSelected;
	}
	
	@NotifyChange("estadoinstalacion")
	public String getEstadoinstalacion() {
		return estadoinstalacion;
	}
	
	@NotifyChange("estadoinstalacion")
	public void setEstadoinstalacion(String estadoinstalacion) {
		this.estadoinstalacion = estadoinstalacion;
	}

	public Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}
	/*public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}*/
	
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		isPdf = true;
		cargarSql();
	}
	
	
	@Command
	public void btnTXT(Event e) throws SQLException, JRException, IOException {
		isPdf = false;
		cargarSql();
	}
	
	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		try {
			Class.forName ("org.postgresql.Driver");
		
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
			
			
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		
		if (this.estadoinstalacion == null){
			Messagebox.show("Seleccione el estado de la instalación", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if(this.estadoinstalacion.equalsIgnoreCase("Reservadas")) {
			
			this.titulo = "INSTALACIONES RESERVADAS";
			this.consulta= "Instalacion reservadas ";
			reporte = System.getProperty("user.home") + "/reportes_america/instalacion_reservada.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/instalacion_reservada.txt";
		
			this.sql = " SELECT i.nombre as instalacion, tp.descripcion as tipo_instalacion, to_char(r.fecha_inicio, 'YYYY-MM-DD') as Fecha, s.nro_carnet,  p.nombre || ' ' || p.apellido as NOMBRE "
					+ "FROM instalacion i "
					+ "INNER JOIN tipo_instalacion tp "
					+ "ON i.tipo_instalacionid_tipo_instalacion = tp.id_tipo_instalacion "
					+ "INNER JOIN reservacion r "
					+ "ON r.instalacionid_instalacion = i.id_instalacion "
					+ "INNER JOIN socio s "
					+ "ON r.socioid_socio = s.id_socio "
					+ "INNER JOIN persona p "
					+ "ON p.id_persona = s.personaid_persona  "
					+ "where i.alquilable = true and i.activo = true ";
			sqlDate();
		} else if(this.estadoinstalacion.equalsIgnoreCase("Alquiladas")) {
			this.titulo = "INSTALACIONES ALQUILADAS";
			this.consulta= "Instalacion alquiladas ";
			this.reporte = System.getProperty("user.home") + "/reportes_america/instalacion_alquiladas.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/instalacion_alquiladas.txt";
			this.sql = "SELECT to_char(r.fecha_inicio, 'YYYY-MM-DD') as Fecha, i.nombre as Instalacion, s.nro_carnet, p.nombre || ' ' || p.apellido as NOMBRE "
					+ "FROM instalacion i "
					+ "INNER JOIN reservacion r "
					+ "ON r.instalacionid_instalacion = i.id_instalacion "
					+ "INNER JOIN alquiler a "
					+ "ON a.reservacionid_reservacion = r.id_reservacion "
					+ "INNER JOIN socio s "
					+ "ON r.socioid_socio = s.id_socio "
					+ "INNER JOIN persona p "
					+ "ON p.id_persona = s.personaid_persona where i.alquilable = true and i.activo = true ";
			sqlDate();
		} else if(this.estadoinstalacion.equalsIgnoreCase("Todas")){
			this.titulo = "INSTALACIONES";
			this.consulta= "Instalación ";
			this.reporte = System.getProperty("user.home") + "/reportes_america/instalacion_alquiladas.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/instalacion_todas.txt";
			this.sql = "SELECT i.nombre as instalacion, to_char(r.fecha_inicio, 'YYYY-MM-DD') as Fecha, "
					+ "s.nro_carnet, p.nombre || ' ' || p.apellido as NOMBRE, "
					+ "CASE WHEN (SELECT al.reservacionid_reservacion from alquiler al "
					+ "where al.reservacionid_reservacion = r.id_reservacion) is NULL then 'Reservacion' ELSE 'Alquiler' END as Estado "
					+ "from instalacion i "
					+ "FULL OUTER  join reservacion r "
					+ "on i.id_instalacion = r.instalacionid_instalacion "
					+ "FULL OUTER  join alquiler a "
					+ "on r.id_reservacion = a.reservacionid_reservacion "
					+ "INNER JOIN socio s "
					+ "ON r.socioid_socio = s.id_socio "
					+ "INNER JOIN persona p "
					+ "ON p.id_persona = s.personaid_persona "
					+ "WHERE i.alquilable = true and i.activo = true";
			sqlDate();
		}
		

		
	}
	
	public void sqlDate() throws FileNotFoundException, JRException, SQLException{
		
		if(this.instalacionSelected != null){
			if(this.instalacionSelected.getIdInstalacion() != 0 )
				this.sql += " and  i.id_instalacion = " + this.instalacionSelected.getIdInstalacion();
		}
	
		if(this.fechadesde == null && this.fechahasta == null){
			generarPDF();
		} else if (this.fechadesde == null || this.fechahasta == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechadesde.compareTo(this.fechahasta) == 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += "entre las fechas " + sdf.format(this.fechadesde) + " y "+ sdf.format(this.fechahasta)+".";
			sql += " and r.fecha_inicio BETWEEN '"+ sdf.format(this.fechadesde) +"' and '"+ sdf.format(this.fechahasta)+"'" ;

			generarPDF();
		}
	}
	
	
	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		Date hoy = (Date) Calendar.getInstance().getTime();
		String date = "-"+sdfGuio.format(hoy).toString();
		String nombreArchivo = this.titulo.concat(date);
		JasperPrint jasperPrint = cargarJasper();	
			
		
		if(jasperPrint.getPages().size() > 0){
			if(this.isPdf) {
				JRExporter exporter = new JRPdfExporter();
				Filedownload.save(JasperExportManager.exportReportToPdf(jasperPrint), "application/pdf", nombreArchivo+".pdf");
			} else {
				JRExporter exporterTxt = new JRTextExporter();
				exporterTxt.setParameter(JRTextExporterParameter.JASPER_PRINT, jasperPrint);
				exporterTxt.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, this.rutaNoEstructurado);
				exporterTxt.setParameter(JRTextExporterParameter.PAGE_WIDTH,130);
				exporterTxt.setParameter(JRTextExporterParameter.PAGE_HEIGHT,130);
				exporterTxt.exportReport();
				FileInputStream input = new FileInputStream(this.rutaNoEstructurado);
				Filedownload.save(input, "txt", nombreArchivo+".txt");
			    con.close();
			    
			    try{
			    	File file = new File(this.rutaNoEstructurado);
		    		file.delete();	
		    	}catch(Exception e){
		    		
		    		e.printStackTrace();
		    		
		    	}
			    
			}
			
		} else {
			Messagebox.show("No existe información para generar un reportes con los datos seleccionados.", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}		
		con.close();
	}
	
	public JasperPrint cargarJasper() throws JRException, FileNotFoundException{
		JasperDesign jd = null;  
		jd = JRXmlLoader.load(reporte); 
		JRDesignQuery newQuery = new JRDesignQuery();  
		newQuery.setText(sql);  
		jd.setQuery(newQuery); 
		JasperReport jasperRepor = JasperCompileManager.compileReport(jd);
		parameters.clear();
		FileInputStream image_club = new FileInputStream(img);
		FileInputStream imagen_equipo = new FileInputStream(img2);
		parameters.put("TITULO", titulo);
		parameters.put("CONSULTA", consulta);
		parameters.put("IMAGEN_EQUIPO", imagen_equipo );
		parameters.put("IMAGEN_CLUB", image_club);
		return  JasperFillManager.fillReport(jasperRepor, parameters, con);
		
		
	}

}
