package es.miw.spotify.models.daos.jpa;

import org.springframework.stereotype.Component;

import es.miw.spotify.models.daos.FavoriteTypeDao;
import es.spotify.models.entities.FavoriteType;
@Component
public class FavoriteTypeDaoJpa extends GenericDaoJpa<FavoriteType, Integer> implements FavoriteTypeDao {
  
	  public FavoriteTypeDaoJpa() {
        super(FavoriteType.class);
    }

   
}
