//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.TipoSugerencia;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class TipoSugerenciaDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarTipoSugerencia(TipoSugerencia dato) throws Exception{
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
	
	
	//Obtiene un TipoSugerencia especifico
	public TipoSugerencia obtenerTipoSugerencia(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoSugerencia dato = null;        
            try{
                dato = (TipoSugerencia) sesion.get(TipoSugerencia.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Obtener un tipo de sugerencia mediante la descripcion
	public TipoSugerencia obtenerTipoDescripcion(String descrip) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoSugerencia dato = null;        
            try{
                dato = (TipoSugerencia) sesion.createCriteria(TipoSugerencia.class)
                		.add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Elimina un TipoSugerencia en especifico
	public void eliminarTipoSugerencia(TipoSugerencia dato) throws Exception{		 
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
	
	//Actualiza un Registro
	public void actualizarTipoSugerencia(TipoSugerencia dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla TipoSugerencia
	public List<TipoSugerencia> obtenerTodos() throws Exception {            
	   List<TipoSugerencia> datos = new ArrayList<TipoSugerencia>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<TipoSugerencia>) em.createCriteria(TipoSugerencia.class).list();             
        } catch (Exception e) {             
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
