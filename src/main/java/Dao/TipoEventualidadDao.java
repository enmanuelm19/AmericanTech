package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.TipoEventualidad;
import modelos.TipoEventualidad;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class TipoEventualidadDao {

private Sesion sesionPostgres;
	
	
	public void agregarTipoEventualidad(TipoEventualidad dato) throws Exception{
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
	
	//Obtiene un TipoEventualidad especifico
		public TipoEventualidad obtenerTipoEventualidad(int id) throws Exception{		 
		    @SuppressWarnings("static-access")
		    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
		    TipoEventualidad dato = null;        
	            try{
	                dato = (TipoEventualidad) sesion.get(TipoEventualidad.class,  id);
	            } catch (Exception e) {  
	            e.printStackTrace();
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
		    return dato;
		}
		
		//Obtener un tipo de eventualidad mediante la descripcion
		public TipoEventualidad obtenerTipoEventualidad(String descrip) throws Exception{		 
		    @SuppressWarnings("static-access")
		    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
		    TipoEventualidad dato = null;        
	            try{
	                dato = (TipoEventualidad) sesion.createCriteria(TipoEventualidad.class)
	                		.add(Restrictions.eq("descripcion", descrip)).add(Restrictions.eq("activo", true)).uniqueResult();
	            } catch (Exception e) {  
	            e.printStackTrace();
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }  
		    return dato;
		
		}
	
	public void eliminarTipoEventualidad(TipoEventualidad dato) throws Exception{		 
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
	
	public void actualizarTipoEventualidad(TipoEventualidad dato) throws Exception{
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
	
	public List<TipoEventualidad> obtenerTodos() throws Exception {            
      
	   List<TipoEventualidad> datos = new ArrayList<TipoEventualidad>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<TipoEventualidad>) em.createCriteria(TipoEventualidad.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	

	
	
	
}
