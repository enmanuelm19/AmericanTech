//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.TipoActividad;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class TipoActividadDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarTipoActividad(TipoActividad dato) throws Exception{
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
	
	
	//Obtiene un TipoActividad especifico
	public TipoActividad obtenerTipoActividad(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoActividad dato = null;        
            try{
                dato = (TipoActividad) sesion.get(TipoActividad.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Obtener un tipo de actividad mediante la descripcion
	public TipoActividad obtenerTipoDescripcion(String descrip) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoActividad dato = null;        
            try{
                dato = (TipoActividad) sesion.createCriteria(TipoActividad.class)
                		.add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina un TipoActividad en especifico
	public void eliminarTipoActividad(TipoActividad dato) throws Exception{		 
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
	
	//Actualiza un Registro
	public void actualizarTipoActividad(TipoActividad dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla TipoActividad
	public List<TipoActividad> obtenerTodos() throws Exception {            
      
	   List<TipoActividad> datos = new ArrayList<TipoActividad>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<TipoActividad>) em.createCriteria(TipoActividad.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}
}
