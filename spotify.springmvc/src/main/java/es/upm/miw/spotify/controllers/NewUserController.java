package es.upm.miw.spotify.controllers;

public interface NewUserController {

	void newUser(String userName,String password, String email, boolean isEnabled,
			 long date, boolean isAdmin);

}
