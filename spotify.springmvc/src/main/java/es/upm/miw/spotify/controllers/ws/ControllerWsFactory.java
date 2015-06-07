package es.upm.miw.spotify.controllers.ws;

import es.upm.miw.spotify.controllers.ControllerFactory;
import es.upm.miw.spotify.controllers.FindAlbumController;
import es.upm.miw.spotify.controllers.FindArtistController;
import es.upm.miw.spotify.controllers.FindFavoritesAlbumsController;
import es.upm.miw.spotify.controllers.FindFavoritesArtistsController;
import es.upm.miw.spotify.controllers.FindTrackController;
import es.upm.miw.spotify.view.beans.SessionBean;


public class ControllerWsFactory extends ControllerFactory {
	private static ControllerWsFactory factory;
	private SessionBean session;
	private FindArtistController findArtistController;
	private FindAlbumController findAlbumController;
	private FindTrackController findTrackController;
	private FindFavoritesAlbumsController findFavoritesAlbumController;
	private FindFavoritesArtistsController findFavoritesArtistsController;

	public ControllerWsFactory(SessionBean session) {
		this.session = session;
	}

	public static ControllerWsFactory getInstance(SessionBean session) {
		if (factory == null) {
			factory = new ControllerWsFactory(session);
		}
		return factory;
	}


	@Override
	public FindArtistController getFindArtistController() {
		if (findArtistController == null) {
			findArtistController = new FindArtistControllerWs(session);
		}
		return findArtistController;
	}
	@Override
	public FindAlbumController getFindAlbumController() {
		if (findAlbumController == null) {
			findAlbumController = new FindAlbumControllerWs(session);
		}
		return findAlbumController;
	}

	@Override
	public FindTrackController getFindTrackController() {
		if (findTrackController == null) {
			findTrackController = new FindTrackControllerWs(session);
		}
		return findTrackController;
	}

	@Override
	public FindFavoritesAlbumsController getFindFavoriteAlbumController() {
		if (findFavoritesAlbumController == null) {
			findFavoritesAlbumController = new FindFavoritesAlbumsControllerWs(session);
		}
		return findFavoritesAlbumController;
	}

	@Override
	public FindFavoritesArtistsController getFindFavoriteArtistsController() {
		if(findFavoritesArtistsController==null){
			 findFavoritesArtistsController = new FindFavoritesArtistsControllerWs(session);
		}
		return findFavoritesArtistsController;
	}

}
