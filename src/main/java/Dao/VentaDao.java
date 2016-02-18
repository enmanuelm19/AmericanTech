//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Venta;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class VentaDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarVenta(Venta dato) throws Exception{
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

	//Obtiene una lista con todas las ventas que se han realizado de una misma accion
	public List<Venta> obtenerVentasAccion(int idAccion)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Venta> datos = new ArrayList<Venta>();        
            try{
                datos = (List<Venta>) sesion.createCriteria(Venta.class)
                		.add(Restrictions.eq("accionid_accion",idAccion)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una lista con todas las ventas que se han realisado en funcion de un motivo especifico
	public List<Venta> obtenerVentasMotivo(int idMotivo)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Venta> datos = new ArrayList<Venta>();        
            try{
                datos = (List<Venta>) sesion.createCriteria(Venta.class)
                		.add(Restrictions.eq("motivo_ventaid_motivo_venta",idMotivo)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una Venta especifica
	public Venta obtenerVenta(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Venta dato = null;        
            try{
                dato = (Venta) sesion.get(Venta.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina una Venta en especifico
	public void eliminarVenta(Venta dato) throws Exception{		 
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
	public void actualizarVenta(Venta dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla Venta
	public List<Venta> obtenerTodos() throws Exception {            
      
	   List<Venta> datos = new ArrayList<Venta>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Venta>) em.createCriteria(Venta.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}
}
