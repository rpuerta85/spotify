package es.upm.miw.spotify.view.components.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.pojos.TrackSimple;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.GenericView;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowTrackDetailsParamsEE;

public class ShowTracksOfAlbumesListViewComponentBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowTracksOfAlbumesListViewComponentBean.class);
	private static final String NAME = "showTracksOfAlbumesListViewComponentBean";
	private SessionBean sessionBean;
	private String spotifyId;
	private boolean success = false;

	public ShowTracksOfAlbumesListViewComponentBean() {
		super();
	}

	public ShowTracksOfAlbumesListViewComponentBean(SessionBean sessionBean,String spotifyId) {
		super();
		this.sessionBean = sessionBean;
		this.spotifyId = spotifyId;
	}

	public void update() {
		this.setMsgs();
	}
	private String getJSON(){
		logger.info("begin showTracksOfAlbumesListViewComponentBean getJSON method");
		Page<TrackSimple> trackList = ControllerWsFactory.getInstance(sessionBean).getFindAlbumController().findTracksOfAlbumId(spotifyId);
		String json=null;
		try {
			json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(trackList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("error in parsing json:"+e);
		}
		logger.info("JSON tracks:"+json);
		this.success = true;
		logger.info("end showTracksOfAlbumesListViewComponentBean getJSON method");
		return json;
	}
   
	public void process(){
	}

	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowAlbumDetailsParamsEE.JSON_TRACKS.getV(),getJSON());
		mapMsgs.put(ShowTrackDetailsParamsEE.SHOW_TRACK_DETAILS_URL.getV(),ViewUrlConstants.SHOW_TRACK_DETAILS_GETPATH);

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
