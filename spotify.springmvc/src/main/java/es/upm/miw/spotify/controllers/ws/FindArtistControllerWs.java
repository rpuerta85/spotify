package es.upm.miw.spotify.controllers.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.upm.miw.spotify.controllers.FindArtistController;
import es.upm.miw.spotify.models.pojos.Artist;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class FindArtistControllerWs extends ControllerWs implements
		FindArtistController {
	private static final Logger log = LogManager.getLogger(FindArtistControllerWs.class);


	public FindArtistControllerWs(SessionBean session) {
		super(session);

	}


	@Override
	public String findArtistJSON(String artist) {
		log.info("begin findArtistJSON");
		log.info("artist received:"+artist);
		WsApacheManager wsApacheManager = ControllerWs.buildWebServiceManager();
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		
		System.out.println();
		String json = "{}";
		try {
		//Page<Artist> page =  restTemplate.post(replaceParamUriForValue(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI, RestArtistUris.PARAM, artist), Page.class);
		System.out.println(replaceParamUriForValue(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI, RestArtistUris.PARAM, artist));
		//System.out.println(">>>>>>>"+new Gson().toJson(page));
		//wsApacheManager.get(replaceParamUriForValue(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI, RestArtistUris.PARAM, artist));
			//log.info("find artist ws URI:" + replaceParamUriForValue(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI,
				//	RestArtistUris.PARAM, artist));
			json = wsApacheManager.getJsonResponse();
			//log.info("rest response:" + json);
			
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end creating channel");
		return json;
	}

	

}
