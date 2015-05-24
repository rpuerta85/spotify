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
import es.upm.miw.spotify.form.beans.FindTrackFormBean;
import es.upm.miw.spotify.utils.constants.ViewNameConstants;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.view.beans.FindTrackViewBean;
import es.upm.miw.spotify.view.beans.SessionBean;

@Controller
public class FindTrackController {
	private static final Logger logger = LogManager.getLogger(FindTrackController.class);
	
	@Autowired
	private SessionBean session;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { ViewUrlConstants.ROOT_PATH+ViewUrlConstants.FIND_TRACK_PATH}, 
			method = RequestMethod.GET)
	public ModelAndView findTrackAction() {
		logger.info("findTrack GET");
		FindTrackFormBean findTrackFormBean = new FindTrackFormBean(messageSource);
		FindTrackViewBean findTrackViewBean = new FindTrackViewBean(findTrackFormBean);
		ModelAndView model = findTrackViewBean.update();
		model.setViewName(ViewNameConstants.FIND_TRACK_VIEWNAME);
		logger.info("redirect to "+model.getViewName()+" page ");
		return model;
	}
	
}