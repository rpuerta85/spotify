package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.web.ee.FindFavoriteFormParamsEE;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.FindFavoritesForUserParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistsViewParamsEE;


public class FindFavoritesAlbumsViewBean extends GenericView{
	private static final Logger logger = LogManager.getLogger( FindFavoritesAlbumsViewBean.class);
	private static final String NAME = "findFavoritesAlbumsViewBean";
	private SessionBean sessionBean;
	private boolean success = false;
	protected MessageSource messageSource;
	public FindFavoritesAlbumsViewBean(MessageSource messageSource, SessionBean session) {
	    this.sessionBean= session;
	    this.messageSource= messageSource;
	}
	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
 		model.addObject(NAME, this);
		
	    this.process();
		
		return model;
	}
	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
		
				
	}
	public void process(){
		logger.info("begin FindFavoriteAlbumsViewBean process method");//"6722052B96424CB5A143BB05FD627C67"
		
		if(sessionBean.getUserWeb()!=null){
			String userUUID = sessionBean.getUserWeb().getIdUUID();
			AlbumsPager albums = ControllerWsFactory.getInstance(sessionBean).getFindFavoriteAlbumController().findAlbumsForUser(userUUID);
			String json=null;

			try {
				json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(albums);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error("error in parsing json:"+e);
			}
			logger.info("JSON album:"+json);
			addSuccessMsg(json);
			this.success = true;
			}
		else
			this.success=false;
		
		logger.info("end FindFvaoritesAlbumViewBean process method");
	}
	

	protected void addSuccessMsg(String jsonArtist){
		this.mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),jsonArtist);
		this.mapMsgs.put(FindFavoritesForUserParamsEE.FIND_FAVORITE_TEXT.getV(),
				messageSource.getMessage ("favorites.msg.title", null, LocaleContextHolder.getLocale()));
	}
	
	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoritesForUserParamsEE.FIND_FAVORITES_MSG_ERROR.getV(),
				messageSource.getMessage ("favorites.msg.empty", null, LocaleContextHolder.getLocale()));
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
