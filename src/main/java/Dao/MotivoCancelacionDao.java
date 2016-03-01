package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MotivoCancelacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class MotivoCancelacionDao {

private Sesion sesionPostgres;
	
	
	public void agregarAccion(MotivoCancelacion dato) throws Exception{
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
	
	public void eliminarAccion(MotivoCancelacion dato) throws Exception{		 
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
	
	public void actualizarAccion(MotivoCancelacion dato) throws Exception{
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
	
	public List<MotivoCancelacion> obtenerTodos() throws Exception {            
      
	   List<MotivoCancelacion> datos = new ArrayList<MotivoCancelacion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<MotivoCancelacion>) em.createCriteria(MotivoCancelacion.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	

	
	
	
}
