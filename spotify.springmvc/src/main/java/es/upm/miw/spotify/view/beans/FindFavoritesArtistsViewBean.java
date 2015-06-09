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
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.FindFavoritesForUserParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistsViewParamsEE;


public class FindFavoritesArtistsViewBean extends GenericView{
	private static final Logger logger = LogManager.getLogger( FindFavoritesArtistsViewBean.class);
	private static final String NAME = "findFavoritesArtistsViewBean";
	private SessionBean sessionBean;
	private boolean success = false;
	protected MessageSource messageSource;
	public FindFavoritesArtistsViewBean(MessageSource messageSource, SessionBean session) {
	    this.sessionBean= session;
	    this.messageSource= messageSource;
	}
	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		//actualizamos el resto de componente por lo que esta formado la vista, en este caso
		//actualizamos tambien el componente de formulario findArtistFormBean
	    this.process();
		model.addObject(NAME, this);

		return model;
	}
	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),ViewUrlConstants.SHOW_ARTIST_DETAILS_GETPATH);
				
	}
	public void process(){
		logger.info("begin FindFavoriteArtistsViewBean process method");//findArtists(userUUID, favoriteTypeUUID)
		if(sessionBean.getUserWeb()!=null){
			String userUUID = sessionBean.getUserWeb().getIdUUID();//"6722052B96424CB5A143BB05FD627C67"
			ArtistsPager artists = ControllerWsFactory.getInstance(sessionBean).getFindFavoriteArtistsController().findArtistsForUser(userUUID);
			String json=null;
			ModelAndView model = new ModelAndView();
			model.addObject(NAME, this);

			try {
				json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(artists);
				mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),json);
				model.setViewName(ViewNameConstants.SHOW_ARTISTS_VIEWNAME);
	
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error("error in parsing json:"+e);
			}
			logger.info("JSON artists:"+json);
			addSuccessMsg(json);
			this.success = true;
		}
		else
			 this.success=false;
		logger.info("end FindFavorritesArstsisViewBean process method");
	}
	

	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoritesForUserParamsEE.FIND_FAVORITES_MSG_ERROR.getV(),
				messageSource.getMessage ("favorites.msg.empty", null, LocaleContextHolder.getLocale()));
	}
	protected void addSuccessMsg(String jsonArtist){
		this.mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),
				jsonArtist);
		this.mapMsgs.put(FindFavoritesForUserParamsEE.FIND_FAVORITE_TEXT.getV(),
				messageSource.getMessage ("favorites.msg.title", null, LocaleContextHolder.getLocale()));
		mapMsgs.put(ShowArtistDetailsParamsEE.SHOW_ARTIST_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ARTIST_DETAILS_GETPATH);
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
