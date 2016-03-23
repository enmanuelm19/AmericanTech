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



public class ReporteEventualidadesEstViewModel {
	
	private String tipo;
	private Time horaInicio;
	private Time horaFin;
	private Date fechaDesde;
	private Date fechaHasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	private String carnet;
	private boolean hora;
	private boolean horaDesde;
	private boolean horaHasta;
	private boolean instalacioncheck;
	private boolean instalacion;
	private String horaDesdeSelect, horaHastaSelect;
	
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
		this.setHoraDesde(true);
		this.setHoraHasta(true);
		this.setInstalacion(true);

	}

	
	@NotifyChange("tipoInstalacionSelected")
	public TipoInstalacion getTipotipoInstalacionSelected() {
		return tipoInstalacionSelected;
	}

	@NotifyChange("InstalacionPorTipo")
	public void setTipoInstalacionSelected(TipoInstalacion tipoInstalacionSelected) {
		this.tipoInstalacionSelected = tipoInstalacionSelected;
	}


	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	/*public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}*/

	public String getTipo() {
		return tipo;
	}

	@NotifyChange({"disablecarnet","disableinstalaciones"})

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	/*@Command
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
				this.carnet="";
			}
			else {
				Messagebox.show("Carnet encontrado", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);	
			}

		}
	}*/

	public boolean getHora() {
		return hora;
	}

	@NotifyChange({"horaDesde","horaHasta"})
	public void setHora(boolean hora) {
		this.hora = hora;
		if (this.hora == true)
		{
			this.horaDesde = false;
			this.horaHasta = false;
		}
		else
		{
			this.horaDesde = true;
			this.horaHasta = true;			
		}	
	}


	public boolean getHoraDesde() {
		return horaDesde;
	}


	public void setHoraDesde(boolean horaDesde) {
		this.horaDesde = horaDesde;
	}


	public boolean getHoraHasta() {
		return horaHasta;
	}


	public void setHoraHasta(boolean horaHasta) {
		this.horaHasta = horaHasta;
	}


	public boolean getInstalacioncheck() {
		return instalacioncheck;
	}

	@NotifyChange({"instalacion"})
	public void setInstalacioncheck(boolean instalacioncheck) {
		this.instalacioncheck = instalacioncheck;
		if (this.instalacioncheck == true)
		{
			this.instalacion = false;
		}
		else
		{
			this.instalacion = true;
		}
	}


	public boolean getInstalacion() {
		return instalacion;
	}


	public void setInstalacion(boolean instalacion) {
		this.instalacion = instalacion;
	}
	

	@NotifyChange("horaDesdeSelect")
	public String getHoraDesdeSelect() {
		return this.horaDesdeSelect;
	}
	
	@NotifyChange("horaDesdeSelect")
	public void setHoraDesdeSelect(String horaDesdeSelect) {
		this.horaDesdeSelect = horaDesdeSelect;
	}


	
	@NotifyChange("horaHastaSelect")
	public String getHoraHastaSelect() {
		return this.horaHastaSelect;
	}
	
	@NotifyChange("horaHastaSelect")
	public void setHoraHastaSelect(String horaHastaSelect) {
		this.horaHastaSelect = horaHastaSelect;
	}

	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		cargarSql();		
	}
	
	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		try {
			Class.forName ("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		if(this.fechaDesde == null && this.fechaHasta == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechaDesde == null || this.fechaHasta == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechaDesde.compareTo(this.fechaHasta) > 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			if(!this.hora && !this.instalacion){
				salida1();
			} else if(this.hora && !this.instalacion){
				salida2();
			} else if (this.hora && this.instalacion){
				salida3();
			} else {
				salida4();
			}
		}
		
		
		
		
		
		
	}
	
	private void salida4() {
		// TODO Auto-generated method stub
		
	}


	private void salida2() throws FileNotFoundException, JRException, SQLException {
		reporte = System.getProperty("user.home") + "/reportes_america/estadisticos_eventualidad2.jrxml";
		this.consulta += "Reporte general de eventualidad ";
			this.consulta += "Reporte de eventualidaes entre la hora " + Integer.valueOf(this.horaDesdeSelect) + " y "+  Integer.valueOf(this.horaHastaSelect)+".";
		
		
		if(this.horaDesdeSelect == null && this.horaHastaSelect == null){
			reporte = System.getProperty("user.home") + "/reportes_america/estadisticos_eventualidad1.jrxml";
			sql = "select i.nombre as Instalacion, COUNT(e.*), (COUNT(e.*) *100) /(select COUNT(*) from eventualidad) as Porcentaje "
					+ "from instalacion i, eventualidad e "
					+ "where i.id_instalacion = e.instalacionid_instalacion and "
					+ "i.activo = e.activo = TRUE  group by i.id_instalacion";
			this.consulta += "Reporte general de eventualidaes sin un rango de fechas.";
			generarPDF();
			
		} else if (this.horaDesdeSelect == null || this.horaHastaSelect == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.horaDesdeSelect.compareTo(this.horaHastaSelect) > 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += "Reporte de eventualidaes entre las fechas " + sdf.format(this.fechaDesde) + " y "+ sdf.format(this.fechaHasta)+".";
			
					sql = "select DISTINCT ((select COUNT(*) from eventualidad e "
							+ "where date_part('hour', e.fecha)< "+ Integer.valueOf(this.horaDesdeSelect) +") * 100) / (select COUNT(*) from eventualidad e)  as Antes, "
							+ "((select COUNT(*) from eventualidad e where date_part('hour', e.fecha) "
							+ "between "+ Integer.valueOf(this.horaDesdeSelect) +" and "+ Integer.valueOf(this.horaHastaSelect) +" )* 100) / (select COUNT(*) from eventualidad e)  as Seleccion, "
							+ "((select COUNT(*) from eventualidad e where date_part('hour', e.fecha)> "+ Integer.valueOf(this.horaHastaSelect) +")  * 100) / (select COUNT(*) from eventualidad e)  as Despues "
							+ "from eventualidad e "
							+ "where e.fecha between '"+sdf.format(this.fechaDesde)+"' and '"+  sdf.format(this.fechaHasta) +"' and e.activo = true;";
		
			generarPDF();
		}		
	}



	private void salida3() {
		sql = "Select te.descripcion, COUNT(e.*) as Cantidad, ( COUNT(e.*) * 100)/(SELECT COUNT(e.*) from eventualidad e "
				+ "WHERE e.fecha between '"+sdf.format(this.fechaDesde)+"' and '"+sdf.format(this.fechaHasta)+"' and e.instalacionid_instalacion =  "+this.in+") as Porcentaje "
				+ "from eventualidad e, tipo_eventualidad te "
				+ "where e.fecha between '03-01-2016' and '03-30-2016' "
				+ "and e.tipo_eventualidadid_tipo_eventualidad = te.id_tipo_eventualidad "
				+ "and e.instalacionid_instalacion = 1 group by te.id_tipo_eventualidad";
		
	}


	public void salida1() throws FileNotFoundException, JRException, SQLException{
		reporte = System.getProperty("user.home") + "/reportes_america/estadisticos_eventualidad1.jrxml";
		this.consulta += "Reporte general de eventualid ";
			this.consulta += "Reporte de eventualidaes entre las fechas " + sdf.format(this.fechaDesde) + " y "+ sdf.format(this.fechaHasta)+".";
			
			sql = "select i.nombre as Instalacion, COUNT(e.*), "
					+ "(COUNT(e.*) *100) /(select COUNT(*) from eventualidad "
					+ "where fecha between '03/01/2015' and '03/30/2016') as Porcentaje "
					+ "from instalacion i, eventualidad e "
					+ "where i.id_instalacion = e.instalacionid_instalacion "
					+ "and i.activo = e.activo = TRUE "
					+ "and e.fecha between '"+sdf.format(this.fechaDesde)+"' and '"+  sdf.format(this.fechaHasta) +"' group by i.id_instalacion ";
			
			generarPDF();
	}
	
	
	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		Date hoy = (Date) Calendar.getInstance().getTime();
		String date = "-"+sdfGuio.format(hoy).toString();
		String nombreArchivo = this.titulo.concat(date);
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
