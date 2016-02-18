//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.TipoEmpleado;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class TipoEmpleadoDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarTipoEmpleado(TipoEmpleado dato) throws Exception{
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
	
	
	//Obtiene un TipoEmpleado especifico
	public TipoEmpleado obtenerTipoEmpleado(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoEmpleado dato = null;        
            try{
                dato = (TipoEmpleado) sesion.get(TipoEmpleado.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Obtener un tipo de empleado mediante la descripcion
	public TipoEmpleado obtenerTipoDescripcion(String descrip) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoEmpleado dato = null;        
            try{
                dato = (TipoEmpleado) sesion.createCriteria(TipoEmpleado.class)
                		.add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Elimina un TipoEmpleado en especifico
	public void eliminarTipoEmpleado(TipoEmpleado dato) throws Exception{		 
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
	public void actualizarTipoAfiliado(TipoEmpleado dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla TipoEmpleado
	public List<TipoEmpleado> obtenerTodos() throws Exception {            
      
	   List<TipoEmpleado> datos = new ArrayList<TipoEmpleado>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<TipoEmpleado>) em.createCriteria(TipoEmpleado.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
