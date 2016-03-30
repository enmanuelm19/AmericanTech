package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MotivoSancion;
import modelos.MotivoSancion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class MotivoSancionDao {

	private Sesion sesionPostgres;

	public void agregarMotivoSancion(MotivoSancion dato) throws Exception {
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = em.beginTransaction();
			em.save(dato);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	public MotivoSancion obtenerMotivoSancion(int id) throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoSancion dato = null;
		try {
			dato = (MotivoSancion) sesion.get(MotivoSancion.class, id);
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sesion.close();
		}

		return dato;
	}

	public MotivoSancion obtenerMotivoSancion(String descrip) throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoSancion dato = null;
		try {
			dato = (MotivoSancion) sesion.createCriteria(MotivoSancion.class)
					.add(Restrictions.eq("descripcion", descrip))
					.add(Restrictions.eq("activo", true))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sesion.close();
		}
		return dato;
	}

	public void eliminarMotivoSancion(MotivoSancion dato) throws Exception {
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

	public void actualizarMotivoSancion(MotivoSancion dato) throws Exception {
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

	public List<MotivoSancion> obtenerTodos() throws Exception {

		List<MotivoSancion> datos = new ArrayList<MotivoSancion>();
		Session em = sesionPostgres.getSessionFactory().openSession();
		try {
			datos = (List<MotivoSancion>) em
					.createCriteria(MotivoSancion.class)
					.add(Restrictions.eq("activo", true)).list();
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			em.close();
		}

		return datos;
	}

}
