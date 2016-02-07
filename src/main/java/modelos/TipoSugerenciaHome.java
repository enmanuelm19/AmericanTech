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
 * Home object for domain model class TipoSugerencia.
 * @see modelos.TipoSugerencia
 * @author Hibernate Tools
 */
public class TipoSugerenciaHome {

	private static final Log log = LogFactory.getLog(TipoSugerenciaHome.class);

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

	public void persist(TipoSugerencia transientInstance) {
		log.debug("persisting TipoSugerencia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoSugerencia instance) {
		log.debug("attaching dirty TipoSugerencia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoSugerencia instance) {
		log.debug("attaching clean TipoSugerencia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TipoSugerencia persistentInstance) {
		log.debug("deleting TipoSugerencia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoSugerencia merge(TipoSugerencia detachedInstance) {
		log.debug("merging TipoSugerencia instance");
		try {
			TipoSugerencia result = (TipoSugerencia) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoSugerencia findById(int id) {
		log.debug("getting TipoSugerencia instance with id: " + id);
		try {
			TipoSugerencia instance = (TipoSugerencia) sessionFactory
					.getCurrentSession().get("modelos.TipoSugerencia", id);
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

	public List<TipoSugerencia> findByExample(TipoSugerencia instance) {
		log.debug("finding TipoSugerencia instance by example");
		try {
			List<TipoSugerencia> results = (List<TipoSugerencia>) sessionFactory
					.getCurrentSession()
					.createCriteria("modelos.TipoSugerencia")
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
