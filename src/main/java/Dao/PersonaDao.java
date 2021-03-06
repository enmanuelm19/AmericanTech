package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Persona;
import modelos.Preferencia;
import confi.Sesion;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;

/**
 * creado por Jos� Francisco Mor�n
 */

public class PersonaDao {

private Sesion sesionPostgres;
	
	public void agregarPersona(Persona dato) throws Exception{
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
	
	public Persona obtenerPersona(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Persona dato = null;        
            try{
                dato = (Persona ) sesion.get(Persona .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarPersona(Persona dato) throws Exception{		 
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
	
	public void hardDelete(Persona dato){
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = em.beginTransaction();
			em.delete(dato);
			tx.commit();
		} catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
				
	}
	
	public void actualizarPersona(Persona dato) throws Exception{
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

	public List<Persona> obtenerTodos() throws Exception {            
	      
		   List<Persona> datos = new ArrayList<Persona>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Persona>) em.createCriteria(Persona.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	public Persona obtenerPersonaCedula(String cedula)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    Persona datos = null;        
            try{
                datos = (Persona) sesion.createCriteria(Persona.class)
                		.add(Restrictions.eq("identificacion", cedula)).add(Restrictions.eq("activo", true)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
//	public List<Persona> obtenerPorPreferencia(List<Preferencia> preferencias) throws Exception { 
//		String tira = "Select DISTINCT p.* from Persona p join preferenciaPersona prefp on p.idPersona = prefp.personaid_persona where prefp.preferenciaid_preferencia =some element(:list)";
//		for (int i=0; i<preferencias.size(); i++){
//			
//		}
//		   List<Persona> datos = new ArrayList<Persona>();  
//		   Session em = sesionPostgres.getSessionFactory().openSession();   	
//	        try {  
//	        Query query = em.createQuery();
//		    datos =  (List<Persona>) em.createCriteria(Persona.class).add(Restrictions.eq("activo", true)).list();             
//	        } catch (Exception e) {             
//	       
//	         throw new Exception(e.getMessage(),e.getCause());
//	        } finally {  
//	          em.close();  
//	        } 
//	       
//	        return datos; 
//	}
}
