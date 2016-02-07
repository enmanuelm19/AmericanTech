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
 * Home object for domain model class VisitaEvento.
 * @see modelos.VisitaEvento
 * @author Hibernate Tools
 */
public class VisitaEventoHome {

	private static final Log log = LogFactory.getLog(VisitaEventoHome.class);

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

	public void persist(VisitaEvento transientInstance) {
		log.debug("persisting VisitaEvento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VisitaEvento instance) {
		log.debug("attaching dirty VisitaEvento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VisitaEvento instance) {
		log.debug("attaching clean VisitaEvento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VisitaEvento persistentInstance) {
		log.debug("deleting VisitaEvento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VisitaEvento merge(VisitaEvento detachedInstance) {
		log.debug("merging VisitaEvento instance");
		try {
			VisitaEvento result = (VisitaEvento) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VisitaEvento findById(int id) {
		log.debug("getting VisitaEvento instance with id: " + id);
		try {
			VisitaEvento instance = (VisitaEvento) sessionFactory
					.getCurrentSession().get("modelos.VisitaEvento", id);
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

	public List<VisitaEvento> findByExample(VisitaEvento instance) {
		log.debug("finding VisitaEvento instance by example");
		try {
			List<VisitaEvento> results = (List<VisitaEvento>) sessionFactory
					.getCurrentSession().createCriteria("modelos.VisitaEvento")
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
