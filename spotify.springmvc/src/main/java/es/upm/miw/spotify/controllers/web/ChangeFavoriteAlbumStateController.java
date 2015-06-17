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
import es.upm.miw.spotify.view.beans.ChangeFavoriteTrackViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowTrackDetailsViewBean;
import es.upm.miw.spotify.view.components.beans.ShowAlbumesOfArtistListViewComponentBean;

@Controller
public class ChangeFavoriteAlbumStateController {
	private static final Logger logger = LogManager.getLogger(ChangeFavoriteAlbumStateController.class);

		@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.CHANGE_FAVORITE_ALBUM_STATE_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView changeAlbumStateAction(@PathVariable("id") String spotifyidAlbum) {
		logger.info("showAlbumDetailsAction GET");
		logger.info("idTrack received"+spotifyidAlbum);
		
		ChangeFavoriteAlbumViewBean 	changeFavoriteAlbumViewBean = 
				new ChangeFavoriteAlbumViewBean(messageSource, session, spotifyidAlbum);
	
		ModelAndView model = changeFavoriteAlbumViewBean.update();
		model.setViewName("redirect:/"+ ViewUrlConstants.FIND_FAVORITES_ALBUM_PATH);
		logger.info("End showAlbumsDetailsAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	

	
	

}