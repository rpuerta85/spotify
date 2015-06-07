package es.upm.miw.spotify.controllers.web;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import es.upm.miw.spotify.models.properties.beans.HomeViewPropertiesManager;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.SessionBean;



@Controller
public class LogoutController {

	private static final Logger log = LogManager.getLogger(LogoutController.class);
	//atributos autocompletados de esta clase
	//concretamente se autocompleta con los valore de los ficheros .properties de internacionalizacion
	@Autowired
	private HomeViewPropertiesManager indexViewPropertiesManager;
	
	@RequestMapping(value = { "/" + ViewUrlConstants.LOGOUT_VIEW_PATH }, method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus status) {
		log.info("session deleted");
		log.debug("create: ");
		session.invalidate();
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
		status.setComplete();
		log.info("redirecting to login view");
		return "redirect:"+ViewUrlConstants.HOME_VIEW_PATH;
	}
	
	

}