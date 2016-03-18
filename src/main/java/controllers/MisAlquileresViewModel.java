package controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import Dao.ReservacionDao;
import Dao.TipoPagoDao;
import modelos.Alquiler;
import modelos.Reservacion;
import modelos.Usuario;

public class MisAlquileresViewModel {
	private List<Alquiler> alquilerAll;
	private Alquiler alquilerSelected;
	private Usuario usuario;
	private String filePath;
	private boolean fileuploaded = false;
	
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
			usuario = (Usuario) session.getAttribute("Usuario");
			getAlquilerAll().addAll(new AlquilerDao().obtenerTodos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
			Media media = upEvent.getMedia();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH);// Note: zero based!
			int day = now.get(Calendar.DAY_OF_MONTH);
			filePath = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
			String yearPath = "\\" + "PDFs" + "\\" + year + "\\" + month + "\\" + day + "\\";
			filePath = filePath + yearPath;
			File baseDir = new File(filePath);
			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			Files.copy(new File(filePath + media.getName()), media.getStreamData());
			Messagebox.show("File Sucessfully uploaded in the path [ ." + filePath + " ]");
			fileuploaded = true;
			filePath = filePath + media.getName();
		}
	}

	@Command
	@NotifyChange("fileContent")
	public void showPDF() throws IOException {
		File f = new File(filePath);
		Messagebox.show(" dfdfdfdsfdsf" + filePath);
		byte[] buffer = new byte[(int) f.length()];
		FileInputStream fs = new FileInputStream(f);
		fs.read(buffer);
		fs.close();
		ByteArrayInputStream is = new ByteArrayInputStream(buffer);
		fileContent = new AMedia("report", "pdf", "application/pdf", is);

	}

}
