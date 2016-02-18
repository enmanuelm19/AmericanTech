package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.PreferenciaPersona;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class PreferenciaPersonaDao {

private Sesion sesionPostgres;
	
	public void agregarPreferenciaPersona(PreferenciaPersona dato) throws Exception{
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
	
	public PreferenciaPersona obtenerPreferenciaPersona(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    PreferenciaPersona dato = null;        
            try{
                dato = (PreferenciaPersona ) sesion.get(PreferenciaPersona .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarPreferenciaPersona(PreferenciaPersona dato) throws Exception{		 
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
	
	public void actualizarPreferenciaPersona(PreferenciaPersona dato) throws Exception{
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

	public List<PreferenciaPersona> obtenerTodos() throws Exception {            
	      
		   List<PreferenciaPersona> datos = new ArrayList<PreferenciaPersona>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<PreferenciaPersona>) em.createCriteria(PreferenciaPersona.class).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
		
	//Metodo para obtener las preferencias de una persona

	public List<PreferenciaPersona> obtenerPreferenciasPersona( int id) throws Exception {            
	      
		   List<PreferenciaPersona> datos = new ArrayList<PreferenciaPersona>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<PreferenciaPersona>) em.createCriteria(PreferenciaPersona.class).add(Restrictions.eq("personaid_persona", id)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	//Metodo para obtener las personas con la misma preferencia

		public List<PreferenciaPersona> obtenerPersonasMismaPreferencia( int id) throws Exception {            
		      
			   List<PreferenciaPersona> datos = new ArrayList<PreferenciaPersona>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<PreferenciaPersona>) em.createCriteria(PreferenciaPersona.class).add(Restrictions.eq("preferenciaid_preferencia", id)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}

	
}
