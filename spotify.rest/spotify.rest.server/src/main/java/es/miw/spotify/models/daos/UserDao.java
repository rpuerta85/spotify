package es.miw.spotify.models.daos;


import java.util.List;

import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;

public interface UserDao extends GenericDao<User , Integer> {
	public abstract List<Favorite> getFavoriteByFavoriteType(FavoriteType favoriteType, Integer userId);
	public abstract boolean isAdminUser(Integer idUser);
	public abstract boolean isFavoriteFromUser(String favoriteId, Integer idUser);
	public abstract Favorite getFavoriteFromUser(String favoriteId, Integer idUser);
	public abstract User getUserByUserName(String userName);
}
