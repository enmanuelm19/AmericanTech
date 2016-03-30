package controllers;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.OpinionDao;
import Dao.TipoOpnionDao;
import modelos.Opinion;
import modelos.Postulacion;
import modelos.TipoOpnion;
import modelos.Usuario;

public class RegistrarOpinionViewModel {
	private Opinion opinion;
	private OpinionDao opinionDao;
	private Postulacion postulacion;
	private TipoOpnionDao tipoOpinionDao;
	private List<TipoOpnion> tiposOpinions;
	@Init
	public void init(@ExecutionArgParam("Postulacion") Postulacion postulacion) throws Exception{
		this.postulacion=postulacion;
		this.opinionDao= new OpinionDao();
		this.tipoOpinionDao= new TipoOpnionDao();
		this.tiposOpinions=tipoOpinionDao.obtenerTodos();
		this.opinion= new Opinion();
		this.opinion.setPostulacion(postulacion);
	}
	
	public ListModelList<TipoOpnion> getTiposOpinons(){
		return new ListModelList<TipoOpnion>(this.tiposOpinions);
	}

	public Postulacion getPostulacion() {
		return postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}
	
	@Command
	public void guardarOpinion(@BindingParam("win") Window win) throws Exception{
		if(this.opinion.getTipoOpnion()==null||this.opinion.getDescripcion()==null||this.opinion.getDescripcion().equalsIgnoreCase("")){
			Messagebox.show("Verifique que los datos esten llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			Usuario usuario=(Usuario)Executions.getCurrent().getSession().getAttribute("Usuario");
			List<Opinion> opiUsu=opinionDao.obtenerOpinionesUsuario(usuario);
			boolean opino=false;
			for(int i=0; i<opiUsu.size(); i++){
				if(opiUsu.get(i).getPostulacion().getIdPostulacion()==opinion.getPostulacion().getIdPostulacion()){
					opino=true;
				}
			}
			if(opino==true){
				Messagebox.show("Usted ya ha dado su opinion sobre el postulado "+this.opinion.getPostulacion().getPostulado().getPersona().getNombre()+" "+this.opinion.getPostulacion().getPostulado().getPersona().getApellido(), "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				win.detach();
			}
			else{
				this.opinion.setUsuario(usuario);
				this.opinion.setFecha(new Date());
				this.opinionDao.agregarOpinion(opinion);
				Messagebox.show("Su opinión sobre el postulado "+this.opinion.getPostulacion().getPostulado().getPersona().getNombre()+" "
						+this.opinion.getPostulacion().getPostulado().getPersona().getApellido()+ " ha sido registrada exitosamente", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshPostulaciones",null);
			}
		}
	}
	@Command
	public void cancelar(@BindingParam("win") Window win){
		win.detach();
	}
	
}
