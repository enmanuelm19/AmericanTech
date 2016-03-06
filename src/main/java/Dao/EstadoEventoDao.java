package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.EstadoAccion;
import modelos.EstadoEvento;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class EstadoEventoDao {

private Sesion sesionPostgres;
	
	
	public void agregarAccion(EstadoEvento dato) throws Exception{
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
	
	public void eliminarAccion(EstadoEvento dato) throws Exception{		 
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
	
	public void actualizarAccion(EstadoEvento dato) throws Exception{
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
	
	public List<EstadoEvento> obtenerTodos() throws Exception {            
      
	   List<EstadoEvento> datos = new ArrayList<EstadoEvento>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<EstadoEvento>) em.createCriteria(EstadoEvento.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
	
	public EstadoEvento obtenerEstadoEvento(String nombre) throws Exception {            
	      
		   EstadoEvento datos = new EstadoEvento();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (EstadoEvento) em.createCriteria(EstadoEvento.class).add(Restrictions.eq("nombre", nombre))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public EstadoEvento obtenerEstadoEvento(int id) throws Exception {            
	      
		   EstadoEvento datos = new EstadoEvento();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (EstadoEvento) em.get(EstadoEvento.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}	
}
