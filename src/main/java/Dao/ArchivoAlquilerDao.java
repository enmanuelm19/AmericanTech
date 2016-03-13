package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Alquiler;
import modelos.Archivo;
import modelos.ArchivoAlquiler;
import modelos.TipoArchivo;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class ArchivoAlquilerDao {

private Sesion sesionPostgres;
	
	
	public void agregarArchivoAlquiler(ArchivoAlquiler dato) throws Exception{
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
	
	public void eliminarArchivoAlquiler(ArchivoAlquiler dato) throws Exception{		 
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
	
	public void actualizarArchivoAlquiler(ArchivoAlquiler dato) throws Exception{
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
	
	public List<ArchivoAlquiler> obtenerTodos() throws Exception {            
      
	   List<ArchivoAlquiler> datos = new ArrayList<ArchivoAlquiler>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<ArchivoAlquiler>) em.createCriteria(ArchivoAlquiler.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}
	
	//devuelve los archivos que pertenecen a un alquiler especifico
	
	public List<ArchivoAlquiler> obtenerPorAlquiler(Alquiler alquiler) throws Exception {            
	      
		   List<ArchivoAlquiler> datos = new ArrayList<ArchivoAlquiler>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<ArchivoAlquiler>) em.createCriteria(ArchivoAlquiler.class).add(Restrictions.eq("alquiler", alquiler))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	       
	        return datos; 
	}
	
	//devuelve el archivo que pertenece a un alquiler a partir de un archivo dentro de la clase archivo
	
	public ArchivoAlquiler obtenerPorArchivo(Archivo archivo) throws Exception {            
	      
		   ArchivoAlquiler datos = new ArchivoAlquiler();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (ArchivoAlquiler) em.createCriteria(ArchivoAlquiler.class).add(Restrictions.eq("archivo", archivo))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return datos; 
	}
	
	//devuelve los archivos por tipo de archivos tipoArchivo
	
	public List<ArchivoAlquiler> obtenerPorTipo(TipoArchivo tipoArchivo) throws Exception {            
	      
		List<ArchivoAlquiler> datos = new ArrayList<ArchivoAlquiler>();  
		   Session em = sesionPostgres.getSessionFactory().openSession();   	
	        try {  	
		    datos =  (List<ArchivoAlquiler>) em.createCriteria(ArchivoAlquiler.class).add(Restrictions.eq("tipoArchivo", tipoArchivo))
		    		.add(Restrictions.eq("activo", true)).list();             
	        } catch (Exception e) {             
	       
	         throw new Exception(e.getMessage(),e.getCause());
	        } finally {  
	          em.close();  
	        } 
	        return datos; 
	}
}
