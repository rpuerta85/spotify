package es.miw.spotify.models.daos;

import es.spotify.models.entities.FavoriteType;

public interface FavoriteTypeDao extends GenericDao<FavoriteType, Integer> {
	FavoriteType getFavoriteTypeByDescription(String description);
}
