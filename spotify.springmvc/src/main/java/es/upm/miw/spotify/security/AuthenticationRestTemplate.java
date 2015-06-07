package es.upm.miw.spotify.security;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.models.utils.Encript;
import es.upm.miw.spotify.security.models.WebUserDetails;


@Component
public class AuthenticationRestTemplate {

	@Autowired(required = true)
	private HomeViewPropertiesManager homeViewPropertiesManager;
	private static int STATUS_CODE_OK = 200;

	private static final Logger log = LoggerFactory
			.getLogger(AuthenticationRestTemplate.class);

	public AuthenticationRestTemplate() {
		super();
	}

	public final ResponseEntity<WebUserDetails> authenticate(
			final String username, final String password) {
		ResponseEntity<WebUserDetails> result = null;
		result = authenticationRestService(username, password);
		return result;
	}

	private ResponseEntity<WebUserDetails> authenticationRestService(
			String userName, String password) {
		ResponseEntity<WebUserDetails> result = null;
		try {
			password = new Encript().MD5(password).toLowerCase();

			final CredentialsProvider cp = new BasicCredentialsProvider();
			final UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
					userName, password);
			final AuthScope scope = new AuthScope(
					homeViewPropertiesManager.getRestServerName(), Integer
							.valueOf(
									homeViewPropertiesManager
											.getRestServerPort()).intValue());
			cp.setCredentials(scope, credentials);
			final HttpClient client = HttpClientBuilder.create()
					.setDefaultCredentialsProvider(cp).build();
			HttpResponse responseApache = null;
			System.out.println("URL rest login:"
					+ homeViewPropertiesManager.getRestServerUri()
					+ homeViewPropertiesManager.getRestUrlLogin());
			log.info("URL rest login:"
					+ homeViewPropertiesManager.getRestServerUri()
					+ homeViewPropertiesManager.getRestUrlLogin());
			HttpPost httpPost = new HttpPost(homeViewPropertiesManager.getRestServerUri()
					+ homeViewPropertiesManager.getRestUrlLogin());
			
			List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			nvps.add(new BasicNameValuePair("userName", userName));
			nvps.add(new BasicNameValuePair("password", password));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			responseApache = client.execute(httpPost);

			final int statusCode = responseApache.getStatusLine()
					.getStatusCode();

			final Gson gson = new Gson();
			if (statusCode == STATUS_CODE_OK) {
				final String responseString = new BasicResponseHandler()
						.handleResponse(responseApache);
				final UserWeb user = gson.fromJson(responseString,
						UserWeb.class);
				user.setPassword(password);
				user.setUserName(userName);
				final WebUserDetailsService webUserDetailsService = new WebUserDetailsService();
				final WebUserDetails userDetails = webUserDetailsService
						.createUserFromJsonResponse(user);
				result = new ResponseEntity(userDetails, HttpStatus.OK);
				result.getBody().setUser(user);
				log.debug("User Authentication code:", HttpStatus.OK);
			} else {
				log.debug("User Authentication code:", HttpStatus.UNAUTHORIZED);
			}

		} catch (final ClientProtocolException e) {
			log.error("error in authenticationRestService.Username='"
					+ userName + "'", e);
		} catch (final IOException e) {
			log.error("error in authenticationRestService.Username='"
					+ userName + "'", e);
		} catch (NoSuchAlgorithmException e) {
			log.error("error in authenticationRestService.Username='"
					+ userName + "'", e);
			e.printStackTrace();
		}
		return result;
	}

  

}
