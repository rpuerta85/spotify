package es.upm.miw.spotify.form.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import es.upm.miw.spotify.form.web.ee.FindFavoriteFormParamsEE;
import es.upm.miw.spotify.form.web.ee.NewUserFormParamsEE;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.forms.UserForm;
import es.upm.miw.spotify.models.forms.validators.FindFavoriteFormValidator;
import es.upm.miw.spotify.models.forms.validators.UserFormValidator;
import es.upm.miw.spotify.view.beans.GenericView;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.ShowArtistsViewParamsEE;

public class UserFormBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(UserFormBean.class);
	private static final String NAME = "userFormBean";
	private MessageSource messageSource;
	private UserFormValidator userFormValidator;
	private UserForm userForm;
	private SessionBean sessionBean;
	
	private boolean success = true;
		
	public UserFormBean(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	public UserFormBean(
			MessageSource messageSource,
			UserForm userForm,SessionBean sessionBean) {
		super();
		this.sessionBean = sessionBean;
		this.userForm =userForm;
		this.userFormValidator = new UserFormValidator(this.userForm);
		this.messageSource = messageSource;

	}
	
	public void update(){
		logger.info("filling the bean "+ UserFormBean.getName()+":"+"values:"+this.mapMsgs.toString());
		this.setMsgs();
	}

	public void setMsgs(){
		logger.info("Begin setMsgs of UserFormBean");//init the form
		this.mapMsgs.put(NewUserFormParamsEE.FORM_NEW_USER_INPUTTEXT_USERNAME_VALUE.getV(),"");
		this.mapMsgs.put(NewUserFormParamsEE.FORM_NEW_USER_INPUTTEXT_PASSWORD_VALUE.getV(),"");
		this.mapMsgs.put(NewUserFormParamsEE.FORM_NEW_USER_INPUTTEXT_CREATETIME_VALUE.getV(),"");
		this.mapMsgs.put(NewUserFormParamsEE.FORM_NEW_USER_INPUTTEXT_ISADMIN_VALUE.getV(),"");
		this.mapMsgs.put(NewUserFormParamsEE.FORM_NEW_USER_INPUTTEXT_ISENABLED_VALUE.getV(),"");
		this.mapMsgs.put(NewUserFormParamsEE.FORM_NEW_USER_INPUTTEXT_EMAIL_VALUE.getV(),"");
		logger.info("End setMsgs of UserFormBean");

	}
	
	//* GETTETS AND SETTERS */
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public UserFormBean() {
		super();
	}

	public static String getName() {
		return NAME;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public UserFormValidator getUserFormValidator() {
		return userFormValidator;
	}
	public void setUserFormValidator(UserFormValidator userFormValidator) {
		this.userFormValidator = userFormValidator;
	}
	public UserForm getUserForm() {
		return userForm;
	}
	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}
	

	

}
