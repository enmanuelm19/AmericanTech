package reportes.estadisticos;

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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zkex.zul.JasperreportExporterFactory;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import antlr.collections.List;
import Dao.InstalacionDao;
import Dao.PersonaDao;
import Dao.SancionDao;
import Dao.SocioDao;
import modelos.Instalacion;
import modelos.Persona;
import modelos.Sancion;
import modelos.Socio;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteSancionesEstViewModel {
	
	private Socio socio;
	private SocioDao socioDao;
	private String carnet;	
	private String tipo;
	private int estadoinstalacion;
	private Date fechadesde;
	private Date fechahasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	
	
	//reporte
		private String sql = "";
		
		private String consulta = "";
		private String titulo = "Sanciones";
		private String reporte;
		private Connection con;
		private Map<String, Object> parameters = new HashMap<String, Object>();
		private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
		private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
		this.socio = new Socio();
	}


	public ListModelList<Instalacion> getInstalaciones() throws Exception {

		return new ListModelList<Instalacion>(instalacionDao.obtenerTodos());

	}

	@NotifyChange("tipoInstalacionSelected")
	public TipoInstalacion getTipotipoInstalacionSelected() {
		return tipoInstalacionSelected;
	}

	@NotifyChange("InstalacionPorTipo")
	public void setTipoInstalacionSelected(TipoInstalacion tipoInstalacionSelected) {
		this.tipoInstalacionSelected = tipoInstalacionSelected;
	}

	public int getEstadoinstalacion() {
		return estadoinstalacion;
	}

	public void setEstadoinstalacion(int estadoinstalacion) {
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
			this.socioDao= new SocioDao();
			this.socio=socioDao.obtenerSocioCarnet(carnet);
			if(this.socio==null){
				Messagebox.show("Carnet encontrado", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}
	}
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		System.out.println("TONY");
		cargarSql();
		
	}
	
	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		try {
			Class.forName ("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		reporte = System.getProperty("user.home") + "/reportes_america/estadisticos_sanciones.jrxml";
		if(this.fechadesde == null && this.fechahasta == null){
			
			sql = "SELECT t.descripcion, COUNT(s.*) as count, "
					+ "  (COUNT(s.*) * 100) / (SELECT COUNT(*) "
					+ "FROM sancion) as porcentaje "
					+ "FROM sancion s, tipo_sancion t "
					+ "WHERE s.tipo_sancionid_tipo_sancion = t.id_tipo_sancion AND s.activo = t.activo = TRUE "
					+ " GROUP BY t.id_tipo_sancion";
			this.consulta = "Reporte general de las sanciones";
			generarPDF();
			
		} else if (this.fechadesde == null || this.fechahasta == null){
			Messagebox.show("Debe Seleccionar un rango de fechas", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechadesde.compareTo(this.fechahasta) == 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += "Reporte general de las sanciones entre las fechas " + sdf.format(this.fechadesde) + " y "+ sdf.format(this.fechahasta)+".";
			sql = "SELECT t.descripcion, COUNT(s.*) as count,"
					+ "  (COUNT(s.*) * 100) / (SELECT COUNT(*) "
					+ "FROM sancion WHERE fecha_inic BETWEEN '"+sdf.format(this.fechadesde)+"' AND '"+  sdf.format(this.fechahasta) +"') as porcentaje "
					+ "FROM sancion s, tipo_sancion t "
					+ "WHERE s.tipo_sancionid_tipo_sancion = t.id_tipo_sancion AND s.activo = t.activo = TRUE "
					+ "AND s.fecha_inic BETWEEN '"+sdf.format(this.fechadesde)+"' AND '"+  sdf.format(this.fechahasta) +"' GROUP BY t.id_tipo_sancion";
			System.out.println(sql);
			generarPDF();
		}
		
	}
	
	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		Date hoy = (Date) Calendar.getInstance().getTime();
		String date = "-"+sdfGuio.format(hoy).toString();
		String nombreArchivo = this.titulo.concat(date);
		JasperPrint jasperPrint = cargarJasper(); 
		if(jasperPrint.getPages().size() > 0){
		  Filedownload.save(JasperExportManager.exportReportToPdf(jasperPrint), "application/pdf", nombreArchivo+".pdf"); 
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
