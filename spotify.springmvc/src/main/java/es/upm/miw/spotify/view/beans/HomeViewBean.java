package es.upm.miw.spotify.view.beans;

import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.HomeViewParamsEE;


public class HomeViewBean extends GenericView{
	private static final String NAME = "homeViewBean";
	
	public HomeViewBean() {
		super();
	}

	
	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		setMsgs();
		model.addObject(NAME, this);
		return model;
	}


	@Override
	protected void setMsgs() {
		mapMsgs.put(HomeViewParamsEE.BUTTON_FIND_ARTIST_URL.getV(),ViewUrlConstants.FIND_ARTIST_PATH);
		mapMsgs.put(HomeViewParamsEE.BUTTON_FIND_ALBUM_URL.getV(),ViewUrlConstants.FIND_ALBUM_PATH);
		mapMsgs.put(HomeViewParamsEE.BUTTON_FIND_TRACK_URL.getV(),ViewUrlConstants.FIND_TRACK_PATH);		

	}


	public static String getName() {
		return NAME;
	}


}
