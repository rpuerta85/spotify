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

import es.upm.miw.spotify.models.pojos.Artists;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class FindArtistControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(FindArtistControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;//cliente REST, el cual se instancia en cuanto
	 //se crea el contexto de la aplicacio,. Se crea concretamente en spotify.rest.client.RestConfig
	 // Por tanto, este objeto aqui ya se encuentra instanciado, nohace falta hace NEW
	
    @RequestMapping(UrisWebApp.FIND_ARTIST_BY_NAME)
    public ArtistsPager findArtistByName(@RequestParam(value="artistName", defaultValue="World") String artistName)  {
    	LOG.info("begin findArtistByName");
    	LOG.info("artist received:"+artistName);
    	ArtistsPager artists = null;
    	try {
    		LOG.info("URI:"+spotifyRestUri+UrisSpotifyApi.FIND_ARTIST_BY_NAME.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(artistName, "UTF-8")));
    		String json = restTemplate.getForObject(spotifyRestUri+UrisSpotifyApi.FIND_ARTIST_BY_NAME.
				replaceAll(UrisSpotifyApi.PARAM, URLEncoder.encode(artistName, "UTF-8")),String.class);
    		artists =new Gson().fromJson(json, ArtistsPager.class);/*objectMapper.readValue(json, Artists.class);*/
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
    	LOG.info("end findArtistByName");
    	return artists;
    }
}