package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.Artists;

public interface FindArtistController {

	Artists findArtist(String artist);
}
