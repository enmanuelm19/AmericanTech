package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Accion;
import modelos.EstadoAccion;

import modelos.Socio;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class AccionDao {

private Sesion sesionPostgres;
	
	
	public void agregarAccion(Accion dato) throws Exception{
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
	
	public void eliminarAccion(Accion dato) throws Exception{		 
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
	
	public void actualizarAccion(Accion dato) throws Exception{
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
	
	public List<Accion> obtenerPorTipo(EstadoAccion estado) throws Exception {            
	      
		   List<Accion> datos = new ArrayList<Accion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Accion>) em.createCriteria(Accion.class).add(Restrictions.eq("estadoAccion", estado)).list();            
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public List<Accion> obtenerTodos() throws Exception {            
      
	   List<Accion> datos = new ArrayList<Accion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Accion>) em.createCriteria(Accion.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}
	
	public Accion obtenerAccion(int id) throws Exception {            
	      
		   Accion dato = new Accion();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    dato =  (Accion) em.createCriteria(Accion.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return dato;
	}
	
	//devuelve las acciones relacionadas a un estado de la accion.
	public List<Accion> obtenerPorEstado(EstadoAccion estado) throws Exception {            
	      
		   List<Accion> datos = new ArrayList<Accion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Accion>) em.createCriteria(Accion.class).add(Restrictions.eq("estadoAccion", estado))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//devuelve las acciones relacionadas a un socio.	
	public List<Accion> obtenerPorSocio(Socio socio) throws Exception {            
	      
		   List<Accion> datos = new ArrayList<Accion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Accion>) em.createCriteria(Accion.class).add(Restrictions.eq("socio", socio))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
}
