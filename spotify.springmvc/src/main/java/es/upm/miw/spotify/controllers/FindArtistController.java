package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.ArtistsPager;

public interface FindArtistController {

	ArtistsPager findArtist(String artist);
}
