package es.upm.miw.spotify.form.web.ee;


public enum NewUserFormParamsEE {
	
	FORM_NEW_USER_INPUTTEXT_USERNAME_VALUE("formNewUserInputTextUsernameValue"),
	FORM_NEW_USER_INPUTTEXT_PASSWORD_VALUE("formNewUserInputTextPasswprdValue"),
	FORM_NEW_USER_INPUTTEXT_CREATETIME_VALUE("formNewUserInputCreateTimeValue"),
	FORM_NEW_USER_INPUTTEXT_ISADMIN_VALUE("formNewUserInputTextIsAdminValue"),
	FORM_NEW_USER_INPUTTEXT_ISENABLED_VALUE("formNewUserInputTextIsEnabledValue"),
	FORM_NEW_USER_INPUTTEXT_EMAIL_VALUE("formNewUserInputTextEmailValue");
	
	
	private String v;

	private NewUserFormParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
