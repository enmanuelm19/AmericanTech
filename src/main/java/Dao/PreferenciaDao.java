package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Preferencia;
import modelos.TipoPreferencia;
import modelos.Preferencia;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

/**
 * creado por Jos� Francisco Mor�n
 */

public class PreferenciaDao {
	
private Sesion sesionPostgres;
	
	public void agregarPreferencia(Preferencia dato) throws Exception{
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
	
	public Preferencia obtenerPreferencia(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Preferencia dato = null;        
            try{
                dato = (Preferencia ) sesion.get(Preferencia .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public Preferencia obtenerPreferencia(String descrip) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Preferencia dato = null;        
            try{
                dato = (Preferencia) sesion.createCriteria(Preferencia.class)
                		.add(Restrictions.eq("descripcion", descrip)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	public void eliminarPreferencia(Preferencia dato) throws Exception{		 
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
	
	public void actualizarPreferencia(Preferencia dato) throws Exception{
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

	public List<Preferencia> obtenerTodos() throws Exception {            
	      
		   List<Preferencia> datos = new ArrayList<Preferencia>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Preferencia>) em.createCriteria(Preferencia.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
		
	//Metodo para obtener las preferencias de "x" tipo de preferencia

	public List<Preferencia> obtenerPreferenciasTipo(TipoPreferencia dato) throws Exception {

		List<Preferencia> datos = new ArrayList<Preferencia>();
		Session em = sesionPostgres.getSessionFactory().openSession();
		try {
			datos = (List<Preferencia>) em.createCriteria(Preferencia.class)
					.add(Restrictions.eq("tipoPreferencia", dato)).list();
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			em.close();
		}

		return datos;
	}


}
