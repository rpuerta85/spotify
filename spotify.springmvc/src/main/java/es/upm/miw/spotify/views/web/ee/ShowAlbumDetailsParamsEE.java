package es.upm.miw.spotify.views.web.ee;

public enum ShowAlbumDetailsParamsEE {
	
	SHOW_ALBUM_DETAILS_URL ("showAlbumDetailsUrl"),JSON_TRACKS("jsonTracks"),
	CHANGE_FAVORITE_ALBUM_STATE("changeFavoriteAlbumState"),
	JSON_ALBUMS("jsonAlbumes");
	
	private String v;

	private ShowAlbumDetailsParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
