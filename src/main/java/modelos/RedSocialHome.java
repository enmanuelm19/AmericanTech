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
 * Home object for domain model class RedSocial.
 * @see modelos.RedSocial
 * @author Hibernate Tools
 */
public class RedSocialHome {

	private static final Log log = LogFactory.getLog(RedSocialHome.class);

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

	public void persist(RedSocial transientInstance) {
		log.debug("persisting RedSocial instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RedSocial instance) {
		log.debug("attaching dirty RedSocial instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RedSocial instance) {
		log.debug("attaching clean RedSocial instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RedSocial persistentInstance) {
		log.debug("deleting RedSocial instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RedSocial merge(RedSocial detachedInstance) {
		log.debug("merging RedSocial instance");
		try {
			RedSocial result = (RedSocial) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RedSocial findById(int id) {
		log.debug("getting RedSocial instance with id: " + id);
		try {
			RedSocial instance = (RedSocial) sessionFactory.getCurrentSession()
					.get("modelos.RedSocial", id);
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

	public List<RedSocial> findByExample(RedSocial instance) {
		log.debug("finding RedSocial instance by example");
		try {
			List<RedSocial> results = (List<RedSocial>) sessionFactory
					.getCurrentSession().createCriteria("modelos.RedSocial")
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