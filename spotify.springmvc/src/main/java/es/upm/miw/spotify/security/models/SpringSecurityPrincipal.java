package es.upm.miw.spotify.security.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import es.upm.miw.spotify.models.pojos.UserWeb;

public final class SpringSecurityPrincipal extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393029192403971335L;
	private final String uuid;
	private UserWeb userWeb;

	public SpringSecurityPrincipal(UserWeb userWeb, final String username,
			final String password, final boolean enabled,
			final Collection<? extends GrantedAuthority> authorities,
			final String uuidToSet) {
		super(username, password, enabled, true, true, true, authorities);

		uuid = uuidToSet;
		this.userWeb = userWeb;
	}

	// API

	public final String getUuid() {
		return uuid;
	}

	public UserWeb getUserWeb() {
		return userWeb;
	}

	public void setUserWeb(UserWeb userWeb) {
		this.userWeb = userWeb;
	}

}
