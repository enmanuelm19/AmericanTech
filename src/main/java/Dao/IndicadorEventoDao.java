package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Evento;
import modelos.Indicador;
import modelos.IndicadorEvento;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class IndicadorEventoDao {

private Sesion sesionPostgres;
	
	
	public void agregarAccion(IndicadorEvento dato) throws Exception{
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
	
	public void eliminarAccion(IndicadorEvento dato) throws Exception{		 
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
	
	public void actualizarIndicadorEvento(IndicadorEvento dato) throws Exception{
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
	
	public List<IndicadorEvento> obtenerTodos() throws Exception {            
      
	   List<IndicadorEvento> datos = new ArrayList<IndicadorEvento>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<IndicadorEvento>) em.createCriteria(IndicadorEvento.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	

	public IndicadorEvento obtenerIndicadorEvento(int id) throws Exception {            
	      
		   IndicadorEvento datos = new IndicadorEvento();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (IndicadorEvento) em.get(IndicadorEvento.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public List<IndicadorEvento> obtenerPorIndicador(Indicador indicador) throws Exception {            
	      
		   List<IndicadorEvento> datos = new ArrayList<IndicadorEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<IndicadorEvento>) em.createCriteria(IndicadorEvento.class).add(Restrictions.eq("indicador", indicador))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	public List<IndicadorEvento> obtenerPorEvento(Evento evento) throws Exception {            
	      
		   List<IndicadorEvento> datos = new ArrayList<IndicadorEvento>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<IndicadorEvento>) em.createCriteria(IndicadorEvento.class).add(Restrictions.eq("evento", evento))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
}
