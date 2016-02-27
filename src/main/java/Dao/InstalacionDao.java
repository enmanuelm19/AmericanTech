package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Foto;
import modelos.Instalacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class InstalacionDao {

private Sesion sesionPostgres;
	
	public void agregarInstalacion(Instalacion dato) throws Exception{
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
	
	public Instalacion obtenerInstalacion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Instalacion dato = null;        
            try{
                dato = (Instalacion ) sesion.get(Instalacion .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarInstalacion(Instalacion dato) throws Exception{		 
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
	
	public void actualizarInstalacion(Instalacion dato) throws Exception{
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

	public List<Instalacion> obtenerTodos() throws Exception {            
	      
		   List<Instalacion> datos = new ArrayList<Instalacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Instalacion>) em.createCriteria(Instalacion.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	
	//Metodo para obtener que tipo de instalacion pertenece la instalacion. duda

			public List<Instalacion> obtenerTipoinstalacion( int id) throws Exception {            
					      
				List<Instalacion> datos = new ArrayList<Instalacion>();  
				Session em = sesionPostgres.getSessionFactory().openSession();   	
				 try {  	
				   datos =  (List<Instalacion>) em.createCriteria(Instalacion.class).add(Restrictions.eq("tipo_instalacionid_tipo_instalacion", id)).list();             
					  } catch (Exception e) {             
				 
				throw new Exception(e.getMessage(),e.getCause());
				     } finally {  
				      em.close();  
					 } 
						       
				   return datos; 
				}
}
