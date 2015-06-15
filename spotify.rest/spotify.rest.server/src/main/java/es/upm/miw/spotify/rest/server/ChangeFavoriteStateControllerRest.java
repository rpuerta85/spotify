package es.upm.miw.spotify.rest.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.miw.spotify.models.daos.DaoFactory;
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
	
   
    private void changeFavoriteStateToUser(String favoriteId,String userUUID, String typeFavoriteDescription)  {
    	LOG.info("begin change changeFavoriteState");
    	LOG.info("favoriteUUID received:"+favoriteId + "userrUUID received " + userUUID  + "Tipo: "+ typeFavoriteDescription);
    	FavoriteType favoriteType = DaoFactory.getFactory().getFavoriteTypeDao().getFavoriteTypeByDescription(typeFavoriteDescription);
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
    	    DaoFactory.getFactory().getUserDao().update(user);
    	}
    	
       	LOG.info("end changeFavoriteState");

    }
    @RequestMapping(UrisWebApp.CHANGE_FAVORITE_ALBUM_STATE)
    public void changeFavoriteAlbumStateToUser(@RequestParam(value="favoriteId") String favoriteId,  @RequestParam(value="userUUID") String userUUID)  {
    	LOG.info("begin change changeAlbumFavoriteState");
    	LOG.info("favoriteUUID received:"+favoriteId + "userrUUID received " + userUUID );
    	this.changeFavoriteStateToUser(favoriteId, userUUID, "ALBUM");
       	LOG.info("end changeAlbumFavoriteState");

    }
//    @RequestMapping(UrisWebApp.CHANGE_FAVORITE_ARTIST_STATE)
//    public void changeFavoriteArtistStateToUser(@RequestParam(value="favoriteId") String favoriteId,  @RequestParam(value="userUUID") String userUUID)  {
//    	LOG.info("begin change changeArtistFavoriteState");
//    	LOG.info("favoriteUUID received:"+favoriteId + "userrUUID received " + userUUID );
//    	this.changeFavoriteStateToUser(favoriteId, userUUID, "ALBUM");
//       	LOG.info("end changeArtistFavoriteState");
//
//    }
    @RequestMapping(UrisWebApp.CHANGE_FAVORITE_TRACK_STATE)
    public void changeFavoriteTrackToUser(@RequestParam(value="favoriteId") String favoriteId,  @RequestParam(value="userUUID") String userUUID)  {
    	LOG.info("begin change changeTRcakFavoriteState");
    	LOG.info("favoriteUUID received:"+favoriteId + "userrUUID received " + userUUID );
    	this.changeFavoriteStateToUser(favoriteId, userUUID, "TRACK");
       	LOG.info("end changeTrackFavoriteState");

    }
}