package es.upm.miw.spotify.controllers.ws;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import es.upm.miw.spotify.view.beans.SessionBean;
@Component
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

	
	@Value("${findArtistView.panel.header.title}")
	private String url2;
	@Autowired
	org.springframework.core.env.Environment env;
	
	protected ControllerWs(SessionBean session) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+url2);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+env);

		this.session = session;
	}
	@PostConstruct
	public void init(){
		System.out.println("url2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+url2);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+env);

		
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
