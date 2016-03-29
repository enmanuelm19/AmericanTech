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

import Dao.AfiliadoDao;

import Dao.InstalacionDao;
import Dao.PersonaDao;
import Dao.SocioDao;
import modelos.Afiliado;
import modelos.Instalacion;
import modelos.Persona;
import modelos.Socio;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteSancionesViewModel {
	
	private Socio socio;
	private SocioDao socioDao;
	private String carnet;	
	private String tipo;
	private Date fechadesde;
	private Date fechahasta;
	private boolean nrocarnet;
	private boolean sancionados;
	private boolean check;
	private Afiliado afiliado;
	private AfiliadoDao afiliadoDao;
	
	//reporte
	private String sql = "";
	private String consulta = "";
	private String titulo = "Sanciones";
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
		this.nrocarnet = true;
		this.socioDao = new SocioDao();
		this.afiliadoDao = new AfiliadoDao();
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

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
			Messagebox.show("Campo Carnet Vacio", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.socio = socioDao.obtenerSocioCarnet(carnet);
			this.afiliado = afiliadoDao.obtenerPorNroCarnet(carnet);
			if(this.socio == null && this.afiliado == null){
				Messagebox.show("Carnet no encontrado", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				this.carnet="";
				this.socio = null;
			}
			else{
				Messagebox.show("Carnet encontrado", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			}
		}
	}

	public boolean isNrocarnet() {
		return nrocarnet;
	}

	public void setNrocarnet(boolean nrocarnet) {
		this.nrocarnet = nrocarnet;
	}

	public boolean isSancionados() {
		return sancionados;
	}

	public void setSancionados(boolean sancionados) {
		this.sancionados = sancionados;
	}

	public boolean isCheck() {
		return check;
	}

	@NotifyChange({"nrocarnet","sancionados"})
	public void setCheck(boolean check) {
		this.check = check;
		if (this.check == true )
		{
			this.nrocarnet = false;
			this.sancionados =true;
			this.tipo = null;
		}
		else
		{
			this.nrocarnet = true;
			this.sancionados= false;
		}
		
	}
	
	@NotifyChange({"carnet","tipo"})
	public void validarCampo(){
		if(this.sancionados == false)
		{
			this.carnet = null;
		}else {
			this.tipo = null;
		}
	}
	
	@Command
	public void btnImprimir1(Event e) throws SQLException, JRException, IOException {
		this.isPdf = true;
	if (this.tipo == null && this.check == false ){
			Messagebox.show("Seleccione una opcion: Todos, Socios, Afiliados o Ingrese un numero de Carnet", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			
		}else if (this.tipo == null && this.check == true)
			 cargarSql1();
		 else{
			 cargarSql(); 
		 }
			 
	}
	
	@Command
	public void btnTxt(Event e) throws SQLException, JRException, IOException {
		this.isPdf = false;
	if (this.tipo == null && this.check == false ){
			Messagebox.show("Seleccione una opcion: Todos, Socios, Afiliados o Ingrese un numero de Carnet", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			
		}else if (this.tipo == null && this.check == true)
			 cargarSql1();
		 else{
			 cargarSql(); 
		 }
			 
	}
	
	
	
	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		try {
			Class.forName ("org.postgresql.Driver");
		
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
			
			
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		if(this.tipo.equalsIgnoreCase("Todos")){
			validarCampo();
			this.titulo = "LISTADO SANCIONES";
			this.consulta= "Sanciones de Socios y Afiliados";
			reporte = System.getProperty("user.home") + "/reportes_america/sanciones_3.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/sanciones_3.txt";
			
			this.sql = "SELECT p.nombre || ' ' || p.apellido as NOMBRE, s.nro_carnet, sa.descripcion,  "
					+ "to_char(sa.fecha_inic, 'YYYY-MM-DD') as FechaI, to_char(sa.fecha_fin, 'YYYY-MM-DD') as FechaF,  "
					+ "CASE WHEN sa.eventualidadid_eventualidad IS NULL THEN 'MONETARIA' ELSE  "
					+ "(select descripcion from eventualidad where id_eventualidad  = sa.eventualidadid_eventualidad) END  as Motivo  "
					+ " FROM sancion sa"
					+ " FULL OUTER JOIN socio s"
					+ " ON s.id_socio = sa.socioid_socio"
					+ " FULL OUTER JOIN afiliado af"
					+ " ON af.id_afilado = sa.afiliadoid_afilado"
					+ " FULL OUTER JOIN persona p"
					+ " ON p.id_persona = s.personaid_persona"
					+ " FULL OUTER JOIN persona pa"
					+ " ON pa.id_persona = af.personaid_persona"
					+ " INNER JOIN tipo_sancion ts"
					+ " ON ts.id_tipo_sancion = sa.tipo_sancionid_tipo_sancion"
					+ " WHERE sa.activo = true";
		
		sqlDate();
		}else if(this.tipo.equalsIgnoreCase("Socios")){
			this.titulo = "LISTADO SANCIONES";
			this.consulta= "Sanciones de Socios";
			reporte = System.getProperty("user.home") + "/reportes_america/sanciones.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/sanciones.txt";
			this.sql = "SELECT p.nombre || ' ' || p.apellido as NOMBRE, s.nro_carnet, sa.descripcion,  "
					+ "to_char(sa.fecha_inic, 'YYYY-MM-DD') as FechaI, to_char(sa.fecha_fin, 'YYYY-MM-DD') as FechaF,  "
					+ "CASE WHEN sa.eventualidadid_eventualidad IS NULL THEN 'MONETARIA' ELSE  "
					+ "(select descripcion from eventualidad where id_eventualidad  = sa.eventualidadid_eventualidad) END  as Motivo  "
					+" FROM sancion sa"
					+" INNER JOIN socio s"
					+" ON s.id_socio = sa.socioid_socio"
					+" INNER JOIN persona p"
					+" ON p.id_persona = s.personaid_persona"
					+" INNER JOIN tipo_sancion ts"
					+" ON ts.id_tipo_sancion = sa.tipo_sancionid_tipo_sancion"
					+" WHERE sa.activo = true";
		sqlDate();
		}else if(this.tipo.equalsIgnoreCase("Afiliados")){
			this.titulo = "LISTADO SANCIONES";
			this.consulta= "Sanciones de Afiliados";
			reporte = System.getProperty("user.home") + "/reportes_america/sanciones.jrxml";
			this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/sanciones.txt";
			this.sql = "SELECT p.nombre || ' ' || p.apellido as NOMBRE, af.nro_carnet, sa.descripcion,  "
				+ "to_char(sa.fecha_inic, 'YYYY-MM-DD') as FechaI, to_char(sa.fecha_fin, 'YYYY-MM-DD') as FechaF,  "
				+ "CASE WHEN sa.eventualidadid_eventualidad IS NULL THEN 'MONETARIA' ELSE  "
				+ "(select descripcion from eventualidad where id_eventualidad  = sa.eventualidadid_eventualidad) END  as Motivo  "
					+" FROM sancion sa"
					+" INNER JOIN afiliado af"
					+" ON sa.afiliadoid_afilado = af.id_afilado"
					+" INNER JOIN persona p"
					+" ON p.id_persona = af.id_afilado"
					+" INNER JOIN tipo_sancion ts"
					+" ON ts.id_tipo_sancion = sa.tipo_sancionid_tipo_sancion"
					+" WHERE sa.activo = true";
		sqlDate();
		}		
	}
	
public void cargarSql1() throws FileNotFoundException, JRException, SQLException{
	try {
		Class.forName ("org.postgresql.Driver");
	
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
		
		
	} catch (ClassNotFoundException el) {
		el.printStackTrace();
	}
	if(this.socio == null){
		Messagebox.show("Debe ingresar un numero de Carnet y que sea un codigo existente", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
	} else {
		
	
		this.titulo = "LISTADO SANCIONES";
		this.consulta= "Sanciones del Carnet Nro: " + this.getCarnet() + " del socio " + this.getSocio().getPersona().getNombre() + " "+ this.getSocio().getPersona().getApellido();
		reporte = System.getProperty("user.home") + "/reportes_america/sanciones_socios_afiliados.jrxml";
		this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/sanciones_socios_afiliados.txt";
		
		this.sql = "SELECT p.nombre || ' ' || p.apellido as NOMBRE, s.nro_carnet, sa.descripcion,  "
					+ "to_char(sa.fecha_inic, 'YYYY-MM-DD') as FechaI, to_char(sa.fecha_fin, 'YYYY-MM-DD') as FechaF,  "
					+ "CASE WHEN sa.eventualidadid_eventualidad IS NULL THEN 'MONETARIA' ELSE  "
					+ "(select descripcion from eventualidad where id_eventualidad  = sa.eventualidadid_eventualidad) END  as Motivo  "
				+" FROM sancion sa "
				+" FULL OUTER JOIN socio s "
				+" ON s.id_socio = sa.socioid_socio "
				+" FULL OUTER JOIN afiliado af "
				+" ON af.id_afilado = sa.afiliadoid_afilado "
				+" FULL OUTER JOIN persona p "
				+" ON p.id_persona = s.personaid_persona "
				+" FULL OUTER JOIN persona pa "
				+" ON pa.id_persona = af.personaid_persona "
				+" INNER JOIN tipo_sancion ts "
				+" ON ts.id_tipo_sancion = sa.tipo_sancionid_tipo_sancion "
				+" WHERE (s.nro_carnet = '" + getCarnet() +   "' OR af.nro_carnet = '" + getCarnet() +   "')";
		sqlDate();
	}
 
  }
public void sqlDate() throws FileNotFoundException, JRException, SQLException{
		
			
		if(this.fechadesde == null && this.fechahasta == null){
			generarPDF();
		} else if (this.fechadesde == null || this.fechahasta == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechadesde.compareTo(this.fechahasta) == 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += " entre las fechas " + sdf.format(this.fechadesde) + " y "+ sdf.format(this.fechahasta)+".";
			sql += " and sa.fecha_inic BETWEEN '"+ sdf.format(this.fechadesde) +"' and '"+ sdf.format(this.fechahasta)+"'" ;
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
