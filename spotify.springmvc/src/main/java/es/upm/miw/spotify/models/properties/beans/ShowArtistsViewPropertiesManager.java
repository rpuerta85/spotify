package es.upm.miw.spotify.models.properties.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShowArtistsViewPropertiesManager {
	@Value("${showArtistsView.panel.header.title}")
	private String findArtistViewPanelHeaderTitle;
	@Value("${showArtistsView.panel.header.subtitle}")
	private String findArtistViewPanelHeaderSubtitle;
	@Value("${showArtistsView.panel.header.description}")
	private String findArtistViewPanelHeaderDescription;
	
	public String getFindArtistViewPanelHeaderTitle() {
		return findArtistViewPanelHeaderTitle;
	}
	public void setFindArtistViewPanelHeaderTitle(
			String findArtistViewPanelHeaderTitle) {
		this.findArtistViewPanelHeaderTitle = findArtistViewPanelHeaderTitle;
	}
	public String getFindArtistViewPanelHeaderSubtitle() {
		return findArtistViewPanelHeaderSubtitle;
	}
	public void setFindArtistViewPanelHeaderSubtitle(
			String findArtistViewPanelHeaderSubtitle) {
		this.findArtistViewPanelHeaderSubtitle = findArtistViewPanelHeaderSubtitle;
	}
	public String getFindArtistViewPanelHeaderDescription() {
		return findArtistViewPanelHeaderDescription;
	}
	public void setFindArtistViewPanelHeaderDescription(
			String findArtistViewPanelHeaderDescription) {
		this.findArtistViewPanelHeaderDescription = findArtistViewPanelHeaderDescription;
	}
	
	
	
	
	

}
