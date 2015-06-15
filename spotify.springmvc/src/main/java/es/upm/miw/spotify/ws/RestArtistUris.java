package es.upm.miw.spotify.ws;

import org.springframework.web.bind.annotation.RequestParam;

import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;

public interface RestArtistUris {
	String PARAM = "#param#";
	String PARAM2 = "#param2#";
	String FIND_ARTIST_REST_URI = "find/artist?artistName="+PARAM;
	String FIND_ALBUM_REST_URI = "find/album?albumName="+PARAM;
	String FIND_TRACK_REST_URI = "find/track?trackName="+PARAM;
	String FIND_ARTIST_BY_SPOTIFYID_REST_URI = "find/artist/"+PARAM;
	String FIND_ALBUMES_OF_ARTISTID_REST_URI = "find/artist/"+PARAM+"/albumes?limit="+UrisSpotifyApi.LIMIT_PARAM;
	String FIND_ALBUM_BY_SPOTIFYID_REST_URI = "find/album/"+PARAM;
	String FIND_TRACKS_OF_ALBUMID_REST_URI = "find/album/"+PARAM+"/tracks";
	String FIND_TRACK_BY_SPOTIFYID_REST_URI = "find/track/"+PARAM;
	String FIND_FAVORITES_ALBUMS_REST_URI = "find/favorites/albums?userUUID="+PARAM;
	String FIND_FAVORITES_ARTISTS_REST_URI = "find/favorites/artists?userUUID="+PARAM; 
	String FIND_FAVORITES_TRACKS_REST_URI = "find/favorites/tracks?userUUID="+PARAM;
	
	String SHOW_USERS_ALL="user/show/all";
	String CHANGE_ALBUM_FAVORITE_STATE = "change/favorite/album/state?favoriteId=" +PARAM +"&userUUID="+ PARAM2;
	String CHANGE_ARTIST_FAVORITE_STATE = "change/favorite/artist/state?favoriteId=" +PARAM +"&userUUID="+ PARAM2;
	String CHANGE_TRACK_FAVORITE_STATE = "change/favorite/track/state?favoriteId=" +PARAM +"&userUUID="+ PARAM2;



}
