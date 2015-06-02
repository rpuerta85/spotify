package es.upm.miw.spotify.rest.core.uris;


public interface UrisWebApp {
	String FIND_ARTIST_BY_NAME = "/find/artist";
	String FIND_ALBUM_BY_NAME = "/find/album";
	String FIND_TRACK_BY_NAME = "/find/track";
	String FIND_ARTIST_BY_SPOTIFYID = "/find/artist/{id}";
	String FIND_ALBUMES_OF_ARTISTID_REST_URI = "/find/artist/{id}/albumes";
	String FIND_ALBUM_BY_SPOTIFYID = "/find/album/{id}";
	String FIND_TRACKS_OF_ALBUM_REST_URI = "/find/album/{id}/tracks";
	String ADD_FAVORITE_ARTIST="/add/favorite/artist";
	String FIND_FAVORITE_ALBUMS = "/find/favorites/albums";
}
