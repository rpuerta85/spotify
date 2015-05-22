package es.miw.spotify.models.daos.jpa;

import es.miw.spotify.models.daos.UserRoleDao;
import es.spotify.models.entities.Role;


public class UserRoleDaoJpa extends GenericDaoJpa<Role, Integer> implements UserRoleDao {
	
	public UserRoleDaoJpa() {
        super(Role.class);
    }
    

}
