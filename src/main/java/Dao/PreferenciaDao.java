package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Preferencia;
import modelos.TipoPreferencia;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class PreferenciaDao {
private Sesion sesionPostgres;
	
	
	public void agregarTipoEventualidad(Preferencia dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();  
         Transaction tx = null;  
         try {    
        	 tx = em.beginTransaction();
              em.save( dato);   
              tx.commit();  
         } catch (Exception e) {  
             tx.rollback();            
             e.printStackTrace();
             throw e;
         } finally {  
             em.close();  
         } 
	}
	
	//Obtiene un TipoEventualidad especifico
		public Preferencia obtenerTipoEventualidad(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
		    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
		    Preferencia dato = null;        
	            try{
	                dato = (Preferencia) sesion.get(Preferencia.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
		    return dato;
		}
		
		//Obtener un tipo de eventualidad mediante la descripcion
		public Preferencia obtenerTipoEventualidad(String descrip) throws Exception{		 
		    @SuppressWarnings("static-access")
		    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
		    Preferencia dato = null;        
	            try{
	                dato = (Preferencia) sesion.createCriteria(Preferencia.class)
	                		.add(Restrictions.eq("descripcion", descrip)).add(Restrictions.eq("activo", true)).uniqueResult();
	            } catch (Exception e) {  
	            e.printStackTrace();
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
		    return dato;
		
		}
	
	public void eliminarTipoEventualidad(Preferencia dato) throws Exception{		 
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();   
         Transaction tx = null;  
         try {    
        	 tx = em.beginTransaction();
        	 dato.setActivo(false);
              em.update(dato);   
              tx.commit();  
         } catch (Exception e) {  
             tx.rollback();            
             e.printStackTrace();
             throw e;
         } finally {  
             em.close();  
         } 
   }
	
	public void actualizarTipoEventualidad(Preferencia dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();   
         Transaction tx = null;  
         try {    
        	 tx = em.beginTransaction();
              em.update(dato);   
              tx.commit();  
         } catch (Exception e) {  
             tx.rollback();            
             e.printStackTrace();
             throw e;
         } finally {  
             em.close();  
         } 
	}
	
	public List<Preferencia> obtenerTodos() throws Exception {            
      
	   List<Preferencia> datos = new ArrayList<Preferencia>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Preferencia>) em.createCriteria(Preferencia.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}
	
	public List<Preferencia> obtenerPreferenciasTipo(TipoPreferencia dato) throws Exception {

		List<Preferencia> datos = new ArrayList<Preferencia>();
		Session em = sesionPostgres.getSessionFactory().openSession();
		try {
			datos = (List<Preferencia>) em.createCriteria(Preferencia.class)
					.add(Restrictions.eq("tipoPreferencia", dato)).list();
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			em.close();
		}

		return datos;
	}

}
