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
 * Home object for domain model class NoticiaPreferencia.
 * @see modelos.NoticiaPreferencia
 * @author Hibernate Tools
 */
public class NoticiaPreferenciaHome {

	private static final Log log = LogFactory
			.getLog(NoticiaPreferenciaHome.class);

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

	public void persist(NoticiaPreferencia transientInstance) {
		log.debug("persisting NoticiaPreferencia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(NoticiaPreferencia instance) {
		log.debug("attaching dirty NoticiaPreferencia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NoticiaPreferencia instance) {
		log.debug("attaching clean NoticiaPreferencia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(NoticiaPreferencia persistentInstance) {
		log.debug("deleting NoticiaPreferencia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NoticiaPreferencia merge(NoticiaPreferencia detachedInstance) {
		log.debug("merging NoticiaPreferencia instance");
		try {
			NoticiaPreferencia result = (NoticiaPreferencia) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public NoticiaPreferencia findById(int id) {
		log.debug("getting NoticiaPreferencia instance with id: " + id);
		try {
			NoticiaPreferencia instance = (NoticiaPreferencia) sessionFactory
					.getCurrentSession().get("modelos.NoticiaPreferencia", id);
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

	public List<NoticiaPreferencia> findByExample(NoticiaPreferencia instance) {
		log.debug("finding NoticiaPreferencia instance by example");
		try {
			List<NoticiaPreferencia> results = (List<NoticiaPreferencia>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.NoticiaPreferencia")
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
