package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.AlbumsPager;

public interface FindAlbumController {
	AlbumsPager findAlbum(String album);
}
