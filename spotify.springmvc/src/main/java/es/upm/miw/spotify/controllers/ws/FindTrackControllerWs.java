package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import es.upm.miw.spotify.controllers.FindTrackController;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindTrackControllerWs extends ControllerWs implements
		FindTrackController {
	private static final Logger log = LogManager.getLogger(FindTrackControllerWs.class);


	public FindTrackControllerWs(SessionBean session) {
		super(session);

	}

	@Override
	public TracksPager findTrack(String track) {
		log.info("begin findTrack");
		log.info("track received:"+track);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		TracksPager tracks = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_TRACK_REST_URI.replaceAll(RestArtistUris.PARAM,track ));
		tracks = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_TRACK_REST_URI.replaceAll(RestArtistUris.PARAM,track ),TracksPager.class );
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findTrack");
		return tracks;
	}

	

}
