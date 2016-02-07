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
 * Home object for domain model class TipoInstalacion.
 * @see modelos.TipoInstalacion
 * @author Hibernate Tools
 */
public class TipoInstalacionHome {

	private static final Log log = LogFactory.getLog(TipoInstalacionHome.class);

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

	public void persist(TipoInstalacion transientInstance) {
		log.debug("persisting TipoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoInstalacion instance) {
		log.debug("attaching dirty TipoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoInstalacion instance) {
		log.debug("attaching clean TipoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TipoInstalacion persistentInstance) {
		log.debug("deleting TipoInstalacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoInstalacion merge(TipoInstalacion detachedInstance) {
		log.debug("merging TipoInstalacion instance");
		try {
			TipoInstalacion result = (TipoInstalacion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoInstalacion findById(int id) {
		log.debug("getting TipoInstalacion instance with id: " + id);
		try {
			TipoInstalacion instance = (TipoInstalacion) sessionFactory
					.getCurrentSession().get("modelos.TipoInstalacion", id);
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

	public List<TipoInstalacion> findByExample(TipoInstalacion instance) {
		log.debug("finding TipoInstalacion instance by example");
		try {
			List<TipoInstalacion> results = (List<TipoInstalacion>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.TipoInstalacion")
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
