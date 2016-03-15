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

import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
import modelos.Preferencia;
import modelos.TipoPreferencia;
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



public class ReporteEventoViewModel {
	

	
	private TipoPreferenciaDao tipopreferenciaDao;
	private Date fechadesde;
	private Date fechahasta;
	private ArrayList<Preferencia> temporalPreferencia;
	private PreferenciaDao preferenciaDao;
	private TipoPreferencia tipoPreferenciaSelected;
	private Set<Preferencia> preferenciaEventos;
	private ArrayList<Preferencia> seleccionPreferencia;

	//reporte
		private String sql = "SELECT p.nombre || ' ' || p.apellido as NOMBRE, "
				+ "p.sexo as SEXO, p.telefono as TELEFONO, s.nro_carnet as CARNET "
				+ "FROM usuario u "
				+ "INNER JOIN persona p "
				+ "ON u.personaid_persona = p.id_persona "
				+ "INNER JOIN socio s "
				+ "ON p.id_persona = s.personaid_persona"
				+ "INNER JOIN preferencia_persona pp "
				+ "ON pp.personaid_persona = p.id_persona"
				+ "INNER JOIN preferencia pre "
				+ "ON pre.id_preferencia = pp.preferenciaid_preferencia"
				+ "INNER JOIN tipo_preferencia tipop "
				+ "ON tipop.id_tipo_preferencia = pre.tipo_preferenciaid_tipo_preferencia ";
		
		private String consulta = "";
		private String titulo = "Alquiler";
		private String reporte = System.getProperty("user.home") + "/reportes_america/reporte_socios.jrxml";
		private Connection con;
		private Map<String, Object> parameters = new HashMap<String, Object>();
		private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
		private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	
	@Init
	public void init() {
		tipopreferenciaDao = new TipoPreferenciaDao();
		preferenciaDao = new PreferenciaDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		preferenciaEventos = new HashSet<Preferencia>();

	}

	public ListModelList<TipoPreferencia> getTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tipopreferenciaDao.obtenerTodos());

	}
	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}

	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}
	
	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
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
	
	public ArrayList<Preferencia> getTemporalPreferencia() {

		return temporalPreferencia;
	}

	public void setTemporalPreferencia(ArrayList<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}	
	
	public Set<Preferencia> getPreferenciaEventos() {
		return preferenciaEventos;
	}	
	public void setPreferenciaEventos(Set<Preferencia> preferenciaEventos) {
		this.preferenciaEventos = preferenciaEventos;
	}
	
	@Command
	@NotifyChange({"preferenciaEventos"})
	public void agregarSeleccionPreferencia() {
		Set<Preferencia> tmp = new HashSet<Preferencia>();
		for(Preferencia p : getTemporalPreferencia()){
			tmp.add(p);
		}
		setPreferenciaEventos(tmp);
	}

	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		
	
		
		System.out.println(this.fechadesde);
		System.out.println(this.fechahasta);
		cargarSql();
		
	
	}
	
	
	@Command
	public void btnEXCEL(Event e) throws SQLException, JRException, IOException {
		
		
		//cargarSql();

	}
	
	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		try {
			Class.forName ("org.postgresql.Driver");
		
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
			
			
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		
		
		System.out.println(sql);
		//generarPDF();
	}
	
	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		DateFormat df = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
		Date hoy = (Date) Calendar.getInstance().getTime();
		String nombreArchivo = titulo +"-"+ df.format(hoy);
		JasperPrint jasperPrint = cargarJasper();
		JRExporter exporter = new JRPdfExporter();
	    Filedownload.save(JasperExportManager.exportReportToPdf(jasperPrint), "application/pdf", nombreArchivo+".pdf"); 
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
