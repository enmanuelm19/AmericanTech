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
 * Home object for domain model class FuncionGrupo.
 * @see modelos.FuncionGrupo
 * @author Hibernate Tools
 */
public class FuncionGrupoHome {

	private static final Log log = LogFactory.getLog(FuncionGrupoHome.class);

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

	public void persist(FuncionGrupo transientInstance) {
		log.debug("persisting FuncionGrupo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FuncionGrupo instance) {
		log.debug("attaching dirty FuncionGrupo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FuncionGrupo instance) {
		log.debug("attaching clean FuncionGrupo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FuncionGrupo persistentInstance) {
		log.debug("deleting FuncionGrupo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FuncionGrupo merge(FuncionGrupo detachedInstance) {
		log.debug("merging FuncionGrupo instance");
		try {
			FuncionGrupo result = (FuncionGrupo) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FuncionGrupo findById(int id) {
		log.debug("getting FuncionGrupo instance with id: " + id);
		try {
			FuncionGrupo instance = (FuncionGrupo) sessionFactory
					.getCurrentSession().get("modelos.FuncionGrupo", id);
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

	public List<FuncionGrupo> findByExample(FuncionGrupo instance) {
		log.debug("finding FuncionGrupo instance by example");
		try {
			List<FuncionGrupo> results = (List<FuncionGrupo>) sessionFactory
					.getCurrentSession().createCriteria("modelos.FuncionGrupo")
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
