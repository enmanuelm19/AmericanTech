package Dao;

import modelos.Portal;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;

public class PortalDao {

private Sesion sesionPostgres;
	
	public void agregarPortal(Portal dato) throws Exception{
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
	
	public Portal obtenerPortal(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Portal dato = null;        
            try{
                dato = (Portal ) sesion.get(Portal .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarPortal(Portal dato) throws Exception{		 
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
	
	public void hardDelete(Portal dato){
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = em.beginTransaction();
			em.delete(dato);
			tx.commit();
		} catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
				
	}
	
	public void actualizarPortal(Portal dato) throws Exception{
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
}
