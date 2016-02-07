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
 * Home object for domain model class ClienteExterno.
 * @see modelos.ClienteExterno
 * @author Hibernate Tools
 */
public class ClienteExternoHome {

	private static final Log log = LogFactory.getLog(ClienteExternoHome.class);

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

	public void persist(ClienteExterno transientInstance) {
		log.debug("persisting ClienteExterno instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ClienteExterno instance) {
		log.debug("attaching dirty ClienteExterno instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClienteExterno instance) {
		log.debug("attaching clean ClienteExterno instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ClienteExterno persistentInstance) {
		log.debug("deleting ClienteExterno instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClienteExterno merge(ClienteExterno detachedInstance) {
		log.debug("merging ClienteExterno instance");
		try {
			ClienteExterno result = (ClienteExterno) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ClienteExterno findById(int id) {
		log.debug("getting ClienteExterno instance with id: " + id);
		try {
			ClienteExterno instance = (ClienteExterno) sessionFactory
					.getCurrentSession().get("modelos.ClienteExterno", id);
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

	public List<ClienteExterno> findByExample(ClienteExterno instance) {
		log.debug("finding ClienteExterno instance by example");
		try {
			List<ClienteExterno> results = (List<ClienteExterno>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.ClienteExterno")
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
