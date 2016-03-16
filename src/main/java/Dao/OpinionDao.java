package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Opinion;
import modelos.Postulacion;
import modelos.Recurso;
import modelos.Usuario;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por José Francisco Morón
 */

public class OpinionDao {
	private Sesion sesionPostgres;
	
	public void agregarOpinion(Opinion dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();  
         Transaction tx = null;  
         try {    
        	 tx = em.beginTransaction();
        	 Object find=em.merge(dato);   
             tx.commit();  
             em.delete(find);  
         } catch (Exception e) {  
             tx.rollback();            
             e.printStackTrace();
             throw e;
         } finally {  
             em.close();  
         } 
	}
	
	public Opinion obtenerOpinion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Opinion dato = null;        
            try{
                dato = (Opinion ) sesion.get(Opinion .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public Opinion obtenerOpinion(String descrip) throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		Opinion dato = null;
		try {
			dato = (Opinion) sesion.createCriteria(Opinion.class)
					.add(Restrictions.eq("descripcion", descrip)).add(Restrictions.eq("activo", true))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sesion.close();
		}
		return dato;
	}
	
	public void eliminarOpinion(Opinion dato) throws Exception{		 
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
	
	public void actualizarOpinion(Opinion dato) throws Exception{
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

	public List<Opinion> obtenerTodos() throws Exception {            
	      
		   List<Opinion> datos = new ArrayList<Opinion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Opinion>) em.createCriteria(Opinion.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}

		
	//Metodo para obtener las opiniones de un usuario

	public List<Opinion> obtenerOpinionesUsuario( Usuario dato) throws Exception {            
	      
		   List<Opinion> datos = new ArrayList<Opinion>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Opinion>) em.createCriteria(Opinion.class).add(Restrictions.eq("usuario", dato)).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	
	//Metodo para obtener las opiniones de una Postulacion

		public List<Opinion> obtenerOpinionesPostulacion( Postulacion dato) throws Exception {            
		      
			   List<Opinion> datos = new ArrayList<Opinion>();  
			   Session em = sesionPostgres.getSessionFactory().openSession();   	
		        try {  	
			    datos =  (List<Opinion>) em.createCriteria(Opinion.class).add(Restrictions.eq("postulacion", dato)).list();             
		        } catch (Exception e) {             
		       
		         throw new Exception(e.getMessage(),e.getCause());
		        } finally {  
		          em.close();  
		        } 
		       
		        return datos; 
			}
	
}
