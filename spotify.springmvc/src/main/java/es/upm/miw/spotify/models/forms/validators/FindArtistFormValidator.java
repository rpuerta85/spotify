package es.upm.miw.spotify.models.forms.validators;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.spotify.models.forms.FindArtistForm;


public class FindArtistFormValidator {
	private static final Logger logger = LogManager.getLogger(FindArtistFormValidator.class);

	private static final String REG_EXP_ARTIST_NAME = "^[A-Za-z0-9]+[A-Za-z0-9_ ]*$";
	
	private FindArtistForm findArtistForm;

	public FindArtistFormValidator(FindArtistForm  findArtistForm) {
		super();
		this.findArtistForm = findArtistForm;
	}

	public boolean validate(){
		logger.info("validating artist name:"+Pattern.matches(REG_EXP_ARTIST_NAME, findArtistForm.getArtist()));
		return Pattern.matches(REG_EXP_ARTIST_NAME, findArtistForm.getArtist());
	}
	
	
}
