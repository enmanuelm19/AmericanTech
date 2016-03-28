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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.iterators.CollatingIterator;
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



public class ReporteEventoViewModel {
	

	
	private TipoPreferenciaDao tipopreferenciaDao;
	private Date fechadesde;
	private Date fechahasta;
	private ArrayList<Preferencia> temporalPreferencia;
	private PreferenciaDao preferenciaDao;
	private TipoPreferencia tipoPreferenciaSelected;
	private Set<Preferencia> preferenciaEventos;
	private ArrayList<Preferencia> seleccionPreferencia;
	private boolean checkestricto, checkcomun, disableestricto, disablecomun, disablecat;
	
	//Reporte
	private int preferencia1,preferencia2, preferencia3, preferencia4, preferencia5;
	private String consulta = "";
	private String titulo = "";
	private String reporte = System.getProperty("user.home") + "/reportes_america/reporte_socios.jrxml";
	private String reporteTxt = System.getProperty("user.home") + "/reportes_america/reporte_socios_txt.jrxml";
	private Connection con;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
	private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	private String sql = "";
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");
	private boolean isPdf;
	private String tituloCategoria; 
	
	@Init
	public void init() {
		tipopreferenciaDao = new TipoPreferenciaDao();
		preferenciaDao = new PreferenciaDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		preferenciaEventos = new HashSet<Preferencia>();
		this.setDisablecat(true);
		this.setCheckcomun(false);
		this.setCheckestricto(false);

	}

	public boolean getDisablecomun() {
		return disablecomun;
	}

	public void setDisablecomun(boolean disablecomun) {
		this.disablecomun = disablecomun;
	}

	public boolean getCheckestricto() {
		return checkestricto;
	}
	@NotifyChange({"disablecomun", "disablecat"})
	public void setCheckestricto(boolean checkestricto) {
		this.checkestricto = checkestricto;
		if(this.checkestricto == true)
		{
			this.setDisablecomun(true);
			this.setDisablecat(false);
		}else
		{
			this.setDisablecomun(false);
			this.setDisablecat(true);
		}
			
	}

	public boolean getDisableestricto() {
		return disableestricto;
	}

	public void setDisableestricto(boolean disableestricto) {
		this.disableestricto = disableestricto;
	}

	public boolean getCheckcomun() {
		return checkcomun;
	}
	@NotifyChange({"disableestricto","disablecat"})
	public void setCheckcomun(boolean checkcomun) {
		this.checkcomun = checkcomun;
		if(this.checkcomun == true)
		{
			this.setDisableestricto(true);
			this.setDisablecat(false);
		}else 
			{
				this.setDisablecat(true);
				this.setDisableestricto(false);
			}
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
	
	public void contarlista(ArrayList<Preferencia> temporalPreferencia)
	{
		
	}
	
	@Command
	@NotifyChange({"preferenciaEventos"})
	public void agregarSeleccionPreferencia() {
		if (this.preferenciaEventos.size()<5)
		{
			Set<Preferencia> tmp = new HashSet<Preferencia>();
			for(Preferencia p : getTemporalPreferencia()){
				tmp.add(p);
			}
			setPreferenciaEventos(tmp);		
		}
		else{
			Messagebox.show("Solo se pueden Seleccionar 5 preferencias", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}

	}

	/*reporte
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
			+ "ON tipop.id_tipo_preferencia = pre.tipo_preferenciaid_tipo_preferencia ";*/
	
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		
	
		this.isPdf = true;
		System.out.println(this.fechadesde);
		System.out.println(this.fechahasta);
		System.out.println(this.checkcomun);
		System.out.println(this.checkestricto);
		cargarSql();
		
	
	}
	
	
	@Command
	public void btnEXCEL(Event e) throws SQLException, JRException, IOException {
		
		this.isPdf = false;
		cargarSql();

	}
	
	public void titulo(){
		this.tituloCategoria = this.tipoPreferenciaSelected.getDescripcion();
	}
	

	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		System.out.println("entre");
		try {
			Class.forName ("org.postgresql.Driver");
		
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
			
			
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		if (this.fechadesde == null && this.fechahasta == null && this.checkcomun == false && this.checkestricto == false)
		{
			this.titulo = "EVENTOS";
			this.consulta= "Eventos de la categoria  ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";
			System.out.println("aqui toy");
			this.sql= " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
					+ " INNER JOIN preferencia_evento pe "
					+ " ON e.id_evento = pe.eventoid_evento "
					+ " INNER JOIN preferencia p "
					+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
					+ " INNER JOIN tipo_preferencia tp "
					+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia ; " ;

			System.out.println(this.sql);
			generarPDF();
		}
		else if (this.fechadesde != null && this.fechahasta == null )
		{
			Messagebox.show("Debe seleccionar la fecha fin con la que va a comparar", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else if (this.fechadesde == null && this.fechahasta != null )
		{
			Messagebox.show("Debe seleccionar la fecha inicio con la que va a comparar", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else if (this.fechadesde == null && this.fechahasta == null && this.checkcomun == true && this.checkestricto == false && this.tipoPreferenciaSelected == null )
		{
			Messagebox.show("Debe seleccionar una Categoria", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}		
		else if (this.fechadesde == null && this.fechahasta == null && this.checkcomun == false && this.checkestricto == true && this.tipoPreferenciaSelected == null )
		{
			Messagebox.show("Debe seleccionar una Categoria", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else if (this.fechadesde == null && this.fechahasta == null && this.checkcomun == true && this.checkestricto == false && this.tipoPreferenciaSelected != null && this.preferenciaEventos.size() == 0 )
		{
			Messagebox.show("Debe seleccionar una Preferencia", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}		
		else if (this.fechadesde == null && this.fechahasta == null && this.checkcomun == false && this.checkestricto == true && this.tipoPreferenciaSelected != null && this.preferenciaEventos.size() == 0)
		{
			Messagebox.show("Debe seleccionar una Preferencia", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}			
		else if (this.fechadesde != null && this.fechahasta != null && this.checkcomun == false && this.checkestricto == false )
		{
			this.titulo = "EVENTOS";
			this.consulta= "Eventos de la categoria  ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";
			System.out.println("aqui toy");
			this.sql= " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
					+ " INNER JOIN preferencia_evento pe "
					+ " ON e.id_evento = pe.eventoid_evento "
					+ " INNER JOIN preferencia p "
					+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
					+ " INNER JOIN tipo_preferencia tp "
					+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
					+ " WHERE e.fecha_inicio BETWEEN '"+ sdf.format(this.fechadesde) +"' and '"+ sdf.format(this.fechahasta)+"';" ;

			System.out.println(this.sql);
			sqlDate();
		}	
		else if (this.tipoPreferenciaSelected != null && this.preferenciaEventos.size() == 0 )
		{
			int tipopreferencia = this.tipoPreferenciaSelected.getIdTipoPreferencia();
			this.titulo = "EVENTOS";
			titulo();
			this.consulta= "Eventos de la categoria "+ this.getTituloCategoria() +" ";
			reporte = System.getProperty("user.home") + "/reportes_america/eventos.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/eventos_txt.jrxml";
			
			if(this.getCheckestricto())
			{
				this.sql= " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+"  " ;
				System.out.println("llegue aqui ");
				sqlDate();				
			}
			else
			{
				this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+"  " ;
				
				sqlDate();			
			}

		
		}
		
		else if(this.preferenciaEventos.size() == 1)
		{
			System.out.println(this.preferenciaEventos.size());
			int tipopreferencia = this.tipoPreferenciaSelected.getIdTipoPreferencia();
			cargarVariables();
			String variable = this.tipoPreferenciaSelected.getDescripcion();
			//Preferencia preferencia1 = this.getPreferenciaEventos().iterator().next();
			int idprefe = getPreferencia1();
			System.out.println(idprefe);

			this.titulo = "EVENTOS";
			titulo();
			this.consulta= "Eventos de la categoria "+ this.getTituloCategoria() +" ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";
			if(this.getCheckestricto())
			{
				this.sql = "select  distinct on (e2.nombre) pe2.*, p2.id_preferencia , e2.nombre, e2.fecha_inicio, "
						+ " e2.fecha_fin, "
						+ "	(select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento "
						+ " and e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),',')) as arreglomatch "
						+ "	from evento e2, preferencia_evento pe2, preferencia p2 "
						+ "	where pe2.eventoid_evento=e2.id_evento and "
						+ " pe2.preferenciaid_preferencia=p2.id_preferencia and "
						+ " (select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento and "
						+ " e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),','))='"+idprefe+"' ";
				System.out.println("pase por aqui :P");
				sqlDate();				
			}
			else 
			{
				this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+" and " 
						+ " p.id_preferencia = "+ idprefe+"";	
				sqlDate();			
			}			
		
		}else if(this.preferenciaEventos.size() == 2)
		{
			System.out.println(this.preferenciaEventos.size());
			int tipopreferencia = this.tipoPreferenciaSelected.getIdTipoPreferencia();
			cargarVariables();
			int idprefe = getPreferencia1();
			int idprefe2 = getPreferencia2();
			System.out.println(idprefe);
			System.out.println(idprefe2);

			this.titulo = "EVENTOS";
			titulo();
			this.consulta= "Eventos de la categoria "+ this.getTituloCategoria() +" ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";
			if(this.getCheckestricto())
			{
				this.sql = "select  distinct on (e2.nombre) pe2.*, p2.id_preferencia , e2.nombre, e2.fecha_inicio, "
						+ " e2.fecha_fin, "
						+ "	(select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento "
						+ " and e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),',')) as arreglomatch "
						+ "	from evento e2, preferencia_evento pe2, preferencia p2 "
						+ "	where pe2.eventoid_evento=e2.id_evento and "
						+ " pe2.preferenciaid_preferencia=p2.id_preferencia and "
						+ " (select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento and "
						+ " e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),','))='"+idprefe+","+idprefe2+"' ";
				System.out.println("------");
				System.out.println(idprefe);
				System.out.println(idprefe2);
				sqlDate();				
			}
			else
			{
				this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+" and " 
						+ " p.id_preferencia in ("+ idprefe2+","+ idprefe+") ";
				sqlDate();			

			}						
			
		}else if(this.preferenciaEventos.size() == 3)
		{
			System.out.println(this.preferenciaEventos.size());
			int tipopreferencia = this.tipoPreferenciaSelected.getIdTipoPreferencia();
			cargarVariables();
			//Preferencia preferencia1 = this.getPreferenciaEventos().iterator().next();
			int idprefe = getPreferencia1();
			int idprefe2 = getPreferencia2();
			int idprefe3 = getPreferencia3();
			System.out.println(idprefe);
			String variable = this.tipoPreferenciaSelected.getDescripcion();	
			this.titulo = "EVENTOS";
			titulo();
			this.consulta= "Eventos de la categoria "+ this.getTituloCategoria() +" ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";

			if(this.getCheckestricto())
			{
				this.sql = "select  distinct on (e2.nombre) pe2.*, p2.id_preferencia , e2.nombre, e2.fecha_inicio, "
						+ " e2.fecha_fin, "
						+ "	(select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento "
						+ " and e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),',')) as arreglomatch "
						+ "	from evento e2, preferencia_evento pe2, preferencia p2 "
						+ "	where pe2.eventoid_evento=e2.id_evento and "
						+ " pe2.preferenciaid_preferencia=p2.id_preferencia and "
						+ " (select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento and "
						+ " e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),','))='"+idprefe+","+idprefe2+","+idprefe3+"' ";
				System.out.println("------");
				System.out.println(idprefe);
				System.out.println(idprefe2);
				System.out.println(idprefe3);
				sqlDate();				
			}
			else
			{
				this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+" and " 
						+ " p.id_preferencia in ("+ idprefe2+","+ idprefe+", "+ idprefe3+") ";			
				sqlDate();			
			}			
 
					
						
		}else if(this.preferenciaEventos.size() == 4)
		{
			System.out.println(this.preferenciaEventos.size());
			int tipopreferencia = this.tipoPreferenciaSelected.getIdTipoPreferencia();
			cargarVariables();
			//Preferencia preferencia1 = this.getPreferenciaEventos().iterator().next();
			int idprefe = getPreferencia1();
			int idprefe2 = getPreferencia2();
			int idprefe3 = getPreferencia3();
			int idprefe4 = getPreferencia4();
			
			System.out.println(idprefe);

			this.titulo = "EVENTOS";
			titulo();
			this.consulta= "Eventos de la categoria "+ this.getTituloCategoria() +" ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";
			if(this.getCheckestricto())
			{
				this.sql = "select  distinct on (e2.nombre) pe2.*, p2.id_preferencia , e2.nombre, e2.fecha_inicio, "
						+ " e2.fecha_fin, "
						+ "	(select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento "
						+ " and e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),',')) as arreglomatch "
						+ "	from evento e2, preferencia_evento pe2, preferencia p2 "
						+ "	where pe2.eventoid_evento=e2.id_evento and "
						+ " pe2.preferenciaid_preferencia=p2.id_preferencia and "
						+ " (select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento and "
						+ " e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),','))='"+idprefe+","+idprefe2+","+idprefe3+", "+ idprefe4+"' ";
				
				sqlDate();				
			}
			else
			{
				this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+" and " 
						+ " p.id_preferencia in ("+ idprefe2+","+ idprefe+", "+ idprefe3+", "+ idprefe4+") ";
				
					sqlDate();	
				}			
		
									
		}else if(this.preferenciaEventos.size() == 5)
		{
			System.out.println(this.preferenciaEventos.size());
			int tipopreferencia = this.tipoPreferenciaSelected.getIdTipoPreferencia();
			cargarVariables();
			//Preferencia preferencia1 = this.getPreferenciaEventos().iterator().next();
			int idprefe = getPreferencia1();
			int idprefe2 = getPreferencia2();
			int idprefe3 = getPreferencia3();
			int idprefe4 = getPreferencia4();
			int idprefe5 = getPreferencia5();			
			
			System.out.println(idprefe);

			this.titulo = "EVENTOS";
			titulo();
			this.consulta= "Eventos de la categoria "+ this.getTituloCategoria() +" ";
			reporte = System.getProperty("user.home") + "/reportes_america/evento.jrxml";
			reporteTxt = System.getProperty("user.home") + "/reportes_america/evento_txt.jrxml";

			if(this.getCheckestricto())
			{
				this.sql = "select  distinct on (e2.nombre) pe2.*, p2.id_preferencia , e2.nombre, e2.fecha_inicio, "
						+ " e2.fecha_fin, "
						+ "	(select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento "
						+ " and e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),',')) as arreglomatch "
						+ "	from evento e2, preferencia_evento pe2, preferencia p2 "
						+ "	where pe2.eventoid_evento=e2.id_evento and "
						+ " pe2.preferenciaid_preferencia=p2.id_preferencia and "
						+ " (select ARRAY_TO_STRING(ARRAY(select preferenciaid_preferencia from preferencia_evento pe, "
						+ " evento e where pe.eventoid_evento=e.id_evento and "
						+ " e.id_evento=e2.id_evento order by pe.preferenciaid_preferencia),','))='"+idprefe+","+idprefe2+","+idprefe3+", "+ idprefe4+", "+ idprefe5+"' ";
				
				sqlDate();				
			}
			else
			{
				this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
						+ " INNER JOIN preferencia_evento pe "
						+ " ON e.id_evento = pe.eventoid_evento "
						+ " INNER JOIN preferencia p "
						+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
						+ " INNER JOIN tipo_preferencia tp "
						+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia "
						+ " WHERE tp.id_tipo_preferencia = "+ tipopreferencia+" and " 
						+ " p.id_preferencia in ("+ idprefe2+","+ idprefe+", "+ idprefe3+", "+ idprefe4+", "+ idprefe5+") ";
				
					sqlDate();
			}	
		
		}
		
		
		System.out.println(sql);
		System.out.println("me fui, no encontre validacion");
		System.out.println(this.preferenciaEventos);
	}
	/*
	public void sqlCargar() throws FileNotFoundException, JRException, SQLException{
		
		if(this.getCheckestricto() == true){
			this.sql = " SELECT distinct e.nombre, e.fecha_inicio, e.fecha_fin FROM evento e "
					+ " INNER JOIN preferencia_evento pe "
					+ " ON e.id_evento = pe.eventoid_evento "
					+ " INNER JOIN preferencia p "
					+ " ON pe.preferenciaid_preferencia = p.id_preferencia "
					+ " INNER JOIN tipo_preferencia tp "
					+ " ON p.tipo_preferenciaid_tipo_preferencia = tp.id_tipo_preferencia ";
			generarPDF();
		} else if (this.fechadesde == null || this.fechahasta == null){
			Messagebox.show("Debe Seleccionar el rango de fechas", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else if (this.fechadesde.compareTo(this.fechahasta) > 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += "entre las fechas " + sdf.format(this.fechadesde) + " y "+ sdf.format(this.fechahasta)+".";
			sql += " and e.fecha_inicio BETWEEN '"+ sdf.format(this.fechadesde) +"' and '"+ sdf.format(this.fechahasta)+"';" ;
						
			generarPDF();
		}
	}*/	
	
	public void sqlDate() throws FileNotFoundException, JRException, SQLException{
			
		if(this.fechadesde != null && this.fechahasta != null && this.checkcomun == false && this.checkcomun == false){
			System.out.println("Aqui toy1");
			generarPDF();
		}else if (this.fechadesde == null || this.fechahasta == null){
			sql += " ; ";
			System.out.println("Aqui toy2 - nueva validacion funciona");
			generarPDF();
		}else if (this.fechadesde.compareTo(this.fechahasta) > 1 ){
			Messagebox.show("Fecha Desde no puede ser mayor a la Fecha Hasta", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += "entre las fechas " + sdf.format(this.fechadesde) + " y "+ sdf.format(this.fechahasta)+".";
			sql += " and e.fecha_inicio BETWEEN '"+ sdf.format(this.fechadesde) +"' and '"+ sdf.format(this.fechahasta)+"';" ;
						
			generarPDF();
			System.out.println("Aqui toy3");
		}

	}		
	public void generarPDF() throws JRException, FileNotFoundException, SQLException {
		String nombreArchivo = titulo;
		JasperPrint jasperPrint = cargarJasper();
			
		
		if(jasperPrint.getPages().size() > 0){
			if(this.isPdf) {
				JRExporter exporter = new JRPdfExporter();
				Filedownload.save(JasperExportManager.exportReportToPdf(jasperPrint), "application/pdf", nombreArchivo+".pdf");
			} else {
				JRExporter exporterTxt = new JRTextExporter();
				exporterTxt.setParameter(JRTextExporterParameter.JASPER_PRINT, jasperPrint);
				exporterTxt.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, System.getProperty("user.home") + "/reportes_america/estadisticos_evento.txt");
				exporterTxt.setParameter(JRTextExporterParameter.PAGE_WIDTH,130);
				exporterTxt.setParameter(JRTextExporterParameter.PAGE_HEIGHT,130);
				exporterTxt.exportReport();
				FileInputStream input = new FileInputStream(System.getProperty("user.home") + "/reportes_america/evento.txt");
			    Filedownload.save(input, "txt", "reporte.txt");	    
			    con.close();
			    
			    try{
		    		File file = new File(("user.home") + "/reportes_america/evento.txt");
		    		file.delete();	
		    	}catch(Exception e){
		    		
		    		e.printStackTrace();
		    		
		    	}
			    
			}
			
		} else {
			Messagebox.show("No existe informacion para generar un reportes con los datos seleccionados.", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
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

	public void cargarVariables(){		
		ArrayList<Preferencia> tmp = new ArrayList<Preferencia>(getPreferenciaEventos());		
		ArrayList id = new ArrayList();
		int arr[] = new int[tmp.size()];
		for(int i = 0; i<tmp.size(); i++){
			if(i==0){
				arr[i] = tmp.get(i).getIdPreferencia();
			}else if(i==1){
				arr[i] = tmp.get(i).getIdPreferencia();
			}else if(i == 2){
				arr[i] = tmp.get(i).getIdPreferencia();
			}else if(i == 3){
				arr[i] = tmp.get(i).getIdPreferencia();
			}else{
				arr[i] = tmp.get(i).getIdPreferencia();
			}
		}

        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr.length - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmpo = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmpo;
                }
            }
        }
        
		for(int i = 0; i<tmp.size(); i++){
			if(i==0){
				this.setPreferencia1(arr[i]);
			}else if(i==1){
				this.setPreferencia2(arr[i]);
			}else if(i == 2){
				this.setPreferencia3(arr[i]);
			}else if(i == 3){
				this.setPreferencia4(arr[i]);
			}else{
				this.setPreferencia5(arr[i]);
			}
		}
        for(int i = 0;i < arr.length; i++)

        {

            System.out.println(arr[i] + "asdad");

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

		/*
		if( (null == this.edadHastaSelected &&  this.edadDedeSelected == null) || (null == this.edadHastaSelected ||  this.edadDedeSelected == null) ){
			generarPDF();//VALIDAR
		} else if(Integer.valueOf(this.edadDedeSelected)  > Integer.valueOf(this.edadHastaSelected)) {
			Messagebox.show("Edad desde no puede ser mayor que edad hasta", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			consulta += "y edades entre "+ Integer.valueOf(this.edadDedeSelected) + " y " +  Integer.valueOf(this.edadHastaSelected)+ ".";
			sql +=" AND substring(age(now(),p.fecha_nac)::text from 1 for 2)::int between "+ Integer.valueOf(this.edadDedeSelected) +" and "+ Integer.valueOf(this.edadHastaSelected) +" ";
			generarPDF();
		}*/
	}
	
	public int getPreferencia2() {
		return preferencia2;
	}

	public void setPreferencia2(int preferencia2) {
		this.preferencia2 = preferencia2;
	}

	public int getPreferencia4() {
		return preferencia4;
	}

	public void setPreferencia4(int preferencia4) {
		this.preferencia4 = preferencia4;
	}

	public int getPreferencia5() {
		return preferencia5;
	}

	public void setPreferencia5(int preferencia5) {
		this.preferencia5 = preferencia5;
	}

	public int getPreferencia3() {
		return preferencia3;
	}

	public void setPreferencia3(int preferencia3) {
		this.preferencia3 = preferencia3;
	}

	public int getPreferencia1() {
		return preferencia1;
	}

	public void setPreferencia1(int preferencia1) {
		this.preferencia1 = preferencia1;
	}

	public String getTituloCategoria() {
		return tituloCategoria;
	}

	public void setTituloCategoria(String tituloCategoria) {
		this.tituloCategoria = tituloCategoria;
	}

	public boolean getDisablecat() {
		return disablecat;
	}

	public void setDisablecat(boolean disablecat) {
		this.disablecat = disablecat;
	}



}
