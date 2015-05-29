package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import es.upm.miw.spotify.controllers.FindAlbumController;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.TrackSimple;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindAlbumControllerWs extends ControllerWs implements
		FindAlbumController {
	private static final Logger log = LogManager.getLogger(FindAlbumControllerWs.class);


	public FindAlbumControllerWs(SessionBean session) {
		super(session);

	}


	@Override
	public AlbumsPager findAlbum(String album) {
		log.info("begin findAlbum");
		log.info("album received:"+album);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		AlbumsPager albums = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_ALBUM_REST_URI.replaceAll(RestArtistUris.PARAM,album ));
		albums = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_ALBUM_REST_URI.replaceAll(RestArtistUris.PARAM,album ),AlbumsPager.class );
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findAlbum");
		return albums;
	}
	@Override
	public Album findAlbumBySpotifyId(String spotifyId) {
		log.info("begin findAlbumBySpotifyId");
		log.info("albumid received:"+spotifyId);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		Album album = null;
		try {
		log.info("URI:" + ControllerWs.URI+RestArtistUris.FIND_ALBUM_BY_SPOTIFYID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId ));
		album = restTemplate.getForObject( ControllerWs.URI+RestArtistUris.FIND_ALBUM_BY_SPOTIFYID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId ),Album.class );
		json = new Gson().toJson(album);
		log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end findAlbumBySpotifyId");
		return album;
	}


	@Override
	public Page<TrackSimple> findTracksOfAlbumId(String spotifyId) {
		log.info("begin findTracksOfAlbumId");
		log.info("albumid received: "+spotifyId);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		ParameterizedTypeReference<Page<TrackSimple>> responseType = 
				new ParameterizedTypeReference<Page<TrackSimple>>() {
		  };
		  log.info("rest uti:"+ControllerWs.URI+RestArtistUris.FIND_TRACKS_OF_ALBUMID_REST_URI.
				  replaceAll(RestArtistUris.PARAM,spotifyId ));
		  ResponseEntity<Page<TrackSimple>> result = restTemplate.
				  exchange(ControllerWs.URI+RestArtistUris.FIND_TRACKS_OF_ALBUMID_REST_URI.replaceAll(RestArtistUris.PARAM,spotifyId), HttpMethod.GET, null, responseType);
		 Page<TrackSimple> resulList = result.getBody();
		 json = new Gson().toJson(resulList);
		 log.info("rest response:" + json);		 
		 log.info("end findTracksOfAlbumId");
		return resulList;
	}

}
