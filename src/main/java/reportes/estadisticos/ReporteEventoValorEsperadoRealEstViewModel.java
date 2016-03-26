package reportes.estadisticos;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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
import javax.servlet.ServletOutputStream;
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

import com.lowagie.text.pdf.codec.Base64.InputStream;

import Dao.EventoDao;
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
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;




public class ReporteEventoValorEsperadoRealEstViewModel {
	
	private Evento eventoSelected;
	private EventoDao eventoDao;

	//reporte
	private String sql = "";
	
	private String consulta = "";
	private String titulo = "Sanciones";
	private String reporte;
	private Connection con;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
	private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");


	@Init
	public void init() {
		eventoDao = new EventoDao();
	}
	
	public ListModelList<Evento> getEventos() throws Exception {

		return new ListModelList<Evento>(eventoDao.obtenerTodos());

	}	
	
	@NotifyChange("eventoSelected")
	public Evento getEventoSelected() {
		return this.eventoSelected;
	}

	@NotifyChange("eventoSelected")
	public void setEventoSelected(Evento eventoSelected) {
		this.eventoSelected = eventoSelected;
	}
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		
		try {
			Class.forName ("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		if(this.eventoSelected == null){
			Messagebox.show("Debe Seleccionar una instalacion", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			reporte = System.getProperty("user.home") + "/reportes_america/estadisticos_evento.jrxml";
			this.consulta = "Reporte del evento "+ this.eventoSelected.getNombre() +", referente a: "
					+ this.eventoSelected.getDescripcion() +".";
		
			sql = "Select DISTINCT e.nombre as evento, i.descripcion as indicador, ie.valor_esperado, ie.valor_real "
					+ "from indicador i, evento e, indicador_evento ie, preferencia p, preferencia_evento pe, tipo_preferencia tp "
					+ "where i.id_indicador = ie.indicadorid_indicador and e.id_evento = ie.eventoid_evento and e.id_evento = pe.eventoid_evento "
					+ "and p.id_preferencia = pe.preferenciaid_preferencia "
					+ "and e.id_evento = "+ this.eventoSelected.getIdEvento()
					+ " and i.activo=e.activo=ie.activo=p.activo=pe.activo=tp.activo=TRUE "
					+ " order by e.nombre";
			generarPDF();
		}		
	}

	
	
	public void generarPDF() throws JRException, SQLException, IOException {
		Date hoy = (Date) Calendar.getInstance().getTime();
		String date = "-"+sdfGuio.format(hoy).toString();
		String nombreArchivo = this.titulo.concat(date);
		JasperPrint jasperPrint = cargarJasper();
		
		
		if(jasperPrint.getPages().size() > 0){
		   Filedownload.save(JasperExportManager.exportReportToPdf(jasperPrint), "application/pdf", nombreArchivo+".pdf"); 
		} else {
			Messagebox.show("No existe informacion para generar un reportes con los datos seleccionados.", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}
	   
	    
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
