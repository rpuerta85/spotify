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
import es.upm.miw.spotify.controllers.NewUserController;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Role;
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.models.utils.Encript;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.ws.RestArtistUris;

public class NewUserControllerControllerWS extends ControllerWs implements NewUserController{
	private static final Logger log = LogManager.getLogger(NewUserControllerControllerWS.class);
	public NewUserControllerControllerWS(SessionBean session) {
		super(session);
	}


	@Override
	public void newUser(String userName, String password, String email,
			boolean isEnabled, long date, boolean isAdmin) {
		
		log.info("begin newUser");
		log.info("data for newUser  received: user:"+userName + password +email + isEnabled + date, isAdmin);
		RestTemplate restTemplate = ControllerWs.buildRestClient();
		String json = "{}";
		User user = null;
		try {
			String  stringURL= RestArtistUris.NEW_USER_REST_URI;
			//   stringURL= stringURL.replaceAll(RestArtistUris.PARAM2, userUUID);
//			 MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//			   map.add("userName", userName);
//			   map.add("password", password);
//			   map.add("email", email);
//			   map.add("isEnabled", String.valueOf(isEnabled));
//			   map.add("date", String.valueOf(date));
//			   map.add("isAdmin", String.valueOf(isAdmin));
//			log.info("URI:" + ControllerWs.URI+stringURL);
//			HttpHeaders requestHeaders = new HttpHeaders();
//			requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
//			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, requestHeaders);
//			ResponseEntity<String> response = restTemplate.exchange(ControllerWs.URI+stringURL, HttpMethod.POST, requestEntity, String.class);
			UserPojo userP = new UserPojo();
			Encript e = new Encript();
			userP.setUserName(userName);
			userP.setPassword(e.encriptacion(password));
			userP.setEmail(email);
			userP.setAdmin(isAdmin);
			userP.setEnabled(isEnabled);
			userP.setCreateTime2(date);
						
			restTemplate.postForObject(ControllerWs.URI+stringURL,userP , String.class);
			//InstagramResult result = response.getBody();
			
			//restTemplate.postForObject(ControllerWs.URI+stringURL,map , String.class);
			log.info("rest response:" + json);
		} catch (Exception e) {
			log.error("error response", e);
		}
		log.debug("end changeFavoriteAlbumState");
		
	}



}
