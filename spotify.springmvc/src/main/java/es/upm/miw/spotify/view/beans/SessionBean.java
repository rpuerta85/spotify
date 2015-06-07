package es.upm.miw.spotify.view.beans;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import es.upm.miw.spotify.models.pojos.UserWeb;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 6802589690326067836L;
	
	private UserWeb userWeb;
	

	public static final String NAME = "sessionBean";

	
	public UserWeb getUserWeb() {
		return userWeb;
	}


	public void setUserWeb(UserWeb userWeb) {
		this.userWeb = userWeb;
	}


	public static String getName() {
		return NAME;
	}

	
	
}
