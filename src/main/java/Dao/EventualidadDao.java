package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Eventualidad;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class EventualidadDao {
	
private Sesion sesionPostgres;
	
	public void agregarEventualidad(Eventualidad dato) throws Exception{
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
	
	public Eventualidad obtenerEventualidad(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Eventualidad dato = null;        
            try{
                dato = (Eventualidad ) sesion.get(Eventualidad .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarEventualidad(Eventualidad dato) throws Exception{		 
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
	
	public void actualizarEventualidad(Eventualidad dato) throws Exception{
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

	public List<Eventualidad> obtenerTodos() throws Exception {            
	      
		   List<Eventualidad> datos = new ArrayList<Eventualidad>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Eventualidad>) em.createCriteria(Eventualidad.class).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	//Metodo para obtener las Eventualidad de una persona "x"

		public List<Eventualidad> obtenerEventualidadUsuario( int id) throws Exception {            
		      
			   List<Eventualidad> datos = new ArrayList<Eventualidad>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<Eventualidad>) em.createCriteria(Eventualidad.class).add(Restrictions.eq("personaid_persona", id)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}
		
		//Metodo para obtener las Eventualidad de "x" evento

			public List<Eventualidad> obtenerEventualidadPostulacion( int id) throws Exception {            
			      
				   List<Eventualidad> datos = new ArrayList<Eventualidad>();  
				   Session em = sesionPostgres.getSessionFactory().openSession();   	
			        try {  	
				    datos =  (List<Eventualidad>) em.createCriteria(Eventualidad.class).add(Restrictions.eq("eventoid_evento", id)).list();             
			        } catch (Exception e) {             
			       
			         throw new Exception(e.getMessage(),e.getCause());
			        } finally {  
			          em.close();  
			        } 
			       
			        return datos; 
				}
	//Metodo para obtener las Eventualidad de "x" instalacion

	public List<Eventualidad> obtenerEventualidadinstalacion( int id) throws Exception {            
			      
		List<Eventualidad> datos = new ArrayList<Eventualidad>();  
		Session em = sesionPostgres.getSessionFactory().openSession();   	
		 try {  	
		   datos =  (List<Eventualidad>) em.createCriteria(Eventualidad.class).add(Restrictions.eq("instalacionid_instalacion", id)).list();             
			  } catch (Exception e) {             
		 
		throw new Exception(e.getMessage(),e.getCause());
		     } finally {  
		      em.close();  
			 } 
				       
		   return datos; 
		}
		

}
