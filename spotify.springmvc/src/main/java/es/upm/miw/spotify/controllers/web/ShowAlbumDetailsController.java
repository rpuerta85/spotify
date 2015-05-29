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
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowAlbumDetailsViewBean;
import es.upm.miw.spotify.view.components.beans.ShowTracksOfAlbumesListViewComponentBean;

@Controller
public class ShowAlbumDetailsController {
	private static final Logger logger = LogManager.getLogger(ShowAlbumDetailsController.class);

	//atributos autocompletados de esta clase
	//concretamente se autocompleta con los valore de los ficheros .properties de internacionalizacion
	
	@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.SHOW_DETAILS_DETAILS_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView showAlbumDetailsAction(@PathVariable("id") String spotifyId) {
		logger.info("showAlbumDetailsAction GET");
		logger.info("spotifyId received"+spotifyId);
		ShowTracksOfAlbumesListViewComponentBean showTracksOfAlbumesListViewComponentBean = 
				new ShowTracksOfAlbumesListViewComponentBean(session, spotifyId);
		ShowAlbumDetailsViewBean showArtistDetailsViewBean = new ShowAlbumDetailsViewBean(session,spotifyId,
				showTracksOfAlbumesListViewComponentBean);
		ModelAndView model = showArtistDetailsViewBean.update();
		model.setViewName(ViewNameConstants.SHOW_ALBUM_DETAILS_VIEWNAME);
		logger.info("End showAlbumDetailsAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
	

}