package es.miw.spotify.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.miw.spotify.models.daos.UserRoleDao;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.Role;


public class UserRoleDaoJpa extends GenericDaoJpa<Role, Integer> implements UserRoleDao {
	
	private static final String FIND_ROLE_BY_NAME = "SELECT r FROM Role r where r.role = :nameRol";

	public UserRoleDaoJpa() {
        super(Role.class);
    }

	@Override
	public Role findRoleByName(String nameRol) {
		 EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	        Query query = entityManager.createQuery(FIND_ROLE_BY_NAME);
	        query.setParameter("nameRol", nameRol);
	        List<Role> listaResultado =(List<Role>) query.getResultList();
	        entityManager.close();
	        return listaResultado.get(0);
	}
    

}
