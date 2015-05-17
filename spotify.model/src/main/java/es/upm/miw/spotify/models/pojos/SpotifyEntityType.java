package es.upm.miw.spotify.models.pojos;

import org.codehaus.jackson.annotate.JsonValue;

public enum SpotifyEntityType {

  ALBUM("album"),
  TRACK("track"),
  ARTIST("artist"),
  USER("user"),
  PLAYLIST("playlist");

  public final String type;

  SpotifyEntityType(String type) {
   this.type = type;
  }
  @JsonValue
  public String getType() {
    return this.type;
  }

}
