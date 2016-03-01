package Dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import confi.Sesion;
import modelos.UnidadMedida;

public class UnidadMedidaDao {
private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarUnidadMedida(UnidadMedida dato) throws Exception{
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
	
	
	//Obtiene una UnidadMedida especifica
	public UnidadMedida obtenerUnidadMedida(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    UnidadMedida dato = null;        
            try{
                dato = (UnidadMedida) sesion.get(UnidadMedida.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Obtener una unidad de medida por el nombre
	public UnidadMedida obtenerUnidadNombre(String nombre) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    UnidadMedida dato = null;        
            try{
                dato = (UnidadMedida) sesion.createCriteria(UnidadMedida.class)
                		.add(Restrictions.eq("nombre", nombre)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	}
	
	//Elimina un UnidadMedida en especifico
	public void eliminarUnidadMedida(UnidadMedida dato) throws Exception{		 
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
	public void actualizarUnidadMedida(UnidadMedida dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla UnidadMedida
	public List<UnidadMedida> obtenerTodos() throws Exception {            
	   List<UnidadMedida> datos = new ArrayList<UnidadMedida>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<UnidadMedida>) em.createCriteria(UnidadMedida.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}
}
