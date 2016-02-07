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
 * Home object for domain model class MotivoPostulacion.
 * @see modelos.MotivoPostulacion
 * @author Hibernate Tools
 */
public class MotivoPostulacionHome {

	private static final Log log = LogFactory
			.getLog(MotivoPostulacionHome.class);

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

	public void persist(MotivoPostulacion transientInstance) {
		log.debug("persisting MotivoPostulacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MotivoPostulacion instance) {
		log.debug("attaching dirty MotivoPostulacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MotivoPostulacion instance) {
		log.debug("attaching clean MotivoPostulacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MotivoPostulacion persistentInstance) {
		log.debug("deleting MotivoPostulacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MotivoPostulacion merge(MotivoPostulacion detachedInstance) {
		log.debug("merging MotivoPostulacion instance");
		try {
			MotivoPostulacion result = (MotivoPostulacion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MotivoPostulacion findById(int id) {
		log.debug("getting MotivoPostulacion instance with id: " + id);
		try {
			MotivoPostulacion instance = (MotivoPostulacion) sessionFactory
					.getCurrentSession().get("modelos.MotivoPostulacion", id);
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

	public List<MotivoPostulacion> findByExample(MotivoPostulacion instance) {
		log.debug("finding MotivoPostulacion instance by example");
		try {
			List<MotivoPostulacion> results = (List<MotivoPostulacion>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.MotivoPostulacion")
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
