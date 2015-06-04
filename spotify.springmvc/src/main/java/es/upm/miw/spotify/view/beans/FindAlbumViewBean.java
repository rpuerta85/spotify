package es.upm.miw.spotify.view.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import es.upm.miw.spotify.form.beans.FindAlbumFormBean;
import es.upm.miw.spotify.form.beans.FindFavoriteFormBean;
import es.upm.miw.spotify.utils.constants.ViewUrlConstants;
import es.upm.miw.spotify.views.web.ee.ShowAlbumDetailsParamsEE;
import es.upm.miw.spotify.views.web.ee.ShowTrackDetailsParamsEE;

public class FindAlbumViewBean extends GenericView {
	private static final Logger logger = LogManager.getLogger(FindAlbumViewBean.class);
	private static final String NAME = "findAlbumViewBean";
	private FindAlbumFormBean findAlbumFormBean;
	private boolean success = false;

	public FindAlbumViewBean() {
		super();
	}

	public FindAlbumViewBean(FindAlbumFormBean findAlbumFormBean) {
		super();
		this.findAlbumFormBean = findAlbumFormBean;
	}

	public ModelAndView update() {
		ModelAndView model = new ModelAndView();
		this.setMsgs();
		model.addObject(NAME, this);
		//actualizamos el resto de componente por lo que esta formado la vista, en este caso
		//actualizamos tambien el componente de formulario findArtistFormBean
		findAlbumFormBean.update();
		model.addObject(FindFavoriteFormBean.getName(), findAlbumFormBean);
		return model;
	}

	public void process(){
		logger.info("begin FindAlbumViewBean process method");
		findAlbumFormBean.process();
		this.success = this.findAlbumFormBean.isSuccess();
		logger.info("end FindAlbumViewBean process method");
	}

	@Override
	protected void setMsgs() {
		mapMsgs.put(ShowAlbumDetailsParamsEE.SHOW_ALBUM_DETAILS_URL.getV(),ViewUrlConstants.SHOW_ALBUM_DETAILS_GETPATH);
		mapMsgs.put(ShowTrackDetailsParamsEE.FAVORITE_NAME.getV(),(findAlbumFormBean.getFindFavoriteForm()!=null)?findAlbumFormBean.getFindFavoriteForm().getName():"");

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
