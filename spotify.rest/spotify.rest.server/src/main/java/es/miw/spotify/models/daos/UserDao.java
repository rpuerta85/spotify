package es.miw.spotify.models.daos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;

public interface UserDao extends GenericDao<User , Integer> {
	
	public abstract boolean isAdminUser(Integer idUser);
	public abstract boolean isFavoriteFromUser(String favoriteId, Integer idUser);
	public abstract Favorite getFavoriteFromUser(String favoriteId, Integer idUser);
	public abstract User getUserByUserName(String userName);
	public abstract List<User>  getUserByUserNameAndPassword(String userName,String password);
	public abstract List<Favorite> getFavoritesAlbums(Integer userId);
	public abstract List<Favorite> getFavoritesArtists(Integer userId);
	public abstract List<Favorite> getFavoritesTracks(Integer userId);
	
}
