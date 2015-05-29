package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.Artist;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.pojos.Page;

public interface FindArtistController {

	ArtistsPager findArtist(String artist);
	Artist findArtistBySpotifyId(String spotifyId);
	Page<AlbumSimple> findAlbumesOfArtistId(String spotifyId,String limit);
}
