package es.upm.miw.spotify.form.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.web.ee.FindFavoriteFormParamsEE;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.pojos.Artists;
import es.upm.miw.spotify.models.pojos.ArtistsPager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.CommonViewParamsEE;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

public class FindArtistFormBean extends FindFavoriteFormBean {
	private static final Logger logger = LogManager.getLogger(FindArtistFormBean.class);
	
	public FindArtistFormBean(MessageSource messageSource) {
		super(messageSource);
	}
	public FindArtistFormBean(
			MessageSource messageSource,
			FindFavoriteForm findArtistForm,SessionBean sessionBean) {
		super(messageSource, findArtistForm, sessionBean);
	}
	
	protected void setMsgs() {
		logger.info("Begin setMsgs of FindArtistFormBean");
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_LABEL_VALUE.getV(),
				messageSource.getMessage ("form.find.artist.label.value", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_PLACEHOLDER.getV(),
				messageSource.getMessage ("form.find.artist.inputText.placeholder", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_BUTTON_SUBMIT_NAME.getV(),
				messageSource.getMessage ("form.find.artist.button.submit.name", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_ACTION_POST.getV(),
				messageSource.getMessage ("form.find.artist.action.post", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_METHOD.getV(),
				messageSource.getMessage ("form.find.artist.method", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_NAME.getV(),
				messageSource.getMessage ("form.find.artist.inputText.name", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_ID.getV(),
				messageSource.getMessage ("form.find.artist.inputText.id", null, LocaleContextHolder.getLocale()));
		logger.info("End setMsgs  messages of FindArtistFormBean");

	}
	public void process(){
		logger.info("begin FindArtistFormBean process method");
		if(findFavoriteFormValidator.validate()){
			ArtistsPager artist = ControllerWsFactory.getInstance(sessionBean).getFindArtistController().findArtist(findFavoriteForm.getName());
			this.favorite = artist;
			String jsonArtist=null;
			try {
				jsonArtist = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(artist);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error("error in parsing json:"+e);
			}
			logger.info("JSON artist:"+jsonArtist);
			addSuccessMsg(jsonArtist);
			this.success = true;
		}else {
			this.success = false;
			addErrorMsg();
			logger.info("msg error artist validation:"+mapMsgs.get(CommonViewParamsEE.MSG.getV()));
		}
		logger.info("end FindArtistFormBean process method");
	}

	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_NAME_MSG_ERROR.getV(),
				messageSource.getMessage ("form.find.artist.msg.error", null, LocaleContextHolder.getLocale()));
	}
	
}
