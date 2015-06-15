package es.upm.miw.spotify.controllers.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import es.upm.miw.spotify.controllers.ShowUsersController;
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class ShowUsersControllerWs extends ControllerWs implements
		ShowUsersController {
	private static final Logger log = LogManager.getLogger(ShowUsersControllerWs.class);


	public ShowUsersControllerWs(SessionBean session) {
		super(session);

	}

	@Override
	public List<UserPojo> showUsersAll() {
		log.info("begin showUsersAll");
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		 log.info("rest uti:"+ControllerWs.URI+RestArtistUris.SHOW_USERS_ALL);
		ResponseEntity<UserPojo[]> responseEntity = restTemplate.getForEntity(ControllerWs.URI+RestArtistUris.SHOW_USERS_ALL, UserPojo[].class);
		UserPojo[] resulList =responseEntity.getBody();
		List<UserPojo> resulList2= new ArrayList<UserPojo>();
		resulList2 = Arrays.asList(resulList);		
		json = new Gson().toJson(resulList2);
		log.info("rest response:" + json);		 
		log.debug("end showUsersAll");
		return resulList2;
	}

	
}
