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
 * Home object for domain model class UsuarioGrupo.
 * @see modelos.UsuarioGrupo
 * @author Hibernate Tools
 */
public class UsuarioGrupoHome {

	private static final Log log = LogFactory.getLog(UsuarioGrupoHome.class);

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

	public void persist(UsuarioGrupo transientInstance) {
		log.debug("persisting UsuarioGrupo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UsuarioGrupo instance) {
		log.debug("attaching dirty UsuarioGrupo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UsuarioGrupo instance) {
		log.debug("attaching clean UsuarioGrupo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UsuarioGrupo persistentInstance) {
		log.debug("deleting UsuarioGrupo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UsuarioGrupo merge(UsuarioGrupo detachedInstance) {
		log.debug("merging UsuarioGrupo instance");
		try {
			UsuarioGrupo result = (UsuarioGrupo) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UsuarioGrupo findById(int id) {
		log.debug("getting UsuarioGrupo instance with id: " + id);
		try {
			UsuarioGrupo instance = (UsuarioGrupo) sessionFactory
					.getCurrentSession().get("modelos.UsuarioGrupo", id);
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

	public List<UsuarioGrupo> findByExample(UsuarioGrupo instance) {
		log.debug("finding UsuarioGrupo instance by example");
		try {
			List<UsuarioGrupo> results = (List<UsuarioGrupo>) sessionFactory
					.getCurrentSession().createCriteria("modelos.UsuarioGrupo")
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
