package es.upm.miw.spotify.rest.server;

import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.upm.miw.spotify.models.pojos.Albums;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class FindAlbumControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(FindAlbumControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;//cliente REST, el cual se instancia en cuanto
	 //se crea el contexto de la aplicacio,. Se crea concretamente en spotify.rest.client.RestConfig
	 // Por tanto, este objeto aqui ya se encuentra instanciado, nohace falta hace NEW
	
    @RequestMapping(UrisWebApp.FIND_ALBUM_BY_NAME)
    public AlbumsPager findAlbumByName(@RequestParam(value="albumName", defaultValue="") String albumName)  {
    	LOG.info("begin findAlbumByName");
    	LOG.info("album received:"+albumName);
    	AlbumsPager albums = null;
    	try {
    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_ALBUM_BY_NAME.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(albumName, "UTF-8")));
    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_ALBUM_BY_NAME.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(albumName, "UTF-8")),String.class);
    		LOG.info("response json:"+json);
    		albums =new Gson().fromJson(json, AlbumsPager.class);
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
    	LOG.info("end findAlbumByName");
    	return albums;
    }
}