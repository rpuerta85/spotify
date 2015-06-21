package es.upm.miw.spotify.controllers;

import java.util.Date;

public interface NewUserController {

	void newUser(String userName, String email, Boolean enabled,
			String password, Date fecha);
	
	// armar para conectar con el api Rest...
	

}
