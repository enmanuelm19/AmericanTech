//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Sancion;
import modelos.Socio;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zhtml.S;

import confi.Sesion;

public class SancionDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarSancion(Sancion dato) throws Exception{
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
	// Obtiene una lista con las Sanciones que sean del mismo tipo.
//	public List<Sancion> obtenerSancionesTipo(TipoSancion dato)throws Exception{
//	    @SuppressWarnings("static-access")
//		Session sesion = sesionPostgres.getSessionFactory().openSession();   
//	    List<Sancion> datos = new ArrayList<Sancion>();        
//            try{
//                datos = (List<Sancion>) sesion.createCriteria(Sancion.class)
//                		.add(Restrictions.eq("tipoSancion", dato)).add(Restrictions.eq("activo", true)).list();
//            } catch (Exception e) {  
//            e.printStackTrace();
//            throw new Exception(e.getMessage(),e.getCause());
//            }  finally {  
//                sesion.close();  
//            }       
//	    return datos;	
//	}
	//Obtiene una lista con todas las Sanciones que ha sufrido un socio
	public List<Sancion> obtenerSancionesSocio(Socio dato)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    List<Sancion> datos = new ArrayList<Sancion>();        
            try{
                datos = (List<Sancion>) sesion.createCriteria(Sancion.class)
                		.add(Restrictions.eq("socio",dato)).add(Restrictions.eq("activo",true)).list();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene una Sancion especifica
	public Sancion obtenerSancion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Sancion dato = null;        
            try{
                dato = (Sancion) sesion.get(Sancion.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina una Sancion en especifico
	public void eliminarSancion(Sancion dato) throws Exception{		 
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
	public void actualizarSancion(Sancion dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();   
         Transaction tx = null;  
         try {    
        	 tx = em.beginTransaction();
        	 Object find= em.merge(dato);
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
	
	//Obtiene una lista de todos los registros de la tabla Sancion
	public List<Sancion> obtenerTodos() throws Exception {            
      
	   List<Sancion> datos = new ArrayList<Sancion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Sancion>) em.createCriteria(Sancion.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
