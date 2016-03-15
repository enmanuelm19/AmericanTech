package reportes.estructurados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
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
import modelos.Preferencia;
import modelos.PreferenciaEvento;


public class ReporteSocioViewModel {

	private TipoPreferencia tipoPreferenciaSelected;
	private TipoPreferenciaDao tPreferenciaDao;
	private Preferencia preferenciaSelected;
	private PreferenciaDao preferenciaDao;	
	private ArrayList<Preferencia> temporalPreferencia;
	private ArrayList<Preferencia> seleccionPreferencia;
	private Set<Preferencia> preferenciaEventos;
	private String edadDedeSelected;
	private String edadHastaSelected; 
	private String sexoSelected;
	private String nroAccionesSelected;
	
	//reporte
		private String sql = "SELECT p.nombre || ' ' || p.apellido as NOMBRE, "
				+ "CASE WHEN p.sexo = 'M' THEN 'Masculino' else 'Femenino' end as SEXO, p.telefono as TELEFONO, "
				+ "s.nro_carnet as CARNET FROM usuario u "
				+ "INNER JOIN persona p ON u.personaid_persona = p.id_persona "
				+ "INNER JOIN socio s ON p.id_persona = s.personaid_persona "
				+ "INNER JOIN preferencia_persona pp ON pp.personaid_persona = p.id_persona "
				+ "INNER JOIN preferencia pre ON pre.id_preferencia = pp.preferenciaid_preferencia "
				+ "INNER JOIN accion ac ON ac.socioid_socio = s.id_socio"
				+ "INNER JOIN tipo_preferencia tipop ON tipop.id_tipo_preferencia = pre.tipo_preferenciaid_tipo_preferencia  "
				+ "WHERE p.activo = true ";
		
		private String consulta = "";
		private String titulo = "SOCIOS";
		private String reporte = System.getProperty("user.home") + "/reportes_america/reporte_socios.jrxml";
		private Connection con;
		private Map<String, Object> parameters = new HashMap<String, Object>();
		private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
		private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	
	
	@Init
	public void init(@ExecutionArgParam("elTipo") TipoPreferencia tpreferencia) {
		tPreferenciaDao = new TipoPreferenciaDao();		
		preferenciaDao = new PreferenciaDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		preferenciaEventos = new HashSet<Preferencia>();

	}
	
	public ArrayList<Integer> getRangeEdadDesde() throws Exception {
		ArrayList<Integer> temporal = new ArrayList<Integer>();		
		for (int i = 0; i < 80; i+=5) {
			temporal.add(i);
		}
		return temporal;
	}
	
	

	
	public ArrayList<Integer> getRangeEdadHasta() throws Exception {
		ArrayList<Integer> temporal = new ArrayList<Integer>();		
		for (int i = 0; i < 80; i+=5) {
			temporal.add(i);
		}
		return temporal;
	}
	
	@NotifyChange("sexoSelected")
	public String getSexoSelected() {
		return sexoSelected;
	}	
	
	@NotifyChange("sexoSelected")
	public void  setSexoSelected(String sexoSelected) {
		this.sexoSelected = sexoSelected;
	}
	
	@NotifyChange("nroAccionesSelected")
	public String getNroAccionesSelected() {
		return nroAccionesSelected;
	}	
	
	@NotifyChange("nroAccionesSelected")
	public void  setNroAccionesSelected(String nroAccionesSelected) {
		this.nroAccionesSelected = nroAccionesSelected;
	}

	@NotifyChange("edadDedeSelected")
	public String getEdadDesdeSelected() {
		return edadDedeSelected;
	}	

	@NotifyChange("edadDedeSelected")
	public void  setEdadDesdeSelected(String edadDedeSelected) {
		this.edadDedeSelected = edadDedeSelected;
	}
	
	@NotifyChange("edadHastaSelected")
	public String getEdadHastaSelected() {
		return edadHastaSelected;
	}
	
	@NotifyChange("edadHastaSelected")
	public void  setEdadHataSelected(String edadHastaSelected) {
		this.edadHastaSelected = edadHastaSelected;
	}

	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}	

	public ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception {
		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
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
	//metodo para elliminar los datos de la tabla temporal
//	@Command
//	@NotifyChange({ "preferenciasEventos"})
//	public void eliminarPreferenciaEvento(@BindingParam("preferenciaEvento") Preferencia p) {
//		if(this.editable)
//			p.setActivo(false);
//		else temporalPreferencia.remove(p);
//		
//	}
	
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
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
	
		System.out.println(this.sexoSelected);
		System.out.println(this.edadDedeSelected);
		System.out.println(this.edadHastaSelected);
		System.out.println(this.nroAccionesSelected);
	
		if(this.sexoSelected == null){
			Messagebox.show("Seleccione un Sexo", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
			
		} else if (this.sexoSelected.equalsIgnoreCase("Femenino")){
			consulta += "Los socios del sexo Femeninos ";
			sql += "  and p.sexo = 'F'";
			dataSql();
		} else if (this.sexoSelected.equalsIgnoreCase("Todos")){
			consulta += "Los socios ";
			sql += " and (p.sexo = 'M' or p.sexo = 'F') ";
			dataSql();
		}else if(this.sexoSelected.equalsIgnoreCase("Masculino")) {
			consulta += "Los socios del sexo Masculino ";
			sql += " and p.sexo = 'M' ";
			dataSql();
		}
		
		
		

		
	}
	
	
	public void dataSql() throws FileNotFoundException, JRException, SQLException{
		
		if(this.tipoPreferenciaSelected != null ){
			consulta += "con preferencia "+ tipoPreferenciaSelected.getDescripcion() + " ";
			sql += " and pre.id_preferencia = " + tipoPreferenciaSelected.getIdTipoPreferencia();
		} 
		
		if(this.preferenciaEventos != null){
			for (Preferencia pe : preferenciaEventos) {
			    sql += " AND tipop.id_tipo_preferencia = "+ pe.getIdPreferencia();
			}
		}
		
		if(this.nroAccionesSelected != null){
			sql += " AND "+ Integer.valueOf(this.nroAccionesSelected) +"  = (SELECT COUNT(ac.socioid_socio) FROM accion ac where ac.socioid_socio = 1 group by ac.socioid_socio  ) ";
		}
		
		if( (null == this.edadHastaSelected &&  this.edadDedeSelected == null) || (null == this.edadHastaSelected ||  this.edadDedeSelected == null) ){
			generarPDF();
		} else if(Integer.valueOf(this.edadDedeSelected)  > Integer.valueOf(this.edadHastaSelected)) {
			Messagebox.show("Edad desde no puede ser mayor que edad hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			consulta += "y edades entre "+ Integer.valueOf(this.edadDedeSelected) + " y " +  Integer.valueOf(this.edadHastaSelected)+ ".";
			sql +=" AND substring(age(now(),p.fecha_nac)::text from 1 for 2)::int between "+ Integer.valueOf(this.edadDedeSelected) +" and "+ Integer.valueOf(this.edadHastaSelected) +" ";
			generarPDF();
		}
	}
	
	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		System.out.println(sql);
		String nombreArchivo = titulo;
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





