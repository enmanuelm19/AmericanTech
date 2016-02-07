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
 * Home object for domain model class ActividadInstalacion.
 * @see modelos.ActividadInstalacion
 * @author Hibernate Tools
 */
public class ActividadInstalacionHome {

	private static final Log log = LogFactory
			.getLog(ActividadInstalacionHome.class);

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

	public void persist(ActividadInstalacion transientInstance) {
		log.debug("persisting ActividadInstalacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ActividadInstalacion instance) {
		log.debug("attaching dirty ActividadInstalacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActividadInstalacion instance) {
		log.debug("attaching clean ActividadInstalacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ActividadInstalacion persistentInstance) {
		log.debug("deleting ActividadInstalacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActividadInstalacion merge(ActividadInstalacion detachedInstance) {
		log.debug("merging ActividadInstalacion instance");
		try {
			ActividadInstalacion result = (ActividadInstalacion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ActividadInstalacion findById(int id) {
		log.debug("getting ActividadInstalacion instance with id: " + id);
		try {
			ActividadInstalacion instance = (ActividadInstalacion) sessionFactory
					.getCurrentSession()
					.get("modelos.ActividadInstalacion", id);
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

	public List<ActividadInstalacion> findByExample(
			ActividadInstalacion instance) {
		log.debug("finding ActividadInstalacion instance by example");
		try {
			List<ActividadInstalacion> results = (List<ActividadInstalacion>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.ActividadInstalacion")
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
