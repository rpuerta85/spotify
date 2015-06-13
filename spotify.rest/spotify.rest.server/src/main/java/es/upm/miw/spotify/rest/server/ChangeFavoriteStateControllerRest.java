package es.upm.miw.spotify.rest.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import es.miw.spotify.models.daos.jpa.FavoriteDaoJpa;
import es.miw.spotify.models.daos.jpa.FavoriteTypeDaoJpa;
import es.miw.spotify.models.daos.jpa.UserDaoJpa;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class ChangeFavoriteStateControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(ChangeFavoriteStateControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
	 @Autowired
	 private UserDaoJpa  userDaoJpa;
	 
	 @Autowired
	 private FavoriteTypeDaoJpa  favoriteTypeDaoJpa;
	 
	 @Autowired
	 private FavoriteDaoJpa  favoriteDaoJpa;
	 
    @RequestMapping(UrisWebApp.ADD_FAVORITE_TO_USER)
    public void changeFavoriteStateToUser(@RequestParam(value="favoriteId") String favoriteId, @RequestParam(value="favoriteTypeUUID") String favoriteTypeUUID,  @RequestParam(value="userUUID") String userUUID)  {
    	LOG.info("begin change changeFavoriteState");
    	LOG.info("favoriteUUID received:"+favoriteId + "userrUUID received " + userUUID +"FavoritetpeUUID "+favoriteTypeUUID);
    	FavoriteType favoriteType = favoriteTypeDaoJpa.readUUID(favoriteTypeUUID);
    	User user =  userDaoJpa.readUUID(userUUID);
    	boolean isFavoriteFromUser =userDaoJpa.isFavoriteFromUser(favoriteId, user.getId());
    	Favorite favorite = null;
    	if(isFavoriteFromUser){
    		 favorite =userDaoJpa.getFavoriteFromUser(favoriteId, user.getId());
    		 user.getFavorites().remove(favorite);
    		 userDaoJpa.update(user);
    		 userDaoJpa.read(user.getId());
    		 favoriteDaoJpa.deleteById(favorite.getId());
    	}
    	else{
    		favorite = new Favorite(favoriteId, favoriteType);
    		user.getFavorites().add(favorite);
    		userDaoJpa.update(user);
    	}
    	
       	LOG.info("end changeFavoriteState");

    }
    
}