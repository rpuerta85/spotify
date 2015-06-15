package es.upm.miw.spotify.controllers.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.ChangeFavoriteTrackViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowTrackDetailsViewBean;
import es.upm.miw.spotify.view.components.beans.ShowAlbumesOfArtistListViewComponentBean;

@Controller
public class ChangeFavoriteTrackStateController {
	private static final Logger logger = LogManager.getLogger(ChangeFavoriteTrackStateController.class);

		@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.CHANGE_FAVORITE_TRACK_STATE}, 
			method = RequestMethod.GET)
	public ModelAndView showTrackDetailsAction(@PathVariable("id") String spotifyidTrack) {
		logger.info("showTrackDetailsAction GET");
		logger.info("idTrack received"+spotifyidTrack);
		
		ChangeFavoriteTrackViewBean 	changeFavoriteTrackViewBean = 
				new ChangeFavoriteTrackViewBean(messageSource, session, spotifyidTrack);
	
		ModelAndView model = changeFavoriteTrackViewBean.update();
		model.setViewName(ViewNameConstants.SHOW_TRACK_DETAILS_VIEWNAME);
		logger.info("End showTracksDetailsAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	

	
	

}