package es.miw.spotify.models.daos;


import java.util.List;

import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;

public interface UserDao extends GenericDao<User , Integer> {
	public abstract List<Favorite> getFavoriteByFavoriteType(FavoriteType favoriteType, int userId);
	public abstract boolean isAdminUser(int idUser);
	//public abstract boolean isFavorite(Favorite favorite, int idUser);
}
