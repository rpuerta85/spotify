package es.upm.miw.spotify.controllers.ws;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import es.upm.miw.spotify.rest.client.config.RestConfig;
import es.upm.miw.spotify.view.beans.SessionBean;

public abstract class ControllerWs {

	protected SessionBean session = null;

	public static final String PROTOCOL = "http";

	public static final String HOST = "localhost";

	public static final int PORT = 9080;

	public static final String WEB = "/api/";

	public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT+ WEB;

	private static final Logger log = LogManager.getLogger(ControllerWs.class);
	
	protected boolean operationSuccess = false;
	//protected static String URI2;

	protected ControllerWs(SessionBean session) {
		this.session = session;
	}

	protected SessionBean getSession() {
		return session;
	}

	protected static RestTemplate buildRestClient() {
		log.info("buildRestClient : "+URI);
		return new RestTemplate();
	}
	
	protected static WsApacheManager buildWebServiceManager() {
		log.info("buildWebServiceManager : ", URI.toString());
		return new WsApacheManager();
	}
	
	protected String replaceParamUriForValue(String uri,String regex,String replacement) throws UnsupportedEncodingException {
		return uri.replaceAll(regex, URLEncoder.encode(replacement, "UTF-8"));
	}

}
