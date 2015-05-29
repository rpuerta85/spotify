package es.upm.miw.spotify.controllers.ws;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;

@Service("servicio")
public class WsApacheManager {
	private static final Logger logger = LogManager.getLogger(WsApacheManager.class);


	protected HttpClient client;
	protected HttpResponse responseApache;
	protected HttpEntityEnclosingRequestBase httpMethod;
	
	@Value("${homeView.jumbotron.button.more.name}")
	private String urii;
	@Autowired
	private HomeViewPropertiesManager ppp;
	// private HttpRequestBase httpMethodForGetRequest;
	@PostConstruct
	public void init(){
	System.out.println("INITTTTTT"+ppp);	
	System.out.println("INITTTTTT"+urii);
	}
	
	public WsApacheManager(String userName, String password) {
		final CredentialsProvider cp = new BasicCredentialsProvider();
		final UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
				userName, password);
		final AuthScope scope = new AuthScope(ControllerWs.HOST,
				ControllerWs.PORT);
		cp.setCredentials(scope, credentials);
		client = HttpClientBuilder.create().setDefaultCredentialsProvider(cp)
				.build();
	}

	public WsApacheManager() {
		client = HttpClientBuilder.create().build();
		System.out.println(">>>>>>>>>>>>>>>>>>>>"+urii);
		System.out.println(">>>>>>>>>>>>>>>>>>>>"+ppp);
	}

	public String getJsonResponse() throws Exception {
		String json = "";
		json = new BasicResponseHandler().handleResponse(responseApache);
		return json;
	}

	protected void execute() throws ClientProtocolException, IOException {
		responseApache = client.execute(httpMethod);
	}
	private URIBuilder getUriBuilder(String uri,Map<String, String> params) throws URISyntaxException{
		logger.info("URI:"+uri);
		URIBuilder builder = new URIBuilder(uri);
		if (params != null) {
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				logger.debug("seting get query params");
				String key = it.next();
				logger.debug("param:"+key+"-"+params.get(key));

				builder.setParameter(key, params.get(key));
			}
		}
		return builder;
	}
	
	public boolean get(String uri, Map<String, String> params) {
		logger.debug("begin http get");
		try {
			URIBuilder builder =getUriBuilder(uri, params);
			URI uriAux;
			logger.debug("building the uri");
			uriAux = builder.build();
			HttpGet httpget = new HttpGet(uriAux);
			logger.debug("httpget URI:" + uriAux);
			responseApache = client.execute(httpget);
		} catch (URISyntaxException e) {
			logger.debug("error in get http method:", e.getMessage());
		} catch (IOException e) {
			logger.debug("error in get http method:", e);
		}
		logger.debug("end http get");
		return ok();

	}
	public boolean get(String uri) {
		return get(uri, null);

	}

	public boolean delete(String uri, Map<String, String> headers)
			throws Exception {
		logger.debug("begin http delete");
		HttpDelete httpDelete = new HttpDelete(uri);
		responseApache = client.execute(httpDelete);
		logger.debug("end http delete");
		return ok();
	}

	public boolean post(String uri, Object entity, Map<String, String> headers)
			throws Exception {
		httpMethod = new HttpPost(uri);
		StringEntity se;
		logger.debug("JSON entuty in POST request:"
				+ ObjectMapperJacksonSingleton.getInstance().getObjectMapper()
						.writeValueAsString(entity));
		se = new StringEntity(new ObjectMapper().writeValueAsString(entity));
		httpMethod.setEntity(se);
		setHeaders(headers);
		execute();
		return ok();
	}

	public boolean post(String uri, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		httpMethod = new HttpPost(uri);
		setHeaders(headers);
		execute();
		return ok();
	}

	protected void setHeaders(Map<String, String> headers) {
		if (headers != null) {
			Iterator<String> it = headers.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				this.httpMethod.setHeader(key, headers.get(key));
			}
		}
	}

	protected boolean ok() {
		boolean ok = false;
		final int statusCode = responseApache.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK
				|| statusCode == HttpStatus.SC_NO_CONTENT) {
			logger.debug("response ok :", HttpStatus.SC_OK);
			ok = true;
		} else {
			logger.debug("response no ok:", statusCode);
		}
		return ok;
	}

	public int getResponseStatusCode() {
		final int statusCode = responseApache.getStatusLine().getStatusCode();
		return statusCode;
	}

	public HttpEntityEnclosingRequestBase getHttpMethod() {
		return httpMethod;
	}

	public String getUrii() {
		return urii;
	}

	public void setUrii(String urii) {
		this.urii = urii;
	}

	public HomeViewPropertiesManager getPpp() {
		return ppp;
	}

	public void setPpp(HomeViewPropertiesManager ppp) {
		this.ppp = ppp;
	}

}
