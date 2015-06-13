package es.upm.miw.spotify.views.web.ee;

public enum ShowUsersParamsEE {
	
	JSON_USERS("jsonUsers");
	
	private String v;

	private ShowUsersParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
