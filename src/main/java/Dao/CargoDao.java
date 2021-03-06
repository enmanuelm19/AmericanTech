package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Cargo;
import modelos.Desvinculacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class CargoDao {

private Sesion sesionPostgres;
	
	
public void agregarCargo(Cargo dato) throws Exception{
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
	
	public void eliminarCargo(Cargo dato) throws Exception{		 
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
	
	public void actualizarCargo(Cargo dato) throws Exception{
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
	
	public List<Cargo> obtenerTodos() throws Exception {            
      
	   List<Cargo> datos = new ArrayList<Cargo>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Cargo>) em.createCriteria(Cargo.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
	
	//devuelve un cargo mediante su id
	public Cargo obtenerCargo(int id) throws Exception {            
	      
		   Cargo datos = new Cargo();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (Cargo) em.get(Cargo.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//devuelve un cargo mediante su descripcion
	public Cargo obtenerCargo(String descripcion) throws Exception {            
	      
		   Cargo datos = new Cargo();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (Cargo) em.createCriteria(Cargo.class).add(Restrictions.eq("descripcion", descripcion))
		    		.add(Restrictions.eq("activo", true));             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
}
