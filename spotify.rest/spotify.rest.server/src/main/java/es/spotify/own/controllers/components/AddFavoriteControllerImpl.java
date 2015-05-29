package es.spotify.own.controllers.components;

import org.springframework.stereotype.Component;

import es.miw.spotify.own.controllers.AddFavoriteController;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.User;

@Component
public class AddFavoriteControllerImpl implements AddFavoriteController {

	@Override
	public void add(Favorite favorite, User user) {
		

	}

}
