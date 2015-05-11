package es.upm.miw.spotify.views.web.ee;

public enum HomeViewParamsEE {
	BUTTON_FIND_ARTIST_URL("buttonFindArtistUrl");
	private String v;

	private HomeViewParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
