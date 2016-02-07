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
 * Home object for domain model class PartocinanteEvento.
 * @see modelos.PartocinanteEvento
 * @author Hibernate Tools
 */
public class PartocinanteEventoHome {

	private static final Log log = LogFactory
			.getLog(PartocinanteEventoHome.class);

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

	public void persist(PartocinanteEvento transientInstance) {
		log.debug("persisting PartocinanteEvento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PartocinanteEvento instance) {
		log.debug("attaching dirty PartocinanteEvento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PartocinanteEvento instance) {
		log.debug("attaching clean PartocinanteEvento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PartocinanteEvento persistentInstance) {
		log.debug("deleting PartocinanteEvento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PartocinanteEvento merge(PartocinanteEvento detachedInstance) {
		log.debug("merging PartocinanteEvento instance");
		try {
			PartocinanteEvento result = (PartocinanteEvento) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PartocinanteEvento findById(int id) {
		log.debug("getting PartocinanteEvento instance with id: " + id);
		try {
			PartocinanteEvento instance = (PartocinanteEvento) sessionFactory
					.getCurrentSession().get("modelos.PartocinanteEvento", id);
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

	public List<PartocinanteEvento> findByExample(PartocinanteEvento instance) {
		log.debug("finding PartocinanteEvento instance by example");
		try {
			List<PartocinanteEvento> results = (List<PartocinanteEvento>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.PartocinanteEvento")
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
