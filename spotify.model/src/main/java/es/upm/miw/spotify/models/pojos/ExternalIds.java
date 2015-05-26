package es.upm.miw.spotify.models.pojos;

import java.util.HashMap;
import java.util.Map;

public class ExternalIds {

  private final Map<String,String> external_ids = new HashMap<String,String>();

public Map<String, String> getExternal_ids() {
	return external_ids;
}


}
