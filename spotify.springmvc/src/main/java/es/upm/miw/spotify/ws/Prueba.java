package es.upm.miw.spotify.ws;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.spotify.models.entities.User;
import es.upm.miw.spotify.controllers.ws.ControllerWs;
import es.upm.miw.spotify.models.pojos.Artists;
import es.upm.miw.spotify.models.utils.Encript;

public class Prueba {

	public static void main(String[] args) throws RestClientException, JsonGenerationException, JsonMappingException, IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = new RestTemplate();
		/*String ppp=restTemplate.getForObject(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI.replaceAll(RestArtistUris.PARAM, URLEncoder.encode("pink floyd", "UTF-8")),String.class);
		System.out.println(ppp);
		 System.out.println("aaa");
		 Artists page = new Gson().fromJson(ppp, Artists.class);*/
		// System.out.println(page.getArtists().getItems().size());
		
		 Encript e = new Encript();
		 System.out.println(e.encriptacion("*u1*"));
		 System.out.println(e.encriptacion("*u2*"));
		 
		 
		
		
			List<User> resulList = new ArrayList<User>();
			String json = "{}";
			ParameterizedTypeReference<List<User>> responseType = new ParameterizedTypeReference<List<User>>() {
			  };
			  try {
			  ResponseEntity<List<User>> result = restTemplate.exchange((ControllerWs.URI+RestArtistUris.SHOW_USERS_ALL)
						, HttpMethod.GET, null, responseType);
			 resulList = result.getBody();
			  json = new Gson().toJson(resulList);
			System.out.println(json);
			  } catch (Exception e1) {
				 
			}
			
		 
	}

}
