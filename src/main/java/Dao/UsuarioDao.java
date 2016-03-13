//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Persona;
import modelos.Usuario;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioDao {
	private Sesion sesionPostgres;
	
	
	public void agregarUsuario(Usuario dato) throws Exception{
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
	
	public Usuario obtenerUsuario(String username, String clave) throws Exception{		 
		    @SuppressWarnings("static-access")
			Session sesion = sesionPostgres.getSessionFactory().openSession();   
		    Usuario dato = null;        
	            try{
	                dato = (Usuario) sesion.createCriteria(Usuario.class)
	                		.add(Restrictions.eq("username",username))
	                		.add(Restrictions.eq("contrasenna", clave)).uniqueResult();
	            } catch (Exception e) {  
	            e.printStackTrace();
	           
	            throw new Exception(e.getMessage(),e.getCause());
	            }  finally {  
	                sesion.close();  
	            }       
		    return dato;
	}
	
	public Usuario obtenerUsuarioPersona(Persona datos)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    Usuario dato = null;        
            try{
                dato = (Usuario) sesion.createCriteria(Usuario.class)
                		.add(Restrictions.eq("persona", datos)).add(Restrictions.eq("activo", true)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return dato;
		
	}
	
	public void eliminarUsuario(Usuario dato) throws Exception{		 
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
	
	public void actualizarUsuario(Usuario dato) throws Exception{
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
	
	public List<Usuario> obtenerTodos() throws Exception {            
      
	   List<Usuario> datos = new ArrayList<Usuario>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Usuario>) em.createCriteria(Usuario.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
       
        return datos; 
	}	
}
