package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.models.pojos.Album;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.components.beans.ShowAlbumesOfArtistListViewComponentBean;
import es.upm.miw.spotify.view.components.beans.ShowTracksOfAlbumesListViewComponentBean;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;


public class ShowAlbumDetailsViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowAlbumDetailsViewBean.class);
	private static final String NAME = "showAlbumDetailsViewBean";
	private SessionBean sessionBean;
	private String spotifyId;
	private boolean success = false;
	private ShowTracksOfAlbumesListViewComponentBean showTracksOfAlbumesListViewComponentBean;
	public ShowAlbumDetailsViewBean() {
		super();
	}

	public ShowAlbumDetailsViewBean(SessionBean sessionBean,String spotifyId,
			ShowTracksOfAlbumesListViewComponentBean showTracksOfAlbumesListViewComponentBean) {
		super();
		this.sessionBean = sessionBean;
		this.spotifyId = spotifyId;
		this.showTracksOfAlbumesListViewComponentBean = showTracksOfAlbumesListViewComponentBean;
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		showTracksOfAlbumesListViewComponentBean.update();
		model.addObject(ShowTracksOfAlbumesListViewComponentBean.getName(), 
				showTracksOfAlbumesListViewComponentBean);
		model.addObject(NAME, this);
		return model;
	}
	private String getJSONAlbum(){
		logger.info("begin showAlbumDetails getJSON method");
		Album album = ControllerWsFactory.getInstance(sessionBean).getFindAlbumController().findAlbumBySpotifyId(spotifyId);
		String json=null;
		try {
			json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(album);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("error in parsing json:"+e);
		}
		logger.info("JSON album:"+json);
		this.success = true;
		logger.info("end showAlbumDetails getJSON method");
		return json;
	}
   
	public void process(){
	}

	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowArtistDetailsParamsEE.JSON_ALBUMES.getV(),getJSONAlbum());
		mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
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
