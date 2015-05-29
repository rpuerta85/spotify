package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.beans.FindArtistFormBean;
import es.upm.miw.spotify.form.beans.FindFavoriteFormBean;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.models.pojos.Artist;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.CommonViewParamsEE;
import es.upm.miw.spotify.views.web.ee.HomeViewParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;


public class ShowArtistDetailsViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowArtistDetailsViewBean.class);
	private static final String NAME = "showArtistDetailsViewBean";
	private SessionBean sessionBean;
	private String spotifyId;
	private boolean success = false;

	public ShowArtistDetailsViewBean() {
		super();
	}

	public ShowArtistDetailsViewBean(SessionBean sessionBean,String spotifyId) {
		super();
		this.sessionBean = sessionBean;
		this.spotifyId = spotifyId;
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		model.addObject(NAME, this);
		return model;
	}
	private String getJSONArtist(){
		logger.info("begin showArtistDetails getJSONArtist method");
		Artist artist = ControllerWsFactory.getInstance(sessionBean).getFindArtistController().findArtistBySpotifyId(spotifyId);
		String json=null;
		try {
			json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(artist);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("error in parsing json:"+e);
		}
		logger.info("JSON artist:"+json);
		this.success = true;
		logger.info("end showArtistDetails getJSONArtist method");
		return json;
	}

	public void process(){
		/*logger.info("begin showArtistDetails process method");
		Artist albums = ControllerWsFactory.getInstance(sessionBean).getFindAlbumController().findAlbum(findFavoriteForm.getName());
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
		logger.info("end showArtistDetails process method");*/
	}

	@Override
	protected void setMsgs() {
		//ViewUrlConstants.FIND_ARTIST_PATH
		mapMsgs.put(ShowArtistDetailsParamsEE.JSON_ARTISTS.getV(),getJSONArtist());
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

	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}
	

}
