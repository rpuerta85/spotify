package es.upm.miw.spotify.controllers.ws;

import es.upm.miw.spotify.controllers.ChangeStateFavoriteController;
import es.upm.miw.spotify.controllers.ControllerFactory;
import es.upm.miw.spotify.controllers.FindAlbumController;
import es.upm.miw.spotify.controllers.FindArtistController;
import es.upm.miw.spotify.controllers.FindFavoritesAlbumsController;
import es.upm.miw.spotify.controllers.FindFavoritesArtistsController;
import es.upm.miw.spotify.controllers.FindFavoritesTracksController;
import es.upm.miw.spotify.controllers.FindTrackController;
import es.upm.miw.spotify.controllers.NewUserController;
import es.upm.miw.spotify.controllers.ShowUsersController;
import es.upm.miw.spotify.view.beans.SessionBean;


public class ControllerWsFactory extends ControllerFactory {
	private static ControllerWsFactory factory;
	private SessionBean session;
	private FindArtistController findArtistController;
	private FindAlbumController findAlbumController;
	private FindTrackController findTrackController;
	private FindFavoritesAlbumsController findFavoritesAlbumController;
	private ShowUsersController showUsersController;
	private FindFavoritesArtistsController findFavoritesArtistsController;
	private FindFavoritesTracksController findFavoritesTracksController;
	private ChangeStateFavoriteController changeStateFavoriteController;
	private NewUserController newUserController;

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

	public ShowUsersController getShowUsersController() {
		if (showUsersController == null) {
			showUsersController = new ShowUsersControllerWs(session);
		}
		return showUsersController;
	}
	public FindFavoritesArtistsController getFindFavoriteArtistsController() {
		if(findFavoritesArtistsController==null){
			 findFavoritesArtistsController = new FindFavoritesArtistsControllerWs(session);
		}
		return findFavoritesArtistsController;
	}

	public FindFavoritesTracksController getFindFavoriteTracksController() {
		if(findFavoritesTracksController == null){
			findFavoritesTracksController= new FindFavoritesTracksControllerWs(session);
		}
		return findFavoritesTracksController;
	}

	@Override
	public ChangeStateFavoriteController getChangeStateFavoriteController() {
		if(changeStateFavoriteController==null)
			changeStateFavoriteController= new ChangeStateFavoriteControllerWS(session);
		return  changeStateFavoriteController;
	}

	public NewUserController getNewUserController() {
		if(newUserController==null)
			newUserController= new NewUserControllerControllerWS(session);
		return  newUserController;
		
	}

}
