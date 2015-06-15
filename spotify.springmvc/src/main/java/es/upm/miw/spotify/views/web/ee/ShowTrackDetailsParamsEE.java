package es.upm.miw.spotify.views.web.ee;

public enum ShowTrackDetailsParamsEE {
	
	JSON_TRACKS("jsonTracks"),SHOW_TRACK_DETAILS_URL ("showTrackDetailsUrl"),JSON_ALBUMES("jsonAlbumes"),
	FAVORITE_NAME("favoriteName"), CHANGE_FAVORITE_TRACK_STATE("changeFavoriteTrackState");
	
	private String v;

	private ShowTrackDetailsParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
