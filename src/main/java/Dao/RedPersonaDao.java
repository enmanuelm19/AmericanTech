package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Opinion;
import modelos.Persona;
import modelos.RedPersona;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

/**
 * creado por Jos� Francisco Mor�n
 */

public class RedPersonaDao {

private Sesion sesionPostgres;
	
	public void agregarRedPersona(RedPersona dato) throws Exception{
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
	
	public RedPersona obtenerRedPersona(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    RedPersona dato = null;        
            try{
                dato = (RedPersona ) sesion.get(RedPersona .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarRedPersona(RedPersona dato) throws Exception{		 
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
	
	public void actualizarRedPersona(RedPersona dato) throws Exception{
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

	public List<RedPersona> obtenerTodos() throws Exception {            
	      
		   List<RedPersona> datos = new ArrayList<RedPersona>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<RedPersona>) em.createCriteria(RedPersona.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	//Metodo para obtener las redes sociales de una persona

		public List<RedPersona> obtenerRedesSocialesPersona( Persona dato) throws Exception {            
		      
			   List<RedPersona> datos = new ArrayList<RedPersona>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<RedPersona>) em.createCriteria(RedPersona.class).add(Restrictions.eq("persona", dato)).add(Restrictions.eq("activo", true)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}

}
