package es.miw.spotify.models.daos.jpa;

import org.springframework.stereotype.Component;

import es.miw.spotify.models.daos.RoleDao;
import es.spotify.models.entities.Role;

@Component
public class RoleDaoJpa extends GenericDaoJpa<Role, Integer> implements RoleDao {
	public RoleDaoJpa() {
        super(Role.class);
    }
}
