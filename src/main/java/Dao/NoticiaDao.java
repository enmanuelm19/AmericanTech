package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Evento;
import modelos.Eventualidad;
import modelos.Noticia;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */
public class NoticiaDao {

private Sesion sesionPostgres;
    
    public void agregarNoticia(Noticia dato) throws Exception{
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
    
    public Noticia obtenerNoticia(int id) throws Exception{        
        @SuppressWarnings("static-access")
        Session sesion = sesionPostgres.getSessionFactory().openSession();  
        Noticia dato = null;        
            try{
                dato = (Noticia ) sesion.get(Noticia .class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
           
        return dato;
}
    
    public void eliminarNoticia(Noticia dato) throws Exception{        
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
    
    public void actualizarNoticia(Noticia dato) throws Exception{
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

    public List<Noticia> obtenerTodos() throws Exception {            
          
           List<Noticia> datos = new ArrayList<Noticia>();  
           Session em = sesionPostgres.getSessionFactory().openSession();       
            try {   
            datos =  (List<Noticia>) em.createCriteria(Noticia.class).add(Restrictions.eq("activo", true)).addOrder(Order.desc("fechaCreacion")).list();             
            } catch (Exception e) {             
           
             throw new Exception(e.getMessage(),e.getCause());
            } finally {  
              em.close();  
            } 
           
            return datos; 
        }
    

  //Metodo para obtener noticias de "x" evento

  	public List<Noticia> obtenerNoticiasevento( Evento dato) throws Exception {            
  			      
  		List<Noticia> datos = new ArrayList<Noticia>();  
  		Session em = sesionPostgres.getSessionFactory().openSession();   	
  		 try {  	
  		   datos =  (List<Noticia>) em.createCriteria(Noticia.class).add(Restrictions.eq("evento", dato)).add(Restrictions.eq("activo", true)).list();             
  			  } catch (Exception e) {             
  		 
  		throw new Exception(e.getMessage(),e.getCause());
  		     } finally {  
  		      em.close();  
  			 } 
  				       
  		   return datos; 
  		}
}
