package es.upm.miw.spotify.controllers;

public interface ChangeStateFavoriteController {
	   public void changeAlbumFavoriteState(String spotifyId, String userUUID );
	   public void changeArtistFavoriteState(String spotifyId, String userUUID );
	   public void changeTrackFavoriteState(String spotifyId, String userUUID );
}
