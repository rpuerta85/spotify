package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.Track;
import es.upm.miw.spotify.models.pojos.TracksPager;

public interface FindTrackController {

	TracksPager findTrackByName(String track);
	Track findTrackBySpotifyId(String spotifyId);

}
