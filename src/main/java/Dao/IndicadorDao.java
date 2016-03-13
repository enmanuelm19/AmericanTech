package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Indicador;
import confi.Sesion;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class IndicadorDao {

private Sesion sesionPostgres;
	
	
//Agrega un registro a la tabla.
	public void agregarIndicador(Indicador dato) throws Exception{
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
	
	

	public Indicador obtenerIndicador(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Indicador dato = null;        
         try{
             dato = (Indicador) sesion.get(Indicador.class,  id);
         } catch (Exception e) {  
         e.printStackTrace();
         throw new Exception(e.getMessage(),e.getCause());
         }  finally {  
             sesion.close();  
         }  
	    return dato;
	}
	
	
	public Indicador obtenerIndicador(String descripcion) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Indicador dato = null;        
         try{
             dato = (Indicador) sesion.createCriteria(Indicador.class)
             		.add(Restrictions.eq("descripcion", descripcion))
             		.add(Restrictions.eq("activo", true)).uniqueResult();
         } catch (Exception e) {  
         e.printStackTrace();
         throw new Exception(e.getMessage(),e.getCause());
         }  finally {  
             sesion.close();  
         }  
	    return dato;
	}
	
	
	public void eliminarIndicador(Indicador dato) throws Exception{		 
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
	public void actualizarIndicador(Indicador dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla 
	public List<Indicador> obtenerTodos() throws Exception {            
	   List<Indicador> datos = new ArrayList<Indicador>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
     try {  	
	    datos =  (List<Indicador>) em.createCriteria(Indicador.class).add(Restrictions.eq("activo", true)).list();             
     } catch (Exception e) {             
      throw new Exception(e.getMessage(),e.getCause());
     } finally {  
       em.close();  
     } 
     return datos; 
	}

}
