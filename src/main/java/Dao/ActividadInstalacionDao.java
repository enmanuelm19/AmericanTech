package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.ActividadInstalacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
public class ActividadInstalacionDao {

private Sesion sesionPostgres;
	
	
	public void agregarActividadInstalacion(ActividadInstalacion dato) throws Exception{
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
	
	public void eliminarActividadInstalacion(ActividadInstalacion dato) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();    
        Transaction tx = null;  
        try {  
            tx = sesion.beginTransaction();  
            sesion.delete(dato);  
            tx.commit();  
           
        } catch (Exception e) {  
            tx.rollback();  
           
            throw new Exception(e.getMessage(), e.getCause());
        } finally {  
            sesion.close();  
        }  
   }
	
	public void actualizarActividad(ActividadInstalacion dato) throws Exception{
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
	
	public List<ActividadInstalacion> obtenerTodos() throws Exception {            
      
	   List<ActividadInstalacion> datos = new ArrayList<ActividadInstalacion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<ActividadInstalacion>) em.createCriteria(ActividadInstalacion.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
	
	
	
}
