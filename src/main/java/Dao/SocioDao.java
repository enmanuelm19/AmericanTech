//Creado por: Edward Rodriguez  17/02/2016
package Dao;

import java.util.ArrayList;
import java.util.List;

import modelos.Socio;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import confi.Sesion;

public class SocioDao {
	private Sesion sesionPostgres;
	
	// Agrega un registro a la tabla.
	public void agregarSocio(Socio dato) throws Exception{
		System.out.println("dsda cart-; "+dato.getNroCarnet());
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
	// Obtiene a un socio mediante su postulacion.
	public Socio obtenerSocioPostulacion(int idPostulacion)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    Socio datos = null;        
            try{
                datos = (Socio) sesion.createCriteria(Socio.class)
                		.add(Restrictions.eq("postulacionid_postulacion", idPostulacion)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene un socio mediante el id de persona al que esta relacionado
	public Socio obtenerSocioPersona(int idPersona)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    Socio datos = null;        
            try{
                datos = (Socio) sesion.createCriteria(Socio.class)
                		.add(Restrictions.eq("personaid_persona", idPersona)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
           
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene un socio mediante su numero de carnet
	public Socio obtenerSocioCarnet(String NroCarnet)throws Exception{
	    @SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();   
	    Socio datos = null;        
            try{
                datos = (Socio) sesion.createCriteria(Socio.class)
                		.add(Restrictions.eq("nro_carnet", NroCarnet)).uniqueResult();
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }       
	    return datos;	
	}
	
	//Obtiene un Socio especifico mediante su id
	public Socio obtenerSocio(int id) throws Exception{		 
	    @SuppressWarnings("static-access")
	    Session sesion = sesionPostgres.getSessionFactory().openSession(); 
	    Socio dato = null;        
            try{
                dato = (Socio) sesion.get(Socio.class,  id);
            } catch (Exception e) {  
            e.printStackTrace();
            throw new Exception(e.getMessage(),e.getCause());
            }  finally {  
                sesion.close();  
            }  
	    return dato;
	
	}
	
	//Elimina una Socio en especifico
	public void eliminarSocio(Socio dato) throws Exception{		 
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
	public void actualizarSocio(Socio dato) throws Exception{
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
	
	//Obtiene una lista de todos los registros de la tabla Socio
	public List<Socio> obtenerTodos() throws Exception {            
      
	   List<Socio> datos = new ArrayList<Socio>();  
	   Session em = sesionPostgres.getSessionFactory().openSession();   	
        try {  	
	    datos =  (List<Socio>) em.createCriteria(Socio.class).add(Restrictions.eq("activo", true)).list();             
        } catch (Exception e) {             
       
         throw new Exception(e.getMessage(),e.getCause());
        } finally {  
          em.close();  
        } 
        return datos; 
	}

}
