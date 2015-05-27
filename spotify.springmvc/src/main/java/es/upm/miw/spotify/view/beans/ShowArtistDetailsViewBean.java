package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.form.beans.FindArtistFormBean;
import es.upm.miw.spotify.form.beans.FindFavoriteFormBean;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.HomeViewParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;


public class ShowArtistDetailsViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowArtistDetailsViewBean.class);
	private static final String NAME = "showArtistDetails";
	private SessionBean sessionBean;
	private boolean success = false;

	public ShowArtistDetailsViewBean() {
		super();
	}

	public ShowArtistDetailsViewBean(SessionBean sessionBean) {
		super();
		this.sessionBean = sessionBean;
	

	}

	public void update() {
		this.setMsgs();
	}

	public void process(){
		logger.info("begin showArtistDetails process method");
	
		
		logger.info("end showArtistDetails process method");
	}

	@Override
	protected void setMsgs() {
		//ViewUrlConstants.FIND_ARTIST_PATH
		//mapMsgs.put(ShowArtistDetailsParamsEE.SHOW_ARTIST_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ARTIST_DETAILS_PATH);
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
