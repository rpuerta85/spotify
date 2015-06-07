package es.upm.miw.spotify.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.gson.Gson;

import es.upm.miw.spotify.models.pojos.Role;
import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.models.utils.SecurityConstants;
import es.upm.miw.spotify.security.models.WebUserDetails;

public class WebUserDetailsService implements UserDetailsService {

	private static final Logger log = LoggerFactory
			.getLogger(WebUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(final String login)
			throws UsernameNotFoundException, DataAccessException {

		return null;
	}

	private Collection<GrantedAuthority> buildAuthorities(final UserWeb user) {
		final Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role :user.getUserRoles()){
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		/*authorities.add(new SimpleGrantedAuthority(
				SecurityConstants.Roles.ROLE_USER));*/

		return authorities;
	}

	public WebUserDetails createUserFromJsonResponse(final UserWeb user) {
		final WebUserDetails userDetails = new WebUserDetails(user,
				buildAuthorities(user));
		return userDetails;
	}

}
