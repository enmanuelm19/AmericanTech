package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import modelos.Accion;
import modelos.MotivoVenta;
import modelos.Socio;
import modelos.SolicitudVenta;
import modelos.Usuario;
import Dao.AccionDao;
import Dao.EstadoAccionDao;
import Dao.MotivoVentaDao;
import Dao.SocioDao;
import Dao.SolicitudVentaDao;

public class SolicitudVentaViewModel {
	private MotivoVentaDao motivoDao;
	private List<MotivoVenta> motivos;
	private SolicitudVenta solicitud;
	private SolicitudVentaDao solicitudDao;
	private Set<Accion> acciones;
	private List<Accion> seleccionadas;
	private SocioDao socioDao;
	private EstadoAccionDao estadoAccionDao;
	private Socio socio;
	private AccionDao accionDao;
	private Usuario user;
	@Init
	public void init() throws Exception{
		this.motivoDao= new MotivoVentaDao();
		this.solicitudDao= new SolicitudVentaDao();
		this.seleccionadas= new ArrayList<Accion>();
		this.socioDao= new SocioDao();
		Session session = Sessions.getCurrent();
		user = (Usuario) session.getAttribute("Usuario");
		socio = socioDao.obtenerSocioPersona(user.getPersona());
		this.acciones= new HashSet<Accion>();
		this.iterar();
		this.motivos= motivoDao.obtenerTodos();
		this.solicitud= new SolicitudVenta();
		this.solicitud.setActivo(true);
		this.estadoAccionDao= new EstadoAccionDao();
		this.accionDao= new AccionDao();
	}
	
	public void iterar(){
		for(Iterator<Accion> i=socio.getAccions().iterator(); i.hasNext();){
			Accion a=i.next();
			if(a.getEstadoAccion().getIdEstadoAccion()==1)
				acciones.add(a);
		}
	}
	public ListModelList<Accion> getAccionesSocio(){
		ListModelList<Accion>a=new ListModelList<Accion>(this.acciones);
		a.setMultiple(true);
		return a;
	}

	public List<Accion> getSeleccionadas() {
		return seleccionadas;
	}

	public void setSeleccionadas(List<Accion> seleccionadas) {
		this.seleccionadas = seleccionadas;
	}
	
	public ListModelList<MotivoVenta> getMotivos(){
		return new ListModelList<MotivoVenta>(this.motivos);
	}

	public SolicitudVenta getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudVenta solicitud) {
		this.solicitud = solicitud;
	}

	@Command
	public void guardarSolicitud() throws Exception{
		if(seleccionadas.size()==0 ||this.solicitud.getMotivoVenta()==null ||this.solicitud.getMotivo()==null ||this.solicitud.getMotivo().equalsIgnoreCase("")){
			Messagebox.show("Debe llenar todos los campos","American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}else{
			Messagebox.show("Estas seguro de Solicitar venta de acción ", "American Tech",
					Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event evt) throws InterruptedException {
							if (evt.getName().equals("onOK")) {
								try {
									for(int i=0; i< seleccionadas.size(); i++){
										SolicitudVenta sol= new SolicitudVenta();
										sol=solicitud;
										seleccionadas.get(i).setEstadoAccion(estadoAccionDao.obtenerEstadoAccion(3));
										accionDao.actualizarAccion(seleccionadas.get(i));
										sol.setAccion(seleccionadas.get(i));
										sol.setFecha(new Date());
										solicitudDao.agregarAccion(sol);
									}
									Messagebox.show("Su solicitud ha sido enviada","American Tech", Messagebox.OK, Messagebox.INFORMATION);
									BindUtils.postGlobalCommand(null, null, "refreshAcciones", null);
								} catch (Exception e) {
							}
						}
					}
				});
			}
	}
	
	@GlobalCommand
	@NotifyChange({"accionesSocio", "seleccionadas","solicitud"})
	public void refreshAcciones() throws Exception{
		socio = socioDao.obtenerSocioPersona(user.getPersona());
		this.acciones= new HashSet<Accion>();
		this.iterar();
		this.seleccionadas= new ArrayList<Accion>();
		this.solicitud= new SolicitudVenta();
		this.solicitud.setActivo(true);
	}
}
