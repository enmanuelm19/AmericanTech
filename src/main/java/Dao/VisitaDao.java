//Creado por: Edward Rodriguez 17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Visita;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class VisitaDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarVenta(Visita dato) throws Exception{
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

	//Obtiene una lista con todas las visitas al club que ha realizado un afiliado especifico
	public List<Visita> obtenerVisitasAfiliado(int idAfiliado)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Visita> datos = new ArrayList<Visita>();        
            try{
                datos = (List<Visita>) sesion.createCriteria(Visita.class)
                		.add(Restrictions.eq("afiliadoid_afiliado",idAfiliado)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una lista con todas las visitas al club por parte de un invitado.
		public List<Visita> obtenerVisitasInvitado(int idInvitado)throws Exception{
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.getSessionFactory().openSession();   
		    List<Visita> datos = new ArrayList<Visita>();        
	            try{
	                datos = (List<Visita>) sesion.createCriteria(Visita.class)
	                		.add(Restrictions.eq("invitadoid_invitado", idInvitado)).list();
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }       
		    return datos;	
		}
	
	//Obtiene una lista con todas las visitas que se ha realizado en funcion de un afiliado especifico
	public List<Visita> obtenerVisitaSocio(int idSocio)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Visita> datos = new ArrayList<Visita>();        
            try{
                datos = (List<Visita>) sesion.createCriteria(Visita.class)
                		.add(Restrictions.eq("socioid_socio",idSocio)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una Visita especifica
	public Visita obtenerVisita(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Visita dato = null;        
            try{
                dato = (Visita) sesion.get(Visita.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina una Visita en especifico
	public void eliminarVisita(Visita dato) throws Exception{		 
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
	public void actualizarVisita(Visita dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla Visita
	public List<Visita> obtenerTodos() throws Exception {            
      
	   List<Visita> datos = new ArrayList<Visita>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Visita>) em.createCriteria(Visita.class).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}
}
