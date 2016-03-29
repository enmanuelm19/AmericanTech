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
import Dao.InstalacionDao;
import Dao.PersonaDao;
import Dao.PreferenciaDao;
import Dao.SocioDao;
import Dao.TipoPreferenciaDao;
import modelos.Instalacion;
import modelos.Persona;
import modelos.Preferencia;
import modelos.Socio;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteSociosEstViewModel {
	
	private Socio socio;
	private SocioDao socioDao;
	private String carnet;	
	private String tipo;
	private int estadoinstalacion;
	private Date fechadesde;
	private Date fechahasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	private TipoPreferencia tipoPreferenciaSelected;
	private PreferenciaDao preferenciaDao;
	
	private int edaddesde;
	private int edadhasta;
	private String sexo;
	private String categoria;
	private Preferencia preferencia;
	private TipoPreferenciaDao tipopreferenciaDao;
	private boolean checkedad;
	private boolean checksexo;
	private boolean checkcategoria;
	private boolean checkpreferencia;
	private boolean disableedad, disablesexo, disablecategoria, disablepreferencia, disablecheckpref;
	private ArrayList<Integer> listaedades;
	
	private String consulta = "";
	private String titulo = "";
	private String reporte = System.getProperty("user.home") + "/reportes_america/estadisticos_socios.jrxml";
	private Connection con;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	private File img = new File(System.getProperty("user.home") + "/reportes_america/imagen_club.png");
	private File img2 = new File(System.getProperty("user.home") + "/reportes_america/imagen_equipo.png");
	private String sqlparticular = "";
	private String sqlParticularAfiliado = "";
	private String sqlGeneral, sqlGeneralAfiliado;
	private String sql = "SELECT DISTINCT ";
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"), sdfGuio = new SimpleDateFormat("dd-MM-yyyy");
	private boolean isPdf;
	


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
		preferenciaDao = new PreferenciaDao();
		tipopreferenciaDao = new TipoPreferenciaDao();
		this.socio = new Socio();
		this.disablecategoria = true ;
		this.disableedad = true ;
		this.disablepreferencia = true ;
		this.disablesexo = true ;
		this.disablecheckpref = true;
		listaedades =new ArrayList<Integer>();
	}
	public ArrayList<Integer> getListaedades() {
		for (int i = 0; i < 100; i++)
		{
			listaedades.add(i);		   
		}	
		return listaedades;
	}

	public void setListaedades(ArrayList<Integer> listaedades) {
		this.listaedades = listaedades;
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
	
	public ListModelList<TipoPreferencia> getTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tipopreferenciaDao.obtenerTodos());

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

	public int getEdaddesde() {
		return edaddesde;
	}

	public void setEdaddesde(int edaddesde) {
		this.edaddesde = edaddesde;
	}

	public int getEdadhasta() {
		return edadhasta;
	}

	public void setEdadhasta(int edadhasta) {
		this.edadhasta = edadhasta;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public boolean isCheckedad() {
		return checkedad;
	}

	@NotifyChange("disableedad")
	public void setCheckedad(boolean checkedad) {
		this.checkedad = checkedad;
		if (this.checkedad == true)
		{
			this.setDisableedad(false);
		}else this.setDisableedad(true);
		
	}

	public boolean isChecksexo() {
		return checksexo;
	}

	@NotifyChange("disablesexo")
	public void setChecksexo(boolean checksexo) {
		this.checksexo = checksexo;
		if (this.checksexo == true)
		{
			this.setDisablesexo(false);
		}else this.setDisablesexo(true);
		
	}

	public boolean isCheckcategoria() {
		return checkcategoria;
	}

	@NotifyChange({"disablecategoria","disablecheckpref", "disablepreferencia"})
	public void setCheckcategoria(boolean checkcategoria) {
		this.checkcategoria = checkcategoria;
		if (this.checkcategoria == true)
		{
			this.setDisablecategoria(false);
			this.setDisablecheckpref(false);
		}else
			{
				this.setDisablecategoria(true);
				this.setDisablecheckpref(true);
				this.setDisablepreferencia(true);
				this.setCheckpreferencia(false);
			}	
	}

	public boolean isCheckpreferencia() {
		return checkpreferencia;
	}

	@NotifyChange({"disablepreferencia"})
	public void setCheckpreferencia(boolean checkpreferencia) {
		this.checkpreferencia = checkpreferencia;
		if (this.checkpreferencia == true)
		{
			this.setDisablepreferencia(false);
		}else this.setDisablepreferencia(true);
		
	}
	
	public boolean getDisablecheckpref() {
		return disablecheckpref;
	}
	public void setDisablecheckpref(boolean disablecheckpref) {
		this.disablecheckpref = disablecheckpref;
	}
	
	public boolean getDisableedad() {
		return disableedad;
	}

	public void setDisableedad(boolean disableedad) {
		this.disableedad = disableedad;
	}

	public boolean getDisablepreferencia() {
		return disablepreferencia;
	}

	public void setDisablepreferencia(boolean disablepreferencia) {
		this.disablepreferencia = disablepreferencia;
	}

	public boolean getDisablecategoria() {
		return disablecategoria;
	}

	public void setDisablecategoria(boolean disablecategoria) {
		this.disablecategoria = disablecategoria;
	}

	public boolean getDisablesexo() {
		return disablesexo;
	}

	public void setDisablesexo(boolean disablesexo) {
		this.disablesexo = disablesexo;
	}
	
	
	@Command
	public void btnPDF(Event e) throws SQLException, JRException, IOException {
		this.isPdf = true;
		cargarSql();
	}
	

	
	public void cargarSql() throws FileNotFoundException, JRException, SQLException{
		try {
			Class.forName ("org.postgresql.Driver");
		
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/America","postgres","postgres");
			
			
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
				
		sql = "SELECT DISTINCT ";
		this.titulo = "SOCIOS";
		this.consulta= "Socios y afiliados";
		if ( this.checkedad == false && this.checksexo == false && this.checkcategoria == false && this.checkpreferencia == false  ) //
		{
			Messagebox.show("Debe seleccionar almenos una opción de busqueda", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		//1
		else if (this.checkedad == true && this.checksexo == false && this.checkcategoria == false && this.checkpreferencia == false)
		{	

			this.sqlparticular = " SELECT Count(p.id_persona) FROM socio s, persona p "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = "SELECT Count(p.id_persona) FROM afiliado a, persona p "
					+ " WHERE a.personaid_persona = p.id_persona ";
			
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			if(sqlAge())
				sqlFinal();

		}
		//1,2
		else if (this.checkedad == true && this.checksexo == true && this.checkcategoria == false && this.checkpreferencia == false)
		{
			
			this.sqlparticular = " SELECT Count(p.id_persona) FROM socio s, persona p "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = "SELECT Count(p.id_persona) FROM afiliado a, persona p "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
	
			if(sqlAge() && sqlSexo())
				sqlFinal();

		}
		//1,2,3
		else if (this.checkedad == true && this.checksexo == true && this.checkcategoria == true && this.checkpreferencia == false)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			
			if(sqlAge() && sqlSexo() && sqlCategoria())
				sqlFinal();

		}	
		//1,2,3,4
		else if (this.checkedad == true && this.checksexo == true && this.checkcategoria == true && this.checkpreferencia == true)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			
			if( sqlAge() && sqlSexo() && sqlPreferencia() )
				sqlFinal();
			
		}
		//1,3
		else if (this.checkedad == true && this.checksexo == false && this.checkcategoria == true && this.checkpreferencia == false)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			
			if(sqlAge() && sqlCategoria())
				sqlFinal();

		}
		//1,3,4
		else if (this.checkedad == true && this.checksexo == false && this.checkcategoria == true && this.checkpreferencia == true)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
		
			if(sqlAge() && sqlCategoria() && sqlPreferencia() )
				sqlFinal();

		}
		//2
		else if (this.checkedad == false && this.checksexo == true && this.checkcategoria == false && this.checkpreferencia == false)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
		
			if(sqlSexo())
				sqlFinal();

		}	
		//2,3
		else if (this.checkedad == false && this.checksexo == true && this.checkcategoria == true && this.checkpreferencia == false)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			
			if(sqlSexo() && sqlCategoria())
				sqlFinal();

		}			
		//2,3,4
		else if (this.checkedad == false && this.checksexo == true && this.checkcategoria == true && this.checkpreferencia == true)
		{

			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			

			if(sqlSexo() && sqlCategoria() &&  sqlPreferencia()  )
				sqlFinal();

		}
		//3
		else if (this.checkedad == false && this.checksexo == false && this.checkcategoria == true && this.checkpreferencia == false)
		{
			
			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			
			if(sqlCategoria())
				sqlFinal();

		}
		//3,4
		else if (this.checkedad == false && this.checksexo == false && this.checkcategoria == true && this.checkpreferencia == true)
		{

			this.sqlparticular = " SELECT DISTINCT Count(p.id_persona) FROM socio s, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE s.personaid_persona = p.id_persona ";
			
			this.sqlParticularAfiliado = " SELECT DISTINCT Count(p.id_persona) FROM afiliado a, persona p, tipo_preferencia tp, "
					+ " preferencia_persona prefp, preferencia pref "
					+ " WHERE a.personaid_persona = p.id_persona ";
			this.sqlGeneral = this.sqlparticular;
			this.sqlGeneralAfiliado = this.sqlParticularAfiliado;
			if( sqlCategoria() && sqlPreferencia() )
			   sqlFinal();

		}	
		
	}
	public boolean sqlAge() throws FileNotFoundException, JRException, SQLException{
		
		if(this.edaddesde > this.edadhasta){
			Messagebox.show("Debe seleccionar un rango de edades valido", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			return false;
		} else {
			this.consulta += ", entre las edades "+ Integer.valueOf(this.edaddesde) +" y "+ Integer.valueOf(this.edadhasta) +" ";
			sqlparticular += " AND substring(age(now(),p.fecha_nac)::text from 1 for 2)::int between "+ Integer.valueOf(this.edaddesde) +" and "+ Integer.valueOf(this.edadhasta) +" ";
			this.sqlParticularAfiliado += " AND substring(age(now(),p.fecha_nac)::text from 1 for 2)::int between "+ Integer.valueOf(this.edaddesde) +" and "+ Integer.valueOf(this.edadhasta) +" ";
			return true;
		}
	}
	public boolean sqlSexo() throws FileNotFoundException, JRException, SQLException{
		
		if(this.sexo == null){
			Messagebox.show("Debe seleccionar un sexo", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			return false;
		} else if(this.sexo.equalsIgnoreCase("Masculino")){
			this.consulta += ",del sexo Masculino"; 
			sqlparticular += " and p.sexo = 'M' ";
			this.sqlParticularAfiliado += " and p.sexo = 'M' ";
		} else if(this.sexo.equalsIgnoreCase("Femenino")) {
			this.consulta += ", del sexo Femenino"; 
			sqlparticular += " and p.sexo = 'F'"; 
			this.sqlParticularAfiliado = " and p.sexo = 'F'"; 
		}  else {
			this.consulta += ", de ambos sexos";
		}
		return true;
	}
	public boolean sqlCategoria() throws FileNotFoundException, JRException, SQLException{
		
		if(this.tipoPreferenciaSelected == null){
			Messagebox.show("Debe seleccionar una Catégoria", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			return false;
		} else {
			this.consulta += " con catégoria " + this.tipoPreferenciaSelected.getDescripcion() + " ";
			sqlparticular += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "
				+ " and tp.id_tipo_preferencia = "+this.tipoPreferenciaSelected.getIdTipoPreferencia()+" "	
				+ " and prefp.preferenciaid_preferencia = pref.id_preferencia "
				+ " and p.id_persona = prefp.personaid_persona ";
			this.sqlParticularAfiliado += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "
					+ " and tp.id_tipo_preferencia = "+this.tipoPreferenciaSelected.getIdTipoPreferencia()+" "	
					+ " and prefp.preferenciaid_preferencia = pref.id_preferencia "
					+ " and p.id_persona = prefp.personaid_persona ";
			
			this.sqlGeneral += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "	
					+ " and prefp.preferenciaid_preferencia = pref.id_preferencia "
					+ " and p.id_persona = prefp.personaid_persona ";
			
			this.sqlGeneralAfiliado += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "	
					+ " and prefp.preferenciaid_preferencia = pref.id_preferencia "
					+ " and p.id_persona = prefp.personaid_persona ";
			
			this.consulta += ", con la categoria " + this.tipoPreferenciaSelected.getDescripcion();
			return true;
		}
	}	
	
	public boolean sqlPreferencia() throws FileNotFoundException, JRException, SQLException{
		
		if(this.preferencia == null){
			Messagebox.show("Debe seleccionar una preferencia", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			return false;
		} else {
			sqlparticular += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "
					+ " and tp.id_tipo_preferencia = "+this.tipoPreferenciaSelected.getIdTipoPreferencia()+" "	
					+ " and prefp.preferenciaid_preferencia = "+this.preferencia.getIdPreferencia()
					+ " and p.id_persona = prefp.personaid_persona ";
			
			this.sqlParticularAfiliado += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "
					+ " and tp.id_tipo_preferencia = "+this.tipoPreferenciaSelected.getIdTipoPreferencia()+" "	
					+ " and prefp.preferenciaid_preferencia = "+this.preferencia.getIdPreferencia()
					+ " and p.id_persona = prefp.personaid_persona ";
			
			sqlGeneral += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "
					+ " and tp.id_tipo_preferencia = "+this.tipoPreferenciaSelected.getIdTipoPreferencia()+" "	
					+ " and p.id_persona = prefp.personaid_persona ";
			
			this.sqlGeneralAfiliado += " and tp.id_tipo_preferencia = pref.tipo_preferenciaid_tipo_preferencia "
					+ " and tp.id_tipo_preferencia = "+this.tipoPreferenciaSelected.getIdTipoPreferencia()+" "	
					+ " and p.id_persona = prefp.personaid_persona ";
			
			this.consulta += " y preferencia: " + this.preferencia.getDescripcion() ;
			return true;
		}
	}	

	public void sqlFinal() throws FileNotFoundException, JRException, SQLException{
		if(this.edaddesde > this.edadhasta){
			Messagebox.show("Debe seleccionar un rango de edades valido", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		} else {
			this.consulta += " con respecto al universo de los socios del Centro Atlético América.";						
			sql += "( ("+ this.sqlparticular +" )+( "+ this.sqlParticularAfiliado +" )) as particular, "
					+ "( ("+ this.sqlGeneral +" ) + ("+this.sqlGeneralAfiliado+") ) as general, "
					+ "CASE WHEN ( (" + this.sqlGeneral +")+("+ this.sqlGeneralAfiliado+") ) > 0 THEN "
					+ "(( ("+ this.sqlparticular+") +("+ this.sqlParticularAfiliado+") ) * 100) / (("+ this.sqlGeneral+")+("+ this.sqlGeneralAfiliado+") ) "
					+ "ELSE 0 END as porcentajeParticular, "
					+ "CASE WHEN (( "+this.sqlGeneral+" )+("+ this.sqlGeneralAfiliado+") ) - ( ("+ this.sqlparticular+ ") +("+ this.sqlParticularAfiliado+") ) > 0 THEN "
					+ "(( ( ("+ this.sqlGeneral+") + ("+ this.sqlGeneralAfiliado+") )  - ( ("+ this.sqlparticular+") +("+ this.sqlParticularAfiliado+") ) ) * 100) / ( (" + this.sqlGeneral+") +("+ this.sqlGeneralAfiliado+") ) "
					+ "ELSE 0 END as porcentajegeneral from socio";
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
				exporterTxt.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, System.getProperty("user.home") + "/reportes_america/estadisticos_evento.txt");
				exporterTxt.setParameter(JRTextExporterParameter.PAGE_WIDTH,130);
				exporterTxt.setParameter(JRTextExporterParameter.PAGE_HEIGHT,130);
				exporterTxt.exportReport();
				FileInputStream input = new FileInputStream(System.getProperty("user.home") + "/reportes_america/estadisticos_evento.txt");
			    Filedownload.save(input, "txt", "reporte.txt");	    
			    con.close();
			    
			    try{
		    		File file = new File(("user.home") + "/reportes_america/estadisticos_evento.txt");
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
