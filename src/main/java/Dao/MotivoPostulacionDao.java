package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MotivoPostulacion;
import modelos.MotivoPostulacion;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class MotivoPostulacionDao {

	private Sesion sesionPostgres;

	public void agregarMotivoPostulacion(MotivoPostulacion dato)
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

	public MotivoPostulacion obtenerMotivoPostulacion(int id) throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoPostulacion dato = null;
		try {
			dato = (MotivoPostulacion) sesion.get(MotivoPostulacion.class, id);
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sesion.close();
		}

		return dato;
	}

	public MotivoPostulacion obtenerMotivoPostulacion(String descrip)
			throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoPostulacion dato = null;
		try {
			dato = (MotivoPostulacion) sesion
					.createCriteria(MotivoPostulacion.class)
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

	public void eliminarMotivoPostulacion(MotivoPostulacion dato)
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

	public void actualizarMotivoPostulacion(MotivoPostulacion dato)
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

	public List<MotivoPostulacion> obtenerTodos() throws Exception {

		List<MotivoPostulacion> datos = new ArrayList<MotivoPostulacion>();
		Session em = sesionPostgres.getSessionFactory().openSession();
		try {
			datos = (List<MotivoPostulacion>) em
					.createCriteria(MotivoPostulacion.class)
					.add(Restrictions.eq("activo", true)).list();
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			em.close();
		}

		return datos;
	}

}
