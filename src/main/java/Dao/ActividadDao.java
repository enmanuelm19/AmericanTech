package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Actividad;

import modelos.Evento;
import modelos.TipoActividad;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class ActividadDao {

private Sesion sesionPostgres;
	
	
	public void agregarActividad(Actividad dato) throws Exception{
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
	
	public void eliminarActividad(Actividad dato) throws Exception{		 
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
	
	public void actualizarActividad(Actividad dato) throws Exception{
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
	
	public List<Actividad> obtenerTodos() throws Exception {            
	      
		   List<Actividad> datos = new ArrayList<Actividad>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Actividad>) em.createCriteria(Actividad.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//obtiene las actividades de un evento
	public List<Actividad> obtenerPorEvento(Evento evento) throws Exception {            
	      
		   List<Actividad> datos = new ArrayList<Actividad>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Actividad>) em.createCriteria(Actividad.class).add(Restrictions.eq("evento", evento))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return datos; 
	}
	//devuelve las actividades que tengan un tipo especifico
	public List<Actividad> obtenerPortipo(TipoActividad tipo) throws Exception {            
	      
		   List<Actividad> datos = new ArrayList<Actividad>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Actividad>) em.createCriteria(Actividad.class).add(Restrictions.eq("tipoActividad", tipo))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return datos; 
	}
	
	//Obtiene una actividad mediante su id
	public Actividad obtenerActividad(int id) throws Exception {            
	      
		   Actividad dato = new Actividad();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    dato =  (Actividad) em.get(Actividad.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return dato; 
	}
}
