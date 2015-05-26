package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import es.upm.miw.spotify.controllers.FindAlbumController;
import es.upm.miw.spotify.models.pojos.Albums;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
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


}
