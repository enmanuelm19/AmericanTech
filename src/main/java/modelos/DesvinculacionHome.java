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
 * Home object for domain model class Desvinculacion.
 * @see modelos.Desvinculacion
 * @author Hibernate Tools
 */
public class DesvinculacionHome {

	private static final Log log = LogFactory.getLog(DesvinculacionHome.class);

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

	public void persist(Desvinculacion transientInstance) {
		log.debug("persisting Desvinculacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Desvinculacion instance) {
		log.debug("attaching dirty Desvinculacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Desvinculacion instance) {
		log.debug("attaching clean Desvinculacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Desvinculacion persistentInstance) {
		log.debug("deleting Desvinculacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Desvinculacion merge(Desvinculacion detachedInstance) {
		log.debug("merging Desvinculacion instance");
		try {
			Desvinculacion result = (Desvinculacion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Desvinculacion findById(int id) {
		log.debug("getting Desvinculacion instance with id: " + id);
		try {
			Desvinculacion instance = (Desvinculacion) sessionFactory
					.getCurrentSession().get("modelos.Desvinculacion", id);
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

	public List<Desvinculacion> findByExample(Desvinculacion instance) {
		log.debug("finding Desvinculacion instance by example");
		try {
			List<Desvinculacion> results = (List<Desvinculacion>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.Desvinculacion")
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