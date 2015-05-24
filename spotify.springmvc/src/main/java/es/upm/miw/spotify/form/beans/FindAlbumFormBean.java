package es.upm.miw.spotify.form.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.form.web.ee.FindFavoriteFormParamsEE;
import es.upm.miw.spotify.models.forms.FindFavoriteForm;
import es.upm.miw.spotify.models.pojos.Albums;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.view.beans.SessionBean;
import es.upm.miw.spotify.views.web.ee.CommonViewParamsEE;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;

public class FindAlbumFormBean extends FindFavoriteFormBean {
	private static final Logger logger = LogManager.getLogger(FindAlbumFormBean.class);
	
	public FindAlbumFormBean(MessageSource messageSource) {
		super(messageSource);
	}
	public FindAlbumFormBean(
			MessageSource messageSource,
			FindFavoriteForm findAlbumForm,SessionBean sessionBean) {
		super(messageSource, findAlbumForm, sessionBean);
	}
	
	protected void setMsgs() {
		logger.info("Begin setMsgs of FindAlbumFormBean");
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_LABEL_VALUE.getV(),
				messageSource.getMessage ("form.find.album.label.value", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_PLACEHOLDER.getV(),
				messageSource.getMessage ("form.find.album.inputText.placeholder", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_BUTTON_SUBMIT_NAME.getV(),
				messageSource.getMessage ("form.find.album.button.submit.name", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_ACTION_POST.getV(),
				messageSource.getMessage ("form.find.album.action.post", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_METHOD.getV(),
				messageSource.getMessage ("form.find.album.method", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_NAME.getV(),
				messageSource.getMessage ("form.find.album.inputText.name", null, LocaleContextHolder.getLocale()));
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_INPUTTEXT_ID.getV(),
				messageSource.getMessage ("form.find.album.inputText.id", null, LocaleContextHolder.getLocale()));
		logger.info("End setMsgs  messages of FindAlbumFormBean");

	}
	public void process(){
		logger.info("begin FindAlbumFormBean process method");
		if(findFavoriteFormValidator.validate()){
			Albums albums = ControllerWsFactory.getInstance(sessionBean).getFindAlbumController().findAlbum(findFavoriteForm.getName());
			String json=null;
			try {
				json = ObjectMapperJacksonSingleton.getInstance().getObjectMapper().writeValueAsString(albums);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error("error in parsing json:"+e);
			}
			logger.info("JSON album:"+json);
			addSuccessMsg(json);
			this.success = true;
		}else {
			this.success = false;
			addErrorMsg();
			logger.info("msg error album validation:"+mapMsgs.get(CommonViewParamsEE.MSG.getV()));
		}
		logger.info("end FindAlbumFormBean process method");
	}
	
	protected void addErrorMsg(){
		this.mapMsgs.put(FindFavoriteFormParamsEE.FORM_FIND_FAVORITE_NAME_MSG_ERROR.getV(),
				messageSource.getMessage ("form.find.album.msg.error", null, LocaleContextHolder.getLocale()));
	}
	
}
