package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.RecursoInstalacion;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class RecursoInstalacionDao {

private Sesion sesionPostgres;
	
	public void agregarRecursoInstalacion(RecursoInstalacion dato) throws Exception{
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
	
	public RecursoInstalacion obtenerRecursoInstalacion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    RecursoInstalacion dato = null;        
            try{
                dato = (RecursoInstalacion ) sesion.get(RecursoInstalacion .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarRecursoInstalacion(RecursoInstalacion dato) throws Exception{		 
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
	
	public void actualizarRecursoInstalacion(RecursoInstalacion dato) throws Exception{
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

	public List<RecursoInstalacion> obtenerTodos() throws Exception {            
	      
		   List<RecursoInstalacion> datos = new ArrayList<RecursoInstalacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<RecursoInstalacion>) em.createCriteria(RecursoInstalacion.class).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
		
	//Metodo para obtener los recursos que tiene una instalacion

	public List<RecursoInstalacion> obtenerRecursosInstalacion( int id) throws Exception {            
	      
		   List<RecursoInstalacion> datos = new ArrayList<RecursoInstalacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<RecursoInstalacion>) em.createCriteria(RecursoInstalacion.class).add(Restrictions.eq("instalacionid_instalacion", id)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}

}
