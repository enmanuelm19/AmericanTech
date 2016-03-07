package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Cargo;
import modelos.JuntaDirectiva;
import modelos.MiembroJunta;
import modelos.Persona;
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
            datos =  (List<MiembroJunta>) em.createCriteria(MiembroJunta.class).add(Restrictions.eq("activo", true)).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
     }

    public List<MiembroJunta> obtenerPorCargo(Cargo cargo) throws Exception {            
        
        List<MiembroJunta> datos = new ArrayList<MiembroJunta>();  
        Session em = sesionPostgres.getSessionFactory().openSession();       
         try {   
         datos =  (List<MiembroJunta>) em.createCriteria(MiembroJunta.class)
        		 .add(Restrictions.eq("cargo", cargo))
        		 .add(Restrictions.eq("activo", true)).list();             
         } catch (Exception e) {             
        
          throw new Exception(e.getMessage(),e.getCause());
         } finally {  
           em.close();  
         } 
        
         return datos; 
    }
    
    public List<MiembroJunta> obtenerPorJunta(JuntaDirectiva juntaDirectiva) throws Exception {            
        
        List<MiembroJunta> datos = new ArrayList<MiembroJunta>();  
        Session em = sesionPostgres.getSessionFactory().openSession();       
         try {   
         datos =  (List<MiembroJunta>) em.createCriteria(MiembroJunta.class)
        		 .add(Restrictions.eq("juntaDirectiva", juntaDirectiva))
        		 .add(Restrictions.eq("activo", true)).list();             
         } catch (Exception e) {             
        
          throw new Exception(e.getMessage(),e.getCause());
         } finally {  
           em.close();  
         } 
        
         return datos; 
    }
    
    public List<MiembroJunta> obtenerPorPersona(Persona persona) throws Exception {            
        
        List<MiembroJunta> datos = new ArrayList<MiembroJunta>();  
        Session em = sesionPostgres.getSessionFactory().openSession();       
         try {   
         datos =  (List<MiembroJunta>) em.createCriteria(MiembroJunta.class)
        		 .add(Restrictions.eq("persona", persona))
        		 .add(Restrictions.eq("activo", true)).uniqueResult();          
         } catch (Exception e) {             
        
          throw new Exception(e.getMessage(),e.getCause());
         } finally {  
           em.close();  
         } 
        
         return datos; 
    }
}
