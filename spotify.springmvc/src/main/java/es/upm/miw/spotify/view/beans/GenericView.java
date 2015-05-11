package es.upm.miw.spotify.view.beans;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class GenericView {

	public HashMap<String, String> mapMsgs = new HashMap<String, String>();

	public GenericView() {
		super();
	}

	public HashMap<String, String> getMapMsgs() {
		return mapMsgs;
	}

	public void setMapMsgs(HashMap<String, String> mapMsgs) {
		this.mapMsgs = mapMsgs;
	}

	protected abstract void setMsgs();

	public String toJson(Object obj) throws JsonGenerationException,
			JsonMappingException, IOException {
		return new ObjectMapper().writeValueAsString(obj);
	}

}
