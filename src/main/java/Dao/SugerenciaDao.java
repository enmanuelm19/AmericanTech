//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Sugerencia;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class SugerenciaDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarSugerencia(Sugerencia dato) throws Exception{
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
	
	// Obtiene una lista con las Sugerencias que sean del mismo tipo.
	public List<Sugerencia> obtenerSugerenciasTipo(int idTipo)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Sugerencia> datos = new ArrayList<Sugerencia>();        
            try{
                datos = (List<Sugerencia>) sesion.createCriteria(Sugerencia.class)
                		.add(Restrictions.eq("tipo_sugerenciaid_tipo_sugerencia", idTipo)).list();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una lista con todas las Sugerencias que ha hecho un usuario del sistema
	public List<Sugerencia> obtenerSugerenciasUsuario(int idUsuario)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Sugerencia> datos = new ArrayList<Sugerencia>();        
            try{
                datos = (List<Sugerencia>) sesion.createCriteria(Sugerencia.class)
                		.add(Restrictions.eq("usuarioid_usuario", idUsuario)).list();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una Sugerencia especifica
	public Sugerencia obtenerSugerencia(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Sugerencia dato = null;        
            try{
                dato = (Sugerencia) sesion.get(Sugerencia.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Elimina una Sugerencia en especifico
	public void eliminarSugerencia(Sugerencia dato) throws Exception{		 
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
	public void actualizarSugerencia(Sugerencia dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla Sugerencia
	public List<Sugerencia> obtenerTodos() throws Exception {            
      
	   List<Sugerencia> datos = new ArrayList<Sugerencia>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Sugerencia>) em.createCriteria(Sugerencia.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
