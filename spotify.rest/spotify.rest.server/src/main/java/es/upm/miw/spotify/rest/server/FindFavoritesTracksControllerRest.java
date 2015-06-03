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
import es.upm.miw.spotify.models.pojos.Track;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class FindFavoritesTracksControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(FindFavoritesTracksControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
    @RequestMapping(UrisWebApp.FIND_FAVORITE_TRACKS)
    public TracksPager findFavoritesAlbums(@RequestParam(value="userId") String userId, @RequestParam(value="idFavoriteType")String idFavoriteType)  {
    	  
    	FavoriteType favoriteType = DaoFactory.getFactory().getFavoriteTypeDao().readUUID(idFavoriteType);
    	User user =  DaoFactory.getFactory().getUserDao().readUUID(userId);
    	List<Favorite> artistsFavorites=	DaoFactory.getFactory().getUserDao().getFavoriteByFavoriteType(favoriteType, user.getId());
    	LOG.info("begin findFavoritesTracks");
    	LOG.info("album received:");
    	 TracksPager tracks = new TracksPager();
    	 tracks.tracks= new Pager<Track>();
    	 tracks.tracks.items = new ArrayList<Track>();
    	 
       	for (Favorite favorite : artistsFavorites) {
		try {
    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_TRACK_BY_ID.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(favorite.getIdFavorite(), "UTF-8")));
    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_TRACK_BY_ID.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(favorite.getIdFavorite(), "UTF-8")),String.class);
    		LOG.info("response json:"+json);
    		Track track = new Gson().fromJson(json, Track.class);
    		tracks.tracks.items.add(track);
    		
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
		
    	}
       	return tracks;
    }
}