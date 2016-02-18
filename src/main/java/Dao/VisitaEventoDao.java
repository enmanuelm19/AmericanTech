package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.VisitaEvento;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class VisitaEventoDao {
private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarVisitaEvento(VisitaEvento dato) throws Exception{
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

	//Obtiene una lista con todas las visitas al club por un evento en especifico
	public List<VisitaEvento> obtenerVisitasAfiliado(int idEvento)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<VisitaEvento> datos = new ArrayList<VisitaEvento>();        
            try{
                datos = (List<VisitaEvento>) sesion.createCriteria(VisitaEvento.class)
                		.add(Restrictions.eq("eventoid_evento", idEvento)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una VisitaEvento especifica
	public VisitaEvento obtenerVisitaEvento(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    VisitaEvento dato = null;        
            try{
                dato = (VisitaEvento) sesion.get(VisitaEvento.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina una VisitaEvento en especifico
	public void eliminarVisitaEvento(VisitaEvento dato) throws Exception{		 
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();    
        Transaction tx = null;  
        try {  
            tx = sesion.beginTransaction();  
            sesion.delete(dato);  
            tx.commit();  
        } catch (Exception e) {  
            tx.rollback();  
            throw new Exception(e.getMessage(), e.getCause());
        } finally {  
            sesion.close();  
        }  
   }
	
	//Actualiza un Registro
	public void actualizarVisitaEvento(VisitaEvento dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla VisitaEvento
	public List<VisitaEvento> obtenerTodos() throws Exception {            
      
	   List<VisitaEvento> datos = new ArrayList<VisitaEvento>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<VisitaEvento>) em.createCriteria(VisitaEvento.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
