package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Evento;
import modelos.CancelacionEvento;
import modelos.MotivoCancelacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Edward Rodriguez
 */

public class CancelacionEventoDao {

private Sesion sesionPostgres;
	
	
	public void agregarAccion(CancelacionEvento dato) throws Exception{
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
	
	public void eliminarAccion(CancelacionEvento dato) throws Exception{		 
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
	
	public void actualizarAccion(CancelacionEvento dato) throws Exception{
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
	
	public List<CancelacionEvento> obtenerTodos() throws Exception {            
      
	   List<CancelacionEvento> datos = new ArrayList<CancelacionEvento>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<CancelacionEvento>) em.createCriteria(CancelacionEvento.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	

	public CancelacionEvento obtenerPorEvento(Evento evento) throws Exception {            
	      
		   CancelacionEvento datos = new CancelacionEvento();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (CancelacionEvento) em.createCriteria(CancelacionEvento.class)
		    		.add(Restrictions.eq("evento", evento))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public CancelacionEvento obtenerMotivoCancelacion(int id) throws Exception {            
	      
		   CancelacionEvento datos = new CancelacionEvento();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (CancelacionEvento) em.get(CancelacionEvento.class, id);          
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public CancelacionEvento obtenerPorDescripcion(String descripcion) throws Exception {            
	      
		CancelacionEvento datos = new CancelacionEvento();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (CancelacionEvento) em.createCriteria(CancelacionEvento.class)
	    		.add(Restrictions.eq("descripcion", descripcion))
	    		.add(Restrictions.eq("activo", true)).list();          
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}
	
	public List<CancelacionEvento> obtenerPorTipo(MotivoCancelacion motivoCancelacion) throws Exception {            
	      
		   List<CancelacionEvento> datos = new ArrayList<CancelacionEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<CancelacionEvento>) em.createCriteria(CancelacionEvento.class)
		    		.add(Restrictions.eq("motivoCancelacion", motivoCancelacion))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
}
