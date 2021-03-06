//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Grupo;
import modelos.Usuario;
import modelos.UsuarioGrupo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class UsuarioGrupoDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarUsuarioGrupo(UsuarioGrupo dato) throws Exception{
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
	// Obtiene los grupos al que pertenece un Usuario
	public List<UsuarioGrupo> obtenerGruposUsuario(Usuario dato)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<UsuarioGrupo> datos = new ArrayList<UsuarioGrupo>();        
            try{
                datos = (List<UsuarioGrupo>) sesion.createCriteria(UsuarioGrupo.class)
                		.add(Restrictions.eq("usuario",dato)).add(Restrictions.eq("activo",true)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	//Obtiene una lista con todos los Usuarios que pertenecen a un grupo especifico
	public List<UsuarioGrupo> obtenerUsuariosGrupo(Grupo datos)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<UsuarioGrupo> dato = new ArrayList<UsuarioGrupo>();        
            try{
                dato = (List<UsuarioGrupo>) sesion.createCriteria(UsuarioGrupo.class)
                		.add(Restrictions.eq("grupo",datos)).add(Restrictions.eq("activo",true)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return dato;	
	}
	
	//Obtiene Un UsuarioGrupo especifico.
	public UsuarioGrupo obtenerUsuarioGrupo(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    UsuarioGrupo dato = null;        
            try{
                dato = (UsuarioGrupo) sesion.get(UsuarioGrupo.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina un UsuarioGrupo en especifico
	public void eliminarUsuarioGrupo(UsuarioGrupo dato) throws Exception{		 
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
	
	//Actualiza un Registro
	public void actualizarUsuarioGrupo(UsuarioGrupo dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla UsuarioGrupo
	public List<UsuarioGrupo> obtenerTodos() throws Exception {            
      
	   List<UsuarioGrupo> datos = new ArrayList<UsuarioGrupo>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<UsuarioGrupo>) em.createCriteria(UsuarioGrupo.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}	
}
