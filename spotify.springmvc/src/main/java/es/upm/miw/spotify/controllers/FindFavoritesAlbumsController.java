package es.upm.miw.spotify.controllers;


import es.upm.miw.spotify.models.pojos.AlbumsPager;


public interface FindFavoritesAlbumsController {
	AlbumsPager findAlbumsForUser(String userUUID);
}
