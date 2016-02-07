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
 * Home object for domain model class TipoPreferencia.
 * @see modelos.TipoPreferencia
 * @author Hibernate Tools
 */
public class TipoPreferenciaHome {

	private static final Log log = LogFactory.getLog(TipoPreferenciaHome.class);

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

	public void persist(TipoPreferencia transientInstance) {
		log.debug("persisting TipoPreferencia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoPreferencia instance) {
		log.debug("attaching dirty TipoPreferencia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoPreferencia instance) {
		log.debug("attaching clean TipoPreferencia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TipoPreferencia persistentInstance) {
		log.debug("deleting TipoPreferencia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoPreferencia merge(TipoPreferencia detachedInstance) {
		log.debug("merging TipoPreferencia instance");
		try {
			TipoPreferencia result = (TipoPreferencia) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoPreferencia findById(int id) {
		log.debug("getting TipoPreferencia instance with id: " + id);
		try {
			TipoPreferencia instance = (TipoPreferencia) sessionFactory
					.getCurrentSession().get("modelos.TipoPreferencia", id);
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

	public List<TipoPreferencia> findByExample(TipoPreferencia instance) {
		log.debug("finding TipoPreferencia instance by example");
		try {
			List<TipoPreferencia> results = (List<TipoPreferencia>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.TipoPreferencia")
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
