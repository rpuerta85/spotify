package es.upm.miw.spotify.views.web.ee;

import es.upm.miw.spotify.utils.constants.ViewUrlConstants;


public enum ShowArtistDetailsParamsEE {
	
	JSON_ARTISTS("jsonArtists"),SHOW_ARTIST_DETAILS_URL ("showArtistDetailsUrl") ;
	private String v;

	private ShowArtistDetailsParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
