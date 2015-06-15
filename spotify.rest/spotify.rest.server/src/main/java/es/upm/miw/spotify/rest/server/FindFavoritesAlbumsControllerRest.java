package es.upm.miw.spotify.rest.server;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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
import es.miw.spotify.models.daos.UserDao;
import es.miw.spotify.models.daos.jpa.FavoriteDaoJpa;
import es.miw.spotify.models.daos.jpa.FavoriteTypeDaoJpa;
import es.miw.spotify.models.daos.jpa.UserDaoJpa;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.Pager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class FindFavoritesAlbumsControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(FindFavoritesAlbumsControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
	 @Autowired
	 private UserDaoJpa  userDaoJpa;
	 
    @RequestMapping(UrisWebApp.FIND_FAVORITE_ALBUMS)
    public AlbumsPager findFavoritesAlbums(@RequestParam(value="userUUID") String userUUID)  {
    	  
    	
    	User user =  userDaoJpa.readUUID(userUUID);
    	List<Favorite> albumesFavorites=	userDaoJpa.getFavoritesAlbums(user.getId());
    	LOG.info("begin findFavoritesAlbums");
    	LOG.info("album received:");
    	AlbumsPager albums = new AlbumsPager();
    	albums.albums=new Pager<AlbumSimple>();
    	albums.albums.items= new ArrayList<AlbumSimple>();
    	for (Favorite favorite : albumesFavorites) {
		try {
    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_ALBUM_BY_ID.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(favorite.getIdFavorite(), "UTF-8")));
    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_ALBUM_BY_ID.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(favorite.getIdFavorite(), "UTF-8")),String.class);
    		LOG.info("response json:"+json);
    		AlbumSimple albumSimple = new Gson().fromJson(json, AlbumSimple.class);
    		albums.albums.items.add(albumSimple);
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
    	}
    	LOG.info("end findFavoritesAlbums");
    	return albums;
    }
    
}