package es.upm.miw.spotify.form.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.forms.validators.FindFavoriteFormValidator;
import es.upm.miw.spotify.view.beans.GenericView;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.ShowArtistsViewParamsEE;

public abstract class FindFavoriteFormBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(FindFavoriteFormBean.class);
	protected static final String NAME = "findFavoriteFormBean";
	protected MessageSource messageSource;
	protected FindFavoriteFormValidator findFavoriteFormValidator;
	protected FindFavoriteForm findFavoriteForm;
	protected SessionBean sessionBean;
	
	protected boolean success = true;
	
	protected Object favorite;
	
	protected FindFavoriteFormBean(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	public FindFavoriteFormBean(
			MessageSource messageSource,
			FindFavoriteForm findArtistForm,SessionBean sessionBean) {
		super();
		this.sessionBean = sessionBean;
		this.findFavoriteForm =findArtistForm;
		this.findFavoriteFormValidator = new FindFavoriteFormValidator(this.findFavoriteForm);
		this.messageSource = messageSource;

	}
	
	public void update(){
		logger.info("filling the bean "+ FindFavoriteFormBean.getName()+":"+"values:"+this.mapMsgs.toString());
		this.setMsgs();
	}

	protected abstract void setMsgs();
	protected abstract void addErrorMsg();
	
	protected void addSuccessMsg(String jsonArtist){
		this.mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),
				jsonArtist);
	}
	
	//* GETTETS AND SETTERS */
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public FindFavoriteFormBean() {
		super();
	}

	public static String getName() {
		return NAME;
	}
	public Object getFavorite() {
		return favorite;
	}
	public void setFavorite(Object favorite) {
		this.favorite = favorite;
	}
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public FindFavoriteForm getFindFavoriteForm() {
		return findFavoriteForm;
	}
	public void setFindFavoriteForm(FindFavoriteForm findFavoriteForm) {
		this.findFavoriteForm = findFavoriteForm;
	}

	

}
