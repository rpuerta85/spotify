package es.upm.miw.spotify.view.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;

public class ShowUsersViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(ShowUsersViewBean.class);
	private static final String NAME = "showUsersViewBean";
	private boolean success = false;
	private SessionBean sessionBean;
	private List<User> userList;
	
	public ShowUsersViewBean(SessionBean sessionBean) {
		super();
		this.sessionBean = sessionBean;
		userList = new ArrayList<User>();
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
	    //mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
