package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.PreferenciaEvento;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

/**
 * creado por Jos� Francisco Mor�n
 */

public class PreferenciaEventoDao {

private Sesion sesionPostgres;
	
	public void agregarPreferenciaEvento(PreferenciaEvento dato) throws Exception{
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
	
	public PreferenciaEvento obtenerPreferenciaEvento(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    PreferenciaEvento dato = null;        
            try{
                dato = (PreferenciaEvento ) sesion.get(PreferenciaEvento .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarPreferenciaEvento(PreferenciaEvento dato) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();    
        Transaction tx = null;  
        try {  
            tx = sesion.beginTransaction();  
            sesion.delete(dato);  
            tx.commit();  
           
        } catch (Exception e) {  
            tx.rollback();  
           
            throw new Exception(e.getMessage(), e.getCause());
        } finally {  
            sesion.close();  
        }  
   }
	
	public void actualizarPreferenciaEvento(PreferenciaEvento dato) throws Exception{
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

	public List<PreferenciaEvento> obtenerTodos() throws Exception {            
	      
		   List<PreferenciaEvento> datos = new ArrayList<PreferenciaEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<PreferenciaEvento>) em.createCriteria(PreferenciaEvento.class).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
		
	//Metodo para obtener las preferencias de un evento

	public List<PreferenciaEvento> PreferenciasEvento( int id) throws Exception {            
	      
		   List<PreferenciaEvento> datos = new ArrayList<PreferenciaEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<PreferenciaEvento>) em.createCriteria(PreferenciaEvento.class).add(Restrictions.eq("eventoid_evento", id)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	//Metodo para obtener los eventos por una preferencia

		public List<PreferenciaEvento> obtenerEventosPreferencia( int id) throws Exception {            
		      
			   List<PreferenciaEvento> datos = new ArrayList<PreferenciaEvento>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<PreferenciaEvento>) em.createCriteria(PreferenciaEvento.class).add(Restrictions.eq("preferenciaid_preferencia", id)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}
	
}
