package es.upm.miw.spotify.controllers.web;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.HomeViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowUsersViewBean;

@Controller
public class ShowUsersController {
	private static final Logger log = LogManager.getLogger(ShowUsersController.class);
	@Autowired
	private HomeViewPropertiesManager indexViewPropertiesManager;
	
	@Autowired
	private SessionBean session;

	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.SHOW_USERS_REGISTERED_PATH   }, method = RequestMethod.GET)
	public ModelAndView showUsersAll() {
		log.info("showUsers page");
		ShowUsersViewBean showUsersViewBean = new ShowUsersViewBean(session);
		ModelAndView model = showUsersViewBean.update();
		model.setViewName(ViewNameConstants.SHOW_USERS_VIEWNAME);
		log.info("redirect to "+model.getViewName()+" page ");
		return model;

	}

}