package es.spotify.own.controllers.components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.miw.spotify.own.controllers.AddFavoriteArtistController;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;


@RestController
public class AddFavoriteArtistControllerRest implements AddFavoriteArtistController {
	 private final static Log LOG = LogFactory
				.getLog(AddFavoriteArtistControllerRest.class);
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
	@RequestMapping(UrisWebApp.ADD_FAVORITE_ARTIST)
	@Override
	public void add(@PathVariable("favorite") Favorite favorite, @PathVariable("favorite") User user) {
		// validar si el usuario está loggeado
		   // validar si la combinacion favorito usuario NO  existe
		     // sisi
		        // invocar la capa dao para guardar la combinacion user favorito

	}

}
