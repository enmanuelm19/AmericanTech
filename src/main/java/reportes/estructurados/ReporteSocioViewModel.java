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

import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
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
import modelos.Preferencia;
import modelos.PreferenciaEvento;


public class ReporteSocioViewModel {

	private TipoPreferencia tipoPreferenciaSelected;
	private TipoPreferenciaDao tPreferenciaDao;
	private Preferencia preferenciaSelected;
	private PreferenciaDao preferenciaDao;	
	private ArrayList<Preferencia> temporalPreferencia;
	private ArrayList<Preferencia> seleccionPreferencia;
	private ArrayList<Integer> listaedades;
	private Set<Preferencia> preferenciaEventos;
	private String edadDedeSelected;
	private String edadHastaSelected; 
	private String sexoSelected;
	private boolean isPdf;
	
	

	private String sql = "SELECT DISTINCT p.nombre || ' ' || p.apellido as NOMBRE, "
			+ "CASE WHEN p.sexo = 'M' THEN 'Masculino' else 'Femenino' end as SEXO, p.telefono as TELEFONO, "
			+ "s.nro_carnet as CARNET FROM socio s "
			+ "INNER JOIN persona p ON s.personaid_persona = p.id_persona "
			+ "INNER JOIN preferencia_persona pp ON pp.personaid_persona = p.id_persona "
			+ "INNER JOIN preferencia pre ON pre.id_preferencia = pp.preferenciaid_preferencia "
			+ "INNER JOIN tipo_preferencia tipop ON tipop.id_tipo_preferencia = pre.tipo_preferenciaid_tipo_preferencia  "
			+ "WHERE p.activo = true ";

	private String sqloriginal = "SELECT DISTINCT p.nombre || ' ' || p.apellido as NOMBRE, "
			+ "CASE WHEN p.sexo = 'M' THEN 'Masculino' else 'Femenino' end as SEXO, p.telefono as TELEFONO, "
			+ "s.nro_carnet as CARNET FROM socio s "
			+ "INNER JOIN persona p ON s.personaid_persona = p.id_persona "
			+ "INNER JOIN preferencia_persona pp ON pp.personaid_persona = p.id_persona "
			+ "INNER JOIN preferencia pre ON pre.id_preferencia = pp.preferenciaid_preferencia "
			+ "INNER JOIN tipo_preferencia tipop ON tipop.id_tipo_preferencia = pre.tipo_preferenciaid_tipo_preferencia  "
			+ "WHERE p.activo = true ";



	private String consulta = "";
	private String titulo = "SOCIOS";
	private String reporte = System.getProperty("user.home") + "/reportes_america/reporte_socios.jrxml";
	private Connection con;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
	private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");
	private String rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/reporte_socios.txt";;
	
	@Init
	public void init(@ExecutionArgParam("elTipo") TipoPreferencia tpreferencia) {
		tPreferenciaDao = new TipoPreferenciaDao();		
		preferenciaDao = new PreferenciaDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		preferenciaEventos = new HashSet<Preferencia>();
		listaedades =new ArrayList<Integer>();


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
	public void  setEdadHastaSelected(String edadHastaSelected) {
		this.edadHastaSelected = edadHastaSelected;
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
	@Command
	@NotifyChange({ "preferenciaEventos"})
	public void eliminarPreferenciaEvento(@BindingParam("preferenciaEvento") final Preferencia pref) {


		Messagebox.show("Estas seguro de eliminar " + pref.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			public void onEvent(Event evt) throws InterruptedException {
				if (evt.getName().equals("onOK")) {
					try {							
						preferenciaEventos.remove(pref);
						setPreferenciaEventos(preferenciaEventos);
						Messagebox.show(pref.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
								Messagebox.INFORMATION);		
					} catch (Exception e) {
						Messagebox.show(e.getMessage(), pref.getDescripcion() + " No se pudo eliminar",
								Messagebox.OK, Messagebox.ERROR);
					}
				}
			}
		});


	}


	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		this.isPdf = true;
		cargarSql();
	}

	@Command
	public void btnTXT(Event e) throws SQLException, JRException, IOException {
		this.isPdf = false;
		cargarSql();
	}

	public void cargarSql() throws FileNotFoundException, JRException, SQLException{

		try {
			Class.forName ("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");


		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}

		
		sql = "SELECT DISTINCT p.nombre || ' ' || p.apellido as NOMBRE, "
				+ "CASE WHEN p.sexo = 'M' THEN 'Masculino' else 'Femenino' end as SEXO, p.telefono as TELEFONO, "
				+ "s.nro_carnet as CARNET FROM socio s "
				+ "INNER JOIN persona p ON s.personaid_persona = p.id_persona "
				+ "INNER JOIN preferencia_persona pp ON pp.personaid_persona = p.id_persona "
				+ "INNER JOIN preferencia pre ON pre.id_preferencia = pp.preferenciaid_preferencia "
				+ "INNER JOIN tipo_preferencia tipop ON tipop.id_tipo_preferencia = pre.tipo_preferenciaid_tipo_preferencia  "
				+ "WHERE p.activo = true ";

		if(this.sexoSelected == null){
			Messagebox.show("Seleccione un Sexo", "warning", Messagebox.OK, Messagebox.EXCLAMATION);

		} else if (this.sexoSelected.equalsIgnoreCase("Femenino")){
			consulta += "Los socios del sexo Femeninos ";
			sql += "  and p.sexo = 'F'";
			dataSql();
		} else if (this.sexoSelected.equalsIgnoreCase("Todos")){
			consulta += "Los socios ";
			sql += " and (p.sexo = 'M' or p.sexo = 'F')";
			dataSql();
		}else if(this.sexoSelected.equalsIgnoreCase("Masculino")) {
			consulta += "Los socios del sexo Masculino ";
			sql += " and p.sexo = 'M'";
			dataSql();
		}
	}


	public void dataSql() throws FileNotFoundException, JRException, SQLException{

		if(this.tipoPreferenciaSelected != null ){
			consulta += "con preferencia "+ tipoPreferenciaSelected.getDescripcion() + " ";			
			sql += " and tipop.id_tipo_preferencia = " + tipoPreferenciaSelected.getIdTipoPreferencia();


		}		

		if(this.preferenciaEventos != null){
			for (Preferencia pe : preferenciaEventos) {
				//sql += " and pre.id_preferencia = "+ pe.getIdPreferencia();
				sql += " or pp.preferenciaid_preferencia = "+ pe.getIdPreferencia();
			}
			
		}
		if( (null == this.edadHastaSelected &&  this.edadDedeSelected == null) || (null == this.edadHastaSelected ||  this.edadDedeSelected == null) ){
			generarPDF();//VALIDAR
		} else if(Integer.valueOf(this.edadDedeSelected)  > Integer.valueOf(this.edadHastaSelected)) {
			Messagebox.show("Edad desde no puede ser mayor que edad hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			consulta += "y edades entre "+ Integer.valueOf(this.edadDedeSelected) + " y " +  Integer.valueOf(this.edadHastaSelected)+ ".";
			sql +=" AND substring(age(now(),p.fecha_nac)::text from 1 for 2)::int between "+ Integer.valueOf(this.edadDedeSelected) +" and "+ Integer.valueOf(this.edadHastaSelected) +" ";
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
			Messagebox.show("No existe informacion para generar un reportes con los datos seleccionados.", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
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
	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}	

	public ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception {
		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
	}




	public ArrayList<Integer> getListaedades() {
		for (int i = 0; i < 100; i++)
		{
			listaedades.add(i);		   
		}
		return listaedades;
	}

	public void setListaedades(ArrayList<Integer> listaedades) {
		for (int i = 0; i < 100; i++)
		{
			listaedades.add(i);		   
		}
		this.listaedades = listaedades;
	}



}





