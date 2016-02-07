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
 * Home object for domain model class ActividadEvento.
 * @see modelos.ActividadEvento
 * @author Hibernate Tools
 */
public class ActividadEventoHome {

	private static final Log log = LogFactory.getLog(ActividadEventoHome.class);

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

	public void persist(ActividadEvento transientInstance) {
		log.debug("persisting ActividadEvento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ActividadEvento instance) {
		log.debug("attaching dirty ActividadEvento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActividadEvento instance) {
		log.debug("attaching clean ActividadEvento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ActividadEvento persistentInstance) {
		log.debug("deleting ActividadEvento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActividadEvento merge(ActividadEvento detachedInstance) {
		log.debug("merging ActividadEvento instance");
		try {
			ActividadEvento result = (ActividadEvento) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ActividadEvento findById(int id) {
		log.debug("getting ActividadEvento instance with id: " + id);
		try {
			ActividadEvento instance = (ActividadEvento) sessionFactory
					.getCurrentSession().get("modelos.ActividadEvento", id);
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

	public List<ActividadEvento> findByExample(ActividadEvento instance) {
		log.debug("finding ActividadEvento instance by example");
		try {
			List<ActividadEvento> results = (List<ActividadEvento>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.ActividadEvento")
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
