package reportes.estructurados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
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
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.InstalacionDao;
import Dao.SocioDao;
import modelos.Evento;
import modelos.Instalacion;
import modelos.Socio;
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



public class ReporteEventualidadesViewModel {
	

	private Socio socio;
	private SocioDao socioDao;
	private String tipo;
	private String horaInicio;
	private String horaFin;
	private Date fechaInicio;
	private Date fechaFin;
	private InstalacionDao instalacionDao;
	private Instalacion instalacionSelected;
	private String carnet;
	private boolean disablecarnet;
	private boolean disableinstalaciones;
	
	//Declaracion del reporte
	private String consulta = "";
	private String titulo = "REPORTE DE EVENTUALIDADES";
	private String sql = "";
	private String reporte;
	private Connection con;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
	private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");
	private boolean isPdf;
	private String rutaNoEstructurado;


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
		this.disableinstalaciones = true;
		this.disablecarnet=true;

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

	public void setInstalacionSelected(Instalacion instalacionSelected) {
		this.instalacionSelected = instalacionSelected;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getTipo() {
		return tipo;
	}

	@NotifyChange({"disablecarnet","disableinstalaciones"})
	public void setTipo(String tipo) {
		this.tipo = tipo;
		if(this.tipo.equalsIgnoreCase("Instalaciones")){
			this.disableinstalaciones = false;
			this.disablecarnet=true;
		}
		else if(this.tipo.equalsIgnoreCase("Socios") || this.tipo.equalsIgnoreCase("Afiliados"))
		{
			this.disablecarnet = false;
			this.disableinstalaciones = true;
		}
		else
		{
			this.disablecarnet = true;
			this.disableinstalaciones =true;
		}
		
	}
	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	@Command
	@NotifyChange({"carnet","socio"})
	public void buscarCarnet() throws Exception{
		if(carnet==""||carnet==null){
			Messagebox.show("Campo Carnet Vacio", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.socioDao= new SocioDao();
			this.socio=socioDao.obtenerSocioCarnet(carnet);
			if(this.socio==null){
				Messagebox.show("Carnet no encontrado", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			else {
				Messagebox.show("Carnet encontrado", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);	
			}

		}
	}

	public boolean getDisablecarnet() {
		return disablecarnet;
	}

	public void setDisablecarnet(boolean disable) {
		this.disablecarnet = disable;
	}	
	
	public boolean getDisableinstalaciones() {
		return disableinstalaciones;
	}

	public void setDisableinstalacionest(boolean disable) {
		this.disableinstalaciones = disable;
	}
	
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		this.isPdf = true;
		cargarSql();
	}
	@Command
	public void btnTxt(Event e) throws SQLException, JRException, IOException {
		this.isPdf = false;
		cargarSql();	 
	}
	
	
	
	
	
	public void cargarSql() throws SQLException, FileNotFoundException, JRException {
		try {
			Class.forName ("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		System.out.println(this.tipo);
		if( this.tipo == null){
			Messagebox.show("Debe elegir una seleccion", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if( this.tipo.equalsIgnoreCase("Instalaciones")){
			this.reporte = System.getProperty("user.home") + "/reportes_america/eventualidades_instalacion.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/eventualidades_instalacion.txt";
			instalacion();
		} else {
			this.reporte = System.getProperty("user.home") + "/reportes_america/eventualidades_socios_afiliados.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/eventualidades_socios_afiliados.txt";
			sociosAfiliado();
		} 
	}

	public void instalacion() throws FileNotFoundException, JRException, SQLException {
		if(instalacionSelected == null){
			Messagebox.show("Debe Seleccionar una instalacion", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			
			this.consulta = "Reporte de eventualidades sobre instalacion: " + this.instalacionSelected.getNombre() + " ";
			this.sql = "SELECT e.descripcion, te.descripcion as Tipo, "
					+ "p.nombre || ' ' || p.apellido as NOMBRE, to_char(e.fecha, 'YYYY-MM-DD') as Fecha,"
					+ " to_char(e.fecha, 'HH:MM') as Hora FROM eventualidad e "
					+ "INNER JOIN tipo_eventualidad te "
					+ "ON e.tipo_eventualidadid_tipo_eventualidad = te.id_tipo_eventualidad "
					+ "INNER JOIN persona p "
					+ "ON p.id_persona = e.personaid_persona where e.activo = true ";
			
			if(this.instalacionSelected.getIdInstalacion() != 0){
				this.sql += " and e.instalacionid_instalacion = " + this.instalacionSelected.getIdInstalacion() + " ";
			}
			
			sqlTime();
		}
		
	}

	public void sociosAfiliado() throws FileNotFoundException, JRException, SQLException {		
		this.sql = "SELECT e.descripcion, i.nombre, "
				+ "te.descripcion as Tipo, p.nombre || ' ' || p.apellido as NOMBRE, "
				+ "to_char(e.fecha, 'YYYY-MM-DD') as Fecha, to_char(e.fecha, 'HH:MM') as Hora "
				+ "FROM eventualidad e "
				+ "INNER JOIN instalacion i "
				+ "ON i.id_instalacion = e.instalacionid_instalacion "
				+ "INNER JOIN tipo_eventualidad te "
				+ "ON e.tipo_eventualidadid_tipo_eventualidad = te.id_tipo_eventualidad "
				+ "INNER JOIN persona p "
				+ "ON p.id_persona = e.personaid_persona where e.activo = true ";
		
		if(this.socio == null){
			this.consulta = "Reporte de eventualidades de todos los: " + this.getTipo().toUpperCase();
			sqlTime();
		} else {
			this.consulta = "Reporte de eventualidades sobre: " + this.getTipo();
			this.sql += " and e.personaid_persona = " +this.socio.getPersona().getIdPersona();
			sqlTime();
		}
	}
	
	public void sqlTime() throws FileNotFoundException, JRException, SQLException{
		if(this.horaInicio == null && this.horaFin == null){
			sqlDate();
		} else if (this.horaInicio == null || this.horaFin == null){
			Messagebox.show("Debe Seleccionar el rango de hora", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (Integer.valueOf(this.horaInicio)  >=  Integer.valueOf(this.horaFin)  ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.sql += " and date_part('hour', e.fecha) between "+ Integer.valueOf(this.horaInicio) +" and "+ Integer.valueOf(this.horaFin)+ " ";
			sqlDate();
		}	
	}
	
	public void sqlDate() throws FileNotFoundException, JRException, SQLException{
		if(this.fechaInicio == null && this.fechaFin == null){
			generarPDF();
		} else if (this.fechaInicio == null || this.fechaFin == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechaInicio.compareTo(this.fechaFin) == 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += "  entre las fechas " + sdf.format(this.fechaInicio) + " y "+ sdf.format(this.fechaFin)+".";
			this.sql += " AND e.fecha  BETWEEN '" + sdf.format(this.fechaInicio) + "' AND '" + sdf.format(this.fechaFin) + "' ";	
			generarPDF();
		}
	}

	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		System.out.println(sql);
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
			Messagebox.show("No existe planificacion para este evento.", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
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
