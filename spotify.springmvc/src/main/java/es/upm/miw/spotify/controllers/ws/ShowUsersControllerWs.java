package es.upm.miw.spotify.controllers.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.spotify.models.entities.User;
import es.upm.miw.spotify.controllers.ShowUsersController;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.TrackSimple;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class ShowUsersControllerWs extends ControllerWs implements
		ShowUsersController {
	private static final Logger log = LogManager.getLogger(ShowUsersControllerWs.class);


	public ShowUsersControllerWs(SessionBean session) {
		super(session);

	}

	@Override
	public List<User> showUsersAll() {
		log.info("begin showUsersAll");
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(ControllerWs.URI+RestArtistUris.SHOW_USERS_ALL, User[].class);
		User[] resulList =responseEntity.getBody();
		List<User> resulList2= new ArrayList<User>();
		resulList2 = Arrays.asList(resulList);
		/*ParameterizedTypeReference<List<User>> responseType = 
				new ParameterizedTypeReference<List<User>>() {
		  };
		  log.info("rest uti:"+ControllerWs.URI+RestArtistUris.SHOW_USERS_ALL);
		  ResponseEntity<List<User>> result = restTemplate.
				  exchange(ControllerWs.URI+RestArtistUris.SHOW_USERS_ALL, HttpMethod.GET, null, responseType);
		  List<User> resulList = result.getBody();
		 json = new Gson().toJson(resulList);*/
		 log.info("rest response:" + json);		 
		log.debug("end showUsersAll");
		return resulList2;
	}

	
}
