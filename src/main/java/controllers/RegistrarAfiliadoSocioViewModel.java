package controllers;

import java.util.List;

import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

import Dao.PreferenciaDao;
import Dao.TipoAfiliadoDao;
import Dao.TipoPreferenciaDao;
import modelos.Afiliado;
import modelos.Persona;
import modelos.Preferencia;
import modelos.Socio;
import modelos.TipoAfiliado;
import modelos.TipoPreferencia;

public class RegistrarAfiliadoSocioViewModel {
		private Socio socio;
		private TipoAfiliadoDao tipoAfDao;
		private Afiliado afiliado;
		private TipoPreferenciaDao tipoPrefDao;
		private PreferenciaDao preferenciaDao;
		private List<Preferencia> preferencias;
		private List<TipoPreferencia> tiposPref;
		private List<TipoAfiliado> tiposAf;
		private TipoAfiliado tipoAfiliado;
		private Persona persona;
		
		@Init
		public void init(@ExecutionArgParam("socioss") Socio socioss){
			System.out.println("djdjdsaldadkadlasjl");
		}
		
		public ListModelList<TipoAfiliado> getTiposAfiliados(){
			return new ListModelList<TipoAfiliado>(tiposAf);
		}
		
		public ListModelList<TipoPreferencia> getTipoPreferencias(){
			return new ListModelList<TipoPreferencia>(tiposPref);
		}
		
		public ListModelList<Preferencia> getPreferencias(){
			return new ListModelList<Preferencia>(preferencias);
		}
		
		public Socio getSocio() {
			return this.socio;
		}
		public Persona getPersona(){
			return this.persona;
		}
		
		public TipoAfiliado getTipoAfiliado(){
			return this.tipoAfiliado;
		}
		public Afiliado getAfiliado(){
			return this.afiliado;
		}
}
