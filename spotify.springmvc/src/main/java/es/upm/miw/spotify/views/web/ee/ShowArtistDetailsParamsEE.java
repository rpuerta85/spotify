package es.upm.miw.spotify.views.web.ee;

public enum ShowArtistDetailsParamsEE {
	
	JSON_ARTISTS("jsonArtists"),SHOW_ARTIST_DETAILS_URL ("showArtistDetailsUrl"),JSON_ALBUMES("jsonAlbumes"),
	CHANGE_FAVORITE_ARTIST_STATE("changeFavoriteArtistState");
	
	private String v;

	private ShowArtistDetailsParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
