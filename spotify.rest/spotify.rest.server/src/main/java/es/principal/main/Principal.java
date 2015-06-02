package es.principal.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.miw.spotify.models.daos.jpa.DaoJpaFactory;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.Role;
import es.spotify.models.entities.User;

public class Principal {

	public static void main(String[] args) {
		 Map<String, String> properties = new HashMap<>();
         properties. put(PersistenceUnitProperties.DDL_GENERATION,
                 PersistenceUnitProperties.DROP_AND_CREATE);
         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties).createEntityManager();
         
         
       Role r= new Role("ADMIN");
   
       DaoJpaFactory.getFactory().getUserRoleDao().create(r);
       User u= new User("u1",LocalDateTime.now(), "jjj@jsj.es", true,"*u1*");
    
       DaoJpaFactory.getFactory().getUserDao().create(u);
       System.out.println( DaoJpaFactory.getFactory().getUserDao().read(2));
       FavoriteType ft= new FavoriteType("ALBUM");
       DaoJpaFactory.getFactory().getFavoriteTypeDao().create(ft);
       Favorite f = new Favorite("5meb7aKE722LA66ssBhvfM",ft);//1M8Klr6g1qPzykza6wN1BA
       DaoJpaFactory.getFactory().getFavoriteDao().create(f);
       Favorite f1 = new Favorite("1M8Klr6g1qPzykza6wN1BA",ft);//
       DaoJpaFactory.getFactory().getFavoriteDao().create(f1);
       User u99 =DaoJpaFactory.getFactory().getUserDao().read(2);
       u99.getFavorites().add(f);
       u99.getFavorites().add(f1);
       u99.getUserRoles().add(r);
       DaoJpaFactory.getFactory().getUserDao().update(u99);
      
       
       u99=DaoJpaFactory.getFactory().getUserDao().read(2);
       System.out.println(u99);
       System.out.println(DaoJpaFactory.getFactory().getUserDao().getFavoriteByFavoriteType(ft, 2));
       List<Favorite> lista =  DaoJpaFactory.getFactory().getUserDao().getFavoriteByFavoriteType(ft, 2);
       System.out.println(lista);
       System.out.println(DaoJpaFactory.getFactory().getUserDao().isAdminUser(u99.getId()));
       
	}

}
