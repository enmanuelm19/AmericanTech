package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.FuncionGrupo;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class FuncionGrupoDao {
	
private Sesion sesionPostgres;
	
	public void agregarFuncionGrupo(FuncionGrupo dato) throws Exception{
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
	
	public FuncionGrupo obtenerFuncionGrupo(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    FuncionGrupo dato = null;        
            try{
                dato = (FuncionGrupo ) sesion.get(FuncionGrupo .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarFuncionGrupo(FuncionGrupo dato) throws Exception{		 
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
	
	public void actualizarFuncionGrupo(FuncionGrupo dato) throws Exception{
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

	public List<FuncionGrupo> obtenerTodos() throws Exception {            
	      
		   List<FuncionGrupo> datos = new ArrayList<FuncionGrupo>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<FuncionGrupo>) em.createCriteria(FuncionGrupo.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	

}
