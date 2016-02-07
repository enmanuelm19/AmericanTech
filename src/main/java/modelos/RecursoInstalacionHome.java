package modelos;

// Generated 07/02/2016 10:09:12 AM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RecursoInstalacion.
 * @see modelos.RecursoInstalacion
 * @author Hibernate Tools
 */
public class RecursoInstalacionHome {

	private static final Log log = LogFactory
			.getLog(RecursoInstalacionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RecursoInstalacion transientInstance) {
		log.debug("persisting RecursoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RecursoInstalacion instance) {
		log.debug("attaching dirty RecursoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RecursoInstalacion instance) {
		log.debug("attaching clean RecursoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RecursoInstalacion persistentInstance) {
		log.debug("deleting RecursoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RecursoInstalacion merge(RecursoInstalacion detachedInstance) {
		log.debug("merging RecursoInstalacion instance");
		try {
			RecursoInstalacion result = (RecursoInstalacion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RecursoInstalacion findById(int id) {
		log.debug("getting RecursoInstalacion instance with id: " + id);
		try {
			RecursoInstalacion instance = (RecursoInstalacion) sessionFactory
					.getCurrentSession().get("modelos.RecursoInstalacion", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<RecursoInstalacion> findByExample(RecursoInstalacion instance) {
		log.debug("finding RecursoInstalacion instance by example");
		try {
			List<RecursoInstalacion> results = (List<RecursoInstalacion>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.RecursoInstalacion")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
