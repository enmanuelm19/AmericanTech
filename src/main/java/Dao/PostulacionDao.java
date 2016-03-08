package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.MotivoPostulacion;
import modelos.Opinion;
import modelos.Postulacion;
import modelos.Postulado;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

/**
 * creado por José Francisco Morón
 */

public class PostulacionDao {

private Sesion sesionPostgres;
	
	public void agregarPostulacion(Postulacion dato) throws Exception{
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
	
	public Postulacion obtenerPostulacion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Postulacion dato = null;        
            try{
                dato = (Postulacion ) sesion.get(Postulacion .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarPostulacion(Postulacion dato) throws Exception{		 
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
	
	public void actualizarPostulacion(Postulacion dato) throws Exception{
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

	public List<Postulacion> obtenerTodos() throws Exception {            
	      
		   List<Postulacion> datos = new ArrayList<Postulacion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Postulacion>) em.createCriteria(Postulacion.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}

	//Metodo para obtener las postulaciones con "x" motivo de postulacion

		public List<Postulacion> obtenerPostulacionesMotivo( MotivoPostulacion dato) throws Exception {            
		      
			   List<Postulacion> datos = new ArrayList<Postulacion>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<Postulacion>) em.createCriteria(Postulacion.class).add(Restrictions.eq("motivoPostulacion", dato)).add(Restrictions.eq("activo", true)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}
		
		//Metodo para obtener las postulaciones de un postulado

				public List<Postulacion> obtenerPostulacionesPostulado( Postulado dato) throws Exception {            
				      
					   List<Postulacion> datos = new ArrayList<Postulacion>();  
					   Session em = sesionPostgres.getSessionFactory().openSession();   	
				        try {  	
					    datos =  (List<Postulacion>) em.createCriteria(Postulacion.class).add(Restrictions.eq("postulado", dato)).add(Restrictions.eq("activo", true)).list();             
				        } catch (Exception e) {             
				       
				         throw new Exception(e.getMessage(),e.getCause());
				        } finally {  
				          em.close();  
				        } 
				       
				        return datos; 
					}
}
