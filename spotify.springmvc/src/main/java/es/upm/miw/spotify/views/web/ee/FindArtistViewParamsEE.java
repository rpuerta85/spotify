package es.upm.miw.spotify.views.web.ee;


public enum FindArtistViewParamsEE {
	
	FORM_FIND_ARTIST_LABEL_VALUE("formFindArtistLabelValue"),
	FORM_FIND_ARTIST_INPUTTEXT_PLACEHOLDER("formFindArtistInputTextPlaceholder"),
	FORM_FIND_ARTIST_BUTTON_SUBMIT_NAME("formFindArtistButtonSubmitName"),
	FORM_FIND_ARTIST_ARTIST_NAME_MSG_ERROR("formFindArtistArtistNameMsgError");
	
	
	private String v;

	private FindArtistViewParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
