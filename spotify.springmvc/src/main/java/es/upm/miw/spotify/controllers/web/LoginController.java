package es.upm.miw.spotify.controllers.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




















import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.security.models.SpringSecurityPrincipal;
import es.upm.miw.spotify.security.models.WebUserDetails;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.HomeViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;

@Controller
public class LoginController {
	private static final Logger log = LogManager.getLogger(LoginController.class);
	//atributos autocompletados de esta clase
	//concretamente se autocompleta con los valore de los ficheros .properties de internacionalizacion
	@Autowired
	private HomeViewPropertiesManager indexViewPropertiesManager;
	
	@Autowired
	private SessionBean session;
	
	@RequestMapping(value = { ViewUrlConstants.HOME_VIEW_PATH  , "home","/welcome**" }, method = RequestMethod.GET)
	public ModelAndView homeView() {
		log.info("home page");
		HomeViewBean homeViewBean = new HomeViewBean();
		ModelAndView model = homeViewBean.update();
		model.setViewName(ViewNameConstants.HOME_VIEWNAME);
		log.info("redirect to "+model.getViewName()+" page ");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		log.info("login page");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		

		}else if(error==null && logout==null){
			updateSession();
			
			
		}
		HomeViewBean homeViewBean = new HomeViewBean();
		model = homeViewBean.update();
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName(ViewNameConstants.HOME_VIEWNAME);
		log.info("redirect to "+model.getViewName()+" page ");
		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}
	private void updateSession() {
		if (session.getUserWeb() == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Object o = auth.getPrincipal();
			SpringSecurityPrincipal userDetails = (SpringSecurityPrincipal) o;
			UserWeb userWeb = userDetails.getUserWeb();
			session.setUserWeb(userWeb);
		}
	}

}