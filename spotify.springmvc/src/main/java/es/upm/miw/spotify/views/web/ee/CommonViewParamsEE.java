package es.upm.miw.spotify.views.web.ee;


public enum CommonViewParamsEE {
	
	MSG("msg"),	PANEL_HEADER_TITLE("panelHeaderTitle"),PANEL_HEADER_SUBTITLE("panelHeaderSubTitle"),
	PANEL_HEADER_DESCRIPTION("panelHeaderDescription");
	private String v;

	private CommonViewParamsEE(String v) {
		this.v = v;
	}

	public String getV() {
		return v;
	}

}
