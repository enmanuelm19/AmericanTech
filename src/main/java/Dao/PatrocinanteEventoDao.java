package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Opinion;
import modelos.PartocinanteEvento;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PatrocinanteEventoDao {
	
private Sesion sesionPostgres;
	
	public void agregarPatrocinanteEvento(PartocinanteEvento dato) throws Exception{
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
	
	public PartocinanteEvento obtenerPatrocinanteEvento(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    PartocinanteEvento dato = null;        
            try{
                dato = (PartocinanteEvento ) sesion.get(PartocinanteEvento .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarPatrocinanteEvento(PartocinanteEvento dato) throws Exception{		 
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
	
	public void actualizarPatrocinanteEvento(PartocinanteEvento dato) throws Exception{
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

	public List<PartocinanteEvento> obtenerTodos() throws Exception {            
	      
		   List<PartocinanteEvento> datos = new ArrayList<PartocinanteEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<PartocinanteEvento>) em.createCriteria(PartocinanteEvento.class).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
		
	//Metodo para obtener los patrocinantes de un evento

	public List<PartocinanteEvento> obtenerPatrocinantesEvento( int id) throws Exception {            
	      
		   List<PartocinanteEvento> datos = new ArrayList<PartocinanteEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<PartocinanteEvento>) em.createCriteria(PartocinanteEvento.class).add(Restrictions.eq("eventoid_evento", id)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	//Metodo para obtener los eventos de un patrocinante

		public List<PartocinanteEvento> obtenerEventosPatrocinante( int id) throws Exception {            
		      
			   List<PartocinanteEvento> datos = new ArrayList<PartocinanteEvento>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<PartocinanteEvento>) em.createCriteria(PartocinanteEvento.class).add(Restrictions.eq("patrocinanteid_patrocinante", id)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}
	
}
