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
 * Home object for domain model class MotivoVenta.
 * @see modelos.MotivoVenta
 * @author Hibernate Tools
 */
public class MotivoVentaHome {

	private static final Log log = LogFactory.getLog(MotivoVentaHome.class);

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

	public void persist(MotivoVenta transientInstance) {
		log.debug("persisting MotivoVenta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MotivoVenta instance) {
		log.debug("attaching dirty MotivoVenta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MotivoVenta instance) {
		log.debug("attaching clean MotivoVenta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MotivoVenta persistentInstance) {
		log.debug("deleting MotivoVenta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MotivoVenta merge(MotivoVenta detachedInstance) {
		log.debug("merging MotivoVenta instance");
		try {
			MotivoVenta result = (MotivoVenta) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MotivoVenta findById(int id) {
		log.debug("getting MotivoVenta instance with id: " + id);
		try {
			MotivoVenta instance = (MotivoVenta) sessionFactory
					.getCurrentSession().get("modelos.MotivoVenta", id);
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

	public List<MotivoVenta> findByExample(MotivoVenta instance) {
		log.debug("finding MotivoVenta instance by example");
		try {
			List<MotivoVenta> results = (List<MotivoVenta>) sessionFactory
					.getCurrentSession().createCriteria("modelos.MotivoVenta")
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
