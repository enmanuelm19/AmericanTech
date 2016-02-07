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
 * Home object for domain model class PreferenciaEvento.
 * @see modelos.PreferenciaEvento
 * @author Hibernate Tools
 */
public class PreferenciaEventoHome {

	private static final Log log = LogFactory
			.getLog(PreferenciaEventoHome.class);

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

	public void persist(PreferenciaEvento transientInstance) {
		log.debug("persisting PreferenciaEvento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PreferenciaEvento instance) {
		log.debug("attaching dirty PreferenciaEvento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PreferenciaEvento instance) {
		log.debug("attaching clean PreferenciaEvento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PreferenciaEvento persistentInstance) {
		log.debug("deleting PreferenciaEvento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PreferenciaEvento merge(PreferenciaEvento detachedInstance) {
		log.debug("merging PreferenciaEvento instance");
		try {
			PreferenciaEvento result = (PreferenciaEvento) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PreferenciaEvento findById(int id) {
		log.debug("getting PreferenciaEvento instance with id: " + id);
		try {
			PreferenciaEvento instance = (PreferenciaEvento) sessionFactory
					.getCurrentSession().get("modelos.PreferenciaEvento", id);
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

	public List<PreferenciaEvento> findByExample(PreferenciaEvento instance) {
		log.debug("finding PreferenciaEvento instance by example");
		try {
			List<PreferenciaEvento> results = (List<PreferenciaEvento>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.PreferenciaEvento")
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
