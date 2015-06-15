package es.upm.miw.spotify.models.forms.validators;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.forms.UserForm;


public class UserFormValidator {
	private static final Logger logger = LogManager.getLogger(UserFormValidator.class);

	private static final String REG_EXP_USERNAME="^[A-Za-z0-9]+[A-Za-z0-9_ ]*$";
	private static final String REG_EXP_PASSWORD ="^[A-Za-z0-9]+[A-Za-z0-9_ ]*$";
	private static final String REG_EXP_CREATE_TIME ="^[0-9]+$";
	private static final String REG_EXP_EMAIL ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private UserForm userForm;
	
	private MessageSource messageSource;
	
	public UserFormValidator(UserForm  userForm) {
		super();
		this.userForm = userForm;
	}

	public boolean validate(){
		logger.info("validating UserForm:");
		return (validateUserName()&&
				validatePassword()&&
				validateCreateTime()&&
				validateIsAdmin()&&
				validateIsEnabled()&&
				validateEmail()&&
				validateIsAdmin()&&
				validateIsEnabled());
	}

	private boolean validateUserName(){
		logger.info("validating UserForm username:"+Pattern.matches(REG_EXP_USERNAME, 
				userForm.getUserName()));
		if(!Pattern.matches(REG_EXP_USERNAME, userForm.getUserName())){
			userForm.setMsgErrorUserName(messageSource.getMessage("form.new.user.msg.validate.username.error", null, LocaleContextHolder.getLocale()));
		}
		return Pattern.matches(REG_EXP_USERNAME, userForm.getUserName());
	}
	private boolean validatePassword(){
		logger.info("validating UserForm password:"+Pattern.matches(REG_EXP_PASSWORD, 
				userForm.getPassword()));
		if(!Pattern.matches(REG_EXP_PASSWORD, 
				userForm.getPassword())){
			userForm.setMsgErrorUserName(messageSource.getMessage("form.new.user.msg.validate.password.error", null, LocaleContextHolder.getLocale()));
		}
		return Pattern.matches(REG_EXP_PASSWORD, 
				userForm.getPassword());
	}
	private boolean validateCreateTime(){
		logger.info("validating UserForm CreateTime:"+Pattern.matches(REG_EXP_CREATE_TIME, 
				String.valueOf(userForm.getCreateTime())));
		if(!Pattern.matches(REG_EXP_CREATE_TIME, 
				String.valueOf(userForm.getCreateTime()))){
			userForm.setMsgErrorUserName(messageSource.getMessage("form.new.user.msg.validate.createtime.error", null, LocaleContextHolder.getLocale()));
		}
		return Pattern.matches(REG_EXP_CREATE_TIME, 
				userForm.getPassword());
	}
	private boolean validateIsAdmin(){
		return true;
	}
	private boolean validateIsEnabled(){
		return true;
	}
	private boolean validateEmail(){
		logger.info("validating UserForm Email:"+Pattern.matches(REG_EXP_EMAIL, 
				String.valueOf(userForm.getEmail())));
		if(!Pattern.matches(REG_EXP_EMAIL, 
				String.valueOf(userForm.getEmail()))){
			userForm.setMsgErrorUserName(messageSource.getMessage("form.new.user.msg.validate.email.error", null, LocaleContextHolder.getLocale()));
		}
		
		return Pattern.matches(REG_EXP_EMAIL, 
				String.valueOf(userForm.getEmail()));
	}
	
	
}
