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
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.views.web.ee.ShowUsersParamsEE;

public class ShowUsersViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowUsersViewBean.class);
	private static final String NAME = "showUsersViewBean";
	private boolean success = false;
	private SessionBean sessionBean;
	private List<UserPojo> userList;
	
	public ShowUsersViewBean(SessionBean sessionBean) {
		super();
		this.sessionBean = sessionBean;
		userList = new ArrayList<UserPojo>();
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.userList = ControllerWsFactory.getInstance(sessionBean).getShowUsersController().showUsersAll();
		this.setMsgs();
		model.addObject(NAME, this);
		return model;
	}

	public void process(){
		logger.info("begin FindAlbumViewBean process method");
		logger.info("end FindAlbumViewBean process method");
	}

	@Override
	protected void setMsgs() {
	    try {
			mapMsgs.put(ShowUsersParamsEE.JSON_USERS.getV(), toJson(this.userList));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public List<UserPojo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserPojo> userList) {
		this.userList = userList;
	}
	
}
