package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.CalendarioFecha;
import modelos.Evento;
import modelos.Reservacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class CalendarioFechaDao {

private Sesion sesionPostgres;
	
	
	public void agregarCalendarioFecha(CalendarioFecha dato) throws Exception{
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
	
	public void eliminarCalendarioFecha(CalendarioFecha dato) throws Exception{		 
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
	
	public void actualizarCalendarioFecha(CalendarioFecha dato) throws Exception{
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
	
	public List<CalendarioFecha> obtenerTodos() throws Exception {            
      
	   List<CalendarioFecha> datos = new ArrayList<CalendarioFecha>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<CalendarioFecha>) em.createCriteria(CalendarioFecha.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}
	
	//devuelve un registro en el calendario por evento
	public CalendarioFecha obtenerPorEvento(Evento evento) throws Exception {            
	      
		   CalendarioFecha datos = new CalendarioFecha();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (CalendarioFecha) em.createCriteria(CalendarioFecha.class).add(Restrictions.eq("evento", evento))
		    		.add(Restrictions.eq("activo", true)).uniqueResult();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//devuelve un registro en el calendario por reservacion
	public CalendarioFecha obtenerPorEvento(Reservacion reservacion) throws Exception {            
	      
		   CalendarioFecha datos = new CalendarioFecha();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (CalendarioFecha) em.createCriteria(CalendarioFecha.class).add(Restrictions.eq("reservacion", reservacion))
		    		.add(Restrictions.eq("activo", true)).uniqueResult();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//devuelve un registro en el calendario por su id
	public CalendarioFecha obtenerPorEvento(int id) throws Exception {            
	      
		   CalendarioFecha datos = new CalendarioFecha();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (CalendarioFecha) em.get(CalendarioFecha.class, id);            
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
}
