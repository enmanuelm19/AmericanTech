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
 * Home object for domain model class InvitadoAlquiler.
 * @see modelos.InvitadoAlquiler
 * @author Hibernate Tools
 */
public class InvitadoAlquilerHome {

	private static final Log log = LogFactory
			.getLog(InvitadoAlquilerHome.class);

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

	public void persist(InvitadoAlquiler transientInstance) {
		log.debug("persisting InvitadoAlquiler instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InvitadoAlquiler instance) {
		log.debug("attaching dirty InvitadoAlquiler instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvitadoAlquiler instance) {
		log.debug("attaching clean InvitadoAlquiler instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InvitadoAlquiler persistentInstance) {
		log.debug("deleting InvitadoAlquiler instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvitadoAlquiler merge(InvitadoAlquiler detachedInstance) {
		log.debug("merging InvitadoAlquiler instance");
		try {
			InvitadoAlquiler result = (InvitadoAlquiler) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InvitadoAlquiler findById(int id) {
		log.debug("getting InvitadoAlquiler instance with id: " + id);
		try {
			InvitadoAlquiler instance = (InvitadoAlquiler) sessionFactory
					.getCurrentSession().get("modelos.InvitadoAlquiler", id);
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

	public List<InvitadoAlquiler> findByExample(InvitadoAlquiler instance) {
		log.debug("finding InvitadoAlquiler instance by example");
		try {
			List<InvitadoAlquiler> results = (List<InvitadoAlquiler>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.InvitadoAlquiler")
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
