package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.models.pojos.Track;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.components.beans.ShowAlbumesOfArtistListViewComponentBean;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowTrackDetailsParamsEE;


public class ShowTrackDetailsViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowTrackDetailsViewBean.class);
	private static final String NAME = "showTrackDetailsViewBean";
	private SessionBean sessionBean;
	private String spotifyId;
	private boolean success = false;
	private ShowAlbumesOfArtistListViewComponentBean showAlbumesOfArtistListViewComponentBean;
	public ShowTrackDetailsViewBean() {
		super();
	}

	public ShowTrackDetailsViewBean(SessionBean sessionBean,String spotifyId,
			ShowAlbumesOfArtistListViewComponentBean showAlbumesOfArtistListViewComponentBean) {
		super();
		this.sessionBean = sessionBean;
		this.spotifyId = spotifyId;
		this.showAlbumesOfArtistListViewComponentBean = showAlbumesOfArtistListViewComponentBean;
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		showAlbumesOfArtistListViewComponentBean.update();
		model.addObject(ShowAlbumesOfArtistListViewComponentBean.getName(), 
				showAlbumesOfArtistListViewComponentBean);
		model.addObject(NAME, this);
		return model;
	}
	private String getJSONTracks(){
		logger.info("begin showTrackDetails getJSONTrack method");
		Track track = ControllerWsFactory.getInstance(sessionBean).getFindTrackController().findTrackBySpotifyId(spotifyId);
		String json=null;
		try {
			json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(track);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("error in parsing json:"+e);
		}
		logger.info("JSON artist:"+json);
		this.success = true;
		logger.info("end showTrackDetails getJSONTrack method");
		return json;
	}
   
	public void process(){
		
	}

	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowTrackDetailsParamsEE.JSON_TRACKS.getV(),getJSONTracks());
		mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
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

	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}
	

}
