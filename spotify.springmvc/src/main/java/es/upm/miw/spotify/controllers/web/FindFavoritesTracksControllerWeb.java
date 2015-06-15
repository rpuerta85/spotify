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

import es.upm.miw.spotify.form.beans.FindAlbumFormBean;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.FindAlbumViewBean;
import es.upm.miw.spotify.view.beans.FindFavoritesAlbumsViewBean;
import es.upm.miw.spotify.view.beans.FindFavoritesArtistsViewBean;
import es.upm.miw.spotify.view.beans.FindFavoritesTracksViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;

@Controller
public class FindFavoritesTracksControllerWeb {
	private static final Logger logger = LogManager.getLogger(FindFavoritesTracksControllerWeb.class);
	
	@Autowired
	private SessionBean session;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_FAVORITES_TRACKS_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView findArtistsAction() {
		logger.info("findFavoritesTracks GET");
		
		FindFavoritesTracksViewBean findFavoritesTracksViewBean = new FindFavoritesTracksViewBean(messageSource,session);
		ModelAndView model = findFavoritesTracksViewBean.update();
		if(findFavoritesTracksViewBean.isSuccess())
		   model.setViewName(ViewNameConstants.SHOW_TRACKS_VIEWNAME);
		else
			model.setViewName(ViewNameConstants.HOME_VIEWNAME);
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
//	@RequestMapping(value = ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_ALBUM_PATH,
//			method = RequestMethod.POST)
//	public ModelAndView findAlbumAction(@RequestParam(value = "albumName",required = false) String albumName) {
//		logger.info("Begin findAlbumAction POST");
//		logger.info("param recived:"+albumName);
//		FindAlbumFormBean findAlbumFormBean = new FindAlbumFormBean(messageSource,
//				new FindFavoriteForm(albumName), session);
//		FindAlbumViewBean findAlbumViewBean = new FindAlbumViewBean(findAlbumFormBean);
//		ModelAndView model = findAlbumViewBean.update();
//		findAlbumViewBean.process();
//		if(findAlbumViewBean.isSuccess()) {
//			model.setViewName(ViewNameConstants.SHOW_ALBUMS_VIEWNAME);
//		}else{
//		    model.setViewName(ViewNameConstants.FIND_ALBUM_VIEWNAME);
//		}
//		logger.info("End findAlbumAction POST");
//		logger.info("redirect to "+model.getViewName()+" page ");
//		return model;
//	}
//	
}