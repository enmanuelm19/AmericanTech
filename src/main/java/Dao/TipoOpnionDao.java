package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Opinion;
import modelos.Postulacion;
import modelos.TipoOpnion;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class TipoOpnionDao {

private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarTipoOpnion(TipoOpnion dato) throws Exception{
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
	
	
	//Obtiene un TipoAfiliado especifico
	public TipoOpnion obtenerTipoOpion(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoOpnion dato = null;        
            try{
                dato = (TipoOpnion) sesion.get(TipoOpnion.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Obtener un tipo de afiliado mediante la descripcion
	public TipoOpnion obtenerTipoDescripcion(String descrip) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    TipoOpnion dato = null;        
            try{
                dato = (TipoOpnion) sesion.createCriteria(TipoOpnion.class)
                		.add(Restrictions.eq("descripcion", descrip)).add(Restrictions.eq("activo", null)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Elimina un TipoAfiliado en especifico
	public void eliminarTipoOpnion(TipoOpnion dato) throws Exception{		 
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
	public void actualizarTipoOpnion(TipoOpnion dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla TipoAfiliado
	public List<TipoOpnion> obtenerTodos() throws Exception {            
      
	   List<TipoOpnion> datos = new ArrayList<TipoOpnion>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<TipoOpnion>) em.createCriteria(TipoOpnion.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}
	
}

