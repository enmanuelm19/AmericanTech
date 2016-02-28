package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.NoticiaPreferencia;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class NoticiaPreferenciaDao {

private Sesion sesionPostgres;
    
    public void agregarNoticiaPreferencia(NoticiaPreferencia dato) throws Exception{
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
    
    public NoticiaPreferencia obtenerNoticiaPreferencia(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        NoticiaPreferencia dato = null;        
            try{
                dato = (NoticiaPreferencia ) sesion.get(NoticiaPreferencia .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarNoticiaPreferencia(NoticiaPreferencia dato) throws Exception{        
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
    
    public void actualizarNoticiaPreferencia(NoticiaPreferencia dato) throws Exception{
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

    public List<NoticiaPreferencia> obtenerTodos() throws Exception {            
          
           List<NoticiaPreferencia> datos = new ArrayList<NoticiaPreferencia>();  
           Session em = sesionPostgres.getSessionFactory().openSession();       
            try {   
            datos =  (List<NoticiaPreferencia>) em.createCriteria(NoticiaPreferencia.class).add(Restrictions.eq("activo", true)).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
        }
    

}
