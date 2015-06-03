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
	 private RestTemplate  restTemplate;//cliente REST, el cual se instancia en cuanto
	 //se crea el contexto de la aplicacio,. Se crea concretamente en spotify.rest.client.RestConfig
	 // Por tanto, este objeto aqui ya se encuentra instanciado, nohace falta hace NEW
	
    @RequestMapping(UrisWebApp.FIND_FAVORITE_ALBUMS)
    public AlbumsPager findFavoritesAlbums(@RequestParam(value="userId") String userId, @RequestParam(value="idFavoriteType")String idFavoriteType)  {
    	  
    	FavoriteType favoriteType = DaoFactory.getFactory().getFavoriteTypeDao().readUUID(idFavoriteType);
    	User user =  DaoFactory.getFactory().getUserDao().readUUID(userId);
    	List<Favorite> albumesFavorites=	DaoFactory.getFactory().getUserDao().getFavoriteByFavoriteType(favoriteType, user.getId());
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
//    	albums =new Gson().fromJson(json, AlbumsPager.class);
    	LOG.info("end findFavoritesAlbums");
    	return albums;
    }
    
//    @RequestMapping(UrisWebApp.FIND_ALBUMES_OF_ARTISTID_REST_URI)
//    public  Page<AlbumSimple> findAlbumesByArtistId(@PathVariable("id") String artistId,
//    		@RequestParam(value="limit", defaultValue="5") String limit)  {
//    	LOG.info("begin findAlbumesByArtistId");
//    	LOG.info("artistId received:"+artistId);
//    	LOG.info("limit received:"+limit);
//    	ParameterizedTypeReference<Page<AlbumSimple>> responseType = new ParameterizedTypeReference<Page<AlbumSimple>>() {
//		  };
//		  Page<AlbumSimple> resulList = null;
//		  try {
//		  LOG.info("URI:"+(spotifyRestUri+UrisSpotifyApi.FIND_ALBUMES_OF_ARTIST_BY_ID.
//					replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(artistId, "UTF-8")).replaceAll(UrisSpotifyApi.LIMIT_PARAM, limit) ));
//		  ResponseEntity<Page<AlbumSimple>> result = restTemplate.exchange((spotifyRestUri+UrisSpotifyApi.FIND_ALBUMES_OF_ARTIST_BY_ID.
//					replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(artistId, "UTF-8")).replaceAll(UrisSpotifyApi.LIMIT_PARAM, limit) ), HttpMethod.GET, null, responseType);
//		 resulList = result.getBody();
//		 String json = new Gson().toJson(resulList);
//		 LOG.info("response json:"+json);
//		  } catch (Exception e) {
//  			LOG.error("error response", e);
//  		}
//		 
//		 LOG.info("end findAlbumesByArtistId");
//    	return resulList;
//    }
//    @RequestMapping(UrisWebApp.FIND_ALBUM_BY_SPOTIFYID)
//    public Album findAlbumBySpotifyId(@PathVariable("id") String spotifyId)  {
//    	LOG.info("begin findAlbumBySpotifyId");
//    	LOG.info("spotifyId received:"+spotifyId);
//    	Album album = null;
//    	try {
//    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_ALBUM_BY_ID.
//				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(spotifyId, "UTF-8")));
//    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_ALBUM_BY_ID.
//				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(spotifyId, "UTF-8")),String.class);
//    		album =new Gson().fromJson(json, Album.class);
//    		} catch (Exception e) {
//    			LOG.error("error response", e);
//    		}
//    	LOG.info("end findAlbumBySpotifyId");
//    	return album;
//    }
//    
    
}