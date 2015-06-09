package es.upm.miw.spotify.controllers;


import es.upm.miw.spotify.models.pojos.AlbumsPager;


public interface FindFavoritesAlbumsController {
	AlbumsPager findAlbumsForUser(String userUUID);
//	Album findAlbumBySpotifyId(String spotifyId);
//	Page<TrackSimple> findTracksOfAlbumId(String spotifyId);
}
