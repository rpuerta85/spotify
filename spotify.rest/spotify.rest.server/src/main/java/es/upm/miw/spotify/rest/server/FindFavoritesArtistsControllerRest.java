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

import es.miw.spotify.models.daos.DaoFactory;
import es.miw.spotify.models.daos.UserDao;
import es.miw.spotify.models.daos.jpa.UserDaoJpa;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Artist;
import es.upm.miw.spotify.models.pojos.ArtistSimple;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.Pager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class FindFavoritesArtistsControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(FindFavoritesArtistsControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
    @RequestMapping(UrisWebApp.FIND_FAVORITE_ARTISTS)
    public ArtistsPager findFavoritesAlbums(@RequestParam(value="userUUID") String userUUID, @RequestParam(value="favoriteTypeUUID")String favoriteTypeUUID)  {
    	  
    	FavoriteType favoriteType = DaoFactory.getFactory().getFavoriteTypeDao().readUUID(favoriteTypeUUID);
    	User user =  DaoFactory.getFactory().getUserDao().readUUID(userUUID);
    	List<Favorite> artistsFavorites=	DaoFactory.getFactory().getUserDao().getFavoriteByFavoriteType(favoriteType, user.getId());
    	LOG.info("begin findFavoritesArstits");
    	LOG.info("album received:");
    	 ArtistsPager artists = new ArtistsPager();
    	 artists.artists= new Pager<Artist>();
    	 artists.artists.items = new ArrayList<Artist>();
    	 
       	for (Favorite favorite : artistsFavorites) {
		try {
    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_ARTIST_BY_ID.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(favorite.getIdFavorite(), "UTF-8")));
    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_ARTIST_BY_ID.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(favorite.getIdFavorite(), "UTF-8")),String.class);
    		LOG.info("response json:"+json);
    		Artist artist = new Gson().fromJson(json, Artist.class);
    		artists.artists.items.add(artist);
    		
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
		
    	}
       	return artists;
    }
}