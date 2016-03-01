//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.TipoPreferencia;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class TipoPreferenciaDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarTipoPreferencia(TipoPreferencia dato) throws Exception{
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
	
	
	//Obtiene un TipoPreferencia especifico
	public TipoPreferencia obtenerTipoPreferencia(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoPreferencia dato = null;        
            try{
                dato = (TipoPreferencia) sesion.get(TipoPreferencia.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Obtener un tipo de preferencia mediante la descripcion
	public TipoPreferencia obtenerTipoDescripcion(String descrip) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoPreferencia dato = null;        
            try{
                dato = (TipoPreferencia) sesion.createCriteria(TipoPreferencia.class)
                		.add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Elimina un TipoPolitica en especifico
	public void eliminarTipoPreferencia(TipoPreferencia dato) throws Exception{		 
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
	public void actualizarTipoPreferencia(TipoPreferencia dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla TipoPreferencia
	public List<TipoPreferencia> obtenerTodos() throws Exception {            
	   List<TipoPreferencia> datos = new ArrayList<TipoPreferencia>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<TipoPreferencia>) em.createCriteria(TipoPreferencia.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
