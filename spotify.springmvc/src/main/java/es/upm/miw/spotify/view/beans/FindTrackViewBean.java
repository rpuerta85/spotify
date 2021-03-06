package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import es.upm.miw.spotify.form.beans.FindTrackFormBean;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.ShowTrackDetailsParamsEE;

public class FindTrackViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(FindTrackViewBean.class);
	private static final String NAME = "findTrackViewBean";
	private FindTrackFormBean findTrackFormBean;
	private boolean success = false;

	public FindTrackViewBean() {
		super();
	}

	public FindTrackViewBean(FindTrackFormBean findTrackFormBean) {
		super();
		this.findTrackFormBean = findTrackFormBean;
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		model.addObject(NAME, this);
		//actualizamos el resto de componente por lo que esta formado la vista, en este caso
		//actualizamos tambien el componente de formulario findTrackFormBean
		findTrackFormBean.update();
		model.addObject(FindTrackFormBean.getName(), findTrackFormBean);
		return model;
	}

	public void process(){
		logger.info("begin FindTrackViewBean process method");
		findTrackFormBean.process();
		this.success = findTrackFormBean.isSuccess();
		logger.info("end FindTrackViewBean process method");
	}

	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowTrackDetailsParamsEE.SHOW_TRACK_DETAILS_URL.getV(),ViewUrlConstants.SHOW_TRACK_DETAILS_GETPATH);
		mapMsgs.put(ShowTrackDetailsParamsEE.FAVORITE_NAME.getV(),(findTrackFormBean.getFindFavoriteForm()!=null)?findTrackFormBean.getFindFavoriteForm().getName():"");

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
}
