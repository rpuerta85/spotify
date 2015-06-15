package es.upm.miw.spotify.utils.constants;

public interface ViewUrlConstants {
	String IDPARAM="/{id}";
	String ROOT_PATH = "/";
	String HOME_VIEW_PATH = "/";
	String LOGOUT_VIEW_PATH = "logout";
	String FIND_ARTIST_PATH = "artist/find";
	String FIND_ALBUM_PATH = "album/find";
	String FIND_TRACK_PATH = "track/find";
	String SHOW_ARTIST_DETAILS_GETPATH = "artist/details";
	String SHOW_ARTIST_DETAILS_PATH=SHOW_ARTIST_DETAILS_GETPATH+IDPARAM;
	String SHOW_ALBUM_DETAILS_GETPATH = "album/details";
	String SHOW_DETAILS_DETAILS_PATH=SHOW_ALBUM_DETAILS_GETPATH+IDPARAM;
	String SHOW_TRACK_DETAILS_GETPATH = "track/details";
	String SHOW_TRACK_DETAILS_PATH=SHOW_TRACK_DETAILS_GETPATH+IDPARAM;
	String FIND_FAVORITES_ALBUM_PATH = "favorites/albums/find";
	String SHOW_USERS_REGISTERED_PATH = "user/show/all";
	String FIND_FAVORITES_ARTISTS_PATH = "favorites/artists/find";
	String FIND_FAVORITES_TRACKS_PATH = "favorites/tracks/find";
	String CHANGE_FAVORITE_ALBUM_STATE="album/favorite/change/state" + IDPARAM;
	String CHANGE_FAVORITE_ARTIST_STATE="artist/favorite/change/state"+ IDPARAM;
	String CHANGE_FAVORITE_TRACK_STATE="track/favorite/change/state" +IDPARAM;
	String NEW_USER_PATH = "user/new";
}
