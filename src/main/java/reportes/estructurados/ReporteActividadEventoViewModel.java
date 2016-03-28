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
import java.util.Iterator;
import java.util.List;
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
import Dao.ActividadDao;
import modelos.Actividad;
import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.InstalacionDao;
import modelos.Evento;
import modelos.Instalacion;
import modelos.Postulacion;
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

public class ReporteActividadEventoViewModel {
	
	
	//Declaracion
	
		private ActividadDao actividadDao;
	    private EventoDao eventoDao;
	    private Evento evento;
	    private List<Evento> eventos;
	    private String nombreFiltro;
	    private Evento eventoSelected;
	    private String fecha_inicial;
		private String fecha_hasta;
	    private List<Evento> eventosListoEjecutar;
		private List<Evento> eventosEjecucion;
		private List<Evento> eventosAll;
		private EstadoEventoDao estadoEventoDao;
		
	//Declaracion del reporte
		
		private String consulta = "";
		private String titulo = "";
		private String sql = "";
		private String reporte;
		private String reporteTxt;
		private Connection con;
		private Map<String, Object> parameters = new HashMap<String, Object>();
		private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
		private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");
		private boolean isPdf;
		private String rutaNoEstructurado;
		
		@Init
		public void init() throws Exception {
			
			eventosAll = new ArrayList<Evento>();
			eventoDao = new EventoDao();
			estadoEventoDao = new EstadoEventoDao();
			eventosListoEjecutar = eventoDao.obtenerPorEstado(estadoEventoDao.obtenerEstadoEvento(2));
			eventosEjecucion = eventoDao.obtenerPorEstado(estadoEventoDao.obtenerEstadoEvento(3));
			eventosAll.addAll(eventosListoEjecutar);
			eventosAll.addAll(eventosEjecucion);
			this.actividadDao = new ActividadDao();
			
		}
		
		public ListModelList<Evento> getAllEventos() {
			return new ListModelList<Evento>(eventosAll);
		}
		
		public String getCantRegistros() {
			return eventosAll.size() + " items en la lista";
		}
		
		public void setNombreFiltro(String nombreFiltro) {
			this.nombreFiltro = nombreFiltro == null ? "" : nombreFiltro.trim();
		}
		
		@NotifyChange("eventoSelected")
		public Evento getEventoSelected() {
			return eventoSelected;
		}

		@NotifyChange("eventoSelected")
		public void setEventoSelected(Evento eventoSelected) {
			this.eventoSelected = eventoSelected;
			
		}
		
			
		public ListModelList<Actividad> getActividad() throws Exception { 
			return new ListModelList<Actividad>(actividadDao.obtenerPorEvento(this.eventoSelected));
			
		}
		
		public ListModelList<Evento> getEvento() {
			return new ListModelList<Evento>(this.eventos);
		}	
		
	
		public String getNombreFiltro() {
			if(nombreFiltro==null)
				return "";
			return nombreFiltro;
		}
		
		
		@Command
		@NotifyChange({ "allEventos", "cantRegistros" })
		public void filtro() throws Exception {
			List<Evento> evento = new ArrayList<Evento>();
			String nomb = getNombreFiltro().toLowerCase();

			for (Iterator<Evento> i = eventoDao.obtenerTodos().iterator(); i.hasNext();) {
				Evento tmp = i.next();
				if (tmp.getNombre().toLowerCase().contains(nomb)) {
					evento.add(tmp);
				}
			}
			eventosAll = evento;
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
		
		
		public void cargarSql() throws FileNotFoundException, JRException, SQLException{
			try {
				Class.forName ("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");

			} catch (ClassNotFoundException el) {
				el.printStackTrace();
			}
			if (this.eventoSelected == null){
				Messagebox.show("Seleccione el evento a consultar", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			
			else{
				
			this.titulo = "Actividades del evento";
			this.consulta = "Reporte del evento: " + this.eventoSelected.getNombre() + " del Centro Atlético América.";
			this.fecha_inicial = this.eventoSelected.getFechaInicio().toString();
			this.fecha_hasta = this.eventoSelected.getFechaFin().toString();
			this.reporte = System.getProperty("user.home") + "/reportes_america/evento_actividad.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_actividad_txt.jrxml";
			
			this.sql = " SELECT a.descripcion, to_char(a.fecha_tope, 'YYYY-MM-DD') as fecha_tope, to_char(a.fecha_realizacion, 'YYYY-MM-DD') as fecha_realizacion, "
					+ "a.valor_real, a.valor_esperado, CASE WHEN a.finalizada = true THEN 'SI' ELSE 'NO' END "
						+ " FROM actividad a"
						+ " WHERE a.eventoid_evento = " + getEventoSelected().getIdEvento() +";";
			
			
			this.generarPDF();
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
					this.rutaNoEstructurado = System.getProperty("user.home") + "/reportes_america/evento_actividad.txt";
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
				Messagebox.show("No existe planificación para este evento.", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}		
			con.close();
		}
	
	public JasperPrint cargarJasper() throws JRException, FileNotFoundException{
		JasperDesign jd = null;
		if(this.isPdf) {
			jd = JRXmlLoader.load(reporte);
		} else {
			jd = JRXmlLoader.load(reporteTxt);
		}
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
		parameters.put("FECHA_INICIAL", fecha_inicial);
		parameters.put("FECHA_HASTA", fecha_hasta);
		parameters.put("IMAGEN_EQUIPO", imagen_equipo );
		parameters.put("IMAGEN_CLUB", image_club);
		return  JasperFillManager.fillReport(jasperRepor, parameters,con);
		
			
	}

}
