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
 * Home object for domain model class MiembroJunta.
 * @see modelos.MiembroJunta
 * @author Hibernate Tools
 */
public class MiembroJuntaHome {

	private static final Log log = LogFactory.getLog(MiembroJuntaHome.class);

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

	public void persist(MiembroJunta transientInstance) {
		log.debug("persisting MiembroJunta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MiembroJunta instance) {
		log.debug("attaching dirty MiembroJunta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MiembroJunta instance) {
		log.debug("attaching clean MiembroJunta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MiembroJunta persistentInstance) {
		log.debug("deleting MiembroJunta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MiembroJunta merge(MiembroJunta detachedInstance) {
		log.debug("merging MiembroJunta instance");
		try {
			MiembroJunta result = (MiembroJunta) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MiembroJunta findById(int id) {
		log.debug("getting MiembroJunta instance with id: " + id);
		try {
			MiembroJunta instance = (MiembroJunta) sessionFactory
					.getCurrentSession().get("modelos.MiembroJunta", id);
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

	public List<MiembroJunta> findByExample(MiembroJunta instance) {
		log.debug("finding MiembroJunta instance by example");
		try {
			List<MiembroJunta> results = (List<MiembroJunta>) sessionFactory
					.getCurrentSession().createCriteria("modelos.MiembroJunta")
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
