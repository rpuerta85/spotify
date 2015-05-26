package es.upm.miw.spotify.ws;

public interface RestArtistUris {
	String PARAM = "#param#";
	String FIND_ARTIST_REST_URI = "find/artist?artistName="+PARAM;
	String FIND_ALBUM_REST_URI = "find/album?albumName="+PARAM;
	String FIND_TRACK_REST_URI = "find/track?trackName="+PARAM;

	

}
