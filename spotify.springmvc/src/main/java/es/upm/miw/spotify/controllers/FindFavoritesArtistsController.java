package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.ArtistsPager;

public interface FindFavoritesArtistsController  {
	ArtistsPager findArtists(String userUUID, String favoriteTypeUUID);
}
