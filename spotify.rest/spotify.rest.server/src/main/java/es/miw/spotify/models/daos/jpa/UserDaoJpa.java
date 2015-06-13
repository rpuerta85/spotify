package es.miw.spotify.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.miw.spotify.models.daos.UserDao;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;
@Component
public class UserDaoJpa extends GenericDaoJpa<User, Integer> implements UserDao {
 
	private static final String TRACK = "TRACK";
	private static final String ARTIST = "ARTIST";
	private static final String ALBUM = "ALBUM";
	private static final String ADMIN = "ADMIN";
	private static final String FIND_BY_FAVORITE_TYPE = "SELECT u.favorites FROM User u JOIN u.favorites f JOIN f.favoritetype ft where ft.id = :favoritetypeId and u.id = :userId";
	private static final String FIND__USER_IS_ADMIN_BY_ID = "SELECT u FROM User u JOIN u.userRoles r where r.role = :role and u.id = :userId";
	private static final String FIND__USER_BY_USERNAME = "SELECT u FROM User u  where u.userName= :userName";
	private static final String FIND__IS_FAVORITE_FROM_USER = "SELECT  u.favorites FROM User u JOIN u.favorites f WHERE f.idFavorite =:idFavorite AND u.id= :userId";
	private static final String FIND__USER_BY_USERNAME_AND_PASSWORD = "SELECT u FROM User u JOIN u.userRoles r  where  u.userName= :userName and u.password= :password";
	private static final String FIND_FAVORITE_TYPE = "SELECT ft FROM FavoriteType ft  where ft.description= :description";
	// SELECT t FROM TemaEntity t JOIN t.votos v where v.ip = :ip and t.id = :idTema
	//private static final String FIND__IS_FAVORITE_FROM_USER = "SELECT  f FROM  Favorite f JOIN User u  WHERE f.idFavorite =:idFavorite AND u.id= :userId";
	  
	public UserDaoJpa() {
        super(User.class);
    }
	
	private List<Favorite> getFavoriteByFavoriteType(FavoriteType favoriteType,
			Integer userId) { 
	        Query query = entityManager.createQuery(FIND_BY_FAVORITE_TYPE);
	        query.setParameter("favoritetypeId", favoriteType.getId());
	        query.setParameter("userId", userId);
	        List<Favorite> listaResultado = query.getResultList();
	        ArrayList<Favorite> resultado= new ArrayList<Favorite>();
	        for (Favorite favorite : listaResultado) {
				if(favorite.getFavoritetype().equals(favoriteType))
					resultado.add(favorite);
			}
	       // entityManager.close();
	        return resultado;
	}
	@Override
	public List<Favorite> getFavoritesAlbums(Integer userId) { 
	        Query query = entityManager.createQuery(FIND_FAVORITE_TYPE);
	        query.setParameter("description", ALBUM);
	        FavoriteType favoriteType = (FavoriteType) query.getSingleResult();
	        //entityManager.close();
	        return getFavoriteByFavoriteType(favoriteType, userId);
	}
	@Override
	public List<Favorite> getFavoritesArtists(Integer userId) { 
        Query query = entityManager.createQuery(FIND_FAVORITE_TYPE);
        query.setParameter("description", ARTIST);
        FavoriteType favoriteType = (FavoriteType) query.getSingleResult();
        //entityManager.close();
        return getFavoriteByFavoriteType(favoriteType, userId);
}
	@Override
	public List<Favorite> getFavoritesTracks(Integer userId) { 
        Query query = entityManager.createQuery(FIND_FAVORITE_TYPE);
        query.setParameter("description", TRACK);
        FavoriteType favoriteType = (FavoriteType) query.getSingleResult();
        //entityManager.close();
        return getFavoriteByFavoriteType(favoriteType, userId);
}

	@Override
	public boolean isAdminUser(Integer idUser) {
        Query query = entityManager.createQuery(FIND__USER_IS_ADMIN_BY_ID);
        query.setParameter("role", ADMIN);
        query.setParameter("userId", idUser);
        List<User> listaResultado =(List<User>) query.getResultList();
       // entityManager.close();
       
		return listaResultado.size()>=1;
	}

	@Override
	public boolean isFavoriteFromUser(String favoriteId, Integer idUser) {
        Query query = entityManager.createQuery(FIND__IS_FAVORITE_FROM_USER);
        query.setParameter("idFavorite", favoriteId);
        query.setParameter("userId", idUser);
        List<Favorite> listaResultado =(List<Favorite>) query.getResultList();
        ArrayList<Favorite> resultado= new ArrayList<Favorite>();
        for (Favorite favorite : listaResultado) {
			if(favorite.getIdFavorite().equals(favoriteId))
				return true;
		}
        //entityManager.close();
       
	  return false;
	}


	@Override
	public Favorite getFavoriteFromUser(String favoriteId, Integer idUser) {
        Query query = entityManager.createQuery(FIND__IS_FAVORITE_FROM_USER);
        query.setParameter("idFavorite", favoriteId);
        query.setParameter("userId", idUser);
        List<Favorite> listaResultado =(List<Favorite>) query.getResultList();
        ArrayList<Favorite> resultado= new ArrayList<Favorite>();
        for (Favorite favorite : listaResultado) {
			if(favorite.getIdFavorite().equals(favoriteId))
				return favorite;
		}
       // entityManager.close();
     	return null;
	}

	@Override
	public User getUserByUserName(String userName) {
		Query query = entityManager.createQuery(FIND__USER_BY_USERNAME);
        query.setParameter("userName", userName);
        User resultado = (User) query.getSingleResult();
        //entityManager.close();
        return resultado;
	}

	@Override
	public List<User> getUserByUserNameAndPassword(String userName, String password) {
		List<User> listaResultado = new ArrayList<User>();
		User resultado = null;
		Query query =entityManager.createQuery(FIND__USER_BY_USERNAME_AND_PASSWORD);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        listaResultado = query.getResultList();
        //entityManager.close();
        return listaResultado;
	}


}
