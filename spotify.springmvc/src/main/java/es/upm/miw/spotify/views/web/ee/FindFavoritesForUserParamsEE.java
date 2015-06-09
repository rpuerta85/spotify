package es.upm.miw.spotify.views.web.ee;

public enum FindFavoritesForUserParamsEE {
	
	FIND_FAVORITE_TEXT("favoriteText"), FIND_FAVORITES_MSG_ERROR("favoritesError");
	
	private String v;

	private FindFavoritesForUserParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
