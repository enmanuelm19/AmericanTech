package Dao;

import java.util.List;
import java.util.ArrayList;

import modelos.MotivoVenta;
import modelos.MotivoVenta;
import confi.Sesion;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * creado por Rosmary Fuentes
 */

public class MotivoVentaDao {

	private Sesion sesionPostgres;

	public void agregarMotivoVenta(MotivoVenta dato) throws Exception {
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

	public MotivoVenta obtenerMotivoVenta(int id) throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoVenta dato = null;
		try {
			dato = (MotivoVenta) sesion.get(MotivoVenta.class, id);
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sesion.close();
		}

		return dato;
	}

	public MotivoVenta obtenerMotivoVenta(String descrip) throws Exception {
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.getSessionFactory().openSession();
		MotivoVenta dato = null;
		try {
			dato = (MotivoVenta) sesion.createCriteria(MotivoVenta.class)
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

	public void eliminarMotivoVenta(MotivoVenta dato) throws Exception {
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

	public void actualizarMotivoVenta(MotivoVenta dato) throws Exception {
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

	public List<MotivoVenta> obtenerTodos() throws Exception {

		List<MotivoVenta> datos = new ArrayList<MotivoVenta>();
		Session em = sesionPostgres.getSessionFactory().openSession();
		try {
			datos = (List<MotivoVenta>) em.createCriteria(MotivoVenta.class)
					.add(Restrictions.eq("activo", true)).list();
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			em.close();
		}

		return datos;
	}

}
