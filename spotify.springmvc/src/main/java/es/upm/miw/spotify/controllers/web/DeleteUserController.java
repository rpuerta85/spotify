package es.upm.miw.spotify.controllers.web;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.form.beans.FindAlbumFormBean;
import es.upm.miw.spotify.form.beans.FindArtistFormBean;
import es.upm.miw.spotify.form.beans.UserFormBean;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.forms.UserForm;
import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.DeleteUserViewBean;
import es.upm.miw.spotify.view.beans.FindAlbumViewBean;
import es.upm.miw.spotify.view.beans.FindArtistViewBean;
import es.upm.miw.spotify.view.beans.HomeViewBean;
import es.upm.miw.spotify.view.beans.NewUserViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowUsersViewBean;

@Controller
public class DeleteUserController {
	private static final Logger log = LogManager.getLogger(DeleteUserController.class);
	@Autowired
	private HomeViewPropertiesManager indexViewPropertiesManager;
	
	@Autowired
	private SessionBean session;

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.DELETE_USER_GETPATH   },
			 method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") String userUUID) {
		log.info("deleteUser page");
		log.info("deleteUser GET  received useruuid :" + userUUID);
		DeleteUserViewBean deleteUserViewBean = new DeleteUserViewBean(messageSource, session,userUUID);
		ModelAndView model = deleteUserViewBean.update();
		model.setViewName("redirect:"+ ViewUrlConstants.ROOT_PATH+ViewUrlConstants.SHOW_USERS_REGISTERED_PATH);
		log.info("deleteUser GET");
		log.info("redirect to "+model.getViewName()+" page ");
		return model;

	}
	
}