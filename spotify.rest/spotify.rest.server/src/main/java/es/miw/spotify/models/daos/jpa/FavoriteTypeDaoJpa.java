package es.miw.spotify.models.daos.jpa;

import javax.persistence.Query;
import org.springframework.stereotype.Component;
import es.miw.spotify.models.daos.FavoriteTypeDao;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;




@Component
public class FavoriteTypeDaoJpa extends GenericDaoJpa<FavoriteType, Integer> implements FavoriteTypeDao {
  
	  private static final String FIND_FAVORITETYPE_BY_DESCRIPTION = "SELECT ft FROM FavoriteType ft  where ft.description= :description";

	public FavoriteTypeDaoJpa() {
        super(FavoriteType.class);
    }

	@Override
	public FavoriteType getFavoriteTypeByDescription(String description) {
		Query query = entityManager.createQuery(FIND_FAVORITETYPE_BY_DESCRIPTION);
        query.setParameter("description", description);
        FavoriteType resultado = ( FavoriteType) query.getSingleResult();
        return resultado;
	}

   
}
