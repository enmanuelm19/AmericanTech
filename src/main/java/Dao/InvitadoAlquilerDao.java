package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.InvitadoAlquiler;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class InvitadoAlquilerDao {
	
private Sesion sesionPostgres;
    
    public void agregarInvitadoAlquiler(InvitadoAlquiler dato) throws Exception{
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
    
    public InvitadoAlquiler obtenerInvitadoAlquiler(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        InvitadoAlquiler dato = null;        
            try{
                dato = (InvitadoAlquiler ) sesion.get(InvitadoAlquiler .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarInvitadoAlquiler(InvitadoAlquiler dato) throws Exception{        
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
    
    public void actualizarInvitadoAlquiler(InvitadoAlquiler dato) throws Exception{
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

    public List<InvitadoAlquiler> obtenerTodos() throws Exception {            
          
           List<InvitadoAlquiler> datos = new ArrayList<InvitadoAlquiler>();  
           Session em = sesionPostgres.getSessionFactory().openSession();       
            try {   
            datos =  (List<InvitadoAlquiler>) em.createCriteria(InvitadoAlquiler.class).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
        }
}
