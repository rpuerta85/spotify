package es.miw.spotify.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;







import es.miw.spotify.models.daos.UserDao;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;


public class UserDaoJpa extends GenericDaoJpa<User, Integer> implements UserDao {
 
	private static final String ADMIN = "ADMIN";
	private static final String FIND_BY_FAVORITE_TYPE = "SELECT u.favorites FROM User u JOIN u.favorites f JOIN f.favoritetype ft where ft.id = :favoritetypeId and u.id = :userId";
	private static final String FIND__USER_IS_ADMIN_BY_ID = "SELECT u FROM User u JOIN u.userRoles r where r.role = :role and u.id = :userId";
	private static final String FIND__IS_FAVORITE_FROM_USER = "SELECT  f FROM  Favorite f JOIN User u  WHERE f =:favorite AND u.id= :userId";

	public UserDaoJpa() {
        super(User.class);
    }

	@Override
	public List<Favorite> getFavoriteByFavoriteType(FavoriteType favoriteType,
			Integer userId) { EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	        Query query = entityManager.createQuery(FIND_BY_FAVORITE_TYPE);
	        query.setParameter("favoritetypeId", favoriteType.getId());
	        query.setParameter("userId", userId);
//	        List<User> user =(List<User>) query.getResultList();
//	        List<Favorite> listaResultado =user.get(0).getFavorites();
	        List<Favorite> listaResultado = query.getResultList();
	        ArrayList<Favorite> resultado= new ArrayList<Favorite>();
	        for (Favorite favorite : listaResultado) {
				if(favorite.getFavoritetype().equals(favoriteType))
					resultado.add(favorite);
			}
	        entityManager.close();
	        return resultado;
	}

	@Override
	public boolean isAdminUser(Integer idUser) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(FIND__USER_IS_ADMIN_BY_ID);
        query.setParameter("role", ADMIN);
        query.setParameter("userId", idUser);
        List<User> listaResultado =(List<User>) query.getResultList();
        entityManager.close();
       
		return listaResultado.size()>=1;
	}

	@Override
	public boolean isFavoriteFromUser(Favorite favorite, Integer idUser) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(FIND__IS_FAVORITE_FROM_USER);
        query.setParameter("favorite", favorite);
        query.setParameter("userId", idUser);
        List<User> listaResultado =(List<User>) query.getResultList();
        entityManager.close();
       
	  return listaResultado.size()>=1;
	}

	

	

}
