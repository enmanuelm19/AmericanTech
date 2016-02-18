//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.SolicitudEvento;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class SolicitudEventoDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarSolicitudEvento(SolicitudEvento dato) throws Exception{
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

	//Obtiene una lista con todas las solicitudes de evento hechas por un socio.
	public List<SolicitudEvento> obtenerSolicitudSocio(int idSocio)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<SolicitudEvento> datos = new ArrayList<SolicitudEvento>();        
            try{
                datos = (List<SolicitudEvento>) sesion.createCriteria(SolicitudEvento.class)
                		.add(Restrictions.eq("socioid_socio",idSocio)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una Solicitud especifica
	public SolicitudEvento obtenerSancion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    SolicitudEvento dato = null;        
            try{
                dato = (SolicitudEvento) sesion.get(SolicitudEvento.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina una Solicitud en especifico
	public void eliminarSolicitud(SolicitudEvento dato) throws Exception{		 
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
	public void actualizarSolicitud(SolicitudEvento dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla SolicitudEvento
	public List<SolicitudEvento> obtenerTodos() throws Exception {            
      
	   List<SolicitudEvento> datos = new ArrayList<SolicitudEvento>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<SolicitudEvento>) em.createCriteria(SolicitudEvento.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
