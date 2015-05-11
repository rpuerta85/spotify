package es.upm.miw.spotify.views.web.ee;


public enum ShowArtistsViewParamsEE {
	
	JSON_ARTISTS("jsonArtists");
	private String v;

	private ShowArtistsViewParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
