package es.upm.miw.spotify.view.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.web.servlet.ModelAndView;

import es.spotify.models.entities.User;
import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.beans.FindFavoriteFormBean;
import es.upm.miw.spotify.form.beans.UserFormBean;
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.views.web.ee.ShowUsersParamsEE;

public class NewUserViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(NewUserViewBean.class);
	private static final String NAME = "newUserViewBean";
	private boolean success = false;
	private SessionBean sessionBean;
	private UserFormBean userFormBean;
	
	public NewUserViewBean(SessionBean sessionBean,UserFormBean userFormBean) {
		super();
		this.sessionBean = sessionBean;
		this.userFormBean = userFormBean;
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		userFormBean.update();
		model.addObject(UserFormBean.getName(), userFormBean);
		
		model.addObject(NAME, this);
		return model;
	}

	public void process(){
		logger.info("begin NewUserViewBean process method");
		logger.info("end NewUserViewBean process method");
	}

	@Override
	protected void setMsgs() {
	    /*try {
			mapMsgs.put(ShowUsersParamsEE.JSON_USERS.getV(), toJson(this.userList));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//mapMsgs.put(ShowTrackDetailsParamsEE.FAVORITE_NAME.getV(),(findAlbumFormBean.getFindFavoriteForm()!=null)?findAlbumFormBean.getFindFavoriteForm().getName():"");

	}
	
	//* GETTETS AND SETTERS */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static String getName() {
		return NAME;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public UserFormBean getUserFormBean() {
		return userFormBean;
	}

	public void setUserFormBean(UserFormBean userFormBean) {
		this.userFormBean = userFormBean;
	}

	
}
