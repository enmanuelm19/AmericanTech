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
 * Home object for domain model class CalendarioFecha.
 * @see modelos.CalendarioFecha
 * @author Hibernate Tools
 */
public class CalendarioFechaHome {

	private static final Log log = LogFactory.getLog(CalendarioFechaHome.class);

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

	public void persist(CalendarioFecha transientInstance) {
		log.debug("persisting CalendarioFecha instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CalendarioFecha instance) {
		log.debug("attaching dirty CalendarioFecha instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CalendarioFecha instance) {
		log.debug("attaching clean CalendarioFecha instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CalendarioFecha persistentInstance) {
		log.debug("deleting CalendarioFecha instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CalendarioFecha merge(CalendarioFecha detachedInstance) {
		log.debug("merging CalendarioFecha instance");
		try {
			CalendarioFecha result = (CalendarioFecha) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CalendarioFecha findById(int id) {
		log.debug("getting CalendarioFecha instance with id: " + id);
		try {
			CalendarioFecha instance = (CalendarioFecha) sessionFactory
					.getCurrentSession().get("modelos.CalendarioFecha", id);
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

	public List<CalendarioFecha> findByExample(CalendarioFecha instance) {
		log.debug("finding CalendarioFecha instance by example");
		try {
			List<CalendarioFecha> results = (List<CalendarioFecha>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.CalendarioFecha")
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
