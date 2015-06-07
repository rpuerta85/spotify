package es.upm.miw.spotify.models.properties.beans;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomeViewPropertiesManager {
	@Value("${homeView.jumbotron.button.more.name}")
	private String buttonMoreName;
	@Value("#{'${homeView.jumbotron.headerTitle.name}'.split(',')}")
	private List<String> jumbotronHeaderTitleList;
	@Value("${restServer.name}")
	private String restServerName;
	@Value("${restServer.port}")
	private String restServerPort;
	@Value("${restServer.protocol}")
	private String restServerProtocol;
	@Value("${restServer.context}")
	private String restServerContext;
	@Value("${restServer.uri}")
	private String restServerUri;
	@Value("${rest.url.login}")
	private String restUrlLogin;

	
	
	public String getButtonMoreName() {
		return buttonMoreName;
	}
	public void setButtonMoreName(String buttonMoreName) {
		this.buttonMoreName = buttonMoreName;
	}
	public List<String> getJumbotronHeaderTitleList() {
		return jumbotronHeaderTitleList;
	}
	public void setJumbotronHeaderTitleList(List<String> jumbotronHeaderTitleList) {
		this.jumbotronHeaderTitleList = jumbotronHeaderTitleList;
	}
	public String getRestServerName() {
		return restServerName;
	}
	public void setRestServerName(String restServerName) {
		this.restServerName = restServerName;
	}
	public String getRestServerPort() {
		return restServerPort;
	}
	public void setRestServerPort(String restServerPort) {
		this.restServerPort = restServerPort;
	}
	public String getRestServerProtocol() {
		return restServerProtocol;
	}
	public void setRestServerProtocol(String restServerProtocol) {
		this.restServerProtocol = restServerProtocol;
	}
	public String getRestServerContext() {
		return restServerContext;
	}
	public void setRestServerContext(String restServerContext) {
		this.restServerContext = restServerContext;
	}
	public String getRestServerUri() {
		return restServerUri;
	}
	public void setRestServerUri(String restServerUri) {
		this.restServerUri = restServerUri;
	}
	public String getRestUrlLogin() {
		return restUrlLogin;
	}
	public void setRestUrlLogin(String restUrlLogin) {
		this.restUrlLogin = restUrlLogin;
	}
	

	
	
	

}
