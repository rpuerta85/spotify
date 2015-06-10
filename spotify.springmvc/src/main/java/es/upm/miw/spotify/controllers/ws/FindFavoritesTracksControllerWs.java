package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.upm.miw.spotify.controllers.FindFavoritesTracksController;
import es.upm.miw.spotify.controllers.FindTrackController;
import es.upm.miw.spotify.models.pojos.Track;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindFavoritesTracksControllerWs extends ControllerWs implements
		FindFavoritesTracksController {
	private static final Logger log = LogManager.getLogger(FindFavoritesTracksControllerWs.class);


	public FindFavoritesTracksControllerWs(SessionBean session) {
		super(session);

	}
//	public TracksPager findTrackByName(String track) {
//		log.info("begin findTrack");
//		log.info("track received:"+track);
//		RestTemplate restTemplate = ControllerWs.buildRestClient();
//		String json = "{}";
//		TracksPager tracks = null;
//		try {
//		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_TRACK_REST_URI.replaceAll(RestArtistUris.PARAM,track ));
//		tracks = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_TRACK_REST_URI.replaceAll(RestArtistUris.PARAM,track ),TracksPager.class );
//		log.info("rest response:" + json);
//		} catch (Exception e) {
//			log.error("error response", e);
//		}
//		log.debug("end findTrack");
//		return tracks;
//	}
//
//
//	public Track findTrackBySpotifyId(String spotifyId) {
//		log.info("begin findTrackBySpotifyId");
//		log.info("artistid received:"+spotifyId);
//		RestTemplate restTemplate = ControllerWs.buildRestClient();
//		String json = "{}";
//		Track track = null;
//		try {
//		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_TRACK_BY_SPOTIFYID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId ));
//		track = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_TRACK_BY_SPOTIFYID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId ),Track.class );
//		json = new Gson().toJson(track);
//		log.info("rest response:" + json);
//		} catch (Exception e) {
//			log.error("error response", e);
//		}
//		log.debug("end findTrackBySpotifyId");
//		return track;
//	}

	@Override
	public TracksPager findTracksForUser(String userUUID) {
		log.info("begin findFavoritesTracks");
		log.info("usserUUID received:"+userUUID);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		TracksPager tracks = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_FAVORITES_TRACKS_REST_URI.replaceAll(RestArtistUris.PARAM,userUUID));
		tracks = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_FAVORITES_TRACKS_REST_URI.replaceAll(RestArtistUris.PARAM,userUUID),TracksPager.class );
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findTrack");
		return tracks;
	}

}
