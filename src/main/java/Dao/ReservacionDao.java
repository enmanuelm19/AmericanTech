//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Reservacion;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class ReservacionDao {
private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarReservacion(Reservacion dato) throws Exception{
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
	// Obtiene las Reservaciones que tiene una instalacion especifica.
	public List<Reservacion> obtenerReservacionesInstalacion(int idInstalacion)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Reservacion> datos = new ArrayList<Reservacion>();        
            try{
                datos = (List<Reservacion>) sesion.createCriteria(Reservacion.class)
                		.add(Restrictions.eq("instalacionid_instalacion", idInstalacion)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	//Obtiene una lista con todas las Reservaciones que ha realizado un socio
	public List<Reservacion> obtenerReservacionesSocio(int idSocio)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Reservacion> datos = new ArrayList<Reservacion>();        
            try{
                datos = (List<Reservacion>) sesion.createCriteria(Reservacion.class)
                		.add(Restrictions.eq("socioid_socio",idSocio)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una Reservacion especifica
	public Reservacion obtenerReservacion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Reservacion dato = null;        
            try{
                dato = (Reservacion) sesion.get(Reservacion.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina un Reservacion en especifico
	public void eliminarReservacion(Reservacion dato) throws Exception{		 
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
	public void actualizarReservacion(Reservacion dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla Reservacion
	public List<Reservacion> obtenerTodos() throws Exception {            
      
	   List<Reservacion> datos = new ArrayList<Reservacion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Reservacion>) em.createCriteria(Reservacion.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}	
}
