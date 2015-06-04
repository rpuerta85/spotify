package es.upm.miw.spotify.rest.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.miw.spotify.models.daos.DaoFactory;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class ChangeFavoriteStateControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(ChangeFavoriteStateControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
    @RequestMapping(UrisWebApp.ADD_FAVORITE_TO_USER)
    public void changeFavoriteStateToUser(@RequestParam(value="favoriteId") String favoriteId, @RequestParam(value="favoriteTypeUUID") String favoriteTypeUUID,  @RequestParam(value="userUUID") String userUUID)  {
    	LOG.info("begin change changeFavoriteState");
    	LOG.info("favoriteUUID received:"+favoriteId + "userrUUID received " + userUUID +"FavoritetpeUUID "+favoriteTypeUUID);
    	FavoriteType favoriteType = DaoFactory.getFactory().getFavoriteTypeDao().readUUID(favoriteTypeUUID);
    	User user =  DaoFactory.getFactory().getUserDao().readUUID(userUUID);
    	boolean isFavoriteFromUser =DaoFactory.getFactory().getUserDao().isFavoriteFromUser(favoriteId, user.getId());
    	Favorite favorite = null;
    	if(isFavoriteFromUser){
    		 favorite =DaoFactory.getFactory().getUserDao().getFavoriteFromUser(favoriteId, user.getId());
    		 user.getFavorites().remove(favorite);
    		 DaoFactory.getFactory().getUserDao().update(user);
    		 DaoFactory.getFactory().getUserDao().read(user.getId());
    		 DaoFactory.getFactory().getFavoriteDao().deleteById(favorite.getId());
    	}
    	else{
    		favorite = new Favorite(favoriteId, favoriteType);
    		user.getFavorites().add(favorite);
    	}
    	
       	LOG.info("end changeFavoriteState");

    }
    
}