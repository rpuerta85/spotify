package es.miw.spotify.models.daos.jpa;

import es.miw.spotify.models.daos.RoleDao;

import es.spotify.models.entities.Role;


public class RoleDaoJpa extends GenericDaoJpa<Role, Integer> implements RoleDao {
	public RoleDaoJpa() {
        super(Role.class);
    }
}
