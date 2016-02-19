package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.JuntaDirectiva;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class JuntaDirectivaDao {
	
private Sesion sesionPostgres;
    
    public void agregarJuntaDirectiva(JuntaDirectiva dato) throws Exception{
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
    
    public JuntaDirectiva obtenerJuntaDirectiva(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        JuntaDirectiva dato = null;        
            try{
                dato = (JuntaDirectiva ) sesion.get(JuntaDirectiva .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarJuntaDirectiva(JuntaDirectiva dato) throws Exception{        
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
    
    public void actualizarJuntaDirectiva(JuntaDirectiva dato) throws Exception{
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

    public List<JuntaDirectiva> obtenerTodos() throws Exception {            
          
           List<JuntaDirectiva> datos = new ArrayList<JuntaDirectiva>();  
           Session em = sesionPostgres.getSessionFactory().openSession();       
            try {   
            datos =  (List<JuntaDirectiva>) em.createCriteria(JuntaDirectiva.class).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
        }
}
