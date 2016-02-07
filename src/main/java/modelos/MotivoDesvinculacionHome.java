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
 * Home object for domain model class MotivoDesvinculacion.
 * @see modelos.MotivoDesvinculacion
 * @author Hibernate Tools
 */
public class MotivoDesvinculacionHome {

	private static final Log log = LogFactory
			.getLog(MotivoDesvinculacionHome.class);

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

	public void persist(MotivoDesvinculacion transientInstance) {
		log.debug("persisting MotivoDesvinculacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MotivoDesvinculacion instance) {
		log.debug("attaching dirty MotivoDesvinculacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MotivoDesvinculacion instance) {
		log.debug("attaching clean MotivoDesvinculacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MotivoDesvinculacion persistentInstance) {
		log.debug("deleting MotivoDesvinculacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MotivoDesvinculacion merge(MotivoDesvinculacion detachedInstance) {
		log.debug("merging MotivoDesvinculacion instance");
		try {
			MotivoDesvinculacion result = (MotivoDesvinculacion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MotivoDesvinculacion findById(int id) {
		log.debug("getting MotivoDesvinculacion instance with id: " + id);
		try {
			MotivoDesvinculacion instance = (MotivoDesvinculacion) sessionFactory
					.getCurrentSession()
					.get("modelos.MotivoDesvinculacion", id);
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

	public List<MotivoDesvinculacion> findByExample(
			MotivoDesvinculacion instance) {
		log.debug("finding MotivoDesvinculacion instance by example");
		try {
			List<MotivoDesvinculacion> results = (List<MotivoDesvinculacion>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.MotivoDesvinculacion")
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
