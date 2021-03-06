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
import es.upm.miw.spotify.view.beans.ChangeFavoriteAlbumViewBean;
import es.upm.miw.spotify.view.beans.ChangeFavoriteArtistViewBean;
import es.upm.miw.spotify.view.beans.ChangeFavoriteTrackViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowTrackDetailsViewBean;
import es.upm.miw.spotify.view.components.beans.ShowAlbumesOfArtistListViewComponentBean;

@Controller
public class ChangeFavoriteArtistStateController {
	private static final Logger logger = LogManager.getLogger(ChangeFavoriteArtistStateController.class);

		@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.CHANGE_FAVORITE_ARTIST_STATE_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView showArtistDetailsAction(@PathVariable("id") String spotifyidArtist) {
		logger.info("showAlbumDetailsAction GET");
		logger.info("idArtitst received"+spotifyidArtist);
		
		ChangeFavoriteArtistViewBean 	changeFavoriteArtistViewBean = 
				new ChangeFavoriteArtistViewBean(messageSource, session, spotifyidArtist);
	
		ModelAndView model = changeFavoriteArtistViewBean.update();
		model.setViewName("redirect:/"+ ViewUrlConstants.FIND_FAVORITES_ARTISTS_PATH);
		logger.info("End showArtistDetailsAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model; 
	}
	

	
	

}