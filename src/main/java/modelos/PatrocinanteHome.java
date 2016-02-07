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
 * Home object for domain model class Patrocinante.
 * @see modelos.Patrocinante
 * @author Hibernate Tools
 */
public class PatrocinanteHome {

	private static final Log log = LogFactory.getLog(PatrocinanteHome.class);

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

	public void persist(Patrocinante transientInstance) {
		log.debug("persisting Patrocinante instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Patrocinante instance) {
		log.debug("attaching dirty Patrocinante instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Patrocinante instance) {
		log.debug("attaching clean Patrocinante instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Patrocinante persistentInstance) {
		log.debug("deleting Patrocinante instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Patrocinante merge(Patrocinante detachedInstance) {
		log.debug("merging Patrocinante instance");
		try {
			Patrocinante result = (Patrocinante) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Patrocinante findById(int id) {
		log.debug("getting Patrocinante instance with id: " + id);
		try {
			Patrocinante instance = (Patrocinante) sessionFactory
					.getCurrentSession().get("modelos.Patrocinante", id);
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

	public List<Patrocinante> findByExample(Patrocinante instance) {
		log.debug("finding Patrocinante instance by example");
		try {
			List<Patrocinante> results = (List<Patrocinante>) sessionFactory
					.getCurrentSession().createCriteria("modelos.Patrocinante")
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
