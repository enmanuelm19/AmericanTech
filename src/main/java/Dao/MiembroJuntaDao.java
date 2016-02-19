package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MiembroJunta;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class MiembroJuntaDao {

private Sesion sesionPostgres;
    
    public void agregarMiembroJunta(MiembroJunta dato) throws Exception{
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
    
    public MiembroJunta obtenerMiembroJunta(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        MiembroJunta dato = null;        
            try{
                dato = (MiembroJunta ) sesion.get(MiembroJunta .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarMiembroJunta(MiembroJunta dato) throws Exception{        
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
    
    public void actualizarMiembroJunta(MiembroJunta dato) throws Exception{
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

    public List<MiembroJunta> obtenerTodos() throws Exception {            
          
           List<MiembroJunta> datos = new ArrayList<MiembroJunta>();  
           Session em = sesionPostgres.getSessionFactory().openSession();       
            try {   
            datos =  (List<MiembroJunta>) em.createCriteria(MiembroJunta.class).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
        }
}
