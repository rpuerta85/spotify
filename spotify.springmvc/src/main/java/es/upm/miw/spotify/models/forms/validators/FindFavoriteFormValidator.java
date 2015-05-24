package es.upm.miw.spotify.models.forms.validators;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.spotify.models.forms.FindFavoriteForm;


public class FindFavoriteFormValidator {
	private static final Logger logger = LogManager.getLogger(FindFavoriteFormValidator.class);

	private static final String REG_EXP_FAVORITE_NAME ="^[A-Za-z0-9]+[A-Za-z0-9_ ]*$";
	
	private FindFavoriteForm findFavaoriteForm;

	public FindFavoriteFormValidator(FindFavoriteForm  findArtistForm) {
		super();
		this.findFavaoriteForm = findArtistForm;
	}

	public boolean validate(){
		logger.info("validating favorite name:"+Pattern.matches(REG_EXP_FAVORITE_NAME, findFavaoriteForm.getName()));
		return Pattern.matches(REG_EXP_FAVORITE_NAME, findFavaoriteForm.getName());
	}
	
	
}
