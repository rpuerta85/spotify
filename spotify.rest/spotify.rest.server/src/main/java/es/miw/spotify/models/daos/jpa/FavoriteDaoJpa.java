package es.miw.spotify.models.daos.jpa;


import es.miw.spotify.models.daos.FavoriteDao;
import es.spotify.models.entities.Favorite;
public class FavoriteDaoJpa extends GenericDaoJpa<Favorite, Integer> implements FavoriteDao {

	public FavoriteDaoJpa() {
		super(Favorite.class);
	}
}
