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
 * Home object for domain model class CalendarioHora.
 * @see modelos.CalendarioHora
 * @author Hibernate Tools
 */
public class CalendarioHoraHome {

	private static final Log log = LogFactory.getLog(CalendarioHoraHome.class);

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

	public void persist(CalendarioHora transientInstance) {
		log.debug("persisting CalendarioHora instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CalendarioHora instance) {
		log.debug("attaching dirty CalendarioHora instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CalendarioHora instance) {
		log.debug("attaching clean CalendarioHora instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CalendarioHora persistentInstance) {
		log.debug("deleting CalendarioHora instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CalendarioHora merge(CalendarioHora detachedInstance) {
		log.debug("merging CalendarioHora instance");
		try {
			CalendarioHora result = (CalendarioHora) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CalendarioHora findById(int id) {
		log.debug("getting CalendarioHora instance with id: " + id);
		try {
			CalendarioHora instance = (CalendarioHora) sessionFactory
					.getCurrentSession().get("modelos.CalendarioHora", id);
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

	public List<CalendarioHora> findByExample(CalendarioHora instance) {
		log.debug("finding CalendarioHora instance by example");
		try {
			List<CalendarioHora> results = (List<CalendarioHora>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.CalendarioHora")
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
