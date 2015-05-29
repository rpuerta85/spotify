package es.upm.miw.spotify.ws;

import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;

public interface RestArtistUris {
	String PARAM = "#param#";
	String FIND_ARTIST_REST_URI = "find/artist?artistName="+PARAM;
	String FIND_ALBUM_REST_URI = "find/album?albumName="+PARAM;
	String FIND_TRACK_REST_URI = "find/track?trackName="+PARAM;
	String FIND_ARTIST_BY_SPOTIFYID_REST_URI = "find/artist/"+PARAM;
	String FIND_ALBUMES_OF_ARTISTID_REST_URI = "find/artist/"+PARAM+"/albumes?limit="+UrisSpotifyApi.LIMIT_PARAM;
	String FIND_ALBUM_BY_SPOTIFYID_REST_URI = "find/album/"+PARAM;
	String FIND_TRACKS_OF_ALBUMID_REST_URI = "find/album/"+PARAM+"/tracks";

}
