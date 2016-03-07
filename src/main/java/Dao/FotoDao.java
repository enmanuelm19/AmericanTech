package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Club;
import modelos.Eventualidad;
import modelos.Foto;
import modelos.Instalacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */


public class FotoDao {

private Sesion sesionPostgres;
	
	public void agregarFoto(Foto dato) throws Exception{
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
	
	public Foto obtenerFoto(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();  
	    Foto dato = null;        
            try{
                dato = (Foto ) sesion.get(Foto .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
	    return dato;
}
	
	public void eliminarFoto(Foto dato) throws Exception{		 
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
	
	public void actualizarFoto(Foto dato) throws Exception{
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

	public List<Foto> obtenerTodos() throws Exception {            
	      
		   List<Foto> datos = new ArrayList<Foto>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<Foto>) em.createCriteria(Foto.class).add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
		}
	

	
	//Metodo para obtener fotos de "x" instalacion.

		public List<Foto> obtenerFotoinstalacion(Instalacion instalacion) throws Exception {            
				      
			List<Foto> datos = new ArrayList<Foto>();  
			Session em = sesionPostgres.getSessionFactory().openSession();   	
			 try {  	
			   datos =  (List<Foto>) em.createCriteria(Foto.class).add(Restrictions.eq("instalacion", instalacion)).list();             
				  } catch (Exception e) {             
			 
			throw new Exception(e.getMessage(),e.getCause());
			     } finally {  
			      em.close();  
				 } 
					       
			   return datos; 
			}
		//Metodo para obtener fotos del club

		public List<Foto> obtenerPorClub(Club club) throws Exception {            
				      
			List<Foto> datos = new ArrayList<Foto>();  
			Session em = sesionPostgres.getSessionFactory().openSession();   	
			 try {  	
			   datos =  (List<Foto>) em.createCriteria(Foto.class).add(Restrictions.eq("club", club))
					   .add(Restrictions.eq("activo", true)).list();             
				  } catch (Exception e) {             
			 
			throw new Exception(e.getMessage(),e.getCause());
			     } finally {  
			      em.close();  
				 } 
					       
			   return datos; 
			}
	
}
