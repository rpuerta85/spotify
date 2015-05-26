package es.upm.miw.spotify.form.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.web.ee.FindFavoriteFormParamsEE;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.pojos.TracksPager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.CommonViewParamsEE;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;

public class FindTrackFormBean extends FindFavoriteFormBean {
	private static final Logger logger = LogManager.getLogger(FindTrackFormBean.class);
	
	public FindTrackFormBean(MessageSource messageSource) {
		super(messageSource);
	}
	public FindTrackFormBean(
			MessageSource messageSource,
			FindFavoriteForm findTrackForm,SessionBean sessionBean) {
		super(messageSource, findTrackForm, sessionBean);
	}
	
	protected void setMsgs() {
		logger.info("Begin setMsgs of FindTrackFormBean");
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_LABEL_VALUE.getV(),
				messageSource.getMessage ("form.find.track.label.value", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_PLACEHOLDER.getV(),
				messageSource.getMessage ("form.find.track.inputText.placeholder", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_BUTTON_SUBMIT_NAME.getV(),
				messageSource.getMessage ("form.find.track.button.submit.name", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_ACTION_POST.getV(),
				messageSource.getMessage ("form.find.track.action.post", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_METHOD.getV(),
				messageSource.getMessage ("form.find.track.method", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_NAME.getV(),
				messageSource.getMessage ("form.find.track.inputText.name", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_ID.getV(),
				messageSource.getMessage ("form.find.track.inputText.id", null, LocaleContextHolder.getLocale()));
		logger.info("End setMsgs  messages of FindTrackFormBean");

	}
	public void process(){
		logger.info("begin FindTrackFormBean process method");
		if(findFavoriteFormValidator.validate()){
			TracksPager track = ControllerWsFactory.getInstance(sessionBean).getFindTrackController().findTrack(findFavoriteForm.getName());
			String jsonTrack=null;
			try {
				jsonTrack = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(track);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error("error in parsing json:"+e);
			}
			logger.info("JSON Track:"+jsonTrack);
			addSuccessMsg(jsonTrack);
			this.success = true;
		}else {
			this.success = false;
			addErrorMsg();
			logger.info("msg error Track validation:"+mapMsgs.get(CommonViewParamsEE.MSG.getV()));
		}
		logger.info("end FindTrackFormBean process method");
	}
	
	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_NAME_MSG_ERROR.getV(),
				messageSource.getMessage ("form.find.track.msg.error", null, LocaleContextHolder.getLocale()));
	}
	
}
