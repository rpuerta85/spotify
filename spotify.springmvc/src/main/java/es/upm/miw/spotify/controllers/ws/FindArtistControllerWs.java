package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import es.upm.miw.spotify.controllers.FindArtistController;
import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.Artist;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindArtistControllerWs extends ControllerWs implements
		FindArtistController {
	private static final Logger log = LogManager.getLogger(FindArtistControllerWs.class);


	public FindArtistControllerWs(SessionBean session) {
		super(session);

	}


	@Override
	public ArtistsPager findArtist(String artist) {
		log.info("begin findArtistJSON");
		log.info("artist received:"+artist);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		ArtistsPager artists = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI.replaceAll(RestArtistUris.PARAM,artist ));
		//System.out.println(replaceParamUriForValue(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI, RestArtistUris.PARAM, artist));
		artists = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI.replaceAll(RestArtistUris.PARAM,artist ),ArtistsPager.class );
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findArtistJSON");
		return artists;
	}


	@Override
	public Artist findArtistBySpotifyId(String spotifyId) {
		log.info("begin findArtistBySpotifyId");
		log.info("artistid received:"+spotifyId);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		Artist artist = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_ARTIST_BY_SPOTIFYID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId ));
		artist = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_ARTIST_BY_SPOTIFYID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId ),Artist.class );
		json = new Gson().toJson(artist);
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findArtistBySpotifyId");
		return artist;
	}


	@Override 
	public Page<AlbumSimple> findAlbumesOfArtistId(String spotifyId,String limit) {
		log.info("begin findAlbumesOfArtistId");
		log.info("artistid received:"+spotifyId);
		log.info("limit received:"+limit);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		ParameterizedTypeReference<Page<AlbumSimple>> responseType = 
				new ParameterizedTypeReference<Page<AlbumSimple>>() {
		  };
		  log.info("rest uti:"+(ControllerWs.URI+RestArtistUris.FIND_ALBUMES_OF_ARTISTID_REST_URI.
				  replaceAll(RestArtistUris.PARAM,spotifyId )).replaceAll(UrisSpotifyApi.LIMIT_PARAM, limit));
		  ResponseEntity<Page<AlbumSimple>> result = restTemplate.
				  exchange((ControllerWs.URI+RestArtistUris.FIND_ALBUMES_OF_ARTISTID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId).replaceAll(UrisSpotifyApi.LIMIT_PARAM, limit) ), HttpMethod.GET, null, responseType);
		 Page<AlbumSimple> resulList = result.getBody();
		 json = new Gson().toJson(resulList);
		 log.info("rest response:" + json);		 
		 log.info("end findAlbumesOfArtistId");
		return resulList;
	}

	

}
