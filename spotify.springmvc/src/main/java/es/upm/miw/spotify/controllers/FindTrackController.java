package es.upm.miw.spotify.controllers;

import es.upm.miw.spotify.models.pojos.TracksPager;

public interface FindTrackController {

	TracksPager findTrack(String track);
}
