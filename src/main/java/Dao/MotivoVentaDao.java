package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MotivoVenta;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class MotivoVentaDao {

private Sesion sesionPostgres;
    
    public void agregarMotivoVenta(MotivoVenta dato) throws Exception{
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
    
    public MotivoVenta obtenerMotivoVenta(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        MotivoVenta dato = null;        
            try{
                dato = (MotivoVenta ) sesion.get(MotivoVenta .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarMotivoVenta(MotivoVenta dato) throws Exception{        
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
    
    public void actualizarMotivoVenta(MotivoVenta dato) throws Exception{
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

    public List<MotivoVenta> obtenerTodos() throws Exception {            
          
           List<MotivoVenta> datos = new ArrayList<MotivoVenta>();  
           Session em = sesionPostgres.getSessionFactory().openSession();       
            try {   
            datos =  (List<MotivoVenta>) em.createCriteria(MotivoVenta.class).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
        }
	
}
