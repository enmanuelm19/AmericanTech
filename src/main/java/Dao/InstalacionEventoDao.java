package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Evento;
import modelos.Instalacion;
import modelos.InstalacionEvento;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class InstalacionEventoDao {

private Sesion sesionPostgres;
	
	
	public void agregarAccion(InstalacionEvento dato) throws Exception{
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
	
	public void eliminarAccion(InstalacionEvento dato) throws Exception{		 
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
	
	public void actualizarAccion(InstalacionEvento dato) throws Exception{
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
	
	public List<InstalacionEvento> obtenerTodos() throws Exception {            
      
	   List<InstalacionEvento> datos = new ArrayList<InstalacionEvento>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<InstalacionEvento>) em.createCriteria(InstalacionEvento.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	

	public InstalacionEvento obtenerInstalacionEvento(int id) throws Exception {            
	      
		   InstalacionEvento datos = new InstalacionEvento();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (InstalacionEvento) em.get(InstalacionEvento.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public List<InstalacionEvento> obtenerPorEvento(Evento evento) throws Exception {            
	      
		   List<InstalacionEvento> datos = new ArrayList<InstalacionEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<InstalacionEvento>) em.createCriteria(InstalacionEvento.class)
		    		.add(Restrictions.eq("evento", evento))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}	
	
	public List<InstalacionEvento> obtenerPorInstalacion(Instalacion instalacion) throws Exception {            
	      
		   List<InstalacionEvento> datos = new ArrayList<InstalacionEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<InstalacionEvento>) em.createCriteria(InstalacionEvento.class)
		    		.add(Restrictions.eq("instalacion", instalacion))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}	
	
}
