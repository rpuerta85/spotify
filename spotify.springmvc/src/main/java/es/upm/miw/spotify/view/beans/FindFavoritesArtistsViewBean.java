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
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
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
		model.addObject(NAME, this);
		//actualizamos el resto de componente por lo que esta formado la vista, en este caso
		//actualizamos tambien el componente de formulario findArtistFormBean
	    this.process();
		
		return model;
	}
	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
				
	}
	public void process(){
		logger.info("begin FindFavoriteArtistsViewBean process method");//findArtists(userUUID, favoriteTypeUUID)
		ArtistsPager artists = ControllerWsFactory.getInstance(sessionBean).getFindFavoriteArtistsController().findArtists("6722052B96424CB5A143BB05FD627C67", "F41C1808A95146CBB8BF4771AABC6C40");
		String json=null;
		try {
			json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(artists);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("error in parsing json:"+e);
		}
		logger.info("JSON artists:"+json);
		addSuccessMsg(json);
		this.success = true;
		
		logger.info("end FindFavorritesArstsisViewBean process method");
	}
	

	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoriteFormParamsEE.FIND_FAVORITES_MSG_ERROR.getV(),
				messageSource.getMessage ("form.find.album.msg.error", null, LocaleContextHolder.getLocale()));
	}
	protected void addSuccessMsg(String jsonArtist){
		this.mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),
				jsonArtist);
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
