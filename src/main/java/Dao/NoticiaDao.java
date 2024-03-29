package Dao;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import modelos.Evento;
import modelos.Eventualidad;
import modelos.Noticia;
import modelos.Postulacion;
import confi.Sesion;

import org.hibernate.SQLQuery;
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
  	
    //Metodo para obtener las noticias que no han caducado

  	public List<Noticia> obtenerNoticiasVigentes(Date dato) throws Exception {            
  			      
  		List<Noticia> datos = new ArrayList<Noticia>();  
  		Session em = sesionPostgres.getSessionFactory().openSession();   	
  		 try { 
  		//devuelve las noticias cuya caducidad sea mayor o igual a la fecha que le envie por parametro y lo ordena de las mas nuevas a las mas viejas.
  		   datos =  (List<Noticia>) em.createCriteria(Noticia.class).add(Restrictions.ge("caducidad", dato))
  				   .add(Restrictions.eq("activo", true))
  				   .addOrder(Order.desc("fechaCreacion")).list();             
  			  } catch (Exception e) {             
  		 
  		throw new Exception(e.getMessage(),e.getCause());
  		     } finally {  
  		      em.close();  
  			 } 
  				       
  		   return datos; 
  		}
  	
  	
	public List<Noticia> obtenerNoticiasPublicas(Date dato) throws Exception {            
	      
  		List<Noticia> datos = new ArrayList<Noticia>();  
  		Session em = sesionPostgres.getSessionFactory().openSession();   	
  		 try { 
  		//devuelve las noticias cuya caducidad sea mayor o igual a la fecha que le envie por parametro y lo ordena de las mas nuevas a las mas viejas.
  		   datos =  (List<Noticia>) em.createCriteria(Noticia.class).add(Restrictions.ge("caducidad", dato))
  				   .add(Restrictions.eq("activo", true))
  				   .add(Restrictions.eq("publico", true))
  				   .addOrder(Order.desc("fechaCreacion")).list();             
  			  } catch (Exception e) {             
  		 
  		throw new Exception(e.getMessage(),e.getCause());
  		     } finally {  
  		      em.close();  
  			 } 
  				       
  		   return datos; 
  		}
	
	public Noticia obtenerNoticiaPostulacion(Postulacion dato) throws Exception {            
	       
	    Noticia datos;  
	    Session em = sesionPostgres.getSessionFactory().openSession();    
	     try {   
	       datos =  (Noticia) em.createCriteria(Noticia.class).add(Restrictions.eq("postulacion", dato)).add(Restrictions.eq("activo", true)).uniqueResult();             
	       } catch (Exception e) {             
	     
	    throw new Exception(e.getMessage(),e.getCause());
	         } finally {  
	          em.close();  
	      } 
	             
	       return datos; 
	    }

	
//	public Noticia obtenerNoticiaPostulacion(Date fecha) throws Exception {            
//	      
//  		List<Noticia> datos = new ArrayList<Noticia>();  
//  		Session em = sesionPostgres.getSessionFactory().openSession();   	
//  		 try {  	
//  		   SQLQuery query =	 em.createSQLQuery("Select n.* from noticia n join postulacion p on n.postulacionid_postulacion = p.id_postulacion where n.activo=p.activo=true and n.caducidad > :fecha");
//  		   query.addEntity(Noticia.class);
//  		   query.setDate("fecha", fecha);
//		   datos =  (List<Noticia>) query.list();
//  			  } catch (Exception e) {             
//  		 
//  		throw new Exception(e.getMessage(),e.getCause());
//  		     } finally {  
//  		      em.close();  
//  			 } 
//  				       
//  		   return datos; 
//  	}
  	

}
