package es.upm.miw.spotify.models.properties.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FindArtistViewPropertiesManager {
	//Estas propiedades estan definidas en los archivos properties de internacionalizacion,
	//los inyecta Spring aqui en estos atributos
	@Value("${findArtistView.panel.header.title}")
	private String findArtistViewPanelHeaderTitle;
	@Value("${findArtistView.panel.header.subtitle}")
	private String findArtistViewPanelHeaderSubtitle;
	@Value("${findArtistView.panel.header.description}")
	private String findArtistViewPanelHeaderDescription;
	@Value("${findArtistView.form.find.artist.label.value}")
	private String findArtistViewFormFindArtistLabelValue;
	@Value("${findArtistView.form.find.artist.inputtext.placeholder}")
	private String findArtistViewFormFindArtistInputTextPlaceholder;
	@Value("${findArtistView.form.find.artist.button.submit.name}")
	private String findArtistViewFormFindArtistButtonSubmitName;
	@Value("${findArtistView.form.find.artist.msg.error.value}")
	private String findArtistViewFormFindArtistMsgErrorValue;
	
	
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
	public String getFindArtistViewFormFindArtistLabelValue() {
		return findArtistViewFormFindArtistLabelValue;
	}
	public void setFindArtistViewFormFindArtistLabelValue(
			String findArtistViewFormFindArtistLabelValue) {
		this.findArtistViewFormFindArtistLabelValue = findArtistViewFormFindArtistLabelValue;
	}
	public String getFindArtistViewFormFindArtistInputTextPlaceholder() {
		return findArtistViewFormFindArtistInputTextPlaceholder;
	}
	public void setFindArtistViewFormFindArtistInputTextPlaceholder(
			String findArtistViewFormFindArtistInputTextPlaceholder) {
		this.findArtistViewFormFindArtistInputTextPlaceholder = findArtistViewFormFindArtistInputTextPlaceholder;
	}
	public String getFindArtistViewFormFindArtistButtonSubmitName() {
		return findArtistViewFormFindArtistButtonSubmitName;
	}
	public void setFindArtistViewFormFindArtistButtonSubmitName(
			String findArtistViewFormFindArtistButtonSubmitName) {
		this.findArtistViewFormFindArtistButtonSubmitName = findArtistViewFormFindArtistButtonSubmitName;
	}
	public String getFindArtistViewFormFindArtistMsgErrorValue() {
		return findArtistViewFormFindArtistMsgErrorValue;
	}
	public void setFindArtistViewFormFindArtistMsgErrorValue(
			String findArtistViewFormFindArtistMsgErrorValue) {
		this.findArtistViewFormFindArtistMsgErrorValue = findArtistViewFormFindArtistMsgErrorValue;
	}

	
	
	

}
