package controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.io.Files;
import org.zkoss.util.media.AMedia;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AlquilerDao;
import Dao.ArchivoAlquilerDao;
import Dao.SocioDao;
import enums.TipoListado;
import modelos.Alquiler;
import modelos.ArchivoAlquiler;
import modelos.Socio;
import modelos.Usuario;

public class MisAlquileresViewModel {
	private List<Alquiler> alquilerAll;
	private Alquiler alquilerSelected;
	private Socio socio;
	private String filePath;
	private boolean fileuploaded = false;
	private String nombreFiltro;
	private TipoListado[] tipoListados = TipoListado.values();
	private String tipoListadoSelected;
	private ArchivoAlquiler archivoAlquiler;

	AMedia fileContent;

	@Wire("#test")
	private Window win;

	@Init
	public void init(@ExecutionArgParam("alquiler") Alquiler alquiler) {
		try {
			if (alquiler != null) {
				setAlquilerSelected(alquiler);
			}
			Session session = Sessions.getCurrent();
			Usuario usuario = (Usuario) session.getAttribute("Usuario");
			if (usuario != null) {
				socio = new SocioDao().obtenerSocioPersona(usuario.getPersona());
			}
			for (Alquiler alq : new AlquilerDao().obtenerTodos()) {
				if (socio != null && alq.getReservacion().getSocio().getIdSocio() == socio.getIdSocio()) {
					getAlquilerAll().add(alq);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArchivoAlquiler getArchivoAlquiler() {
		return archivoAlquiler;
	}

	public void setArchivoAlquiler(ArchivoAlquiler archivoAlquiler) {
		this.archivoAlquiler = archivoAlquiler;
	}

	public String getTipoListadoSelected() {
		return tipoListadoSelected;
	}

	public void setTipoListadoSelected(String tipoListadoSelected) {
		this.tipoListadoSelected = tipoListadoSelected;
	}

	public TipoListado[] getTipoListados() {
		return tipoListados;
	}

	public void setTipoListados(TipoListado[] tipoListados) {
		this.tipoListados = tipoListados;
	}

	public String getNombreFiltro() {
		if (nombreFiltro == null)
			return "";
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro;
	}

	public List<Alquiler> getAlquilerAll() {
		if (alquilerAll == null) {
			alquilerAll = new ArrayList<Alquiler>();
		}
		return alquilerAll;
	}

	public void setAlquilerAll(List<Alquiler> alquilerAll) {
		this.alquilerAll = alquilerAll;
	}

	public Alquiler getAlquilerSelected() {
		return alquilerSelected;
	}

	public void setAlquilerSelected(Alquiler alquilerSelected) {
		this.alquilerSelected = alquilerSelected;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	@Command
	public void showModal(@BindingParam("alquiler") Alquiler alquiler) {
		if (alquiler != null) {
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("alquiler", alquiler);
			Window window = (Window) Executions.createComponents("instalacion/dialogo/registrarAdjunto.zul", null,
					args);
			window.doModal();
		}
	}

	public AMedia getFileContent() {
		return fileContent;
	}

	public void setFileContent(AMedia fileContent) {
		this.fileContent = fileContent;
	}

	public boolean isFileuploaded() {
		return fileuploaded;
	}

	public void setFileuploaded(boolean fileuploaded) {
		this.fileuploaded = fileuploaded;
	}

	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	@NotifyChange("fileuploaded")
	public void onUploadPDF(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
		UploadEvent upEvent = null;
		Object objUploadEvent = ctx.getTriggerEvent();
		if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
			upEvent = (UploadEvent) objUploadEvent;
		}
		if (upEvent != null) {
			for (ArchivoAlquiler archiAlq : getAlquilerSelected().getArchivoAlquilers()) {
				if (archiAlq.getTipoListado().equals(getTipoListadoSelected())) {
					Messagebox.show("El archivo de tipo " + getTipoListadoSelected() + " se encuentra registrado");
					setTipoListadoSelected(null);
					return;
				}
			}
			Media media = upEvent.getMedia();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH);// Note: zero based!
			int day = now.get(Calendar.DAY_OF_MONTH);
			filePath = System.getProperty("user.home");
			System.out.println(filePath);
			String yearPath = "/" + "PDFs" + "/" + year + "/" + month + "/" + day + "/";
			filePath = filePath + yearPath;
			File baseDir = new File(filePath);
			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}
			setArchivoAlquiler(new ArchivoAlquiler());
			getArchivoAlquiler().setExtension(".pdf");
			getArchivoAlquiler().setNombre(media.getName());
			getArchivoAlquiler().setUrl(filePath);
			getArchivoAlquiler().setActivo(true);
			getArchivoAlquiler().setTipoListado(getTipoListadoSelected());
			getArchivoAlquiler().setAlquiler(getAlquilerSelected());
			fileuploaded = true;
			Files.copy(new File(filePath + media.getName()), media.getStreamData());
		}
	}

	@Command
	@NotifyChange("fileContent")
	public void showPDF() throws IOException {
		if (getArchivoAlquiler() != null) {
			File f = new File(getArchivoAlquiler().getUrl() + getArchivoAlquiler().getNombre());
			byte[] buffer = new byte[(int) f.length()];
			FileInputStream fs = new FileInputStream(f);
			fs.read(buffer);
			fs.close();
			ByteArrayInputStream is = new ByteArrayInputStream(buffer);
			fileContent = new AMedia("report", "pdf", "application/pdf", is);
		}
	}

	@Command
	@NotifyChange({ "alquilerAll", "cantRegistros" })
	public void filtro() throws Exception {
		List<Alquiler> alquiler = new ArrayList<Alquiler>();
		String nomb = getNombreFiltro().toLowerCase();

		for (Iterator<Alquiler> i = new AlquilerDao().obtenerTodos().iterator(); i.hasNext();) {
			Alquiler tmp = i.next();
			if (socio != null && tmp.getReservacion().getSocio().getIdSocio() == socio.getIdSocio()) {
				alquiler.add(tmp);
			}
		}
		alquilerAll = alquiler;
	}

	public String getCantRegistros() {
		return getAlquilerAll().size() + " items en la lista";
	}

	public double precio(Date date1, Date date2, float precio) {
		if (date1 != null && date2 != null) {
			return precio * diasEntreFecha(date1, date2);
		}
		return 0;
	}

	public int diasEntreFecha(Date date1, Date date2) {
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; // Milisegundos al d�a
		long diferencia = 1 + ((date2.getTime() - date1.getTime()) / MILLSECS_PER_DAY);
		return (int) diferencia;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		Set<ArchivoAlquiler> archivoAlquileres = new HashSet();
		if(getTipoListadoSelected() == null || getTipoListadoSelected().equalsIgnoreCase("")){
			Messagebox.show("Debe seleccionar tipo de Listado" , "American Tech", Messagebox.OK,
					Messagebox.EXCLAMATION);
			return;
		}
		if(getArchivoAlquiler() == null){
			Messagebox.show("Debe cargar un archivo tipo .pdf" , "American Tech", Messagebox.OK,
					Messagebox.EXCLAMATION);
			return;
		}		
		try {
			new ArchivoAlquilerDao().agregarArchivoAlquiler(getArchivoAlquiler());
			archivoAlquileres.addAll(new ArchivoAlquilerDao().obtenerPorAlquiler(getAlquilerSelected()));
			getAlquilerSelected().setArchivoAlquilers(archivoAlquileres);
			new AlquilerDao().actualizarAlquiler(getAlquilerSelected());
			Messagebox.show("Ha agregado archivo:" + getArchivoAlquiler().getNombre(), "American Tech", Messagebox.OK,
					Messagebox.INFORMATION);
			win.detach();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	public boolean validarTipo(TipoListado tipoListado) {
		for (ArchivoAlquiler archiAlq : getAlquilerSelected().getArchivoAlquilers()) {
			if (archiAlq.getTipoListado().equals(tipoListado)) {
				return true;
			}
		}
		return false;
	}

}
