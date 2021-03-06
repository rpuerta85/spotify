package es.upm.miw.spotify.controllers.web;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.FindAlbumViewBean;
import es.upm.miw.spotify.view.beans.FindArtistViewBean;
import es.upm.miw.spotify.view.beans.HomeViewBean;
import es.upm.miw.spotify.view.beans.NewUserViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.view.beans.ShowUsersViewBean;

//@Controller
//@SessionAttributes(types = UserForm.class)
public class NewUserControllerPRueba {
	private static final Logger log = LogManager.getLogger(NewUserControllerPRueba.class);
	@Autowired
	private HomeViewPropertiesManager indexViewPropertiesManager;
	
	@Autowired
	private SessionBean session;

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.NEW_USER_GETPATH   },
			 method = RequestMethod.GET)
	public ModelAndView newUser() {
		log.info("newUser page");
		log.info("newUser GET");
		UserFormBean userFormBean = new UserFormBean(messageSource);
		NewUserViewBean newUserViewBean = new NewUserViewBean(userFormBean);
		ModelAndView model = newUserViewBean.update();
		model.setViewName(ViewNameConstants.NEW_USER_VIEWNAME);
		model.addObject("UserForm", new UserForm()); 
		log.info("End newUser GET");
		log.info("redirect to "+model.getViewName()+" page ");
		return model;

	}
//	@RequestMapping(value = ViewUrlConstants.ROOT_PATH+ViewUrlConstants.NEW_USER_PATH,
//			method = RequestMethod.POST)
	public ModelAndView newUser( @ModelAttribute UserForm userForm) {
		log.info("newUser page");
		log.info("newUser POST");
		
		UserFormBean userFormBean =new UserFormBean(messageSource, 
				       userForm, session);
		NewUserViewBean newUserViewBean = new NewUserViewBean(userFormBean);
		ModelAndView model = newUserViewBean.update();
		newUserViewBean.process();
		if(newUserViewBean.isSuccess()) {
			model.setViewName(ViewNameConstants.SHOW_USERS_VIEWNAME);
		}else{
		    model.setViewName(ViewNameConstants.NEW_USER_VIEWNAME);
		}
		log.info("End findAlbumAction POST");
		log.info("redirect to "+model.getViewName()+" page ");
		return model;
	}

}