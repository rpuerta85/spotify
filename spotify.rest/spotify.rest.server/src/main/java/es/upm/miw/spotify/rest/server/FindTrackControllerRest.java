package es.upm.miw.spotify.rest.server;

import java.net.URLEncoder;

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

import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.TrackSimple;
import es.upm.miw.spotify.models.pojos.Tracks;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class FindTrackControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(FindTrackControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;//cliente REST, el cual se instancia en cuanto
	 //se crea el contexto de la aplicacio,. Se crea concretamente en spotify.rest.client.RestConfig
	 // Por tanto, este objeto aqui ya se encuentra instanciado, nohace falta hace NEW
	
    @RequestMapping(UrisWebApp.FIND_TRACK_BY_NAME)
    public TracksPager findTrackByName(@RequestParam(value="trackName", defaultValue="") String trackName)  {
    	LOG.info("begin findTrackByName");
    	LOG.info("track received:"+trackName);
    	TracksPager tracks = null;
    	try {
    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_TRACK_BY_NAME.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(trackName, "UTF-8")));
    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_TRACK_BY_NAME.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(trackName, "UTF-8")),String.class);
    		tracks =new Gson().fromJson(json, TracksPager.class);
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
    	LOG.info("end findTrackByName");
    	return tracks;
    }
    @RequestMapping(UrisWebApp.FIND_TRACKS_OF_ALBUM_REST_URI)
    public  Page<TrackSimple> findTracksByAlbumId(@PathVariable("id") String albumId)  {
    	LOG.info("begin findAlbumesByArtistId");
    	LOG.info("albumId received:"+albumId);
    	ParameterizedTypeReference<Page<TrackSimple>> responseType = new ParameterizedTypeReference<Page<TrackSimple>>() {
		  };
		  Page<TrackSimple> resulList = null;
		  try {
		  LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_TRACKS_OF_ALBUM_BY_ID.
					replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(albumId, "UTF-8") ));
		  ResponseEntity<Page<TrackSimple>> result = restTemplate.exchange(spotifyRestUri+UrisSpotifyApi.FIND_TRACKS_OF_ALBUM_BY_ID.
					replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(albumId, "UTF-8")) , HttpMethod.GET, null, responseType);
		 resulList = result.getBody();
		 String json = new Gson().toJson(resulList);
		 LOG.info("response json:"+json);
		  } catch (Exception e) {
  			LOG.error("error response", e);
  		}
		 
		 LOG.info("end findAlbumesByArtistId");
    	return resulList;
    }
    
    
    
}