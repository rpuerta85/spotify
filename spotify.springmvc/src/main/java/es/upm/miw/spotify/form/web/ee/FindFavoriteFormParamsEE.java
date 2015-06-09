package es.upm.miw.spotify.form.web.ee;


public enum FindFavoriteFormParamsEE {
	
	FORM_FIND_FAVORITE_LABEL_VALUE("formFindFavoriteLabelValue"),
	FORM_FIND_FAVORITE_INPUTTEXT_PLACEHOLDER("formFindFavoriteInputTextPlaceholder"),
	FORM_FIND_FAVORITE_BUTTON_SUBMIT_NAME("formFindFavoriteButtonSubmitName"),
	FORM_FIND_FAVORITE_NAME_MSG_ERROR("formFindFavoriteNameMsgError"),
	FORM_FIND_FAVORITE_ACTION_POST("formFindFavoriteActionPost"),
	FORM_FIND_FAVORITE_METHOD("formFindFavoriteMethod"),
	FORM_FIND_FAVORITE_INPUTTEXT_ID("formFindFavoriteInputTextId"),
	FORM_FIND_FAVORITE_INPUTTEXT_NAME("formFindFavoriteInputTextName");
	
	private String v;

	private FindFavoriteFormParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
