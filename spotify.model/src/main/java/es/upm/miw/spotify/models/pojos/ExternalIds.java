package es.upm.miw.spotify.models.pojos;

import java.util.HashMap;
import java.util.Map;

public class ExternalIds {

  private final Map<String,String> externalIds = new HashMap<String,String>();

  public Map<String,String> getExternalIds() {
    return externalIds;
  }

}
