package es.upm.miw.spotify.ws;

import java.io.IOException;
import java.net.URLEncoder;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import es.upm.miw.spotify.controllers.ws.ControllerWs;
import es.upm.miw.spotify.models.pojos.Artists;

public class Prueba {

	public static void main(String[] args) throws RestClientException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = new RestTemplate();
		String ppp=restTemplate.getForObject(ControllerWs.URI+RestArtistUris.FIND_ARTIST_REST_URI.replaceAll(RestArtistUris.PARAM, URLEncoder.encode("pink floyd", "UTF-8")),String.class);
		System.out.println(ppp);
		 System.out.println("aaa");
		 Artists page = new Gson().fromJson(ppp, Artists.class);
		 System.out.println(page.getArtists().getItems().size());
		
	}

}
