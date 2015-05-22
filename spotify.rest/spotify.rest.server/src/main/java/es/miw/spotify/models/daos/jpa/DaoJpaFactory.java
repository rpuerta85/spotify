package es.miw.spotify.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.miw.spotify.models.daos.DaoFactory;
import es.miw.spotify.models.daos.FavoriteDao;
import es.miw.spotify.models.daos.FavoriteTypeDao;
import es.miw.spotify.models.daos.UserDao;
import es.miw.spotify.models.daos.UserRoleDao;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "BBDD";

    private static EntityManagerFactory entityManagerFactory=null; 

    public DaoJpaFactory() {
    }
    
   
	public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
        
        }
        return entityManagerFactory;
    }

    public static void prepareFactoryWithDropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

	@Override
	public FavoriteDao getFavoriteDao() {
		return new FavoriteDaoJpa();
	}

	@Override
	public UserDao getUserDao() {
		return new UserDaoJpa();
	}

	@Override
	public UserRoleDao getUserRoleDao() {
	   return new UserRoleDaoJpa();
	}

	@Override
	public FavoriteTypeDao getFavoriteTypeDao() {
		return new FavoriteTypeDaoJpa();
	}

 

}
