package es.miw.spotify.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.miw.spotify.models.daos.DaoFactory;
import es.miw.spotify.models.daos.FavoriteDao;
import es.miw.spotify.models.daos.FavoriteTypeDao;
import es.miw.spotify.models.daos.UserDao;
import es.miw.spotify.models.daos.RoleDao;
@Component
public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "BBDD";

    /*@Autowired
    private EntityManagerFactory entityManagerFactory;*/
    private static EntityManagerFactory entityManagerFactory=null; 
 
    public DaoJpaFactory() {
    }
    
   //Este singleton ya no hace falta, ya que lo cargamos directamente desde el SpringConfiguration y por 
    //defecto ya es un singleton el Autowired
    
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
	public RoleDao getUserRoleDao() {
		return new RoleDaoJpa();
	}

	@Override
	public FavoriteTypeDao getFavoriteTypeDao() {
		return new FavoriteTypeDaoJpa();
	}

 

}
