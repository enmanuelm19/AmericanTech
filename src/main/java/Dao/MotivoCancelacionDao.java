package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.Evento;
import modelos.MotivoCancelacion;
import modelos.MotivoCancelacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Tony Suarez
 */

public class MotivoCancelacionDao {

	private Sesion sesionPostgres;

	public void agregarMotivoCancelacion(MotivoCancelacion dato)
			throws Exception {
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

	public MotivoCancelacion obtenerMotivoCancelacion(int id)
			throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoCancelacion dato = null;
		try {
			dato = (MotivoCancelacion) sesion.get(
					MotivoCancelacion.class, id);
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sesion.close();
		}

		return dato;
	}

	public MotivoCancelacion obtenerMotivoCancelacion(String descrip)
			throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoCancelacion dato = null;
		try {
			dato = (MotivoCancelacion) sesion
					.createCriteria(MotivoCancelacion.class)
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

	public void eliminarMotivoCancelacion(MotivoCancelacion dato)
			throws Exception {
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

	public void actualizarMotivoCancelacion(MotivoCancelacion dato)
			throws Exception {
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

	public List<MotivoCancelacion> obtenerTodos() throws Exception {

		List<MotivoCancelacion> datos = new ArrayList<MotivoCancelacion>();
		Session em = sesionPostgres.getSessionFactory().openSession();
		try {
			datos = (List<MotivoCancelacion>) em
					.createCriteria(MotivoCancelacion.class)
					.add(Restrictions.eq("activo", true)).list();
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			em.close();
		}

		return datos;
	}

}
