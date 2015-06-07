package es.upm.miw.spotify.security.models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.upm.miw.spotify.models.pojos.UserWeb;

public class WebUserDetails implements UserDetails {
	private static final long serialVersionUID = 340910985613023659L;
	private UserWeb user;
	private final Collection<GrantedAuthority> authorities;

	public WebUserDetails() {
		user = null;
		authorities = null;
	}

	public WebUserDetails(final UserWeb newUser,
			final Collection<? extends GrantedAuthority> newAuthorities) {
		user = newUser;
		if (newAuthorities != null)
			authorities = Collections.unmodifiableCollection(newAuthorities);
		else
			authorities = null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		if (user == null)
			return null;

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		if (user == null)
			return null;

		return user.getUserName();
	}

	public void setUser(UserWeb user) {
		this.user = user;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public UserWeb getUserWeb() {
		return user;
	}

	@Override
	public String toString() {
		return "" + user;
	}
}
