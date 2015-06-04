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


}
