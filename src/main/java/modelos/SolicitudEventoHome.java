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
 * Home object for domain model class SolicitudEvento.
 * @see modelos.SolicitudEvento
 * @author Hibernate Tools
 */
public class SolicitudEventoHome {

	private static final Log log = LogFactory.getLog(SolicitudEventoHome.class);

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

	public void persist(SolicitudEvento transientInstance) {
		log.debug("persisting SolicitudEvento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SolicitudEvento instance) {
		log.debug("attaching dirty SolicitudEvento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SolicitudEvento instance) {
		log.debug("attaching clean SolicitudEvento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SolicitudEvento persistentInstance) {
		log.debug("deleting SolicitudEvento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SolicitudEvento merge(SolicitudEvento detachedInstance) {
		log.debug("merging SolicitudEvento instance");
		try {
			SolicitudEvento result = (SolicitudEvento) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SolicitudEvento findById(int id) {
		log.debug("getting SolicitudEvento instance with id: " + id);
		try {
			SolicitudEvento instance = (SolicitudEvento) sessionFactory
					.getCurrentSession().get("modelos.SolicitudEvento", id);
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

	public List<SolicitudEvento> findByExample(SolicitudEvento instance) {
		log.debug("finding SolicitudEvento instance by example");
		try {
			List<SolicitudEvento> results = (List<SolicitudEvento>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.SolicitudEvento")
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
