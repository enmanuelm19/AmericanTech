package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Hora;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class HoraDao {

private Sesion sesionPostgres;
	
	public void agregarHora(Hora dato) throws Exception{
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
	
	public Hora obtenerHora(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Hora dato = null;        
            try{
                dato = (Hora ) sesion.get(Hora .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarHora(Hora dato) throws Exception{		 
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
	
	public void actualizarHora(Hora dato) throws Exception{
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

	public List<Hora> obtenerTodos() throws Exception {            
	      
		   List<Hora> datos = new ArrayList<Hora>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Hora>) em.createCriteria(Hora.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
}
