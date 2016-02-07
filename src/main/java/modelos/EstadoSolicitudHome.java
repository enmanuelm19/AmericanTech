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
 * Home object for domain model class EstadoSolicitud.
 * @see modelos.EstadoSolicitud
 * @author Hibernate Tools
 */
public class EstadoSolicitudHome {

	private static final Log log = LogFactory.getLog(EstadoSolicitudHome.class);

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

	public void persist(EstadoSolicitud transientInstance) {
		log.debug("persisting EstadoSolicitud instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EstadoSolicitud instance) {
		log.debug("attaching dirty EstadoSolicitud instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EstadoSolicitud instance) {
		log.debug("attaching clean EstadoSolicitud instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EstadoSolicitud persistentInstance) {
		log.debug("deleting EstadoSolicitud instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EstadoSolicitud merge(EstadoSolicitud detachedInstance) {
		log.debug("merging EstadoSolicitud instance");
		try {
			EstadoSolicitud result = (EstadoSolicitud) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstadoSolicitud findById(int id) {
		log.debug("getting EstadoSolicitud instance with id: " + id);
		try {
			EstadoSolicitud instance = (EstadoSolicitud) sessionFactory
					.getCurrentSession().get("modelos.EstadoSolicitud", id);
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

	public List<EstadoSolicitud> findByExample(EstadoSolicitud instance) {
		log.debug("finding EstadoSolicitud instance by example");
		try {
			List<EstadoSolicitud> results = (List<EstadoSolicitud>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.EstadoSolicitud")
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
