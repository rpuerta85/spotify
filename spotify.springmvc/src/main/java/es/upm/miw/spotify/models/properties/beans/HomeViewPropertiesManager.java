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

	
	
	

}
