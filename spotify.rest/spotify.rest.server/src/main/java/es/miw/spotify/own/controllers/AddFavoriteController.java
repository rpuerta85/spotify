package es.miw.spotify.own.controllers;

import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.User;

public interface AddFavoriteController {
	 public void add(Favorite favorite, User user);
}
