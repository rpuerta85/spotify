package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.form.beans.FindArtistFormBean;
import es.upm.miw.spotify.form.beans.FindFavoriteFormBean;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.ShowArtistDetailsParamsEE;


public class FindArtistViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(FindArtistViewBean.class);
	private static final String NAME = "findArtistViewBean";
	private SessionBean sessionBean;
	private FindArtistFormBean findArtistFormBean;
	private boolean success = false;

	public FindArtistViewBean() {
		super();
	}

	public FindArtistViewBean(SessionBean sessionBean,
			FindArtistFormBean findArtistFormBean) {
		super();
		this.sessionBean = sessionBean;
		this.findArtistFormBean = findArtistFormBean;

	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		model.addObject(NAME, this);
		//actualizamos el resto de componente por lo que esta formado la vista, en este caso
		//actualizamos tambien el componente de formulario findArtistFormBean
		findArtistFormBean.update();
		model.addObject(FindFavoriteFormBean.getName(), findArtistFormBean);
		return model;
	}

	public void process(){
		logger.info("begin FindArtistViewBean process method");
		findArtistFormBean.process();
		this.success = this.findArtistFormBean.isSuccess();
		logger.info("end FindArtistViewBean process method");
	}

	@Override
	protected void setMsgs() {		
		mapMsgs.put(ShowArtistDetailsParamsEE.SHOW_ARTIST_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ARTIST_DETAILS_GETPATH);
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
