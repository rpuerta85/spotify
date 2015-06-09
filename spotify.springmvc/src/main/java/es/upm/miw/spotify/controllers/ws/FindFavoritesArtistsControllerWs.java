package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import es.upm.miw.spotify.controllers.FindFavoritesArtistsController;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindFavoritesArtistsControllerWs implements
		FindFavoritesArtistsController {
	private static final Logger log = LogManager.getLogger(FindFavoritesArtistsControllerWs.class);

	public FindFavoritesArtistsControllerWs(SessionBean session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArtistsPager findArtistsForUser(String userUUID) {
		log.info("begin findArtistsJSON");
		log.info("datas  received:"+ "userrUUId " + userUUID );
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		ArtistsPager artists = null;
		try {
			String favoritesURI = RestArtistUris.FIND_FAVORITES_ARTISTS_REST_URI.replace(RestArtistUris.PARAM,userUUID);
		    
		log.info("URI:" + ControllerWs.URI+ favoritesURI);
		artists = restTemplate.getForObject( ControllerWs.URI+ favoritesURI,ArtistsPager.class );
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findArtistsJSON");
		return artists;
	}

}
