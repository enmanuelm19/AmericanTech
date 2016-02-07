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
 * Home object for domain model class PreferenciaPersona.
 * @see modelos.PreferenciaPersona
 * @author Hibernate Tools
 */
public class PreferenciaPersonaHome {

	private static final Log log = LogFactory
			.getLog(PreferenciaPersonaHome.class);

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

	public void persist(PreferenciaPersona transientInstance) {
		log.debug("persisting PreferenciaPersona instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PreferenciaPersona instance) {
		log.debug("attaching dirty PreferenciaPersona instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PreferenciaPersona instance) {
		log.debug("attaching clean PreferenciaPersona instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PreferenciaPersona persistentInstance) {
		log.debug("deleting PreferenciaPersona instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PreferenciaPersona merge(PreferenciaPersona detachedInstance) {
		log.debug("merging PreferenciaPersona instance");
		try {
			PreferenciaPersona result = (PreferenciaPersona) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PreferenciaPersona findById(int id) {
		log.debug("getting PreferenciaPersona instance with id: " + id);
		try {
			PreferenciaPersona instance = (PreferenciaPersona) sessionFactory
					.getCurrentSession().get("modelos.PreferenciaPersona", id);
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

	public List<PreferenciaPersona> findByExample(PreferenciaPersona instance) {
		log.debug("finding PreferenciaPersona instance by example");
		try {
			List<PreferenciaPersona> results = (List<PreferenciaPersona>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.PreferenciaPersona")
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
