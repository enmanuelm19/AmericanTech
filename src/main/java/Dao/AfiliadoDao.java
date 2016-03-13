package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Afiliado;
import modelos.Persona;
import modelos.TipoAfiliado;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class AfiliadoDao {

private Sesion sesionPostgres;
	
	
	public void agregarAfiliado(Afiliado dato) throws Exception{
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
	
	public void eliminarAfiliado(Afiliado dato) throws Exception{		 
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
	
	public void actualizarAfiliado(Afiliado dato) throws Exception{
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
	
	public List<Afiliado> obtenerTodos() throws Exception {            
      
	   List<Afiliado> datos = new ArrayList<Afiliado>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Afiliado>) em.createCriteria(Afiliado.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
	
	public Afiliado obtenerAfiliado(int id) throws Exception {            
	      
		   Afiliado dato = new Afiliado();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    dato =  (Afiliado) em.get(Afiliado.class, id);             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return dato; 
	}
	
	//devuelve un afiliado con un numero de carnet especifico
	public Afiliado obtenerPorNroCarnet(String carnet) throws Exception {            
	      
		   Afiliado dato = new Afiliado();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    dato =  (Afiliado) em.createCriteria(Afiliado.class).add(Restrictions.eq("nroCarnet", carnet))
		    		.add(Restrictions.eq("activo", true)).uniqueResult();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return dato; 
	}
	
	//devuelve un afiliado a partir de un objeto persona
	public Afiliado obtenerPorPersona(Persona persona) throws Exception {            
	      
		   Afiliado dato = new Afiliado();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    dato =  (Afiliado) em.createCriteria(Afiliado.class).add(Restrictions.eq("persona", persona))
		    		.add(Restrictions.eq("activo", true)).uniqueResult();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return dato; 
	}
	
	//obtiene todos los afiliados de cierto socio.
	public List<Afiliado> obtenerPorSocio(Persona persona) throws Exception {            
	      
		   List<Afiliado> dato = new ArrayList<Afiliado>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    dato =  (List<Afiliado>) em.createCriteria(Afiliado.class).add(Restrictions.eq("persona", persona))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return dato; 
	}
	
	//obtiene todos los afiliados de cierto tipo
	public List<Afiliado> obtenerPorTipo(TipoAfiliado tipo) throws Exception {            
	      
		List<Afiliado> datos = new ArrayList<Afiliado>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Afiliado>) em.createCriteria(Afiliado.class).add(Restrictions.eq("tipoAfiliado", tipo))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
}
