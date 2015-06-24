package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.web.ShowArtistsDetailsController;
import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.web.ee.FindFavoriteFormParamsEE;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.FindFavoritesForUserParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistsViewParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowTrackDetailsParamsEE;


public class DeleteUserViewBean extends GenericView{
	private static final Logger logger = LogManager.getLogger( DeleteUserViewBean.class);
	private static final String NAME = "deleteUserViewBean";
	private SessionBean sessionBean;
	private String userUUIDToDelete;
	private boolean success = false;
	protected MessageSource messageSource;
	public DeleteUserViewBean(MessageSource messageSource, SessionBean session, String userUUIDToDelete) {
	    this.sessionBean= session;
	    this.messageSource= messageSource;
	    this.userUUIDToDelete= userUUIDToDelete;
	}
	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		//actualizamos el resto de componente por lo que esta formado la vista, en este caso
		//actualizamos tambien el componente de formulario findArtistFormBean
	    this.process();
		model.addObject(NAME, this);
		model.setViewName(ViewNameConstants.SHOW_USERS_VIEWNAME);
		return model;
	}
	@Override
	protected void setMsgs() {
		//mapMsgs.put(ShowAlbumDetailsParamsEE.JSON_ALBUMS.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
	    			
	}
	public void process(){
		logger.info("begin deleteUserViewBean process method");
		if(sessionBean.getUserWeb()!=null){
			String userUUIDLogeado = sessionBean.getUserWeb().getIdUUID();
			
			ControllerWsFactory.getInstance(sessionBean)
			               .getDeleteUserController().deleteUser(userUUIDToDelete);
			ModelAndView model = new ModelAndView();
			model.addObject(NAME, this);
			model.setViewName(ViewNameConstants.FIND_FAVORITES_ALBUMS_VIEWNAME);
	
			this.success = true;
		}
		else{
			 this.success=false;
			
		}
		logger.info("end deleteUserViewBean process method");
	}
	

	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoritesForUserParamsEE.FIND_FAVORITES_MSG_ERROR.getV(),
				messageSource.getMessage ("favorites.msg.empty", null, LocaleContextHolder.getLocale()));
	}
	protected void addSuccessMsg(String jsonArtist){
//		this.mapMsgs.put(FindFavoritesForUserParamsEE.FIND_FAVORITE_TEXT.getV(),
//				messageSource.getMessage ("favorites.msg.title", null, LocaleContextHolder.getLocale()));
//		mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(), ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
//		mapMsgs.put(ShowAlbumDetailsParamsEE.CHANGE_FAVORITE_ALBUM_STATE.getV(),ViewUrlConstants.CHANGE_FAVORITE_ALBUM_STATE_GETPATH);	
	}
//* GETTETS AND SETTERS */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static String getName() {
		return NAME;
	}

}
