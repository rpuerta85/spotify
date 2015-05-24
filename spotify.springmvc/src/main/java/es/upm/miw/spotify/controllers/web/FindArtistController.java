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

@Controller
public class FindArtistController {
	private static final Logger logger = LogManager.getLogger(FindArtistController.class);

	//atributos autocompletados de esta clase
	//concretamente se autocompleta con los valore de los ficheros .properties de internacionalizacion
	
	@Autowired
	private SessionBean session;

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_ARTIST_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView findArtistAction() {
		logger.info("findArtistAction GET");
		FindArtistFormBean findArtistFormBean = new FindArtistFormBean(messageSource);
		FindArtistViewBean findArtistViewBean = new FindArtistViewBean(session, findArtistFormBean);
		ModelAndView model = findArtistViewBean.update();
		model.setViewName(ViewNameConstants.FIND_ARTIST_VIEWNAME);
		logger.info("End findArtistAction GET");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
	@RequestMapping(value = ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_ARTIST_PATH,
			method = RequestMethod.POST)
	public ModelAndView findArtistAction(@RequestParam(value = "artistName",required = false) String artistName) {
		logger.info("Begin findArtistAction POST");
		logger.info("param recived:"+artistName);
		FindArtistFormBean findArtistFormBean = new FindArtistFormBean(messageSource,
				new FindFavoriteForm(artistName), session);
		FindArtistViewBean findArtistViewBean = new FindArtistViewBean(session, findArtistFormBean);
		ModelAndView model = findArtistViewBean.update();
		findArtistViewBean.process();
		if(findArtistViewBean.isSuccess()) {
			model.setViewName(ViewNameConstants.SHOW_ARTISTS_VIEWNAME);
		}else{
		    model.setViewName(ViewNameConstants.FIND_ARTIST_VIEWNAME);
		}
		logger.info("End findArtistAction POST");
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
	

}