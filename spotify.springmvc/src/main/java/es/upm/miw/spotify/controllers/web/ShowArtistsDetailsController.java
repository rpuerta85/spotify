package es.upm.miw.spotify.controllers.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.upm.miw.spotify.form.beans.FindArtistFormBean;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.FindArtistViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowArtistDetailsViewBean;

@Controller
public class ShowArtistsDetailsController {
	private static final Logger logger = LogManager.getLogger(ShowArtistsDetailsController.class);

	//atributos autocompletados de esta clase
	//concretamente se autocompleta con los valore de los ficheros .properties de internacionalizacion
	
	@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.SHOW_ARTIST_DETAILS_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView showArtistDetailsAction() {
		logger.info("showArtistDetailsAction GET");
		ShowArtistDetailsViewBean showArtistDetailsViewBean = new ShowArtistDetailsViewBean(session);
		ModelAndView model = showArtistDetailsViewBean.update();
		model.setViewName(ViewNameConstants.SHOW_ARTIST_DETAILS_VIEWNAME);
		logger.info("End showArtistDetailsAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
//	@RequestMapping(value = ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_ARTIST_PATH,
//			method = RequestMethod.POST)
//	public ModelAndView findArtistAction(@RequestParam(value = "artistName",required = false) String artistName) {
//		logger.info("Begin findArtistAction POST");
//		logger.info("param recived:"+artistName);
//		FindArtistFormBean findArtistFormBean = new FindArtistFormBean(messageSource,
//				new FindFavoriteForm(artistName), session);
//		FindArtistViewBean findArtistViewBean = new FindArtistViewBean(session, findArtistFormBean);
//		ModelAndView model = findArtistViewBean.update();
//		findArtistViewBean.process();
//		if(findArtistViewBean.isSuccess()) {
//			model.setViewName(ViewNameConstants.SHOW_ARTISTS_VIEWNAME);
//		}else{
//		    model.setViewName(ViewNameConstants.FIND_ARTIST_VIEWNAME);
//		}
//		logger.info("End findArtistAction POST");
//		logger.info("redirect to "+model.getViewName()+" page ");
//		return model;
//	}
	
	

}