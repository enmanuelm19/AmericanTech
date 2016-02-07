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
 * Home object for domain model class JuntaDirectiva.
 * @see modelos.JuntaDirectiva
 * @author Hibernate Tools
 */
public class JuntaDirectivaHome {

	private static final Log log = LogFactory.getLog(JuntaDirectivaHome.class);

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

	public void persist(JuntaDirectiva transientInstance) {
		log.debug("persisting JuntaDirectiva instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(JuntaDirectiva instance) {
		log.debug("attaching dirty JuntaDirectiva instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JuntaDirectiva instance) {
		log.debug("attaching clean JuntaDirectiva instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(JuntaDirectiva persistentInstance) {
		log.debug("deleting JuntaDirectiva instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JuntaDirectiva merge(JuntaDirectiva detachedInstance) {
		log.debug("merging JuntaDirectiva instance");
		try {
			JuntaDirectiva result = (JuntaDirectiva) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JuntaDirectiva findById(int id) {
		log.debug("getting JuntaDirectiva instance with id: " + id);
		try {
			JuntaDirectiva instance = (JuntaDirectiva) sessionFactory
					.getCurrentSession().get("modelos.JuntaDirectiva", id);
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

	public List<JuntaDirectiva> findByExample(JuntaDirectiva instance) {
		log.debug("finding JuntaDirectiva instance by example");
		try {
			List<JuntaDirectiva> results = (List<JuntaDirectiva>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.JuntaDirectiva")
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
