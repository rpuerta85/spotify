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
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowTrackDetailsViewBean;
import es.upm.miw.spotify.view.components.beans.ShowAlbumesOfArtistListViewComponentBean;

@Controller
public class ShowTrackDetailsController {
	private static final Logger logger = LogManager.getLogger(ShowTrackDetailsController.class);

	//atributos autocompletados de esta clase
	//concretamente se autocompleta con los valore de los ficheros .properties de internacionalizacion
	
	@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.SHOW_TRACK_DETAILS_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView showTrackDetailsAction(@PathVariable("id") String idTrack,
			@RequestParam(value="limit", defaultValue="5") String limit,
			@RequestParam(value="idArtist") String idArtist) {
		logger.info("showTrackDetailsAction GET");
		logger.info("idTrack received"+idTrack);
		logger.info("limit received"+limit);
		ShowAlbumesOfArtistListViewComponentBean showAlbumesOfArtistListViewComponentBean = 
				new ShowAlbumesOfArtistListViewComponentBean(session, idArtist,limit);
		ShowTrackDetailsViewBean showTrackDetailsViewBean = new ShowTrackDetailsViewBean(session,idTrack,
				showAlbumesOfArtistListViewComponentBean);
		ModelAndView model = showTrackDetailsViewBean.update();
		model.setViewName(ViewNameConstants.SHOW_TRACK_DETAILS_VIEWNAME);
		logger.info("End showArtistDetailsAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	

	
	

}