package es.upm.miw.spotify.controllers;

public abstract class ControllerFactory {
	public abstract FindArtistController getFindArtistController();
	public abstract FindAlbumController getFindAlbumController();
	public abstract FindTrackController getFindTrackController();
	public abstract FindFavoritesAlbumsController getFindFavoriteAlbumController();
	public abstract FindFavoritesArtistsController getFindFavoriteArtistsController();
}
