package es.upm.miw.spotify.controllers;

import java.util.List;
import es.upm.miw.spotify.models.pojos.UserPojo;

public interface ShowUsersController {
	List<UserPojo> showUsersAll();
}
