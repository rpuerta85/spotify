package es.upm.miw.spotify.controllers.ws;

import java.util.Date;





















import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import es.spotify.models.entities.User;
import es.upm.miw.spotify.controllers.DeleteUserController;
import es.upm.miw.spotify.controllers.NewUserController;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Role;
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.models.utils.Encript;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class DeleteUserControllerControllerWS extends ControllerWs implements DeleteUserController{
	private static final Logger log = LogManager.getLogger(DeleteUserControllerControllerWS.class);
	public DeleteUserControllerControllerWS(SessionBean session) {
		super(session);
	}


	@Override
	public void deleteUser(String userUUIDToDelete) {
		
		log.info("begin deleteUser");
		log.info("data for deleteUser  received: user:"+userUUIDToDelete);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		User user = null;
		try {
			String  stringURL= RestArtistUris.DELETE_USER_REST_URI;
			UserPojo userP = new UserPojo();
 
    		userP.setIdUUID(userUUIDToDelete);
    		restTemplate.postForObject(ControllerWs.URI+stringURL,userP , String.class);
			log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end  deleteUser");
		
	}



}
