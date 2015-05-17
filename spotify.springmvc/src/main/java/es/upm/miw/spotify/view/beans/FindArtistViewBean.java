package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.upm.miw.spotify.controllers.ws.ControllerWsFactory;
import es.upm.miw.spotify.models.forms.FindArtistForm;
import es.upm.miw.spotify.models.forms.validators.FindArtistFormValidator;
import es.upm.miw.spotify.models.pojos.Artists;
import es.upm.miw.spotify.models.properties.beans.FindArtistViewPropertiesManager;
import es.upm.miw.spotify.models.properties.beans.ShowArtistsViewPropertiesManager;
import es.upm.miw.spotify.models.utils.ObjectMapperJacksonSingleton;
import es.upm.miw.spotify.views.web.ee.CommonViewParamsEE;
import es.upm.miw.spotify.views.web.ee.FindArtistViewParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowArtistsViewParamsEE;


public class FindArtistViewBean extends GenericView{
	private static final Logger logger = LogManager.getLogger(FindArtistViewBean.class);

	private static final String NAME = "findArtistViewBean";

	private FindArtistViewPropertiesManager findArtistViewPropertiesManager;
	private ShowArtistsViewPropertiesManager showArtistsViewPropertiesManager;
	private FindArtistFormValidator findArtistFormValidator;
	private FindArtistForm findArtistForm;
	private SessionBean sessionBean;
	private boolean success = false;

	public FindArtistViewBean(
			FindArtistViewPropertiesManager findArtistViewPropertiesManager) {
		super();
		this.findArtistViewPropertiesManager = findArtistViewPropertiesManager;
	}
	public FindArtistViewBean(
			FindArtistViewPropertiesManager findArtistViewPropertiesManager,ShowArtistsViewPropertiesManager
			showArtistsViewPropertiesManager,
			FindArtistForm findArtistForm,SessionBean sessionBean) {
		super();
		this.sessionBean = sessionBean;
		this.findArtistViewPropertiesManager = findArtistViewPropertiesManager;
		this.showArtistsViewPropertiesManager = showArtistsViewPropertiesManager;
		this.findArtistForm =findArtistForm;
		this.findArtistFormValidator = new FindArtistFormValidator(this.findArtistForm);
	}
	
	
	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		model.addObject(NAME, this);
		return model;
	}

	public void process(){
		logger.info("begin process method");
		if(findArtistFormValidator.validate()){
			Artists artist = ControllerWsFactory.getInstance(sessionBean).getFindArtistController().findArtistJSON(findArtistForm.getArtist());
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
		logger.info("end process method");
	}

	@Override
	protected void setMsgs() {
		this.mapMsgs.put(CommonViewParamsEE.PANEL_HEADER_TITLE.getV(),
				findArtistViewPropertiesManager.getFindArtistViewPanelHeaderTitle());
		this.mapMsgs.put(CommonViewParamsEE.PANEL_HEADER_SUBTITLE.getV(),
				findArtistViewPropertiesManager.getFindArtistViewPanelHeaderSubtitle());
		this.mapMsgs.put(CommonViewParamsEE.PANEL_HEADER_DESCRIPTION.getV(),
				findArtistViewPropertiesManager.getFindArtistViewPanelHeaderDescription());
		this.mapMsgs.put(FindArtistViewParamsEE.FORM_FIND_ARTIST_LABEL_VALUE.getV(),
				findArtistViewPropertiesManager.getFindArtistViewFormFindArtistLabelValue());
		this.mapMsgs.put(FindArtistViewParamsEE.FORM_FIND_ARTIST_INPUTTEXT_PLACEHOLDER.getV(),
				findArtistViewPropertiesManager.getFindArtistViewFormFindArtistInputTextPlaceholder());
		this.mapMsgs.put(FindArtistViewParamsEE.FORM_FIND_ARTIST_BUTTON_SUBMIT_NAME.getV(),
				findArtistViewPropertiesManager.getFindArtistViewFormFindArtistButtonSubmitName());
		
	}
	
	private void addSuccessMsg(String jsonArtist){
		this.mapMsgs.put(ShowArtistsViewParamsEE.JSON_ARTISTS.getV(),
				jsonArtist);
		this.mapMsgs.put(CommonViewParamsEE.PANEL_HEADER_TITLE.getV(),
				showArtistsViewPropertiesManager.getFindArtistViewPanelHeaderTitle());
		this.mapMsgs.put(CommonViewParamsEE.PANEL_HEADER_SUBTITLE.getV(),
				showArtistsViewPropertiesManager.getFindArtistViewPanelHeaderSubtitle());
		this.mapMsgs.put(CommonViewParamsEE.PANEL_HEADER_DESCRIPTION.getV(),
				showArtistsViewPropertiesManager.getFindArtistViewPanelHeaderDescription());
		
	}
	private void addErrorMsg(){
		this.mapMsgs.put(FindArtistViewParamsEE.FORM_FIND_ARTIST_ARTIST_NAME_MSG_ERROR.getV(),
				findArtistViewPropertiesManager.getFindArtistViewFormFindArtistMsgErrorValue());
	}
	
	//* GETTETS AND SETTERS */
	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public FindArtistViewBean() {
		super();
	}

	public static String getName() {
		return NAME;
	}

}
