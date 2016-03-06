package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Accion;
import modelos.Desvinculacion;
import modelos.MotivoDesvinculacion;
import modelos.Socio;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class DesvinculacionDao {

private Sesion sesionPostgres;
	
	
	public void agregarDesvinculacion(Desvinculacion dato) throws Exception{
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
	
	public void eliminarDesvinculacion(Desvinculacion dato) throws Exception{		 
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
	
	public void actualizarDesvinculacion(Desvinculacion dato) throws Exception{
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
	
	public List<Desvinculacion> obtenerTodos() throws Exception {            
      
	   List<Desvinculacion> datos = new ArrayList<Desvinculacion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Desvinculacion>) em.createCriteria(Desvinculacion.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
	
	//devuelve una desvinculacion mediante su id
	public Desvinculacion obtenerDesvinculacion(int id) throws Exception {            
	      
		   Desvinculacion datos = new Desvinculacion();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (Desvinculacion) em.get(Desvinculacion.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return datos; 
	}
	
	//devuelve una lista de desvinculaciones por una socio especifico
	public List<Desvinculacion> obtenerPorSocio(Socio socio) throws Exception {            
	      
		   List<Desvinculacion> datos = new ArrayList<Desvinculacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Desvinculacion>) em.createCriteria(Desvinculacion.class).add(Restrictions.eq("socio", socio))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//devuelve una lista de desvinculaciones por una accion especifica
	public List<Desvinculacion> obtenerPorAccion(Accion accion) throws Exception {            
	      
		   List<Desvinculacion> datos = new ArrayList<Desvinculacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Desvinculacion>) em.createCriteria(Desvinculacion.class).add(Restrictions.eq("accion", accion))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}

	public List<Desvinculacion> obtenerPorMotivo(MotivoDesvinculacion motivoDesvinculacion) throws Exception {            
	      
		   List<Desvinculacion> datos = new ArrayList<Desvinculacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Desvinculacion>) em.createCriteria(Desvinculacion.class).add(Restrictions.eq("motivoDesvinculacion", motivoDesvinculacion))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	
}
