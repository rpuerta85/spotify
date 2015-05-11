package es.upm.miw.spotify.controllers.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.upm.miw.spotify.models.forms.FindArtistForm;
import es.upm.miw.spotify.models.properties.beans.FindArtistViewPropertiesManager;
import es.upm.miw.spotify.models.properties.beans.ShowArtistsViewPropertiesManager;
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
	private FindArtistViewPropertiesManager findArtistViewPropertiesManager;
	@Autowired
	private ShowArtistsViewPropertiesManager showArtistsViewPropertiesManager;
	@Autowired
	private SessionBean session;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_ARTIST_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView findArtistAction() {
		logger.info("findArtist GET");
		FindArtistViewBean findArtistViewBean = new FindArtistViewBean(findArtistViewPropertiesManager);
		ModelAndView model = findArtistViewBean.update();
		logger.info("filling the bean "+ FindArtistViewBean.getName()+":"+"values:"+findArtistViewBean.getMapMsgs().toString());
		model.setViewName(ViewNameConstants.FINDARTIST_VIEWNAME);
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
	@RequestMapping(value = ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_ARTIST_PATH,
			method = RequestMethod.POST)
	public ModelAndView findArtistAction(@RequestParam(value = "artistName",required = false) String artistName) {
		logger.info("findArtistAction POST");
		logger.info("param recived:"+artistName);
		FindArtistViewBean findArtistViewBean = new FindArtistViewBean(findArtistViewPropertiesManager,
				showArtistsViewPropertiesManager,
				new FindArtistForm(artistName),session);
		findArtistViewBean.process();
		ModelAndView model = findArtistViewBean.update();
		if(findArtistViewBean.isSuccess()) {
			model.setViewName(ViewNameConstants.ARTISTS_VIEWNAME);
		}else{
		    model.setViewName(ViewNameConstants.FINDARTIST_VIEWNAME);
		}
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
	

}