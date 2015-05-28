package es.miw.spotify.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;



import es.miw.spotify.models.daos.UserDao;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;


public class UserDaoJpa extends GenericDaoJpa<User, Integer> implements UserDao {
 
	 private static final String FIND_BY_FAVORITE_TYPE = "SELECT u FROM User u JOIN u.favorites f where f.favoritetype = :favoritetype and u.id = :userId";
	 private static final String FIND__USER_IS_ADMIN_BY_ID = "SELECT u FROM User u JOIN r.roles r where r.role.role = :role and u.id = :userId";

	public UserDaoJpa() {
        super(User.class);
    }

	@Override
	public List<Favorite> getFavoriteByFavoriteType(FavoriteType favoriteType,
			int userId) { EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	        Query query = entityManager.createQuery(FIND_BY_FAVORITE_TYPE);
	        query.setParameter("favoritetype", favoriteType);
	        query.setParameter("userId", userId);
	        List<Favorite> listaResultado =(List<Favorite>) query.getResultList();
	        entityManager.close();
	        return listaResultado;
	}

	@Override
	public boolean isAdminUser(int idUser) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(FIND__USER_IS_ADMIN_BY_ID);
        query.setParameter("role", "ADMIN");
        query.setParameter("userId", idUser);
        List<User> listaResultado =(List<User>) query.getResultList();
        entityManager.close();
       
		return listaResultado.size()>=1;
	}

}
