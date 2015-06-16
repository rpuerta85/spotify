package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import es.spotify.models.entities.FavoriteType;
import es.upm.miw.spotify.controllers.ChangeStateFavoriteController;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Artist;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.pojos.Track;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class ChangeStateFavoriteControllerWS extends ControllerWs implements
		ChangeStateFavoriteController {
	private static final Logger log = LogManager.getLogger(ChangeStateFavoriteControllerWS.class);


	protected ChangeStateFavoriteControllerWS(SessionBean session) {
		super(session);
	}

	@Override
	public void changeAlbumFavoriteState(String spotifyId, String userUUID) {
		log.info("begin changeFavoriteState");
		log.info("data for Album Favorite  received:"+spotifyId , "user" + userUUID );
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		AlbumsPager albums = null;
		try {
			String  stringURL= RestArtistUris.CHANGE_ALBUM_FAVORITE_STATE.replaceAll(RestArtistUris.PARAM, spotifyId);
			        stringURL= stringURL.replaceAll(RestArtistUris.PARAM2, userUUID);
		log.info("URI:" + ControllerWs.URI+stringURL);
		
		restTemplate.getForObject( ControllerWs.URI+stringURL,Album.class);
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end changeFavoriteAlbumState");

	}

	@Override
	public void changeArtistFavoriteState(String spotifyId, String userUUID) {
		log.info("begin changeFavoriteState");
		log.info("data for Artist Favorite  received:"+spotifyId , "user" + userUUID );
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		ArtistsPager artists = null;
		try {
			String  stringURL= RestArtistUris.CHANGE_ARTIST_FAVORITE_STATE.replace(RestArtistUris.PARAM, spotifyId);
			        stringURL= stringURL.replace(RestArtistUris.PARAM2, userUUID);
		log.info("URI:" + ControllerWs.URI+stringURL);
		
		restTemplate.getForObject( ControllerWs.URI+stringURL,Artist.class);
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end changeFavoriteArtistState");

	}

	@Override
	public void changeTrackFavoriteState(String spotifyId, String userUUID) {
		log.info("begin changeFavoriteState");
		log.info("data for Track Favorite  received:"+spotifyId , "user" + userUUID );
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		TracksPager tracks = null;
		try {
			String  stringURL= RestArtistUris.CHANGE_TRACK_FAVORITE_STATE.replaceAll(RestArtistUris.PARAM, spotifyId);
			        stringURL= stringURL.replaceAll(RestArtistUris.PARAM2, userUUID);
		log.info("URI:" + ControllerWs.URI+stringURL);
		
		Track track =restTemplate.getForObject( ControllerWs.URI+stringURL,Track.class);
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end changeFavoriteTrackState");
	}
	
	
    
}
