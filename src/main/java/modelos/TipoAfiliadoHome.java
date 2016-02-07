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
 * Home object for domain model class TipoAfiliado.
 * @see modelos.TipoAfiliado
 * @author Hibernate Tools
 */
public class TipoAfiliadoHome {

	private static final Log log = LogFactory.getLog(TipoAfiliadoHome.class);

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

	public void persist(TipoAfiliado transientInstance) {
		log.debug("persisting TipoAfiliado instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoAfiliado instance) {
		log.debug("attaching dirty TipoAfiliado instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoAfiliado instance) {
		log.debug("attaching clean TipoAfiliado instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TipoAfiliado persistentInstance) {
		log.debug("deleting TipoAfiliado instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoAfiliado merge(TipoAfiliado detachedInstance) {
		log.debug("merging TipoAfiliado instance");
		try {
			TipoAfiliado result = (TipoAfiliado) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoAfiliado findById(int id) {
		log.debug("getting TipoAfiliado instance with id: " + id);
		try {
			TipoAfiliado instance = (TipoAfiliado) sessionFactory
					.getCurrentSession().get("modelos.TipoAfiliado", id);
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

	public List<TipoAfiliado> findByExample(TipoAfiliado instance) {
		log.debug("finding TipoAfiliado instance by example");
		try {
			List<TipoAfiliado> results = (List<TipoAfiliado>) sessionFactory
					.getCurrentSession().createCriteria("modelos.TipoAfiliado")
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
