package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.ProveedorActividad;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

/**
 * creado por José Francisco Morón
 */

public class ProveedorActividadDao {
	
private Sesion sesionPostgres;
	
	public void agregarProveedorActividad(ProveedorActividad dato) throws Exception{
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
	
	public ProveedorActividad obtenerProveedorActividad(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    ProveedorActividad dato = null;        
            try{
                dato = (ProveedorActividad ) sesion.get(ProveedorActividad .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarProveedorActividad(ProveedorActividad dato) throws Exception{		 
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
	
	public void actualizarProveedorActividad(ProveedorActividad dato) throws Exception{
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

	public List<ProveedorActividad> obtenerTodos() throws Exception {            
	      
		   List<ProveedorActividad> datos = new ArrayList<ProveedorActividad>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<ProveedorActividad>) em.createCriteria(ProveedorActividad.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
		
	//Metodo para obtener los proveedores de una actividad

	public List<ProveedorActividad> obtenerProveedoresPorActividad( int id) throws Exception {            
	      
		   List<ProveedorActividad> datos = new ArrayList<ProveedorActividad>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<ProveedorActividad>) em.createCriteria(ProveedorActividad.class).add(Restrictions.eq("actividadid_actividad", id)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	//Metodo para obtener las actividades en las que participa un proveedor

		public List<ProveedorActividad> obtenerActividadesPorProveedor( int id) throws Exception {            
		      
			   List<ProveedorActividad> datos = new ArrayList<ProveedorActividad>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<ProveedorActividad>) em.createCriteria(ProveedorActividad.class).add(Restrictions.eq("proveedorid_proveedor", id)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}


}
