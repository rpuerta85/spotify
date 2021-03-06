
package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.TrackSimple;

public interface FindAlbumController {
	AlbumsPager findAlbum(String album);
	Album findAlbumBySpotifyId(String spotifyId);
	Page<TrackSimple> findTracksOfAlbumId(String spotifyId);
}
