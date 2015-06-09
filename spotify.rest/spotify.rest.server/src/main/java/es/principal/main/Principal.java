package es.principal.main;

import java.security.NoSuchAlgorithmException;
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
import es.upm.miw.spotify.models.utils.Encript;

public class Principal {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		 Map<String, String> properties = new HashMap<>();
         properties. put(PersistenceUnitProperties.DDL_GENERATION,
                 PersistenceUnitProperties.DROP_AND_CREATE);
         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties).createEntityManager();
         
         Encript e = new Encript();
       Role r= new Role("ADMIN");
       Role r2= new Role("PRINGADO");
       DaoJpaFactory.getFactory().getUserRoleDao().create(r);
       User u= new User("u1",LocalDateTime.now(), "jjj@jsj.es", true,e.encriptacion("*u1*"));
    
       DaoJpaFactory.getFactory().getUserDao().create(u);
       System.out.println( DaoJpaFactory.getFactory().getUserDao().read(2));
       FavoriteType ft= new FavoriteType("ALBUM");
       DaoJpaFactory.getFactory().getFavoriteTypeDao().create(ft);
       Favorite f = new Favorite("5meb7aKE722LA66ssBhvfM",ft);//1M8Klr6g1qPzykza6wN1BA
       DaoJpaFactory.getFactory().getFavoriteDao().create(f);
       Favorite f1 = new Favorite("1M8Klr6g1qPzykza6wN1BA",ft);//
      // DaoJpaFactory.getFactory().getFavoriteDao().create(f1);
       User u99 =DaoJpaFactory.getFactory().getUserDao().read(2);
       u99.getFavorites().add(f);
       u99.getFavorites().add(f1);
       u99.getUserRoles().add(r);
       DaoJpaFactory.getFactory().getUserDao().update(u99);
       FavoriteType ft2= new FavoriteType("ARTIST");
       DaoJpaFactory.getFactory().getFavoriteTypeDao().create(ft2);
       Favorite f3 = new Favorite("0UWZUmn7sybxMCqrw9tGa7",ft2);//
       FavoriteType ft3 =new FavoriteType("TRACK");
       DaoJpaFactory.getFactory().getFavoriteTypeDao().create(ft3);
	   Favorite f4 = new Favorite("0eGsygTp906u18L0Oimnem",ft3);//
       //DaoJpaFactory.getFactory().getFavoriteDao().create(f3);
       u99.getFavorites().add(f3);
     
       u99.getFavorites().add(f4);
       DaoJpaFactory.getFactory().getUserDao().update(u99);
       u99=DaoJpaFactory.getFactory().getUserDao().read(2);
       System.out.println(u99);
       System.out.println(DaoJpaFactory.getFactory().getUserDao().getFavoriteByFavoriteType(ft, 2));
       List<Favorite> lista =  DaoJpaFactory.getFactory().getUserDao().getFavoriteByFavoriteType(ft2, 2);
       System.out.println(lista);
       System.out.println(DaoJpaFactory.getFactory().getUserDao().getFavoriteByFavoriteType(ft3, 2));
       f4=DaoJpaFactory.getFactory().getFavoriteDao().read(8);
       System.out.println("Es admin:"+DaoJpaFactory.getFactory().getUserDao().isAdminUser(u99.getId()));
       System.out.println("Esfavorito:"+DaoJpaFactory.getFactory().getUserDao().isFavoriteFromUser("0eGsygTp906u18L0Oimnem", u99.getId()));
       System.out.println("Es favorito (debe dar false:" +DaoJpaFactory.getFactory().getUserDao().isFavoriteFromUser("lkshfklshfk", u99.getId()));
       
       User u2 = new User("u2", LocalDateTime.now(), "123@rr.es", true, e.encriptacion("*u2*"));
       DaoJpaFactory.getFactory().getUserDao().create(u2);
       Favorite f20 = new Favorite("0UWZUmn7sybxMCqrw9tGa7",ft2);
       u2.getFavorites().add(f20);
       DaoJpaFactory.getFactory().getUserDao().update(u2);
       System.out.println(DaoJpaFactory.getFactory().getUserDao().getUserByUserName("u1"));
       System.out.println(DaoJpaFactory.getFactory().getUserDao().getUserByUserName("u2"));
       
       
       System.out.println(e.encriptacion("*u1*"));
       System.out.println(e.encriptacion("*u2*"));
       
	}

}
