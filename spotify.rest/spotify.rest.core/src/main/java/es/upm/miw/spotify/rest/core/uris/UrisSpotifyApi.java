package es.upm.miw.spotify.rest.core.uris;

public interface UrisSpotifyApi {
	String PARAM = "#param#";
	String TYPE = "type";
	String MARKET = "market=ES";
	String SEARCH = "search?q=";
	String FIND_ARTIST_BY_NAME = SEARCH+PARAM+"&"+TYPE+"=artist&"+MARKET;
	String FIND_ALBUM_BY_NAME = SEARCH+PARAM+"&"+TYPE+"=album&"+MARKET;
	String FIND_TRACK_BY_NAME = SEARCH+PARAM+"&"+TYPE+"=track&"+MARKET;
	String FIND_ARTIST_BY_ID = "artists/"+PARAM;
	
}
