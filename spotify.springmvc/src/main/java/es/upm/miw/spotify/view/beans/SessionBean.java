package es.upm.miw.spotify.view.beans;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 6802589690326067836L;
	
	private User user;
	

	public static final String NAME = "sessionBean";

	public SessionBean() {
		user = null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static String getName() {
		return NAME;
	}

	
	
}
