package es.upm.miw.spotify.controllers.ws;

import java.util.Date;

import es.upm.miw.spotify.controllers.NewUserController;
import es.upm.miw.spotify.view.beans.SessionBean;

public class NewUserControllerControllerWS extends ControllerWs implements NewUserController{

	public NewUserControllerControllerWS(SessionBean session) {
		super(session);
	}

	@Override
	public void newUser(String userName, String email, Boolean enabled,
			String password, Date fecha) {
		
		
	}

}
