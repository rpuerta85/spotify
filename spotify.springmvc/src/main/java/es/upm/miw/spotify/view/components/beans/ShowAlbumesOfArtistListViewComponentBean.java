package es.upm.miw.spotify.view.components.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.models.pojos.AlbumSimple;
import es.upm.miw.spotify.models.pojos.Page;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.view.beans.GenericView;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;


public class ShowAlbumesOfArtistListViewComponentBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowAlbumesOfArtistListViewComponentBean.class);
	private static final String NAME = "showAlbumesOfArtistListViewComponentBean";
	private SessionBean sessionBean;
	private String spotifyId;
	private String limit;
	private boolean success = false;

	public ShowAlbumesOfArtistListViewComponentBean() {
		super();
	}

	public ShowAlbumesOfArtistListViewComponentBean(SessionBean sessionBean,String spotifyId,
			String limit) {
		super();
		this.sessionBean = sessionBean;
		this.spotifyId = spotifyId;
		this.limit = limit;
	}

	public void update() {
		this.setMsgs();
	}
	private String getJSON(){
		logger.info("begin ShowAlbumesOfArtistListViewComponentBean getJSON method");
		Page<AlbumSimple> albumesList = ControllerWsFactory.getInstance(sessionBean).getFindArtistController().findAlbumesOfArtistId(spotifyId,limit);
		String json=null;
		try {
			json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(albumesList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("error in parsing json:"+e);
		}
		logger.info("JSON artist:"+json);
		this.success = true;
		logger.info("end ShowAlbumesOfArtistListViewComponentBean getJSON method");
		return json;
	}
   
	public void process(){
	}

	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowArtistDetailsParamsEE.JSON_ALBUMES.getV(),getJSON());
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
