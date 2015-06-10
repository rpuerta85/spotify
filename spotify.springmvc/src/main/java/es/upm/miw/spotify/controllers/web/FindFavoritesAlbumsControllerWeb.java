package es.upm.miw.spotify.controllers.web;

import java.lang.ProcessBuilder.Redirect;

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

import es.upm.miw.spotify.form.beans.FindAlbumFormBean;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.FindAlbumViewBean;
import es.upm.miw.spotify.view.beans.FindFavoritesAlbumsViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;

@Controller
public class FindFavoritesAlbumsControllerWeb {
	private static final Logger logger = LogManager.getLogger(FindFavoritesAlbumsControllerWeb.class);
	
	@Autowired
	private SessionBean session;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_FAVORITES_ALBUM_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView findAlbumsAction() {
		logger.info("findFavoritesAlbums GET");
		
		FindFavoritesAlbumsViewBean findFavoritesAlbumsViewBean = new FindFavoritesAlbumsViewBean(messageSource,session);
		ModelAndView model = findFavoritesAlbumsViewBean.update();
		if(findFavoritesAlbumsViewBean.isSuccess())
		   model.setViewName(ViewNameConstants.FIND_FAVORITES_ALBUMS_VIEWNAME);
		else
			model.setViewName(ViewNameConstants.HOME_VIEWNAME);
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
}