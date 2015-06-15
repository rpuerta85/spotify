package es.upm.miw.spotify.controllers.web;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.form.beans.FindArtistFormBean;
import es.upm.miw.spotify.form.beans.UserFormBean;
import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.FindArtistViewBean;
import es.upm.miw.spotify.view.beans.HomeViewBean;
import es.upm.miw.spotify.view.beans.NewUserViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowUsersViewBean;

@Controller
public class NewUserController {
	private static final Logger log = LogManager.getLogger(NewUserController.class);
	@Autowired
	private HomeViewPropertiesManager indexViewPropertiesManager;
	
	@Autowired
	private SessionBean session;

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.NEW_USER_PATH   }, method = RequestMethod.GET)
	public ModelAndView newUser() {
		log.info("newUser page");
		log.info("newUser GET");
		UserFormBean userFormBean = new UserFormBean(messageSource);
		NewUserViewBean newUserViewBean = new NewUserViewBean(session, userFormBean);
		ModelAndView model = newUserViewBean.update();
		model.setViewName(ViewNameConstants.NEW_USER_VIEWNAME);
		log.info("End newUser GET");
		log.info("redirect to "+model.getViewName()+" page ");
		return model;

	}

}