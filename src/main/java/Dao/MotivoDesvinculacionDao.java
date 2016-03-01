package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MotivoDesvinculacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class MotivoDesvinculacionDao {

private Sesion sesionPostgres;
    
    public void agregarMotivoDesvinculacion(MotivoDesvinculacion dato) throws Exception{
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
    
    public MotivoDesvinculacion obtenerMotivoDesvinculacion(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        MotivoDesvinculacion dato = null;        
            try{
                dato = (MotivoDesvinculacion ) sesion.get(MotivoDesvinculacion .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarMotivoDesvinculacion(MotivoDesvinculacion dato) throws Exception{        
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
    
    public void actualizarMotivoDesvinculacion(MotivoDesvinculacion dato) throws Exception{
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



    public List<MotivoDesvinculacion> obtenerTodos() throws Exception {            
        
        List<MotivoDesvinculacion> datos = new ArrayList<MotivoDesvinculacion>();  
        Session em = sesionPostgres.getSessionFactory().openSession();       
         try {   
         datos =  (List<MotivoDesvinculacion>) em.createCriteria(MotivoDesvinculacion.class).add(Restrictions.eq("activo", true)).list();             
         } catch (Exception e) {             
        
          throw new Exception(e.getMessage(),e.getCause());
         } finally {  
           em.close();  
         } 
        
         return datos; 
     }
}
