package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import es.upm.miw.spotify.controllers.FindArtistController;
import es.upm.miw.spotify.models.pojos.Artists;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindArtistControllerWs extends ControllerWs implements
		FindArtistController {
	private static final Logger log = LogManager.getLogger(FindArtistControllerWs.class);


	public FindArtistControllerWs(SessionBean session) {
		super(session);

	}


	@Override
	public Artists findArtist(String artist) {
		log.info("begin findArtistJSON");
		log.info("artist received:"+artist);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		Artists artists = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI.replaceAll(RestArtistUris.PARAM,artist ));
		//System.out.println(replaceParamUriForValue(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI, RestArtistUris.PARAM, artist));
		artists = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI.replaceAll(RestArtistUris.PARAM,artist ),Artists.class );
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findArtistJSON");
		return artists;
	}

	

}
